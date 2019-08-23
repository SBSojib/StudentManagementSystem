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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class LoginPageController implements Initializable {

    
    @FXML
    private TextField id;
    
    @FXML 
    private PasswordField password;
    
    @FXML
    private Button confirm;
    
    
    @FXML 
    private Label enterName;
    
    @FXML 
    private Label enterPass;
    
    @FXML
    private Label error;
    
    @FXML 
    private ChoiceBox Identity;
    
    
    String idString;
    String passwordString;
    String status;
 
    String incomingCommand;
    Teacher teacher;
    Student student;
    
    
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
    @FXML
    public void confirmButton(ActionEvent event) throws IOException{
        idString= id.getText();
        
        passwordString = password.getText();
        //System.out.println(passwordString);
        status = Identity.getValue().toString();
        
        id.clear();
        password.clear();
        
        
        Parent root2 = null;
        
        
        
        if("Student".equals(status)){
            try { 
                Scanner scn = new Scanner(System.in); 
                InetAddress ip = InetAddress.getByName("localhost"); 
                Socket s = new Socket(ip, 5056); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                student = new Student( "id", "password", "fullName", "fatherName", "motherName", "year", "semester", 
                                            "department", "phoneNumber", "email", "address", "result");

                dos.writeUTF("Student Information");
                dos.writeUTF(idString); 
                dos.writeUTF(passwordString);
                incomingCommand = dis.readUTF();
                System.out.println(incomingCommand);
                if(incomingCommand.equals("Found")) {
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
                    System.out.println(student.ID);
                    root2 = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
                    Scene scene2;
                    scene2 = new Scene(root2);

                    Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();

                    window2.setScene(scene2);
                    window2.show();
        
                }
                else if(incomingCommand.equals("Not Found")) {
                    //System.out.println("Invalid ID or Wrong Password");
                    error.setText("Error : Not Found");
		}
                dos.writeUTF("Exit"); 
                
                
                
            }
            catch(Exception e){ 
                e.printStackTrace(); 
            } 
        } 
        else {
             try { 
                Scanner scn = new Scanner(System.in); 
                InetAddress ip = InetAddress.getByName("localhost"); 
                Socket s = new Socket(ip/*"192.168.43.223"*/, 5056); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                teacher = new Teacher ("444", "54321", "AB", "CSE", "01980928189", "AB@gmail.com");
                dos.writeUTF("Teacher Information");
                dos.writeUTF(idString); 
                dos.writeUTF(passwordString);
                incomingCommand = dis.readUTF();
		if(incomingCommand.equals("Found")) {
                    teacher.ID = dis.readUTF();
                    teacher.password = dis.readUTF();
                    teacher.fullName = dis.readUTF();
                    teacher.department = dis.readUTF();
                    teacher.phoneNumber = dis.readUTF();
                    teacher.email = dis.readUTF();
                    
                    root2 = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
                    Scene scene2;
                    scene2 = new Scene(root2);

                    Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();

                    window2.setScene(scene2);
                    window2.show();
                    
		}
		else if(incomingCommand.equals("Not Found")) {
                    //System.out.println("Invalid ID or Wrong Password");
                    error.setText("Error : Not Found");
		}
                dos.writeUTF("Exit");    
                
            }
        
            catch(Exception e){ 
                e.printStackTrace(); 
            } 
            
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Identity.getItems().clear();
        Identity.getItems().add("Student");
        Identity.getItems().add("Admin");
       
    }    

    
    
}
