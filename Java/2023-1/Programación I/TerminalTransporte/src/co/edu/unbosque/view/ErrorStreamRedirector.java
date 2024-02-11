package co.edu.unbosque.view;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JTextArea;
/**
 * Clase que convierte un JTextArea en la salida por defecto de los errores de la consola.
 * @author Federico Vargas Rozo
 * @param text_area JTextArea donde se mostraran los errores de consola.
 * @param ps Objeto de la clase PrintStream que se requiere para convertir la salida de consola en texto que se 
 * muestre en el JTextArea.
 */
public class ErrorStreamRedirector {

	private JTextArea text_area;
	private PrintStream ps;
	/**
	 * Funcion para establecer el parametro como salida de errores por defecto del programa.
	 * @param text_area JTextArea donde se mostraran los errores de consola.
	 */
	public ErrorStreamRedirector(JTextArea text_area) {
		super();
		this.text_area = text_area;
		this.ps = new PrintStream(new TextAreaOutputStream(text_area));
		System.setErr(ps);
	}
	/**
	 * Clase para convertir texto de consola en texto sin formato. Extiende de OutputStream que permite la conversion.
	 * @author Federico Vargas Rozo
	 * @param textArea JTextArea donde se mostraran los errores de consola.
	 *
	 */
    private class TextAreaOutputStream extends OutputStream {
        private JTextArea textArea;
        
        public TextAreaOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }
        
        @Override
        public void write(int b) {
            textArea.append(String.valueOf((char) b));
        }
    }

	
}
