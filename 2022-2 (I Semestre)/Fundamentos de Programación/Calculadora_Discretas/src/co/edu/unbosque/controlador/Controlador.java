package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import co.edu.unbosque.modelo.BinarioDecimal;
import co.edu.unbosque.modelo.DecimalBinario;
import co.edu.unbosque.modelo.DecimalHexadecimal;
import co.edu.unbosque.modelo.DecimalOctal;
import co.edu.unbosque.modelo.Divisores;
import co.edu.unbosque.modelo.Factorial;
import co.edu.unbosque.modelo.HexadecimalDecimal;
import co.edu.unbosque.modelo.MCD;
import co.edu.unbosque.modelo.MCM;
import co.edu.unbosque.modelo.OctalDecimal;
import co.edu.unbosque.modelo.SumaBinarios;
import co.edu.unbosque.vista.Calculadora;

public class Controlador implements ActionListener {

	private Calculadora cal;
	private long num1, num2;

	// Operaciones
	private BinarioDecimal binDec;
	private OctalDecimal octDec;
	private HexadecimalDecimal hexDec;
	private DecimalBinario decBin;
	private DecimalOctal decOct;
	private DecimalHexadecimal decHex;
	private Divisores divisores;
	private Factorial factorial;
	private MCD mcd;
	private MCM mcm;
	private SumaBinarios sumBin;

	public Controlador() {

	}

	public void run() {
		cal = new Calculadora();
		agregarLectores();
	}

