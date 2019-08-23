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
public class StudentPaswordChangeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private PasswordField previousPassword;
    
    @FXML 
    private PasswordField newPassword;
    
    @FXML 
    private PasswordField confirmNewPassword;
    
    @FXML 
    private TextField id;
    
    @FXML
    private Button confirm;
    
    String previousPasswordString;
    
    String newPasswordString;
    
    String confirmNewPasswordString;
    
    String idString;
    
    public void confirmButton(ActionEvent event){
        previousPasswordString= previousPassword.getText();
        
        newPasswordString = newPassword.getText();
      
        confirmNewPasswordString = confirmNewPassword.getText();
        
        idString = id.getText();
        id.clear();
        previousPassword.clear();
        newPassword.clear();
        confirmNewPassword.clear();
        
        try { 
                Scanner scn = new Scanner(System.in); 
                InetAddress ip = InetAddress.getByName("localhost"); 
                Socket s = new Socket("127.0.0.1", 5056); 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                dos.writeUTF("Change Student Password");
                dos.writeUTF(idString);
                dos.writeUTF(previousPasswordString);
                dos.writeUTF(newPasswordString);
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
        
        root5 = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
      
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
