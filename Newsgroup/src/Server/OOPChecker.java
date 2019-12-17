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
class OOPChecker implements Runnable{

        private ServerSocket ServSock;
        private Thread th ;
	
	OOPChecker() 
        {
            th = new Thread( this  ) ;
            th.start() ;
        }

    @Override
    public void run()
    {   
        try
            {
                System.out.println("OOPchecker strting..........");
		ServSock = new ServerSocket(33334);
		while (true) 
                {
		Socket clientSock = ServSock.accept();
                System.out.println("OOPChecker......");
		NetworkUtilities nc=new NetworkUtilities(clientSock);
		new OOPReadWriteThread(nc);
                
		}
            }catch(Exception e)
            {
            System.out.println("OOPChecker failed... "+e);
            }
    }
    
    
}
