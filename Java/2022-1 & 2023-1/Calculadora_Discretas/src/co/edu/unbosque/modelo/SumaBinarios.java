package co.edu.unbosque.modelo;

import co.edu.unbosque.controlador.Controlador;

public class SumaBinarios {
	
	private Controlador c;
	private String reves = "";
	
	public SumaBinarios(String n1, String n2) {
		c = new Controlador();
		
		String mayor = "";
		String menor = "";
		
		if (Long.parseLong(n1) > Long.parseLong(n2)) {
			mayor = n1;
			menor = n2;
		}
		else if (Long.parseLong(n1) < Long.parseLong(n2)) {
			mayor = n2;
			menor = n1;
		}
		else if (Long.parseLong(n1) == Long.parseLong(n2)) {
			mayor = n1;
		}

		int[] numsMayor = new int[mayor.length()];
		int[] numsMenor = new int[mayor.length()];
		
		int x = 0;
		//Reves y Convertirlos a Integer
		for (int j = n1.length()-1; j >= 0; j--) {
			numsMayor[x] = Integer.parseInt(Character.toString(n1.charAt(j)));
			x++;
		}
		//System.out.println(Arrays.toString(numsMayor)+"\n");
		
		int y = 0;
		//Reves y Convertirlos a Integer
		for (int j = n2.length()-1; j >= 0; j--) {
			numsMenor[y] = Integer.parseInt(Character.toString(n2.charAt(j)));
			y++;
		}
		//System.out.println(Arrays.toString(numsMenor));
		


		
		String res = "";
		int[] arriba = new int[mayor.length()];
		arriba[0] = 0;
		
		if (mayor.length() == 1) {
			if ((numsMayor[0] + numsMenor[0]) == 2){
				res += 0;
				res += 1;
			}
			else if ((numsMayor[0] + numsMenor[0]) == 1){
				res += 1;
			}
		}
		else if (mayor.length() != 1){
			for (int i = 0; i < mayor.length(); i++ ) {
				int temp = 0;
				temp = numsMayor[i] +  numsMenor[i] + arriba[i];
				if (temp == 0) {
					try {
						arriba[i+1] = 0;
						res += 0;
					} catch (IndexOutOfBoundsException e) {
						res += 0;
					}
				}
				else if (temp == 1) {
					try {
						arriba[i+1] = 0;
						res += 1;
					} catch (IndexOutOfBoundsException e) {
						res += 1;
					}
				}
				else if (temp == 2) {
					try {
						arriba[i+1] = 1;
						res += 0;
					} catch (IndexOutOfBoundsException e) {
						res += 0+""+1;
					}
				}
				else if (temp == 3) {
					try {
						arriba[i+1] = 1;
						res += 1;
					} catch (IndexOutOfBoundsException e) {
						res += 1+""+1;
					}
				}
				
			}
		}
		
		for (int r = res.length()-1; r >= 0; r--) {
			reves += res.charAt(r);
		}
	}

	public String getReves() {
		return reves;
	}

	public void setReves(String reves) {
		this.reves = reves;
	}
}
