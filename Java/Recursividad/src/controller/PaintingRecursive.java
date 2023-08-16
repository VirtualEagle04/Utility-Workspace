package controller;

import java.util.Scanner;

public class PaintingRecursive {

	public char[][] matrix;
	public Scanner sc;

	public PaintingRecursive() {
		sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int walls = sc.nextInt();
		System.out.println();

		matrix = new char[x][y];

		fill(matrix, 0, 0); //RECURSIVO

		print(matrix, 0, 0); // DEBUG
		
		fillWalls(matrix, 0, walls); //RECURSIVO
		
		print(matrix, 0, 0); //DEBUG
		
		int numPainters = sc.nextInt();
		startPainters(numPainters, 0); //RECURSIVO
		
		print(matrix, 0, 0); //DEBUG
		
		System.exit(0);
	}
	
	//RECURSIVO
	public void startPainters(int numPainters, int cont) {
		
		if(cont == numPainters) {
			return;
		}
		else {
			cont++;
			paint(sc.nextInt(), sc.nextInt(), 0);
			startPainters(numPainters, cont);
		}
		
	}
	
	//RECURSIVO
	public void fillWalls(char[][] m, int cont, int walls) {
		
		if(cont == walls) {
			return;
		}
		else {
			m[sc.nextInt()][sc.nextInt()] = '*';
			cont++;
			fillWalls(m, cont, walls);
		}
		
	}
	
	//RECURSIVO
	public void fill(char[][] m, int posRow, int posCol) {

		if (posRow == m.length) {
			return;
		} else if (posCol < m[0].length) {
			m[posRow][posCol] = '#';
			fill(m, posRow, posCol + 1);
		} else {
			fill(m, posRow + 1, 0);
		}

	}
	
	//RECURSIVO
	public void print(char[][] m, int posRow, int posCol) {
		
		if(posRow == m.length) {
			System.out.println("-----------------------");
			return;
		} else if(posCol < m[0].length) {
			System.out.print(m[posRow][posCol] + " ");
			print(m, posRow, posCol + 1);
		}
		else {
			System.out.println();
			print(m, posRow + 1, 0);
		}
		
	}

	public boolean isValid(int x, int y) {

		try {
			char aux = matrix[x][y];
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}

	}
	
	//RECURSIVO
	public void paint(int posX, int posY, int cont) {
		int[] movex = { 0, 0, 1, -1 };
		int[] movey = { -1, 1, 0, 0 };
		
		if(cont == 4) {
			return;
		}else {
			int posxactual = posX + movex[cont];
			int posyactual = posY + movey[cont];
			
			if (isValid(posxactual, posyactual)) {
				if (matrix[posX][posY] == '#') {
					matrix[posX][posY] = '@';
				} else if (matrix[posX][posY] == '*') {
					return;
				}
				if (matrix[posxactual][posyactual] == '*') {
					paint(posX, posY, cont + 1);
				} else if (matrix[posxactual][posyactual] == '@') {
					paint(posX, posY, cont + 1);
				} else if (matrix[posxactual][posyactual] == '#') {
					//matrix[posxactual][posyactual] = '@';
					paint(posxactual, posyactual, 0);
				}
			}
			paint(posX, posY, cont + 1);
		}
		
	}
}