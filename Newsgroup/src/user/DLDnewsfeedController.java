/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import utilities.NetworkUtilities;

/**
 * FXML Controller class
 *
 * @author saad
 */
public class DLDnewsfeedController implements Initializable  {

    @FXML
    private TextArea newPost;
    @FXML
    private VBox myVBox;
    private TextArea [] Posts = new TextArea[100] ;// = new TextArea[ 100 ] ;
    private Button [] comment = new Button[ 100] ;
    private TextField []commentBox = new TextField[100] ; 
    private int numberOfPosts ;

    /**
     * Initializes the controller class.
     */
    
    private int numberOfPostsIs() throws Exception
    {
        String serverAddress = "127.0.0.1";
        int serverPort = 33337;
        NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);          
        nc.write("numberOfPostIs#....#..."+ "#"+START.USERNAME );
        String NoOfPost = (String)nc.read(); ;
        int numberOfPosts = Integer.parseInt(NoOfPost) ;
        return numberOfPosts ;
    }
    
    
    void UpdateNumberOfPost() throws Exception
    {
        String serverAddress = "127.0.0.1";
        int serverPort = 33337;
        NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);          
        nc.write("UpdateNumberOfPost#"+ numberOfPosts +"#" + "...."+ "#"+START.USERNAME );
    }
    
    void UpdateAllPosts() throws FileNotFoundException, IOException, Exception
    {
        myVBox.getChildren().clear();
        numberOfPosts = numberOfPostsIs() ;
        System.out.println(" number of posts is : " + numberOfPosts ) ;
        
            for( int i = 1 ; i <= numberOfPosts ; i++ )
            {
                System.out.println(" POST "+  i + " is updating ");

                String serverAddress = "127.0.0.1";
                int serverPort = 33337;
                NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);          
                nc.write("UpdateAllPosts#"+ i + "#..."+ "#"+START.USERNAME );
                String Post = (String)nc.read(); ;
      
         
                Posts[i] = new TextArea()  ;
                Posts[i].setText( Post ) ;
                System.out.println("Updated Post is :: " + Post ) ;
                Posts[i].setEditable(false);
                comment[i] = new Button("Comment") ;
                commentBox[i] = new TextField() ;
                
                
                myVBox.getChildren().add(Posts[i] );
                myVBox.getChildren().add( commentBox[i] );
                myVBox.getChildren().add(comment[i] ) ;
       
                System.out.println(" POST "+  i + " is updated ");
            }
            int i = 1 ;
            while( i <= numberOfPosts )
            {
                UpdateComment(i);
                i++ ;
            }
        
    }
    
    void UpdateComment( int i )
    {
       comment[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
                public void handle(MouseEvent e) 
                {
                try {
                     
                    System.out.println(i+" Commnet  Working : \n [ " +commentBox[i].getText() + " is My commnet!! ]" ) ;
                    String UpdatedPost = Posts[i].getText() +"\n[Comment] : " +commentBox[i].getText() +"\n..... by [ "+ START.USERNAME + " ] ( "+ START.USERID + ")\n" ;
                    System.out.println("Updated Post is " + UpdatedPost ) ;
                    commentBox[i].setText("") ;
                    String serverAddress = "127.0.0.1";
                    int serverPort = 33337;
                    NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);          
                    nc.write("UpdateComment#"+ i +"#" + UpdatedPost+ "#"+START.USERNAME );
                    System.out.println("after write in file , updated post is : " + UpdatedPost ) ;
                  
                    
                    UpdateAllPosts();
                    
                } catch (Exception ex) {
                    Logger.getLogger(OOPnewsfeedController.class.getName()).log(Level.SEVERE, null, ex);
                } 
                }
            });
        
    }
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        System.out.println("initialize DLDnewsfeed.....");
      
            
        try {
            numberOfPosts = numberOfPostsIs() ;
            UpdateAllPosts() ;
            
        } catch (Exception ex) {
            Logger.getLogger(DLDnewsfeedController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
     
            
          
        
        
    }  
    
    

    @FXML
    private void PostIt(ActionEvent event) throws Exception 
    {
        numberOfPosts = numberOfPostsIs() ;
        numberOfPosts++ ;
        UpdateNumberOfPost();
        String NewPost = newPost.getText() + "\n.....Posted by [ "+ START.USERNAME + " ] ( "+ START.USERID + ")\n" ;
        System.out.println(" newpost is : " +  NewPost ) ; 
        newPost.setText("") ;
        

        String serverAddress = "127.0.0.1";
        int serverPort = 33337;
        NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);          
        nc.write("UpdateNewPost#"+ numberOfPosts +"#" + NewPost+ "#"+START.USERNAME );
            
        UpdateAllPosts();
            
        
    }

    @FXML
    private void Reload(ActionEvent event) throws IOException, Exception 
    {
        UpdateAllPosts();
    }

    @FXML
    private void Back(ActionEvent event) 
    {
        START.window.setScene(START.DLDcourseScene);
    }
    
}
