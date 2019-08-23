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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tanzimul Hoque
 */
public class StudentPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Student student;
    
    @FXML
    private Label id;
    
    @FXML
    private Label fullName;
    
    @FXML
    private Label department;
            
    @FXML
    private Label phoneNumber;
    
    @FXML
    private Label email;
    
    @FXML
    private Label fatherName;
    
    @FXML
    private Label motherName;
            
    @FXML
    private Label year;
    
    @FXML
    private Label semester;
    
    @FXML
    private Label address;
    
    @FXML
    private Label result;
    
    @FXML
    private Button confirm;
    
    @FXML
    public void confirmButton(ActionEvent event) throws IOException{
           
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("StudentPaswordChange.fxml"));
        
        Scene scene2;
        scene2 = new Scene(root2);
        
        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window2.setScene(scene2);
        window2.show();
        
    }
    @FXML
    private Button back;
    
    @FXML
    public void back(ActionEvent event) throws IOException{
        
        Parent root5;
        
        root5 = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
      
        Scene scene5;
        scene5 = new Scene(root5);
        
        Stage window5 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window5.setScene(scene5);
        window5.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try { 
                Scanner scn = new Scanner(System.in); 
                InetAddress ip = InetAddress.getByName("localhost"); 
                Socket s = new Socket(ip, 5056); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                student = new Student( "id", "password", "fullName", "fatherName", "motherName", "year", "semester", 
                                            "department", "phoneNumber", "email", "address", "result");

                dos.writeUTF("Get Student");
                
                student.ID = dis.readUTF();
                student.password = dis.readUTF();
                student.fullName = dis.readUTF();
                student.fatherName = dis.readUTF();
                student.motherName = dis.readUTF();
                student.year = dis.readUTF();
                student.semester = dis.readUTF();
                student.department = dis.readUTF();
                student.phoneNumber = dis.readUTF();
                student.email = dis.readUTF();
                student.address = dis.readUTF();
                student.result = dis.readUTF();
               
                dos.writeUTF("Exit"); 
                //done
                
                id.setText(student.ID);
                //done
                fullName.setText(student.fullName);
                //done
                fatherName.setText(student.fatherName);
                //done
                motherName.setText(student.motherName);//done
                year.setText(student.semester);
                semester.setText(student.department);
                department.setText(student.year);
                phoneNumber.setText(student.email);
                email.setText(student.address);
                address.setText(student.phoneNumber);
                result.setText(student.result);//done

            }
            catch(Exception e){ 
                e.printStackTrace(); 
            } 
        
        // TODO
    }    
    
}
