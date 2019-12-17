/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import utilities.NetworkUtilities;

/**
 *
 * @author saad
 */
public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtilities nc;

	public ReadThread(NetworkUtilities nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			while(true) {
				String s=(String)nc.read();
				System.out.println(s);
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}
