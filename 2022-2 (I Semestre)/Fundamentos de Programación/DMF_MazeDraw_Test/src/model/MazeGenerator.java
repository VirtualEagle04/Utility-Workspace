package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
	
    private Stack<Node> stack = new Stack<>();
    private Random rand = new Random();
    private int[][] maze;
    private int dimension;
	
	public MazeGenerator(int dim) {
        maze = new int[dim][dim];
        dimension = dim;
	}
	
	public void generateMaze() {
        stack.push(new Node(0,0));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                maze[next.y][next.x] = 1;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
            }
        }
    }
    
    public ArrayList getListMaze() {
    	
    	ArrayList<Integer> mazeMap = new ArrayList<Integer>();
    	for (int[] row : maze) {
    		for (int element : row) {
    			mazeMap.add(element);
    		}
    	}   	
    	return mazeMap;
    }

    public String getRawMaze() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            sb.append(Arrays.toString(row) + "\n");
        }
        return sb.toString();
    }

    public String getSymbolicMaze() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(maze[i][j] == 1 ? "*" : " ");
                sb.append("  "); 
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && maze[y][x] == 1) {
                    numNeighboringOnes++;
                }
            }
        }
        return (numNeighboringOnes < 3) && maze[node.y][node.x] != 1;
    }

    private void randomlyAddNodesToStack(ArrayList<Node> nodes) {
        int targetIndex;
        while (!nodes.isEmpty()) {
            targetIndex = rand.nextInt(nodes.size());
            stack.push(nodes.remove(targetIndex));
        }
    }

    private ArrayList<Node> findNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (int y = node.y-1; y < node.y+2; y++) {
            for (int x = node.x-1; x < node.x+2; x++) {
                if (pointOnGrid(x, y) && pointNotCorner(node, x, y)
                    && pointNotNode(node, x, y)) {
                    neighbors.add(new Node(x, y));
                }
            }
        }
        return neighbors;
    }

    private Boolean pointOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < dimension && y < dimension;
    }

    private Boolean pointNotCorner(Node node, int x, int y) {
        return (x == node.x || y == node.y);
    }
    
    private Boolean pointNotNode(Node node, int x, int y) {
        return !(x == node.x && y == node.y);
    }
    
//	public ArrayList<Integer> generateMaze(dim) {
//		
//		Random rnd = new Random();
//		String maze = "";
//		
//		ArrayList<Integer> mazeMap = new ArrayList<Integer>();
//		int[] col = new int[x];
//		int[] fil = new int[y];
//		
//		for (int i = 0; i < fil.length; i++) {
//			
//			for (int j = 0; j < col.length; j++) {
//				int temp = rnd.nextInt(2) ;
//				col[j] = temp;
//				maze += temp+" ";
//				mazeMap.add(temp);
//			}
//			maze += "\n";
//		}
//		System.out.println(maze);
//		System.out.println(mazeMap.toString());
//
//		
//		return mazeMap;
//	}
	
	
	
	
	
}
