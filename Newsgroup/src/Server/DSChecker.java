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
class DSChecker implements Runnable{

        private ServerSocket ServSock;
        private Thread th ;
	
	DSChecker() 
        {
            th = new Thread( this  ) ;
            th.start() ;
        }

    @Override
    public void run()
    {   
        try
            {
                System.out.println("DSchecker strting..........");
		ServSock = new ServerSocket(33340);
		while (true) 
                {
		Socket clientSock = ServSock.accept();
                System.out.println("DSChecker......");
		NetworkUtilities nc=new NetworkUtilities(clientSock);
		new DSReadWriteThread(nc);
                
		}
            }catch(Exception e)
            {
            System.out.println("DSChecker failed... "+e);
            }
    }
    
    
}
