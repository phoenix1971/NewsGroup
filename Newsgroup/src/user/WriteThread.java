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
public class WriteThread implements Runnable {
	
	private Thread thr;
	private NetworkUtilities nc;
	String name;

	public WriteThread(NetworkUtilities nc,String name) {
		this.nc = nc;
		this.name=name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			Scanner input=new Scanner(System.in);
			while(true) {
				String s=input.nextLine();
				nc.write(name+":"+s);																
			}
		} catch(Exception e) {
			System.out.println (e);
		}			
		nc.closeConnection();
	}
}
