package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private JScrollPane scroll;
	private JTextArea output;
	private JTextField input;

	public MainWindow() {
		setTitle("Generador de Carros");
		setSize(320, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);

		output = new JTextArea();
		output.setFont(new Font("Consolas", Font.PLAIN, 12));
		output.setBackground(Color.BLACK);
		output.setForeground(Color.GREEN);
		output.setEditable(false);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setSize(284, 380);

		scroll = new JScrollPane();
		scroll.setBounds(10, 10, 284, 380);
		scroll.setViewportView(output);
		add(scroll);

		input = new JTextField();
		input.setFont(new Font("Consolas", Font.PLAIN, 12));
		input.setBackground(Color.BLACK);
		input.setForeground(Color.GREEN);
		input.setBounds(10, 400, 284, 25);
		add(input);
		
		System.setOut(new PrintStream(new OutputStream() {
			@Override
			public void write(int b) {
				output.append(String.valueOf((char) b));
			}
			
		}));
		
		System.setErr(new PrintStream(new OutputStream() {
			@Override
			public void write(int b) {
				output.append(String.valueOf((char) b));
			}
			
		}));
		
	}
	
	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JTextArea getOutput() {
		return output;
	}

	public void setOutput(JTextArea output) {
		this.output = output;
	}

	public JTextField getInput() {
		return input;
	}

	public void setInput(JTextField input) {
		this.input = input;
	}

}
