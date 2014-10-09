/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerio.jauthenticator.client;

import java.util.Scanner;
import java.util.Timer;

/**
 *
 * @author mpetrak
 */
public class JAuthenticatorClient {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.print("\nInsert secret: ");
		Scanner sc = new Scanner(System.in);
		String secret = sc.next();
		
		Timer timer = new Timer();
		PinPrinter printer = new PinPrinter(secret);
		printer.printHeader();
		timer.scheduleAtFixedRate(printer, 0, 1 * 1000);
	}
}
