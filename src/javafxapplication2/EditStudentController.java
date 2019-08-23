package javafxapplication2;

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
public class EditStudentController implements Initializable {


   
    
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
    
    @FXML 
    private Button autofill; 
    
    @FXML 
    private ChoiceBox ids;
    
    
    
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
    
    
    public void autofill(ActionEvent event){
        idString= ids.getValue().toString();
        try { 
            Scanner scn = new Scanner(System.in); 
            InetAddress ip = InetAddress.getByName("localhost"); 
            Socket s = new Socket("127.0.0.1", 5056); 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

            
            student = new Student( "id", "password", "fullName", "fatherName", "motherName", "year", "semester", 
                                            "department", "phoneNumber", "email", "address", "result");

            dos.writeUTF("AutoFill");
            dos.writeUTF(idString); 
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

        }

        catch(Exception e){ 
            e.printStackTrace(); 
        } 
        
        ///write code here to return student type object from id
        
        name.setText(student.getFullName());
        department.setText(student.getDepartment());
        phoneNumber.setText(student.getPhoneNumber());
        email.setText(student.getEmail());
        fatherName.setText(student.getFatherName());
        motherName.setText(student.getMotherName());
        year.setText(student.getYear());
        semester.setText(student.getSemester());
        address.setText(student.getAddress());
        result.setText(student.getResult());
    }
    
    public void confirmButton(ActionEvent event){
        
        idString= ids.getValue().toString();
        
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
                
                dos.writeUTF("Edit");
                dos.writeUTF(idString);
                dos.writeUTF(nameString);
                dos.writeUTF(fatherNameString);
                dos.writeUTF(motherNameString);
                dos.writeUTF(yearString);
                dos.writeUTF(semesterString);
                dos.writeUTF(departmentString);
                dos.writeUTF(phoneNumberString);
                dos.writeUTF(emailString);
                dos.writeUTF(addressString);
                dos.writeUTF(resultString);
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
