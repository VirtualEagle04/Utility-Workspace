package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.MazeGeneratorMatrix;
import model.MazeBFS;
import view.GameFrame;

public class Controller implements KeyListener{
	
	private MazeGeneratorMatrix mazeGen;
	private Scanner sc;
	private GameFrame gameFrame;
	private MazeBFS mazeBFS;
	
	private static int columns;
	private static int rows;
	private static int[][] mazeMatrix;
	private static ArrayList<Integer> mazeMap;
	
	private int intentosGeneracion;
	
	private boolean upP, downP, leftP, rightP;
	private int posX, posY, desplazamiento;
	
	public Controller() {
		mazeGen = new MazeGeneratorMatrix();
		sc = new Scanner(System.in);
		

		
	}

	public void run() {


		mazeMap = new ArrayList<Integer>();
		System.out.println("Ingrese el ancho X de su laberinto: ");
		columns = sc.nextInt();
		System.out.println("Ingrese el largo Y de su laberinto: ");
		rows = sc.nextInt();
		
				//Generar laberintos hasta generar uno con solucion
				do {
					mazeMatrix = mazeGen.generateMaze(rows, columns);
					
					//Rows
					for (int i = 0; i < mazeMatrix.length-1; i++) {
						//Columns
						for (int j = 0; j < mazeMatrix[i].length-1; j++) {
							mazeMap.add(mazeMatrix[i][j]);
						}
					}
					System.out.println(Arrays.deepToString(mazeMatrix).replace("], ", "]\n"));
					//System.out.println("ArrayList: "+mazeMap.toString());
					
		
		
					mazeBFS = new MazeBFS();
					intentosGeneracion++;
					
				} while (!mazeBFS.isSolucion());
		
		
		System.out.println("Numero de intentos en la generacion: "+intentosGeneracion);
		//gameFrame = new GameFrame();
		//gameFrame.repaint();
		//gameFrame.addKeyListener(this);
		
		
		//posX = gameFrame.getGameState().getPlayer().getX();
		//posY = gameFrame.getGameState().getPlayer().getY();
		//desplazamiento = 32;


	}
	

	//Movimiento
				@Override
				public void keyPressed(KeyEvent e) {
			
					
					int code = e.getKeyCode();
					
					if(code == KeyEvent.VK_W) {
						
						//Cuando el jugador trata de moverse fuera del length de la matriz
						try {
							 if (mazeMatrix[(posY/32)-1][posX/32] != 1) {
									upP = true;
									System.out.println("W");
									gameFrame.getGameState().getPlayer().setLocation(posX, posY-desplazamiento);
									gameFrame.getGameState().getPlayer().repaint();
									posX = gameFrame.getGameState().getPlayer().getX();
									posY = gameFrame.getGameState().getPlayer().getY();
							 }
						} catch (ArrayIndexOutOfBoundsException e2) {}

					}
					if(code == KeyEvent.VK_S) {
						try {
							 if (mazeMatrix[(posY/32)+1][posX/32] != 1) {
									downP = true;
									System.out.println("S");
									gameFrame.getGameState().getPlayer().setLocation(posX, posY+desplazamiento);
									gameFrame.getGameState().getPlayer().repaint();
									posX = gameFrame.getGameState().getPlayer().getX();
									posY = gameFrame.getGameState().getPlayer().getY();
							 }
						} catch (ArrayIndexOutOfBoundsException e2) {}

					}
					if(code == KeyEvent.VK_A) {
						try {
							 if (mazeMatrix[posY/32][(posX/32)-1] != 1) {
									leftP = true;
									System.out.println("A");
									gameFrame.getGameState().getPlayer().setLocation(posX-desplazamiento, posY);
									gameFrame.getGameState().getPlayer().repaint();
									posX = gameFrame.getGameState().getPlayer().getX();
									posY = gameFrame.getGameState().getPlayer().getY();
							 }
						} catch (ArrayIndexOutOfBoundsException e2) {}

					}
					if(code == KeyEvent.VK_D) {
						try {
							 if (mazeMatrix[posY/32][(posX/32)+1] != 1) {
									rightP = true;
									System.out.println("D");
									gameFrame.getGameState().getPlayer().setLocation(posX+desplazamiento, posY);
									gameFrame.getGameState().getPlayer().repaint();
									posX = gameFrame.getGameState().getPlayer().getX();
									posY = gameFrame.getGameState().getPlayer().getY();
							 }
						} catch (ArrayIndexOutOfBoundsException e2) {}

					}
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
			
					int code = e.getKeyCode();
					
					if(code == KeyEvent.VK_W) {
						upP = false;
					}
					if(code == KeyEvent.VK_S) {
						downP = false;
					}
					if(code == KeyEvent.VK_A) {
						leftP = false;
					}
					if(code == KeyEvent.VK_D) {
						rightP = false;
					}
				}
				@Override
				public void keyTyped(KeyEvent e) {}
	
	
	//Getters & Setters
	public MazeGeneratorMatrix getMazeGen() {
		return mazeGen;
	}

	public void setMazeGen(MazeGeneratorMatrix mazeGen) {
		this.mazeGen = mazeGen;
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

	public static int getColumns() {
		return columns;
	}

	public static void setColumns(int columns) {
		Controller.columns = columns;
	}

	public static int getRows() {
		return rows;
	}

	public static void setRows(int rows) {
		Controller.rows = rows;
	}

	public static ArrayList<Integer> getMazeMap() {
		return mazeMap;
	}

	public static void setMazeMap(ArrayList<Integer> mazeMap) {
		Controller.mazeMap = mazeMap;
	}

	public static int[][] getMazeMatrix() {
		return mazeMatrix;
	}

	public static void setMazeMatrix(int[][] mazeMatrix) {
		Controller.mazeMatrix = mazeMatrix;
	}

	public boolean isUpP() {
		return upP;
	}

	public void setUpP(boolean upP) {
		this.upP = upP;
	}

	public boolean isDownP() {
		return downP;
	}

	public void setDownP(boolean downP) {
		this.downP = downP;
	}

	public boolean isLeftP() {
		return leftP;
	}

	public void setLeftP(boolean leftP) {
		this.leftP = leftP;
	}

	public boolean isRightP() {
		return rightP;
	}

	public void setRightP(boolean rightP) {
		this.rightP = rightP;
	}

	
}
