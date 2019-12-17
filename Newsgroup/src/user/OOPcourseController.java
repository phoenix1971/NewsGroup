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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author saad
 */
public class OOPcourseController implements Initializable {

   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) 
    {       
        START.window.setScene(START.HomeScene);
    }



    @FXML
    private void GoToOOPnewsfeed(ActionEvent event) 
    {
        System.out.println("Go to newsfeed please....");
        START.window.setScene( START.OOPnewsFeed) ;
    }
    
}
