package controller;

import java.util.Scanner;

public class Painting {
	
	static char[][]matrix;
	static Scanner sc;
	
	public Painting() {
		 sc = new Scanner(System.in);
		 
		 int x = sc.nextInt();
		 int y= sc.nextInt();
		 int walls = sc.nextInt();
		 matrix= new char[x][y];
			 
		fill(matrix);
//		print(matrix);
		for (int i = 0; i < walls; i++) {
			matrix[sc.nextInt()][sc.nextInt()]='*';
		}
		print(matrix);
		
		int numPainters = sc.nextInt();
		for (int i = 0; i < numPainters; i++) {
			paint(sc.nextInt(), sc.nextInt());
		}
		print(matrix);
		
	}


	 static void fill(char [][]m) {
		 for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = '#';
			}
		}
	 }
	 
	 static void print(char[][]m) {
		 
		 for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
			System.out.print(m[i][j]);	
			}
			System.out.println();
		}
		 
	 }
	 
	 static boolean isValid(int x, int y) {
		 
		 try {
			char aux = matrix[x][y];
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		 
	 }
	 
	 static void paint(int posx, int posy) {
		 int[] movex = {0,0,1,-1};
		 int[] movey = {-1,1,0,0};
		 
		 for (int i = 0; i < movey.length; i++) {
			int posxactual = posx + movex[i];
			int posyactual = posy + movey[i];
			
			if(isValid(posxactual,posyactual)) {
				if(matrix[posx][posy] == '#') {
					matrix[posx][posy] = '@';
				}
				else if(matrix[posx][posy]=='*') {//en este momento, similar a fibonacci
					return;
				}
				else if(matrix[posxactual][posyactual]=='*') {//siguiente pos
					continue;
				}
				else if(matrix[posxactual][posyactual]=='@') {
					continue;
				}
				else if(matrix[posxactual][posyactual]=='#') {
					matrix[posxactual][posyactual] = '@';
					paint(posxactual, posyactual);
				}
			}
		}
	 } 
}