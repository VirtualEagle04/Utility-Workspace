package controller;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SeekEmpty {

	public static Scanner sc = new Scanner(System.in);
	public static Random r = new Random();
	public static char[] chairRow;

	static void fill() { Arrays.fill(chairRow, '@'); }
	
	static void print(int pos) {
		if(pos == 0) {
			System.out.print("|");
		}
		if(pos == chairRow.length) {
			System.out.println();
			return;
		}
		else {
			System.out.print(chairRow[pos] + "|");
			print(pos + 1);
		}
	}
	static void addSpaces() {
		int cant = r.nextInt(chairRow.length);
		System.out.println("Chairs to remove: "+cant);
		for(int i = 0; i < cant; i++) {
			int pos = r.nextInt(chairRow.length);
			System.out.println("Chair to remove in pos: "+pos);
			if(chairRow[pos] == ' ') {
				System.err.println(pos+ " was already empty.");
				cant++;
			}
			else {
				chairRow[pos] = ' ';
				System.err.println(pos + " is not empty.");
			}
			print(0);
		}		
	}
	
	static void addSpaces(int i, int cant) {
		if(i == cant) return;
		int pos = r.nextInt(chairRow.length);
		if(chairRow[pos] == ' ') {
			System.err.println(pos+ " was already empty.");
			cant++;
		}
		else {
			chairRow[pos] = ' ';
			System.err.println(pos + " is not empty.");
		}
		print(0);
		addSpaces(i+1, cant);
		
		
	}
	
	static int countSpaces(int pos, int count) {
		
		if(pos == chairRow.length) return count;
		if(chairRow[pos] != ' ') count = countSpaces(pos+1, count);
		else return countSpaces(pos+1, count+1);
		return count;
		
	}
	
//	static int countSpaces(int pos, int count) {
//		if(pos == chairRow.length) {
//			return count;
//		}
//		else if(chairRow[pos] == ' ') {
//			count++;
//			count = countSpaces(pos+1, count);
//		}
//		else if(chairRow[pos] != ' ') {
//			count = countSpaces(pos+1, count); 
//		}
//		return count;
//	}
//	
	public static void main(String[] args) {
		int charCant = sc.nextInt();
		chairRow = new char[charCant];
		fill();
		print(0);
		int cant = r.nextInt(chairRow.length);
		System.out.println("Chairs to remove: "+cant);
		addSpaces(0, cant);
		print(0);
		System.err.println("Number of spaces: " + countSpaces(0, 0));
		
	}

}
