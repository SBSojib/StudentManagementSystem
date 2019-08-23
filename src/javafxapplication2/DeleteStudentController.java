/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import static java.awt.AWTEventMulticaster.add;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Tanzimul Hoque
 */
public class DeleteStudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField id; 
    @FXML
    private Button confirm;
    
    @FXML
    private ChoiceBox ids;
    
    String idString;
    
    String[] allID = new String[10000];
    int n = 0;
    
    public void getStudentID() {
        try { 
            Scanner scn = new Scanner(System.in); 
            InetAddress ip = InetAddress.getByName("localhost"); 
            Socket s = new Socket("127.0.0.1", 5056); 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

            dos.writeUTF("Get ID");
            n = Integer.parseInt(dis.readUTF());
            for(int i=0; i<n; i++) {
                allID[i] = dis.readUTF();
            }
            dos.writeUTF("Exit");

        }

        catch(Exception e){ 
            e.printStackTrace(); 
        } 
    }
    
    @FXML
    public void confirmButton(ActionEvent event) throws IOException{
        idString= ids.getValue().toString();
       
  
        try { 
            Scanner scn = new Scanner(System.in); 
            InetAddress ip = InetAddress.getByName("localhost"); 
            Socket s = new Socket("127.0.0.1", 5056); 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

            dos.writeUTF("Delete");
            dos.writeUTF(idString);

            dos.writeUTF("Exit");
            }
        
        catch(Exception e){ 
            e.printStackTrace(); 
        } 
        //we cant not delete more than one time with this thing added
        //ids.getItems().clear();
        ids.getSelectionModel().clearSelection();
        //ids.setValue(null);
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
        getStudentID();
        String[] add = new String[10000];
        for( int i=0; i<n; i++) {
            add[i] = allID[i];
            System.out.println(add[i]);
        }
        
        
        ArrayList<String> studentIds = new ArrayList<String>(Arrays.asList(add)); ///set this arraylist as the one returned from function
        
  
        
        
       
        ObservableList<String> list = FXCollections.observableArrayList(studentIds);
        
        
        ids.getItems().clear();
        for(int i=0;i<n;i++){
            ids.getItems().add(add[i]);
        }
    }    
    
}
