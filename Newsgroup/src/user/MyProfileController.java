/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilities.NetworkUtilities;

/**
 * FXML Controller class
 *
 * @author saad
 */
public class MyProfileController implements Initializable {

    @FXML
    private Label MyInfo = new Label() ;

    /**
     * Initializes the controller class.
     */
    public void ShowInfo()
    {
        System.out.println("ShowInfoworking.....");
        String serverAddress = "127.0.0.1";
        int serverPort = 33336;
        NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);  
        nc.write( START.USERNAME ) ;        
        String Info = (String)nc.read(); 
        System.out.println("From Server Info is [ " + Info + " ]" );
        MyInfo.setText(Info); 
        System.out.println("MyInfo setTesT done :D");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) 
    {
         MyInfo.setText("") ;
        START.window.setScene(START.HomeScene);
       
    }

    @FXML
    private void ShowAllInfo(ActionEvent event) 
    {
        ShowInfo();
    }
    
}
