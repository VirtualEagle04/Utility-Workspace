package co.edu.unbosque.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculadora extends JFrame{
	private JButton[] botones_numeros;
	private JButton mas, menos, div, mult, mod, igual, ans, del, ac;
	private JTextField visor, entrada, salida;
	private JPanel numeros, operadores, pVisor, funciones;
	private JComboBox sistema_entrada, sistema_salida;
	private JLabel flecha_indicadora, numero_divisores;
	private JButton convertir;
	private JScrollPane scrollPane;
	private JTextArea textAreaDivisores;
	private JLabel fact_indicador, div_indicador, instrucciones_ab, instrucciones_abMCM, sumBin;
	
	private JMenuBar menuBar;
	private JMenu operaciones;
	private JMenuItem convBases, divisores, factorial, mcd, mcm, sumaBin, calc_standar;
	
	public Calculadora() {
		setTitle("Calculadora Discretas");
		setSize(400, 650);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		//MenuItem
		calc_standar = new JMenuItem("Standard Calculator");
		convBases = new JMenuItem("System Conversion");
		divisores = new JMenuItem("Dividers");
		factorial = new JMenuItem("Factorial");
		mcd = new JMenuItem("Greatest Common Divisor (M. C. D.)");
		mcm = new JMenuItem("Least Common Multiple (M. C. M.)");
		sumaBin = new JMenuItem("Binary Addition");
		
		
		//Menu
		operaciones = new JMenu("Operations");
		operaciones.add(calc_standar);
		operaciones.add(convBases);
		operaciones.add(divisores);
		operaciones.add(factorial);
		operaciones.add(mcd);
		operaciones.add(mcm);
		operaciones.add(sumaBin);
		
		//MenuBar
		menuBar = new JMenuBar();
		menuBar.add(operaciones);
		add(menuBar);
		setJMenuBar(menuBar);
		
		//Conversion
		String[] sistemas = {"Binary", "Octal", "Decimal", "Hexadecimal"};
		
		sistema_entrada = new JComboBox(sistemas);
		sistema_salida = new JComboBox(sistemas);
		
		sistema_entrada.setSize(100, 20);
		sistema_salida.setSize(100, 20);
		
		sistema_entrada.setLocation(80, 0);
		sistema_salida.setLocation(200, 0);
		
		flecha_indicadora = new JLabel("\u2192");
		flecha_indicadora.setSize(20, 20);
		flecha_indicadora.setFont(new Font("Consolas", Font.BOLD, 25));
		flecha_indicadora.setLocation(184, 4);
		
		convertir = new JButton(" Convert");
		convertir.setSize(150, 20);
		convertir.setLocation(118, 130);
		convertir.setFont(new Font("Consolas", Font.PLAIN, 16));
		convertir.setBackground(new Color(62, 79, 82));
		convertir.setForeground(Color.WHITE);
		
		//Factorial
		fact_indicador = new JLabel();
		fact_indicador.setBounds(0,0,0,0);
		
		//Crear elementos del visor

		pVisor = new JPanel();
		pVisor.setBounds(0,0, 400, 150);
		pVisor.setBackground(Color.LIGHT_GRAY);
		pVisor.setLayout(null);
		
		visor = new JTextField();
		visor.setBounds(20,20,340,110);
		visor.setFont(new Font("Consolas", Font.BOLD, 50));
		visor.setEditable(true);
		pVisor.add(visor);
		
		entrada = new JTextField();
		entrada.setBounds(20, 20, 340, 55);
		entrada.setFont(new Font("Consolas", Font.BOLD, 30));
		entrada.setEditable(true);

		salida = new JTextField();
		salida.setBounds(20, 75, 340, 55);
		salida.setFont(new Font("Consolas", Font.BOLD, 15));
		salida.setEditable(false);
		
		//MCD
		instrucciones_ab = new JLabel();
		instrucciones_ab.setSize(340, 20);
		instrucciones_ab.setLocation(20, 0);
		instrucciones_ab.setFont(new Font("Consolas", Font.BOLD, 15));
		instrucciones_ab.setText("Enter (a, b) separated by a comma:");
		//MCM
		instrucciones_abMCM = new JLabel();
		instrucciones_abMCM.setSize(340, 20);
		instrucciones_abMCM.setLocation(20, 0);
		instrucciones_abMCM.setFont(new Font("Consolas", Font.BOLD, 15));
		instrucciones_abMCM.setText("Enter (a, b) separated by a comma:");
		
		
		//Suma de Binarios
		sumBin = new JLabel();
		sumBin.setSize(340, 20);
		sumBin.setLocation(20, 0);
		sumBin.setFont(new Font("Consolas", Font.BOLD, 15));
		sumBin.setText("Enter (a, b) separated by a comma:");
		
		
		//Divisores
		div_indicador = new JLabel();
		div_indicador.setBounds(0,0,0,0);
		
		numero_divisores = new JLabel();
		numero_divisores.setBounds(20, 20, 80, 55);
		numero_divisores.setFont(new Font("Consolas", Font.BOLD, 20));
		numero_divisores.setText("Num: ");
		
		textAreaDivisores = new JTextArea();
		textAreaDivisores.setBounds(20, 75, 340, 55);
		textAreaDivisores.setEditable(false);
		textAreaDivisores.setFont(new Font("Consolas", Font.PLAIN, 20));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 75, 340, 55);
		scrollPane.setViewportView(textAreaDivisores);
		
		pVisor.add(sumBin).setVisible(false);
		pVisor.add(instrucciones_abMCM).setVisible(false);
		pVisor.add(instrucciones_ab).setVisible(false);
		pVisor.add(div_indicador).setVisible(false);
		pVisor.add(fact_indicador).setVisible(false);
		pVisor.add(numero_divisores).setVisible(false);
		pVisor.add(scrollPane).setVisible(false);
		pVisor.add(convertir).setVisible(false);
		pVisor.add(entrada).setVisible(false);
		pVisor.add(salida).setVisible(false);
		pVisor.add(sistema_entrada).setVisible(false);
		pVisor.add(flecha_indicadora).setVisible(false);
		pVisor.add(sistema_salida).setVisible(false);

		
		
		//Crear los valores de botones_numeros
		botones_numeros = new JButton[12];
		for (int i = 0; i < botones_numeros.length - 2; i++) {
			botones_numeros[i] = new JButton(i +"");
			botones_numeros[i].setFont(new Font("Consolas", Font.BOLD, 20));
			botones_numeros[i].setBackground(Color.DARK_GRAY);
			botones_numeros[i].setForeground(Color.WHITE);
		}
		
		botones_numeros[10] = new JButton("000");
		botones_numeros[10].setFont(new Font("Consolas", Font.BOLD, 20));
		botones_numeros[10].setBackground(Color.DARK_GRAY);
		botones_numeros[10].setForeground(Color.WHITE);
		
		botones_numeros[11] = new JButton(".");
		botones_numeros[11].setFont(new Font("Consolas", Font.BOLD, 20));
		botones_numeros[11].setBackground(Color.DARK_GRAY);
		botones_numeros[11].setForeground(Color.WHITE);
		
		
		//Añadir botones_numeros al Panel numeros
		numeros = new JPanel();
		numeros.setBounds(0,210, 325, 380);
		numeros.setLayout(new GridLayout(4, 3));
		for (int i = 0; i < botones_numeros.length-3; i++) {
			numeros.add(botones_numeros[i]);
		}
		numeros.add(botones_numeros[10]);
		numeros.add(botones_numeros[9]);
		numeros.add(botones_numeros[11]);
		
		operadores = new JPanel();
		operadores.setBounds(325, 210, 60, 380);
		operadores.setLayout(new GridLayout(6, 1));
		
		
		//Operadores
		mas = new JButton("+");
		mas.setBackground(Color.DARK_GRAY);
		mas.setForeground(Color.WHITE);
		mas.setFont(new Font("Consolas", Font.BOLD, 20));
		
		menos = new JButton("-");
		menos.setBackground(Color.DARK_GRAY);
		menos.setForeground(Color.WHITE);
		menos.setFont(new Font("Consolas", Font.BOLD, 20));
		
		div = new JButton("\u00F7");
		div.setBackground(Color.DARK_GRAY);
		div.setForeground(Color.WHITE);
		div.setFont(new Font("Consolas", Font.BOLD, 20));
		
		mult = new JButton("\u00D7");
		mult.setBackground(Color.DARK_GRAY);
		mult.setForeground(Color.WHITE);
		mult.setFont(new Font("Consolas", Font.BOLD, 20));
		
		mod = new JButton("%");
		mod.setBackground(Color.DARK_GRAY);
		mod.setForeground(Color.WHITE);
		mod.setFont(new Font("Consolas", Font.BOLD, 20));
		
		igual = new JButton("=");
		igual.setBackground(Color.DARK_GRAY);
		igual.setForeground(Color.WHITE);
		igual.setFont(new Font("Consolas", Font.BOLD, 20));
		
		operadores.add(mas);
		operadores.add(menos);
		operadores.add(div);
		operadores.add(mult);
		operadores.add(mod);
		operadores.add(igual);
		
		//Funciones
		funciones = new JPanel();
		funciones.setBounds(0,150, 385, 60);
		funciones.setLayout(new GridLayout(1, 3));
		
		ans = new JButton("Ans");
		ans.setBackground(Color.DARK_GRAY);
		ans.setForeground(Color.WHITE);
		ans.setFont(new Font("Consolas", Font.BOLD, 20));
		
		del = new JButton("DEL");
		del.setBackground(new Color(130, 55, 55));
		del.setForeground(Color.WHITE);
		del.setFont(new Font("Consolas", Font.BOLD, 20));
		
		ac = new JButton("AC");
		ac.setBackground(new Color(130, 55, 55));
		ac.setForeground(Color.WHITE);
		ac.setFont(new Font("Consolas", Font.BOLD, 20));
		
		funciones.add(ans);
		funciones.add(del);
		funciones.add(ac);
		

		add(funciones, JLayeredPane.DEFAULT_LAYER);
		add(operadores, JLayeredPane.DEFAULT_LAYER);
		add(numeros, JLayeredPane.DEFAULT_LAYER);
		add(pVisor, JLayeredPane.DEFAULT_LAYER);
		setVisible(true);
	}



	public JButton getIgual() {
		return igual;
	}



	public void setIgual(JButton igual) {
		this.igual = igual;
	}



	public JButton[] getBotones_numeros() {
		return botones_numeros;
	}



	public void setBotones_numeros(JButton[] botones_numeros) {
		this.botones_numeros = botones_numeros;
	}



	public JButton getMas() {
		return mas;
	}



	public void setMas(JButton mas) {
		this.mas = mas;
	}



	public JButton getMenos() {
		return menos;
	}



	public void setMenos(JButton menos) {
		this.menos = menos;
	}



	public JButton getDiv() {
		return div;
	}



	public void setDiv(JButton div) {
		this.div = div;
	}



	public JButton getMult() {
		return mult;
	}



	public void setMult(JButton mult) {
		this.mult = mult;
	}



	public JButton getMod() {
		return mod;
	}



	public void setMod(JButton mod) {
		this.mod = mod;
	}



	public JTextField getVisor() {
		return visor;
	}



	public void setVisor(JTextField visor) {
		this.visor = visor;
	}



	public JPanel getNumeros() {
		return numeros;
	}



	public void setNumeros(JPanel numeros) {
		this.numeros = numeros;
	}



	public JPanel getOperadores() {
		return operadores;
	}



	public void setOperadores(JPanel operadores) {
		this.operadores = operadores;
	}



	public JPanel getpVisor() {
		return pVisor;
	}



	public void setpVisor(JPanel pVisor) {
		this.pVisor = pVisor;
	}



	public JButton getAns() {
		return ans;
	}



	public void setAns(JButton ans) {
		this.ans = ans;
	}



	public JButton getDel() {
		return del;
	}



	public void setDel(JButton del) {
		this.del = del;
	}



	public JButton getAc() {
		return ac;
	}



	public void setAc(JButton ac) {
		this.ac = ac;
	}



	public JPanel getFunciones() {
		return funciones;
	}



	public void setFunciones(JPanel funciones) {
		this.funciones = funciones;
	}

	
	
	public JMenu getOperaciones() {
		return operaciones;
	}



	public void setOperaciones(JMenu operaciones) {
		this.operaciones = operaciones;
	}



	public JMenuItem getConvBases() {
		return convBases;
	}



	public void setConvBases(JMenuItem convBases) {
		this.convBases = convBases;
	}



	public JMenuItem getDivisores() {
		return divisores;
	}



	public void setDivisores(JMenuItem divisores) {
		this.divisores = divisores;
	}



	public JMenuItem getFactorial() {
		return factorial;
	}



	public void setFactorial(JMenuItem factorial) {
		this.factorial = factorial;
	}



	public JMenuItem getMcd() {
		return mcd;
	}



	public void setMcd(JMenuItem mcd) {
		this.mcd = mcd;
	}



	public JMenuItem getMcm() {
		return mcm;
	}



	public void setMcm(JMenuItem mcm) {
		this.mcm = mcm;
	}



	public JMenuItem getSumaBin() {
		return sumaBin;
	}



	public void setSumaBin(JMenuItem sumaBin) {
		this.sumaBin = sumaBin;
	}



	public JTextField getEntrada() {
		return entrada;
	}



	public void setEntrada(JTextField entrada) {
		this.entrada = entrada;
	}



	public JTextField getSalida() {
		return salida;
	}



	public void setSalida(JTextField salida) {
		this.salida = salida;
	}



	public JComboBox getSistema_entrada() {
		return sistema_entrada;
	}



	public void setSistema_entrada(JComboBox sistema_entrada) {
		this.sistema_entrada = sistema_entrada;
	}



	public JComboBox getSistema_salida() {
		return sistema_salida;
	}



	public void setSistema_salida(JComboBox sistema_salida) {
		this.sistema_salida = sistema_salida;
	}



	public JLabel getFlecha_indicadora() {
		return flecha_indicadora;
	}



	public void setFlecha_indicadora(JLabel flecha_indicadora) {
		this.flecha_indicadora = flecha_indicadora;
	}



	public JButton getConvertir() {
		return convertir;
	}



	public void setConvertir(JButton convertir) {
		this.convertir = convertir;
	}



	public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}



	public JTextArea getTextAreaDivisores() {
		return textAreaDivisores;
	}



	public void setTextAreaDivisores(JTextArea textAreaDivisores) {
		this.textAreaDivisores = textAreaDivisores;
	}



	public JLabel getNumero_divisores() {
		return numero_divisores;
	}



	public void setNumero_divisores(JLabel numero_divisores) {
		this.numero_divisores = numero_divisores;
	}



	public JLabel getFact_indicador() {
		return fact_indicador;
	}



	public void setFact_indicador(JLabel fact_indicador) {
		this.fact_indicador = fact_indicador;
	}



	public JLabel getDiv_indicador() {
		return div_indicador;
	}



	public void setDiv_indicador(JLabel div_indicador) {
		this.div_indicador = div_indicador;
	}



	public JLabel getInstrucciones_ab() {
		return instrucciones_ab;
	}



	public void setInstrucciones_ab(JLabel instrucciones_ab) {
		this.instrucciones_ab = instrucciones_ab;
	}



	public JLabel getInstrucciones_abMCM() {
		return instrucciones_abMCM;
	}



	public void setInstrucciones_abMCM(JLabel instrucciones_abMCM) {
		this.instrucciones_abMCM = instrucciones_abMCM;
	}



	public JLabel getSumBin() {
		return sumBin;
	}



	public void setSumBin(JLabel sumBin) {
		this.sumBin = sumBin;
	}



	public JMenuItem getCalc_standar() {
		return calc_standar;
	}



	public void setCalc_standar(JMenuItem calc_standar) {
		this.calc_standar = calc_standar;
	}

}
