package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.MazeGenerator;
import view.GameFrame;

public class Controller {
	
	private static MazeGenerator mg;
	private Scanner sc;
	private GameFrame gameFrame;
	public static int dim;
	
	private static ArrayList<Integer> mazeMap;
	
	public Controller() {

		sc = new Scanner(System.in);
		
	}
	
	public void run() {
		System.out.println("Dim: ");
		dim = sc.nextInt();
		mg = new MazeGenerator(dim);
		
		mg.generateMaze();
		mazeMap = mg.getListMaze();
		
		System.out.println(mg.getRawMaze());
		System.out.println(mazeMap.toString());
		
		gameFrame = new GameFrame();
	}

	public MazeGenerator getMg() {
		return mg;
	}

	public void setMg(MazeGenerator mg) {
		this.mg = mg;
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

	public static ArrayList<Integer> getMazeMap() {
		return mazeMap;
	}

	public static void setMazeMap(ArrayList<Integer> mazeMap) {
		Controller.mazeMap = mazeMap;
	}

	public static int getDim() {
		return dim;
	}

	public static void setDim(int dim) {
		Controller.dim = dim;
	}
	
}
