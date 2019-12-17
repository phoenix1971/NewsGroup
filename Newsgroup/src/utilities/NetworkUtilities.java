/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author saad
 */
public class NetworkUtilities {
    
    	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public NetworkUtilities(String s, int port) 
        {
		try {
			this.socket=new Socket(s,port);  
			oos=new ObjectOutputStream(socket.getOutputStream());
			ois=new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			System.out.println("In NetworkUtil : " + e.toString());
		}
	}

	public NetworkUtilities(Socket s)
        {
		try {
			this.socket = s;
			oos=new ObjectOutputStream(socket.getOutputStream());
			ois=new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			System.out.println("In NetworkUtil : " + e.toString());
		}
	}

	public Object read() 
        {
		Object o = null;
		try {
			o=ois.readObject();
		} catch (Exception e) {
		  //System.out.println("Reading Error in network : " + e.toString());
		}
		return o;
	}
	
	public void write(Object o) 
        {
		try {
			oos.writeObject(o);                        
		} catch (Exception e) {
			System.out.println("Writing  Error in network : " + e.toString());
		}
	}

	public void closeConnection() 
        {
		try {
			ois.close();
			oos.close();
		} catch (Exception e) {
			System.out.println("Closing Error in network : "  + e.toString());
		}
	}
    
}
