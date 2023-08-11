package model;

import java.util.LinkedList;

import controller.Controller;

public class MazeBFSTest {
	
	public class Coord{
		int x;
		int y;
		
		public Coord() {}
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		
	}

	private Controller c;
	
	private int tamañoMatriz; //Columnas x Filas
	private int[][] mazeMatrix;
	private boolean[][] visitado;
	private Coord startXY, endXY;
	private LinkedList<Coord> cola = new LinkedList<Coord>();
	

	
	
	public MazeBFSTest() {
		c = new Controller();
		tamañoMatriz = (c.getRows()+2)*(c.getColumns()+2);
		mazeMatrix = c.getMazeMatrix();
		visitado = new boolean[tamañoMatriz][tamañoMatriz];
		
				//Buscar Coordenadas del Inicio
				for (int i = 0; i < mazeMatrix.length; i++) {
					
					for (int j = 0; j < mazeMatrix[0].length; j++) {
						if (mazeMatrix[i][j] == 3) {
							startXY = new Coord(i, j);
						}
					}
				}
				//Buscar Coordenadas del Final
				for (int i = 0; i < mazeMatrix.length; i++) {
					
					for (int j = 0; j < mazeMatrix[0].length; j++) {
						if (mazeMatrix[i][j] == 4) {
							endXY = new Coord(i, j);
						}
					}
				}
		this.BFS(startXY, endXY);

	}
	
	public void BFS(Coord startXY, Coord endXY) {
		
		
		int[] desplazamientoX = {-1, +1, 0, 0}; //x-1, x+1, y-0, y+0 (izquierda, derecha, arriba, abajo)
		int[] desplazamientoY = {0, 0, -1, +1}; //x-0, x+0, y-1, y+1 (izquierda, derecha, arriba, abajo)
		
		//Inicializar los valores del array Visitado como falsos
		for (int i = 0; i < tamañoMatriz; i++) {
			for (int j = 0; j < tamañoMatriz; j++) {
				visitado[i][j] = false;
			}
		}
		
		cola.add(startXY);
		Coord actualXY = new Coord(startXY.getX(), startXY.getY());
		
		for (int i = 0; i < 4; i++) {
			Coord tempXY = new Coord();
			try {
				if(mazeMatrix[actualXY.getY()+desplazamientoY[i]][actualXY.getX()+desplazamientoX[i]] != 1 
						&& actualXY.getY()+desplazamientoY[i] != -1 
						&& actualXY.getX()+desplazamientoX[i] != -1) {
				
				tempXY.setY(actualXY.getY()+desplazamientoY[i]);
				tempXY.setX(actualXY.getX()+desplazamientoX[i]);
				
				
				cola.addLast(tempXY);
				
			}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("error");
			}

			
		}
		
		
		
	}
	
	

}
