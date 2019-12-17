/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utilities.NetworkUtilities;

/**
 * FXML Controller class
 *
 * @author saad
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField Password;
    @FXML
    private Label wrongInfo;
    
    public static String userName = "" ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        System.out.println(" sigh login");
    }    

    @FXML
    private void Login(ActionEvent event) throws IOException 
    {
//         START.window.setScene(START.HomeScene); 
//         return ;
         
        String sentance = username.getText() + " "+Password.getText() ;
        System.out.println("sentnce = " + sentance);
        
        String IDinfo = "Invalid" ;
        
        //................... .............
        try {
            System.out.println("In de login controller...");
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);
            
            nc.write(username.getText()+" "+ Password.getText() );
                        
            IDinfo =(String)nc.read();
            System.out.println( IDinfo );
                        
            } catch(Exception e) 
            {
                System.out.println (e);
            }
        
        //..................
        userName = username.getText() ;
        username.setText("");
        Password.setText("") ;
        wrongInfo.setText("");
        
        
        
        System.out.println("sigh infromserver");
        //CanLogIn = "YES" ;
        
       System.out.println("CanLogIn ?? ( From Server ) " + IDinfo);
        
        
        if( IDinfo.equals("Invalid" ) == false )
        {
            
            System.out.println("userNamw is >> " + userName ); 
            START.window.setScene(START.HomeScene);
            
            System.out.println("set home label" + userName);
             START.USERNAME = userName ;
            START.USERID = IDinfo ; 
            System.out.println(" USER is " + START.USERID + "  " + START.USERNAME ) ;
            System.out.println("Logged In successfully..........");
            
                    
        }
        else
        {
            wrongInfo.setText(" Invalid username or password. Please Try again.") ;            
        }

        
    }

    @FXML
    private void Exit(ActionEvent event) {
        System.exit( 0 ) ;
    }
    
}
