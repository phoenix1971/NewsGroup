/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author saad
 */
public class HOMEController implements Initializable {

    @FXML
    public Label Name ;

    /**
     * Initializes the controller class.
     * @param url
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        System.out.println(" Home Controller working.....");
        
        System.out.println(Name.getText() );
        
        Name.setText(START.USERNAME);
        
    }    

    @FXML
    private void GoToOOP(ActionEvent event) 
    {
        START.window.setScene(START.OOPcourseScene);
    }

    @FXML
    private void GoToDS(ActionEvent event) 
    {
        START.window.setScene(START.DScourseScene);
    }
    
    @FXML
    private void GoToDM(ActionEvent event) 
    {
        START.window.setScene(START.DMcourseScene);
    }

    @FXML
    private void GoToDLD(ActionEvent event) 
    {
        START.window.setScene(START.DLDcourseScene);
    }

    @FXML
    private void GoToProfile(ActionEvent event) 
    {
        START.window.setScene(START.ProfileScene);
    }

    @FXML
    private void GoToNotification(ActionEvent event) 
    {
        START.window.setScene(START.NotificationScene);
    }

    @FXML
    private void LogOut(ActionEvent event) 
    {
        START.window.setScene(START.LogInScene);
    }

    @FXML
    private void GoToFaculty(ActionEvent event)
    {
         START.window.setScene(START.FacultyScene);
    }

    
    
}
