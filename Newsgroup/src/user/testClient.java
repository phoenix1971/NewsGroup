/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.Scanner;
import utilities.NetworkUtilities;

/**
 *
 * @author saad
 */
public class testClient
{
	public static void main(String args[]) {
            Scanner input=new Scanner(System.in);
            String s = null ;
            while(true)
            {
            s=input.nextLine();
            if( s != null )
            {
		try {
                        System.out.println("client er khela suru....");
			String serverAddress = "127.0.0.1";
			int serverPort = 33333;
                        NetworkUtilities nc = new NetworkUtilities(serverAddress,serverPort);
//			new ReadThread(nc);
//			new WriteThread(nc,"Client");
                        
                        String name = "saad" ;
                        
                        nc.write(name+":"+s);
                        
                        String sm =(String)nc.read();
                        System.out.println(sm );
                        
		} catch(Exception e) {
			System.out.println (e);
		}
            }
            }
	}
}