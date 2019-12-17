/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import utilities.NetworkUtilities;

/**
 * FXML Controller class
 *
 * @author saad
 */
public class NotificationController implements Initializable {

    @FXML
    private TextArea MyNotifications;
    
    void UpdateNotification() throws FileNotFoundException, IOException
    {
//            String Notifications ;
//            File file ;
//            file = new File("Notification.txt" );
//            FileReader filereader = new FileReader(file ) ;
//            char data[]=new char[100000];
//            System.out.println("data size is now" + data.length ) ;
//            filereader.read(data);
//            System.out.println("yo yo" + new String( data) + "yo yo" );
//            Notifications = new String(data) ;
//            filereader.close() ;
//            System.out.println("sigh");      
//            MyNotifications.setText(Notifications);
        System.out.println("Updating Notification .......");
        String serverAddress = "127.0.0.1";
        int serverPort = 33335;
        NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);          
        String Notifications = (String)nc.read(); ;
        MyNotifications.setText(Notifications);
        System.out.println("Updated Notification .......");

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        System.out.println("Notificationcontroller starting...");
        try {
            UpdateNotification();
        } catch (IOException ex) {
            Logger.getLogger(NotificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void Back(ActionEvent event) {
        
        START.window.setScene(START.HomeScene);
    }

    @FXML
    private void Reload(ActionEvent event) throws IOException 
    {
        UpdateNotification();
    }
    
}
