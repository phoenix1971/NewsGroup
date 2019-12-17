/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import utilities.NetworkUtilities;

/**
 *
 * @author saad
 */
public class DLDReadWriteThread implements Runnable 
{
	private Thread thr;
	private NetworkUtilities nc;
        String [] strigFromClient = new String[10];
        String Type , PostNo , Post , ClientName ;
        
	public DLDReadWriteThread(NetworkUtilities nc) 
        {
		this.nc = nc;               
		this.thr = new Thread(this);
		thr.start();
	}
	
        @Override
	public void run() 
        {
            try 
            {
                System.out.println("DLDReadWriteThreadWOrking..............");
                String StringfromCLient = (String)nc.read();
                System.out.println("stringFromclient is " + StringfromCLient );
                int i = 0 ;
                for (String yo: StringfromCLient.split("#", 4))
                {
                    System.out.println("after split , yo = " + yo);
                    strigFromClient[i] = yo ;
                    i++ ;
                }
                Type = strigFromClient[0] ;
                PostNo = strigFromClient[1] ;
                Post = strigFromClient[2] ;
                ClientName = strigFromClient[3] ;
                System.out.println("Type : " + Type ) ;
                System.out.println("PostNo : " + PostNo ) ;
                System.out.println("Post : " + Post) ;
                
                if( Type.equals( "UpdateNumberOfPost") )
                {
                    UpdateNumberOfPost(PostNo) ;
                }
                else if ( Type.equals( "numberOfPostIs"))
                {
                    String numberOfPost = numberOfPostIs()  ;
                    nc.write(numberOfPost);
                }
                else if( Type.equals( "UpdateAllPosts"))
                {
                    String Post = UpdateAllPosts(PostNo ) ;
                    nc.write( Post);
                }
                else if( Type.equals("UpdateComment"))
                {
                    UpdateComment(Post, PostNo , ClientName );
                }
                else if( Type.equals("UpdateNewPost"))
                {
                    UpdateNewPost(Post, PostNo , ClientName );
                }
                else
                {
                    // do nothing
                }
                            
                        

            } catch(Exception e)
            {
                System.out.println (e);
            }
            nc.closeConnection();
	}
        
        String UpdateAllPosts( String PostNo ) throws FileNotFoundException, IOException
        {
            String filename = "DLDnewsfeed" + PostNo + ".txt";
            File file ;
            file = new File( filename );
            FileReader filereader = new FileReader(file ) ;
            char data[]=new char[(int)file.length()];
            System.out.println("data size is now : " + data.length ) ;
            filereader.read(data);
            System.out.println("yo yo" + new String( data) + "yo yo" );
            String Post = new String(data) ;
            filereader.close() ;   
            return Post ;
            
        }
        
        String numberOfPostIs() throws FileNotFoundException, IOException
        {
            String NumberOfPosts ;
            File file ;
            file = new File("DLDnewsfeedPost.txt" );
            FileReader filereader = new FileReader(file ) ;
            char data[]=new char[(int)file.length()];
            System.out.println("data size is now" + data.length ) ;
            filereader.read(data);
            System.out.println("yo yo" + new String( data) + "yo yo" );
            NumberOfPosts = new String(data) ;
            filereader.close() ;
            System.out.println("sigh");      
            return NumberOfPosts ;
        }
        
        void UpdateNumberOfPost( String PostNo ) throws IOException
        {
            String filename = "DLDnewsfeedPost.txt";
            FileWriter filewriter = new FileWriter(filename) ;
            filewriter.write( PostNo ) ;
            System.out.println("update numberOfPost in file "+ PostNo ) ;
            filewriter.close();           
        }
        
        void UpdateComment( String Post , String PostNo , String ClientName ) throws IOException
        {
            
            String filename = "DLDnewsfeed" + PostNo + ".txt";
            FileWriter filewriter = new FileWriter(filename) ;
            filewriter.write( Post) ;
            System.out.println("update new comment in file "+ Post ) ;
            filewriter.close();
            
            filename = "Notification.txt";
            System.out.println("data ta = new char[filsize of notification file is " + filename.length() ) ;
            FileReader filereader = new FileReader( filename ) ;
            char [] data = new char[100000] ;
            filereader.read(data ) ;
            filereader.close() ;
            String oldNotification = new String( data ) ;
            System.out.println("oldnotification is " + oldNotification );
            System.out.println("username is " + ClientName ) ;
            String UpdatedNotification = ClientName + " commented on the "+PostNo+"th post in the DLD course \n\n"+ oldNotification ;
            filewriter = new FileWriter(filename) ;
            filewriter.write(UpdatedNotification);
            filewriter.close();
            System.out.println("update notification in file "+ Post ) ;
            
            
        }
        
        void UpdateNewPost( String NewPost , String PostNo , String ClientName ) throws IOException
        {
            String filename = "DLDnewsfeed" + PostNo + ".txt";
            FileWriter filewriter = new FileWriter(filename) ;
            filewriter.write( NewPost) ;
            System.out.println(" update new post in file "+ NewPost ) ;
            filewriter.close();   
            
            filename = "Notification.txt";
            FileReader filereader = new FileReader( filename ) ;
            char [] data = new char[100000] ;
            filereader.read(data ) ;
            
            String oldNotification = new String( data ) ;
            filereader.close() ;
            
            System.out.println("oldnotification is " + oldNotification );
            System.out.println("username is " + ClientName ) ;
            String UpdatedNotification = ClientName + "  posted in the DLD course \n\n"+ oldNotification ;
            filewriter = new FileWriter(filename) ;
            filewriter.write(UpdatedNotification);
            filewriter.close();
            System.out.println("update notification in file "+ Post ) ;
        }
        

}
