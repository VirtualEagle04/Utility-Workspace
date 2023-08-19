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

import co.edu.unbosque.model.NumeroDTO;

/**
 *
 * @author englinx
 */
public class Servidor extends Thread {
	// initialize socket and input stream
	private Socket socket; // This socket is for read client message
	private Socket socketR;// This socket is for send a message to client
	private ServerSocket server;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private int port;
	private String addressClient;

	// constructor with port
	public Servidor(int port) {
		// initialize socket and input stream
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.addressClient = addressClient;

	}

	@Override
	public void run() {

		NumeroDTO num;
		try {
			this.server = new ServerSocket(this.port);
			System.err.println("Server started in port: " + this.port);
			System.err.println("Waiting for a client ...");
			this.socket = server.accept();
			System.out.println("Client accepted");
			
			// Takes input from the client socket
			this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			// Read an object sent from client
			num = (NumeroDTO) in.readObject();
			
			// Create a socket to send message to client
			this.socketR = new Socket(this.socket.getInetAddress(), this.port + 1);
			
			// Sends output to the socket to client
			this.out = new ObjectOutputStream(socketR.getOutputStream());
			NumeroDTO numSend = new NumeroDTO(5);
			this.out.writeObject(numSend);
			System.out.println("Server sending -> " + num.toString());
			
			this.out.close();
			this.socketR.close();

			this.in.close();
			this.server.close();
		} catch (IOException i) {
			System.err.println(i);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		System.err.println("---Closing connection with client---");
		
		try {
			socket.close();
			in.close();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public static void main(String args[]) {

		Servidor server = new Servidor(5000);
		server.start();
	}

}
