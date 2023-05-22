/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoemployee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.table.DefaultTableModel;


/**
 * FXML Controller class
 *
 * @author fuadj
 */
public class EmployeeFXMLController implements Initializable {

    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtLname;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtSalary;
    
    //java.sql.Connection c;
    PreparedStatement pst;
    @FXML
    private TableView<testingEmployee> recordTable;
    @FXML
    private TableColumn<testingEmployee, Integer> id_label;
    @FXML
    private TableColumn<testingEmployee, String> fname_label;
    @FXML
    private TableColumn<testingEmployee, String> lname_label;
    @FXML
    private TableColumn<testingEmployee, String> city_label;
    @FXML
    private TableColumn<testingEmployee, Integer> phone_label;
    @FXML
    private TableColumn<testingEmployee, Integer> salary_label;
    
    private ObservableList<testingEmployee> data;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //saythankyou();
        // Any method or thing you do here will be shown immediately after showing javafx scene
        data=FXCollections.observableArrayList(); // list being instanstiated
    
    }    

    @FXML
    private void saveInformation(ActionEvent event) throws ClassNotFoundException {
        String fname,lname,city,phone,salary;
        
        
        
        try {
            String user="root";
            String password="";
            String url="jdbc:mysql://localhost:3306/employeeinfo";
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection c=DriverManager.getConnection(url,user,password);
            fname=txtFname.getText();
            lname=txtLname.getText();
            city=txtCity.getText();
            phone=txtPhone.getText();
            salary=txtSalary.getText();
            pst=c.prepareStatement("insert into records (fname,lname,city,phone,salary) values(?,?,?,?,?)");
            
            pst.setString(1,fname);
            pst.setString(2, lname);
            pst.setString(3, city);
            pst.setString(4, phone);
            pst.setString(5, salary);
            
            pst.executeUpdate();
            
            txtFname.setText("");
            txtLname.setText("");
            txtCity.setText("");
            txtPhone.setText("");
            txtSalary.setText("");
            
            txtFname.requestFocus();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void showRecords(ActionEvent event) throws ClassNotFoundException {
        
        setCellTable();
        
        data.clear();
        
        //int CC; // Column count
        try {
            String user="root";
            String password="";
            String url="jdbc:mysql://localhost:3306/employeeinfo";
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection c=DriverManager.getConnection(url,user,password);
            pst=c.prepareStatement("SELECT * FROM records");
            ResultSet Rs=pst.executeQuery(); // result set object
            
            while(Rs.next()){
                data.add(new testingEmployee(Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getInt(5),Rs.getInt(6))); //Integer.parseInt(Rs.getString(5))
            }
            
//            ResultSetMetaData RSMD=Rs.getMetaData();
//            CC=RSMD.getColumnCount(); // will count the number of columns
//            //DefaultTableModel DFT=(DefaultTableModel) recordTable.get
            
            
        }
        catch(SQLException ex){
            Logger.getLogger(EmployeeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        recordTable.setItems(data);
        
        
    }
    
    private void setCellTable(){
        fname_label.setCellValueFactory(new PropertyValueFactory<testingEmployee, String>("first_name"));
        lname_label.setCellValueFactory(new PropertyValueFactory<testingEmployee, String>("last_name"));
        city_label.setCellValueFactory(new PropertyValueFactory<testingEmployee, String>("emp_city"));
        phone_label.setCellValueFactory(new PropertyValueFactory<testingEmployee, Integer>("emp_phone"));
        salary_label.setCellValueFactory(new PropertyValueFactory<testingEmployee, Integer>("emp_salary"));
    }
    
//    private void saythankyou(){
//            System.out.println("Thank you");
//        }
    
}
