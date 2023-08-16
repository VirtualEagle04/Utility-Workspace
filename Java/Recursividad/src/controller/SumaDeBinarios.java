package controller;

public class SumaDeBinarios {

	static int add(int x, int y) {
		int carry = (x & y)<<1;
		int res = x^y;
		if(carry == 0) return res;
		
		System.out.println(carry + " "+ res);
		return add(carry, res);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(add(20, 5));
		
	}
}
