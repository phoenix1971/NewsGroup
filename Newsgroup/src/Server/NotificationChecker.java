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
class NotificationChecker implements Runnable{

        private ServerSocket ServSock;
        private Thread th ;

    public NotificationChecker() 
    {
        th = new Thread( this  ) ;
        th.start() ;
    }

    @Override
    public void run()
    {   
        try
            {
                System.out.println("Notificationchecker strting..........");
		ServSock = new ServerSocket(33335);
		while (true) 
                {
		Socket clientSock = ServSock.accept();
                System.out.println("NotificationChecker......");
		NetworkUtilities nc=new NetworkUtilities(clientSock);
		new NotificationThread(nc);
                
		}
            }catch(Exception e)
            {
            System.out.println("NotificationChecker failed... "+e);
            }
    }
    
    
}
