package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
	
	public MazeGenerator() {}

	public ArrayList<Integer> generateMaze(int x, int y) {
		
		Random rnd = new Random();
		String maze = "";
		
		ArrayList<Integer> mazeMap = new ArrayList<Integer>();
		int[] col = new int[x];
		int[] fil = new int[y];
		
		for (int i = 0; i < fil.length; i++) {
			
			for (int j = 0; j < col.length; j++) {
				int temp = rnd.nextInt(2) ;
				col[j] = temp;
				maze += temp+" ";
				mazeMap.add(temp);
			}
			maze += "\n";
		}
		System.out.println(maze);
		System.out.println(mazeMap.toString());

		
		return mazeMap;
	}
	
	
	
	
	
}
