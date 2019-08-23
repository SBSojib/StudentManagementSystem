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
public class AdminPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
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
    private Button add;
    
    @FXML
    private Button edit;
    
    @FXML
    private Button delete;
    
    String idString;
    
    String nameString;
    
    String departmentString;
    
    String phoneString;
    
    String emailString;
    Teacher teacher;
    
    @FXML
    public void add(ActionEvent event) throws IOException{
        
        Parent root;
        
        root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
      
        Scene scene;
        scene = new Scene(root);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    public void edit(ActionEvent event) throws IOException{
        
        Parent root2;
        
        root2 = FXMLLoader.load(getClass().getResource("EditStudent.fxml"));
      
        Scene scene2;
        scene2 = new Scene(root2);
        
        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window2.setScene(scene2);
        window2.show();
    }
    
    @FXML
    public void delete(ActionEvent event) throws IOException{
        
        Parent root3;
        
        root3 = FXMLLoader.load(getClass().getResource("DeleteStudent.fxml"));
      
        Scene scene3;
        scene3 = new Scene(root3);
        
        Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window3.setScene(scene3);
        window3.show();
    }
    
    @FXML
    public void changePass(ActionEvent event) throws IOException{
        
        Parent root4;
        
        root4 = FXMLLoader.load(getClass().getResource("AdminPass.fxml"));
      
        Scene scene4;
        scene4 = new Scene(root4);
        
        Stage window4 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window4.setScene(scene4);
        window4.show();
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
        // TODO
       
        try { 
                Scanner scn = new Scanner(System.in); 
                InetAddress ip = InetAddress.getByName("localhost"); 
                Socket s = new Socket("127.0.0.1", 5056); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                teacher = new Teacher( "id", "password", "fullName",
                                            "department", "phoneNumber", "email");

                dos.writeUTF("Get Teacher");
                
                teacher.ID = dis.readUTF();
                teacher.password = dis.readUTF();
                teacher.fullName = dis.readUTF();
                teacher.department = dis.readUTF();
                teacher.phoneNumber = dis.readUTF();
                teacher.email = dis.readUTF();
               
                dos.writeUTF("Exit"); 
                
                id.setText(teacher.ID);
                fullName.setText(teacher.fullName);
                department.setText(teacher.department);
                phoneNumber.setText(teacher.phoneNumber);
                email.setText(teacher.email);
            }
            catch(Exception e){ 
                e.printStackTrace(); 
            } 

    }    
    
}
