/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tanzimul Hoque
 */
public class AddStudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField department;
    
    @FXML
    private TextField phoneNumber;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField motherName;
    
    @FXML
    private TextField fatherName;
    
    @FXML
    private TextField year;
    
    @FXML
    private TextField semester;
    
   
    @FXML
    private TextField address;
    
    @FXML
    private TextField result;
    
    @FXML 
    private Button confirm; 
    
    
    
    String idString;
    String nameString;
    String departmentString;
    String phoneNumberString;
    String emailString;
    String fatherNameString;
    String motherNameString;
    String yearString;
    String semesterString;
    String addressString;
    String resultString;
    Student student;
    
    public void confirmButton(ActionEvent event){
        idString= id.getText();
        
        nameString = name.getText();
      
        departmentString = department.getText();
        
        phoneNumberString = phoneNumber.getText();
        
        emailString = email.getText();
        
        fatherNameString = fatherName.getText();
        
        motherNameString = motherName.getText();
        
        yearString = year.getText();
        
        semesterString = semester.getText();
        
        addressString = address.getText();
        
        resultString = result.getText();
        
        id.clear();
        name.clear();
        department.clear();
        phoneNumber.clear();
        email.clear();
        fatherName.clear();
        motherName.clear();
        year.clear();
        semester.clear();
        result.clear();
        address.clear();
        
        try { 
                Scanner scn = new Scanner(System.in); 
                InetAddress ip = InetAddress.getByName("localhost"); 
                Socket s = new Socket("127.0.0.1", 5056); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                student = new Student( "id", "password", "fullName", "fatherName", "motherName", "year", "semester", 
                                            "department", "phoneNumber", "email", "address", "result");

                dos.writeUTF("Submit");  
		dos.writeUTF(idString); 
		dos.writeUTF("999");
		dos.writeUTF(nameString); 
		dos.writeUTF(fatherNameString); 
		dos.writeUTF(motherNameString); 
		dos.writeUTF(departmentString); 
		dos.writeUTF(yearString); 
		dos.writeUTF(semesterString); 
		dos.writeUTF(addressString); 
		dos.writeUTF(phoneNumberString); 
		dos.writeUTF(emailString); 
		dos.writeUTF(resultString); 
                                        
                dos.writeUTF("Exit"); 
                
            }
            catch(Exception e){ 
                e.printStackTrace(); 
            } 
         
    }
    @FXML
    private Button back;
    
    @FXML
    public void back(ActionEvent event) throws IOException{
        
        Parent root5;
        
        root5 = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
      
        Scene scene5;
        scene5 = new Scene(root5);
        
        Stage window5 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window5.setScene(scene5);
        window5.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}

    