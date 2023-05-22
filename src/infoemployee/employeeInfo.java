
package infoemployee;

import com.sun.jdi.connect.spi.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.DriverManager;
import java.sql.SQLException;



public class employeeInfo extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("employeeFXML.fxml"));
        Scene scene=new Scene(root);
        stage.setTitle("Employee Information");
        stage.setScene(scene);
        stage.show();
    
    }
    
    public static void main(String[] args) throws SQLException {
        launch(args);
        
        try {
            String user="root";
            String password="";
            String url="jdbc:mysql://localhost:3306/employeeinfo";
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection c=DriverManager.getConnection(url,user,password);
            System.out.println("Success");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeeInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
