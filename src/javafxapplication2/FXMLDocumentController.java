/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Tanzimul Hoque
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button login;
    private Object locator;
    private AnchorPane AnchorPane;
    

     
   @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        
        Parent root2;
        
        root2 = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        
        Scene scene2;
        scene2 = new Scene(root2);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        
        window.show();
    }
    @FXML
    private Button signup;
    
    /**
     *
     * @param event
     * @throws IOException
     */
    
    
    @FXML
    public void handleSignup(ActionEvent event) throws IOException{
        
        Parent root3;
        
        root3 = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
      
        Scene scene3;
        scene3 = new Scene(root3);
        
        Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window3.setScene(scene3);
        window3.show();
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
