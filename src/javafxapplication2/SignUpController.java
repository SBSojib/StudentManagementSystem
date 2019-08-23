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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tanzimul Hoque
 */
public class SignUpController implements Initializable {

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
    private TextField authenCode;
    
    @FXML
    private PasswordField password;
    
    
    
    @FXML 
    private Button confirm; 
    
    @FXML
    private Label error;
    
    
    
    String idString;
    String nameString;
    String departmentString;
    String phoneNumberString;
    String emailString;
    String authenCodeString;
    String passwordString;
    String feedback;
    Teacher teacher;
    
    
    public void confirmButton(ActionEvent event) throws IOException{
        idString= id.getText();
        
        nameString = name.getText();
      
        departmentString = department.getText();
        
        phoneNumberString = phoneNumber.getText();
        
        emailString = email.getText();
        
        authenCodeString = authenCode.getText();
       
        passwordString = password.getText();
        
        id.clear();
        name.clear();
        department.clear();
        phoneNumber.clear();
        email.clear();
        authenCode.clear();
        password.clear();
        
        
        try { 
                Scanner scn = new Scanner(System.in); 
                InetAddress ip = InetAddress.getByName("localhost"); 
                Socket s = new Socket("127.0.0.1", 5056); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                teacher = new Teacher (idString, passwordString, nameString, departmentString, phoneNumberString, 
                                                emailString);
                
                dos.writeUTF("Sign Up");  
		dos.writeUTF(teacher.getID()); 
		dos.writeUTF(teacher.getPassword());
		dos.writeUTF(teacher.getFullName());
		dos.writeUTF(teacher.getDepartment()); 
		dos.writeUTF(teacher.getPhoneNumber()); 
		dos.writeUTF(teacher.getEmail()); 
                dos.writeUTF(authenCodeString);
                
                feedback = dis.readUTF();
                if(feedback.equals("authenticated")) {
                    
                }
                else{
                    //printf some error
                }
                dos.writeUTF("Exit");
            }
        
            catch(Exception e){ 
                e.printStackTrace(); 
            } 
       
        
        Parent root3;
        
        root3 = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
      
        Scene scene3;

        scene3 = new Scene(root3);    

        Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window3.setScene(scene3);
        window3.show();
         
    }
    
    
@FXML
    private Button back;
    
    @FXML
    public void back(ActionEvent event) throws IOException{
        
        Parent root5;
        
        root5 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      
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
