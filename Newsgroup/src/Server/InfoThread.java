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
public class InfoThread implements Runnable 
{
	private Thread thr;
	private NetworkUtilities nc;
        
	public InfoThread(NetworkUtilities nc) 
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
                System.out.println("InfoThreadWOrking..............");
                String StringfromCLient = (String)nc.read();
                System.out.println("stringFromclient is " + StringfromCLient );
                
                String filename = StringfromCLient+".txt";
                FileReader filereader = new FileReader( filename ) ;
                char [] data = new char[100000] ;
                filereader.read(data ) ;
            
                String ClientInfo = new String( data ) ;
                filereader.close() ;
            
                nc.write( ClientInfo ) ;
                
                
                        

            } catch(Exception e)
            {
                System.out.println (e);
            }
            nc.closeConnection();
	}
        
        

}
