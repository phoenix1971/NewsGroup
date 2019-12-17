/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.FileReader;
import utilities.NetworkUtilities;

/**
 *
 * @author saad
 */
public class LogInReadThread implements Runnable 
{
	private Thread thr;
	private NetworkUtilities nc;
        String [] IdPass = new String[100] ;
        String [] IdInfo = new String[100] ;
        int TotalId ;
        
	public LogInReadThread(NetworkUtilities nc) 
        {
		this.nc = nc;
                TotalId = 0 ;
                LoginInfoFileOpen();
                IdInfoFileOpen();
                
		this.thr = new Thread(this);
		thr.start();
	}
	
        @Override
	public void run() 
        {
	try 
        {
            String usernamePassword =(String)nc.read();
            System.out.println("usernamePassword  : " + usernamePassword );
            boolean CanLogIn = false ;
            String IDinfo = null ;
            for( int i = 0 ; i < TotalId ; i++ )
            {
                if( usernamePassword.equals(IdPass[i] ) )
                {
                    CanLogIn = true ;
                    IDinfo = IdInfo[i] ;
                }
            }
            if( CanLogIn ) nc.write(IDinfo);
            else nc.write("Invalid");
        } catch(Exception e)
        {
            System.out.println (e);
        }
            nc.closeConnection();
            System.out.println("loginreadwritethread closed...! ");
	}
        
    private void LoginInfoFileOpen()
    {
        // The name of the file to open.
        String fileName = "LoginInfo.txt";

        // This will reference one line at a time
        String line = null ;
        int numberOfId = 0 ;
       
        try 
        {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =  new FileReader(fileName);

            try ( // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) 
                {
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        System.out.println(line);
                        IdPass[numberOfId++] = line ;
                    }
                // Always close files.
                bufferedReader.close() ;
            }         
        }
        catch( Exception ex) 
        {
            System.out.println("Unable to open file '" +   fileName + "'");                
        }
        
        
         System.out.println("\n\nnow line is printing\n");
         
         for( int i = 0 ; i < numberOfId ; i++ )
         {
             System.out.println("IdPass = " + IdPass[i] ) ;
         }
         
         TotalId = numberOfId ;
         
         System.out.println("\ndone");
         
         // file er kaj ses
        
        
    }
    
       private void IdInfoFileOpen()
    {
        // The name of the file to open.
        String fileName = "IdInfo.txt";

        // This will reference one line at a time
        String line = null ;
        int numberOfId = 0 ;
        
        try 
        {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =  new FileReader(fileName);

            try ( // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) 
                {
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        System.out.println(line);
                        IdInfo[numberOfId++] = line ;
                    }
                // Always close files.
                bufferedReader.close() ;
            }         
        }
        catch( Exception ex) 
        {
            System.out.println("Unable to open file '" +   fileName + "'");                
        }
        
        
         System.out.println("\n\nnow line is printing\n");
         
         for( int i = 0 ; i < numberOfId ; i++ )
         {
             System.out.println("IdInfo = " + IdInfo[i] ) ;
         }
         
         TotalId = numberOfId ;
         
         System.out.println("\ndone");
         
         // file er kaj ses
        
        
    }
}
