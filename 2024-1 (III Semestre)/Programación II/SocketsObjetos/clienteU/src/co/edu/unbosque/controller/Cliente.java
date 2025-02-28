/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import co.edu.unbosque.model.NumeroDTO;

/**
 *
 * @author englinx
 */
public class Cliente extends Thread {
	// initialize socket and input output streams
	private Socket socket;
	private ServerSocket server;
	private Scanner sn;
	private ObjectOutputStream out;
	private ObjectInputStream in; // Input stream from server
	private String address;
	private int port;

	// constructor to put ip address and port
	public Cliente(String address, int port) {
		// initialize socket and input output streams
		this.socket = null;
		this.server = null;
		this.sn = new Scanner(System.in);
		this.out = null;
		this.address = address;
		this.port = port;

	}

	@Override
	public void run() {

		// string to read message from input
		// establish a connection
		try {
			this.socket = new Socket(this.address, this.port);
			System.out.println("Connected");

			// sends output to the socket
			this.out = new ObjectOutputStream(socket.getOutputStream());

			// line = this.input.readLine();
			NumeroDTO num = new NumeroDTO(420);

			this.out.writeObject(num);
			// close socket and output stream
			this.out.close();
			this.socket.close();
			// Create a serverSocket to wait message from server
			this.server = new ServerSocket(this.port + 1);
			this.socket = server.accept();
			System.out.println("Received message:");
			// takes input from the client socket
			this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			// Print in server the client message
			System.out.println(in.readUTF());
			this.in.close();
			this.server.close();
		} catch (IOException i) {
			System.out.println(i);
		}
		// close the connection
		try {
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}

	}

	public static void main(String args[]) {
		// Servidor server = new Servidor(5001);
		Cliente client = new Cliente("127.0.0.1", 5000);
		client.start();

	}

}
