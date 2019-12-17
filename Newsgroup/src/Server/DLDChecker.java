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
class DLDChecker implements Runnable{

        private ServerSocket ServSock;
        private Thread th ;
	
	DLDChecker() 
        {
            th = new Thread( this  ) ;
            th.start() ;
        }

    @Override
    public void run()
    {   
        try
            {
                System.out.println("DLDchecker strting..........");
		ServSock = new ServerSocket(33337);
		while (true) 
                {
		Socket clientSock = ServSock.accept();
                System.out.println("DLDChecker......");
		NetworkUtilities nc=new NetworkUtilities(clientSock);
		new DLDReadWriteThread(nc);
                
		}
            }catch(Exception e)
            {
            System.out.println("DLDChecker failed... "+e);
            }
    }
    
    
}