	public void agregarLectores() {
		for (int i = 0; i < cal.getBotones_numeros().length - 2; i++) {
			cal.getBotones_numeros()[i].addActionListener(this);
			cal.getBotones_numeros()[i].setActionCommand("calBoton" + i);
		}

		cal.getBotones_numeros()[10].addActionListener(this);
		cal.getBotones_numeros()[10].setActionCommand("calBoton000");

		cal.getBotones_numeros()[11].addActionListener(this);
		cal.getBotones_numeros()[11].setActionCommand("calBoton.");

		cal.getAns().addActionListener(this);
		cal.getAns().setActionCommand("calBotonAns");

		cal.getDel().addActionListener(this);
		cal.getDel().setActionCommand("calBotonDEL");

		cal.getAc().addActionListener(this);
		cal.getAc().setActionCommand("calBotonAC");

		cal.getMas().addActionListener(this);
		cal.getMas().setActionCommand("calBotonMas");

		cal.getMenos().addActionListener(this);
		cal.getMenos().setActionCommand("calBotonMenos");

		cal.getDiv().addActionListener(this);
		cal.getDiv().setActionCommand("calBotonDiv");

		cal.getMult().addActionListener(this);
		cal.getMult().setActionCommand("calBotonMult");

		cal.getMod().addActionListener(this);
		cal.getMod().setActionCommand("calBotonMod");

		cal.getIgual().addActionListener(this);
		cal.getIgual().setActionCommand("calBotonIgual");

		// MenuItem
		cal.getCalc_standar().addActionListener(this);
		cal.getCalc_standar().setActionCommand("op_calculator");
		
		cal.getConvBases().addActionListener(this);
		cal.getConvBases().setActionCommand("op_convBases");

		cal.getDivisores().addActionListener(this);
		cal.getDivisores().setActionCommand("op_divisores");

		cal.getFactorial().addActionListener(this);
		cal.getFactorial().setActionCommand("op_factorial");

		cal.getMcd().addActionListener(this);
		cal.getMcd().setActionCommand("op_mcd");

		cal.getMcm().addActionListener(this);
		cal.getMcm().setActionCommand("op_mcm");

		cal.getSumaBin().addActionListener(this);
		cal.getSumaBin().setActionCommand("op_sumaBin");

		// JComboBox

		cal.getSistema_entrada().addActionListener(this);
		cal.getSistema_entrada().setActionCommand("drop_entrada");

		cal.getSistema_salida().addActionListener(this);
		cal.getSistema_salida().setActionCommand("drop_salida");

		cal.getConvertir().addActionListener(this);
		cal.getConvertir().setActionCommand("convertir");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "op_calculator": {
			cal.getVisor().setText("");
			num1 = 0;
			num2 = 0;
			
			cal.getSumBin().setVisible(false);
			cal.getInstrucciones_abMCM().setVisible(false);
			cal.getInstrucciones_ab().setVisible(false);
			cal.getDiv_indicador().setVisible(false);
			cal.getEntrada().setText("");
			cal.getSalida().setText("");
			cal.getEntrada().setBounds(20, 20, 340, 55);
			cal.getNumero_divisores().setVisible(false);
			cal.getTextAreaDivisores().setVisible(false);
			cal.getScrollPane().setVisible(false);
			cal.getFact_indicador().setVisible(false);
			
			cal.getVisor().setVisible(true);
			cal.getEntrada().setVisible(false);
			cal.getSalida().setVisible(false);
			cal.getFlecha_indicadora().setVisible(false);
			cal.getSistema_entrada().setVisible(false);
			cal.getSistema_salida().setVisible(false);
			cal.getConvertir().setVisible(false);
			
			
			break;
		}
		case "convertir": {
			int entrada = cal.getSistema_entrada().getSelectedIndex();
			int salida = cal.getSistema_salida().getSelectedIndex();

			entrada: switch (entrada) {
			// Binario
			case 0: {
				int bin = 0;

				try {
					bin = Integer.parseInt(cal.getEntrada().getText());
				} catch (NumberFormatException e2) {
					cal.getSalida().setText("Syntax Error");
				}
				
				String binString = String.valueOf(bin);
				if (binString.matches("[0-1]+") == false) {
					cal.getSalida().setText("No Binary");
				}
				else {
					binDec = new BinarioDecimal(bin);
					int dec = binDec.getResultado();

					salida: switch (salida) {
						// Binario Salida
						case 0: {
							decBin = new DecimalBinario(dec);
							String res = decBin.getResultado();
		
							cal.getSalida().setText(res);
		
							break salida;
						}
						// Octal Salida
						case 1: {
		
							decOct = new DecimalOctal(dec);
							String res = decOct.getResultado();
		
							cal.getSalida().setText(res);
							break salida;
						}
						// Decimal Salida
						case 2: {
		
							cal.getSalida().setText(dec + "");
		
							break salida;
						}
						// Hexadecimal Salida
						case 3: {
		
							decHex = new DecimalHexadecimal(dec);
							String res = decHex.getResultado();
		
							cal.getSalida().setText(res);
		
							break salida;
						}
					}
				}
				
				
				
				break entrada;
			}
			// Octal
			case 1: {

				int oct = 0;
				try {
					oct = Integer.parseInt(cal.getEntrada().getText());
				} catch (NumberFormatException e2) {
					cal.getSalida().setText("SyntaxError");
				}
				
				String octalString = String.valueOf(oct);
				if (octalString.matches("[0-7]+") == false) {
					cal.getSalida().setText("No Octal");
				}
				else {
					octDec = new OctalDecimal(oct);
					int dec = octDec.getResultado();

					salida: switch (salida) {
						// Binario Salida
						case 0: {
							decBin = new DecimalBinario(dec);
							String res = decBin.getResultado();
		
							cal.getSalida().setText(res);
		
							break salida;
						}
						// Octal Salida
						case 1: {
		
							decOct = new DecimalOctal(dec);
							String res = decOct.getResultado();
		
							cal.getSalida().setText(res);
							break salida;
						}
						// Decimal Salida
						case 2: {
		
							cal.getSalida().setText(dec + "");
		
							break salida;
						}
						// Hexadecimal Salida
						case 3: {
		
							decHex = new DecimalHexadecimal(dec);
							String res = decHex.getResultado();
		
							cal.getSalida().setText(res);
		
							break salida;
						}
					}
				}

				break entrada;
			}
			// Decimal
			case 2: {

				int dec = 0;

				try {
					dec = Integer.parseInt(cal.getEntrada().getText());
				} catch (NumberFormatException e2) {
					cal.getSalida().setText("Syntax Error");
				}

				salida: switch (salida) {
					// Binario Salida
					case 0: {
						decBin = new DecimalBinario(dec);
						String res = decBin.getResultado();
	
						cal.getSalida().setText(res);
	
						break salida;
					}
					// Octal Salida
					case 1: {
	
						decOct = new DecimalOctal(dec);
						String res = decOct.getResultado();
	
						cal.getSalida().setText(res);
						break salida;
					}
					// Decimal Salida
					case 2: {
	
						cal.getSalida().setText(dec + "");
	
						break salida;
					}
					// Hexadecimal Salida
					case 3: {
	
						decHex = new DecimalHexadecimal(dec);
						String res = decHex.getResultado();
	
						cal.getSalida().setText(res);
	
						break salida;
					}
				}
				break entrada;
			}
			// Hexadecimal
			case 3: {

				String hex = cal.getEntrada().getText();

				if (hex.matches("[0-9a-fA-F]+") == false) {
					cal.getSalida().setText("No Hexadecimal");
				}
				else{
					hexDec = new HexadecimalDecimal(hex);

					int dec = hexDec.getResultado();

					salida: switch (salida) {
					// Binario Salida
					case 0: {
						decBin = new DecimalBinario(dec);
						String res = decBin.getResultado();

						cal.getSalida().setText(res);

						break salida;
					}
					// Octal Salida
					case 1: {

						decOct = new DecimalOctal(dec);
						String res = decOct.getResultado();

						cal.getSalida().setText(res);
						break salida;
					}
					// Decimal Salida
					case 2: {

						cal.getSalida().setText(dec + "");

						break salida;
					}
					// Hexadecimal Salida
					case 3: {

						decHex = new DecimalHexadecimal(dec);
						String res = decHex.getResultado();

						cal.getSalida().setText(res);

						break salida;
					}
					}
				}

				break entrada;
			}
			}

			break;
		}
		case "op_convBases": {
			num1 = 0;
			num2 = 0;
			
			cal.getSumBin().setVisible(false);
			cal.getInstrucciones_abMCM().setVisible(false);
			cal.getInstrucciones_ab().setVisible(false);
			cal.getDiv_indicador().setVisible(false);
			cal.getEntrada().setText("");
			cal.getSalida().setText("");
			cal.getEntrada().setBounds(20, 20, 340, 55);
			cal.getNumero_divisores().setVisible(false);
			cal.getTextAreaDivisores().setVisible(false);
			cal.getScrollPane().setVisible(false);
			cal.getFact_indicador().setVisible(false);
			
			cal.getVisor().setVisible(false);
			cal.getEntrada().setVisible(true);
			cal.getSalida().setVisible(true);
			cal.getFlecha_indicadora().setVisible(true);
			cal.getSistema_entrada().setVisible(true);
			cal.getSistema_salida().setVisible(true);
			cal.getConvertir().setVisible(true);
			

			break;
		}
		case "op_divisores": {
			num1 = 0;
			num2 = 0;
			
			cal.getSumBin().setVisible(false);
			cal.getInstrucciones_abMCM().setVisible(false);
			cal.getInstrucciones_ab().setVisible(false);
			cal.getDiv_indicador().setVisible(true);
			cal.getEntrada().setText("");
			cal.getTextAreaDivisores().setText("");
			cal.getFact_indicador().setVisible(false);
			
			cal.getVisor().setVisible(false);
			cal.getEntrada().setVisible(true);
			cal.getSalida().setVisible(false);
			cal.getFlecha_indicadora().setVisible(false);
			cal.getSistema_entrada().setVisible(false);
			cal.getSistema_salida().setVisible(false);
			cal.getConvertir().setVisible(false);
			cal.getTextAreaDivisores().setVisible(true);
			cal.getScrollPane().setVisible(true);
			cal.getNumero_divisores().setVisible(true);
			cal.getEntrada().setBounds(70, 20, 290, 55);

			break;
		}
		case "op_factorial": {
			num1 = 0;
			num2 = 0;
			
			cal.getSumBin().setVisible(false);
			cal.getInstrucciones_abMCM().setVisible(false);
			cal.getInstrucciones_ab().setVisible(false);
			cal.getDiv_indicador().setVisible(false);
			cal.getEntrada().setText("");
			cal.getTextAreaDivisores().setText("");
			cal.getFact_indicador().setVisible(true);
			
			cal.getVisor().setVisible(false);
			cal.getEntrada().setVisible(true);
			cal.getSalida().setVisible(false);
			cal.getFlecha_indicadora().setVisible(false);
			cal.getSistema_entrada().setVisible(false);
			cal.getSistema_salida().setVisible(false);
			cal.getConvertir().setVisible(false);
			cal.getTextAreaDivisores().setVisible(true);
			cal.getScrollPane().setVisible(true);
			cal.getNumero_divisores().setVisible(true);
			cal.getEntrada().setBounds(70, 20, 290, 55);
			
			
			break;
		}
		case "op_mcd": {
			num1 = 0;
			num2 = 0;
			
			cal.getSumBin().setVisible(false);
			cal.getInstrucciones_abMCM().setVisible(false);
			cal.getInstrucciones_ab().setVisible(true);
			cal.getDiv_indicador().setVisible(false);
			cal.getEntrada().setText("");
			cal.getSalida().setText("");
			cal.getEntrada().setBounds(20, 20, 340, 55);
			cal.getNumero_divisores().setVisible(false);
			cal.getTextAreaDivisores().setVisible(false);
			cal.getScrollPane().setVisible(false);
			cal.getFact_indicador().setVisible(false);
			
			cal.getVisor().setVisible(false);
			cal.getEntrada().setVisible(true);
			cal.getSalida().setVisible(true);
			cal.getFlecha_indicadora().setVisible(false);
			cal.getSistema_entrada().setVisible(false);
			cal.getSistema_salida().setVisible(false);
			cal.getConvertir().setVisible(false);
			
			break;
		}
		case "op_mcm": {
			num1 = 0;
			num2 = 0;
			
			cal.getSumBin().setVisible(false);
			cal.getInstrucciones_abMCM().setVisible(true);
			cal.getInstrucciones_ab().setVisible(false);
			cal.getDiv_indicador().setVisible(false);
			cal.getEntrada().setText("");
			cal.getSalida().setText("");
			cal.getEntrada().setBounds(20, 20, 340, 55);
			cal.getNumero_divisores().setVisible(false);
			cal.getTextAreaDivisores().setVisible(false);
			cal.getScrollPane().setVisible(false);
			cal.getFact_indicador().setVisible(false);
			
			cal.getVisor().setVisible(false);
			cal.getEntrada().setVisible(true);
			cal.getSalida().setVisible(true);
			cal.getFlecha_indicadora().setVisible(false);
			cal.getSistema_entrada().setVisible(false);
			cal.getSistema_salida().setVisible(false);
			cal.getConvertir().setVisible(false);
			
			
			break;
		}
		case "op_sumaBin": {
			num1 = 0;
			num2 = 0;
			
			cal.getSumBin().setVisible(true);
			cal.getInstrucciones_abMCM().setVisible(false);
			cal.getInstrucciones_ab().setVisible(false);
			cal.getDiv_indicador().setVisible(false);
			cal.getEntrada().setText("");
			cal.getSalida().setText("");
			cal.getEntrada().setBounds(20, 20, 340, 55);
			cal.getNumero_divisores().setVisible(false);
			cal.getTextAreaDivisores().setVisible(false);
			cal.getScrollPane().setVisible(false);
			cal.getFact_indicador().setVisible(false);
			
			cal.getVisor().setVisible(false);
			cal.getEntrada().setVisible(true);
			cal.getSalida().setVisible(true);
			cal.getFlecha_indicadora().setVisible(false);
			cal.getSistema_entrada().setVisible(false);
			cal.getSistema_salida().setVisible(false);
			cal.getConvertir().setVisible(false);
			
			break;
		}
		case "calBoton0": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 0);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 0);
				break;
			}
		}
		case "calBoton1": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 1);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 1);
				break;
			}
		}
		case "calBoton2": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 2);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 2);
				break;
			}
		}
		case "calBoton3": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 3);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 3);
				break;
			}
		}
		case "calBoton4": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 4);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 4);
				break;
			}
		}
		case "calBoton5": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 5);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 5);
				break;
			}
		}
		case "calBoton6": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 6);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 6);
				break;
			}
		}
		case "calBoton7": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 7);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 7);
				break;
			}
		}
		case "calBoton8": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 8);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 8);
				break;
			}
		}
		case "calBoton9": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + 9);
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + 9);
				break;
			}
		}
		case "calBoton000": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + "000");
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + "000");
				break;
			}
		}
		case "calBoton.": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + ".");
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + ".");
				break;
			}
		}
		case "calBotonMas": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + "+");
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + "+");
				break;
			}
		}
		case "calBotonMenos": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + "-");
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + "-");
				break;
			}
		}
		case "calBotonDiv": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + "\u00F7");
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + "\u00F7");
				break;
			}
		}
		case "calBotonMult": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + "\u00D7");
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + "\u00D7");
				break;
			}
		}
		case "calBotonMod": {
			if (cal.getEntrada().isVisible()) {
				String temp = cal.getEntrada().getText();
				cal.getEntrada().setText(temp + "%");
				break;
			}
			else {
				String temp = cal.getVisor().getText();
				cal.getVisor().setText(temp + "%");
				break;
			}
		}
		case "calBotonIgual": {
			//Divisores
			
			if(cal.getDiv_indicador().isVisible()) {
				long numero = Long.parseLong(cal.getEntrada().getText());
				
				divisores = new Divisores(numero);
				cal.getTextAreaDivisores().setText("El numero es "+ divisores.getTipo()+"\n"
												+"Sus divisores son:\n"+divisores.getDivisores());
			}
			//MCD
			
			else if(cal.getInstrucciones_ab().isVisible()) {
				String ab = cal.getEntrada().getText();
				String numsString[] = ab.split(", ");
				num1 = Long.parseLong(numsString[0]);
				num2 = Long.parseLong(numsString[1]);
				
				if(num1 == num2) {
					cal.getSalida().setText("MCD("+num1+", "+num2+"): "+num1);
				}
				else {
					mcd = new MCD(num1, num2);
					cal.getSalida().setText("MCD("+num1+", "+num2+"): "+mcd.getResultado());
				}

			}
			//MCM
			
			else if(cal.getInstrucciones_abMCM().isVisible()) {
				String ab = cal.getEntrada().getText();
				String numsString[] = ab.split(", ");
				num1 = Long.parseLong(numsString[0]);
				num2 = Long.parseLong(numsString[1]);
				
				if(num1 == num2) {
					cal.getSalida().setText("MCM("+num1+", "+num2+"): "+num1);
				}
				else {
					mcm = new MCM(num1, num2);
					cal.getSalida().setText("MCM("+num1+", "+num2+"): "+mcm.getMcm());
				}

			}
			
			//Factorial
			else if(cal.getFact_indicador().isVisible()) {
				long n = Long.parseLong(cal.getEntrada().getText());
				
				factorial = new Factorial(n);
				cal.getTextAreaDivisores().setText(n+"!: "+factorial.getResultado());
			}
			
			//Suma Binarios
			else if(cal.getSumBin().isVisible()){
				String ab = cal.getEntrada().getText();
				String numsString[] = ab.split(", ");
				String numBin1 = numsString[0];
				String numBin2 = numsString[1];
				
				if ((numBin1.matches("[0-1]+") == false) || (numBin2.matches("[0-1]+") == false)) {
					cal.getSalida().setText("No Binario");
				}
				else {
					sumBin = new SumaBinarios(numBin1, numBin2);
					cal.getSalida().setText("Resultado: "+sumBin.getReves());
				}
			}
			//Calculadora Estandar
			
			else if(cal.getVisor().isVisible()) {
				try {
					String operacion = cal.getVisor().getText();

					char mas = '+';
					char menos = '-';
					char mod = '%';
					char mult = '\u00D7';
					char div = '\u00F7';

					LinkedList<Character> operaciones = new LinkedList<Character>();
					LinkedList<Double> numeros = new LinkedList<Double>();

					String aux = operacion;

					// Añadir a LinkedList operaciones las operaciones como caracteres
					for (int i = 0; i < operacion.length(); i++) {
						if (operacion.charAt(i) == mas) {
							operaciones.add(operacion.charAt(i));
						}
						if (operacion.charAt(i) == menos) {
							operaciones.add(operacion.charAt(i));
						}
						if (operacion.charAt(i) == mod) {
							operaciones.add(operacion.charAt(i));
						}
						if (operacion.charAt(i) == mult) {
							operaciones.add(operacion.charAt(i));
						}
						if (operacion.charAt(i) == div) {
							operaciones.add(operacion.charAt(i));
						}

					}

					// Reemplazar todo lo que no sean numeros (operadores) con espacios

					try {

					} catch (IndexOutOfBoundsException e2) {
						// TODO: handle exception
					}
					aux = aux.replaceAll("[^0-9.]", " ");

					// Separar los numeros en string

					String[] arrNumString = aux.split(" ");

					// Conversion números individuales tipo String a numeros individuales tipo Int
					for (int i = 0; i < arrNumString.length; i++) {
						numeros.add(Double.parseDouble(arrNumString[i]));
					}

					double res = 0;

					calculo: while (true) {

						double num1 = numeros.get(0);
						double num2 = numeros.get(1);

						switch (operaciones.get(0)) {
						case '+': {
							res = num1 + num2;
							operaciones.remove(0);
							numeros.removeFirst();
							numeros.removeFirst();

							numeros.addFirst(res);
							break;
						}
						case '-': {
							res = num1 - num2;
							operaciones.remove(0);
							numeros.removeFirst();
							numeros.removeFirst();
							numeros.addFirst(res);
							break;
						}
						case '%': {
							res = num1 % num2;
							operaciones.remove(0);
							numeros.removeFirst();
							numeros.removeFirst();
							numeros.addFirst(res);
							break;
						}
						case '\u00D7': {
							res = num1 * num2;
							operaciones.remove(0);
							numeros.removeFirst();
							numeros.removeFirst();
							numeros.addFirst(res);
							break;
						}
						case '\u00F7': {
							res = num1 / num2;
							operaciones.remove(0);
							numeros.removeFirst();
							numeros.removeFirst();
							numeros.addFirst(res);
							break;
						}

						}
						if (operaciones.size() == 0) {
							break calculo;
						}
					}

					cal.getVisor().setText(res + "");

					break;
				} catch (IndexOutOfBoundsException e2) {
					cal.getVisor().setText("Syntax Error");
				}
			}
		}
		case "calBotonAns": {

			break;
		}
		case "calBotonDEL": {
			String temp = cal.getVisor().getText();
			cal.getVisor().setText(new StringBuffer(temp).deleteCharAt(temp.length() - 1) + "");

			// cal.getVisor().setText(temp.replace(temp.charAt(temp.length()-1)+"", ""));
			break;
		}
		case "calBotonAC": {
			cal.getVisor().setText("");
			break;
		}
		default:

		}
	}

	public Calculadora getCal() {
		return cal;
	}

	public void setCal(Calculadora cal) {
		this.cal = cal;
	}

	public long getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public long getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

}
