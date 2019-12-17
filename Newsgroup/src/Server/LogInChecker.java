/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;
import utilities.NetworkUtilities;

/**
 *
 * @author saad
 */
class LogInChecker implements Runnable
{

        private ServerSocket ServSock;
        private Thread th ;
	
	LogInChecker() 
        {
            th = new Thread(this ) ;
            th.start() ;
        }
		

    @Override
    public void run()
    {
        try 
        {
            ServSock = new ServerSocket(33333);
            System.out.println("LogInchecker strting..........");
            while (true) 
            {
		Socket clientSock = ServSock.accept();
                System.out.println("LogInChecker......");
		NetworkUtilities nc=new NetworkUtilities(clientSock);
		new LogInReadThread(nc);
            }
	}catch(Exception e) 
        {
            System.out.println("LogIncheckerFailed"+e);
	}
    }
        
}
    

