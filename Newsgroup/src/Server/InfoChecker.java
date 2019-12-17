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
class InfoChecker implements Runnable{

        private ServerSocket ServSock;
        private Thread th ;

    public InfoChecker() 
    {
        th = new Thread( this  ) ;
        th.start() ;
    }

    @Override
    public void run()
    {   
        try
            {
                System.out.println("InfoChecker strting..........");
		ServSock = new ServerSocket(33336);
		while (true) 
                {
		Socket clientSock = ServSock.accept();
                System.out.println("InfoChecker......");
		NetworkUtilities nc=new NetworkUtilities(clientSock);
		new InfoThread(nc);
                
		}
            }catch(Exception e)
            {
            System.out.println("InfoChecker failed... "+e);
            }
    }
    
    
}
