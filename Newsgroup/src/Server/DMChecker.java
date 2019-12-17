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
class DMChecker implements Runnable{

        private ServerSocket ServSock;
        private Thread th ;
	
	DMChecker() 
        {
            th = new Thread( this  ) ;
            th.start() ;
        }

    @Override
    public void run()
    {   
        try
            {
                System.out.println("DMchecker strting..........");
		ServSock = new ServerSocket(33341);
		while (true) 
                {
		Socket clientSock = ServSock.accept();
                System.out.println("DMChecker......");
		NetworkUtilities nc=new NetworkUtilities(clientSock);
		new DMReadWriteThread(nc);
                
		}
            }catch(Exception e)
            {
            System.out.println("DMChecker failed... "+e);
            }
    }
    
    
}
