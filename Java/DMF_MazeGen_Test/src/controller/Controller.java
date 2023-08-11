package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.MazeGenerator;
import view.GameFrame;

public class Controller {
	
	private static MazeGenerator mg;
	private Scanner sc;
	private GameFrame gameFrame;
	public static int ancho;
	public static int alto;
	private static ArrayList<Integer> mazeMap;
	
	public Controller() {
		mg = new MazeGenerator();
		sc = new Scanner(System.in);
		
	}
	
	public void run() {
		System.out.println("Ancho: ");	
		ancho = sc.nextInt();
		System.out.println("Alto: ");
		alto = sc.nextInt();

		mg.generateMaze(ancho, alto);
		
		
		//gameFrame = new GameFrame();
	}

	
	//Getters & Setters
	public MazeGenerator getMg() {
		return mg;
	}

	public void setMg(MazeGenerator mg) {
		Controller.mg = mg;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public static int getAncho() {
		return ancho;
	}

	public static void setAncho(int ancho) {
		Controller.ancho = ancho;
	}

	public static int getAlto() {
		return alto;
	}

	public static void setAlto(int alto) {
		Controller.alto = alto;
	}

	public static ArrayList<Integer> getMazeMap() {
		return mazeMap;
	}

	public static void setMazeMap(ArrayList<Integer> mazeMap) {
		Controller.mazeMap = mazeMap;
	}

	
}
