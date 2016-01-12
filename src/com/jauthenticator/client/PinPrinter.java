package com.jauthenticator.client;

import com.jauthenticator.JAuthenticator;
import java.util.TimerTask;


/**
 *
 * @author mpetrak
 */
public class PinPrinter extends TimerTask {

	private final String secret;
	private String oldPin = "";
	private int count = 1;

	public PinPrinter(String secret) {
		this.secret = secret;
	}
	
	public void printHeader() {
		System.out.println("|--------|-----------------------------|");
		System.out.println("|  Code  |             Time            |");
		System.out.println("|--------|-----------------------------|");
	}

	@Override
	public void run() {
		/* compute pin */
		String pin = JAuthenticator.computePin(secret);
		
		/* if pin is time - valid, print "." */
		if (oldPin.equals(pin)) {
			System.out.print(".");
		} else {
			
			/* fill remaining space - for initial synchronization */
			if(!oldPin.isEmpty()) {
				if (count <= 30) {
					for (int i = count + 1; i <= 30; i++) {
						System.out.print("#");
					}
				}

				System.out.println("|");
			}
			
			/* print new pin */
			System.out.print("| " + pin + " |");
			count = 0;
		}
		
		oldPin = pin;
		count++;
	}
}
