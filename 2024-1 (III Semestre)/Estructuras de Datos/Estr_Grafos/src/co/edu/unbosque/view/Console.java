package co.edu.unbosque.view;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);
	private static String[] tree = { "\u2500", "\u2502", "\u2514", "\u251C" };

	static {
		
		try {
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
	}

	/***
	 * @param index 0[Horizontal], 1[Vertical], 2[L], 3[Node]
	 */
	public static void printTree(int index) {
		System.out.print(tree[index]);
	}

	/***
	 * @param index 0[Horizontal], 1[Vertical], 2[L], 3[Node]
	 */
	public static void printLineTree(int index) {
		System.out.println(tree[index]);
	}

	public static void printLine(String txt) {
		System.out.println(txt);
	}

	public static void print(String txt) {
		System.out.print(txt);
	}

	public static void printSuccessLine(String txt) {
		System.out.println("\u001B[32m" + txt + "\u001B[0m");
	}

	public static void printSuccess(String txt) {
		System.out.print("\u001B[32m" + txt + "\u001B[0m");
	}

	public static void printErrLine(String txt) {
		System.err.println(txt);
	}

	public static void printErr(String txt) {
		System.err.print(txt);
	}

	public static int readInt() {
		return sc.nextInt();
	}

	public static long readLong() {
		return sc.nextLong();
	}

	public static String readLine() {
		return sc.nextLine();
	}

	public static String read() {
		return sc.next();
	}

	public static float readFloat() {
		return sc.nextFloat();
	}

	public static double readDouble() {
		return sc.nextDouble();
	}

	public static char readChar() {
		return sc.next().charAt(0);
	}

	public static boolean readBoolean() {
		return sc.nextBoolean();
	}

	public static void burnLine() {
		sc.nextLine();
	}

}
