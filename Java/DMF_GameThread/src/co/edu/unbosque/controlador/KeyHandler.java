package co.edu.unbosque.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean wPressed, sPressed, aPressed, dPressed;
	

	@Override //No se usa
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode(); //Codigo asociado a la tecla oprimida
		
		
		if (codigo == KeyEvent.VK_W) {
			wPressed = true;
		}
		if (codigo == KeyEvent.VK_S) {
			sPressed = true;
		}
		if (codigo == KeyEvent.VK_A) {
			aPressed = true;
		}
		if (codigo == KeyEvent.VK_D) {
			dPressed = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode(); //Codigo asociado a la tecla oprimida
		
		
		if (codigo == KeyEvent.VK_W) {
			wPressed = false;
		}
		if (codigo == KeyEvent.VK_S) {
			sPressed = false;
		}
		if (codigo == KeyEvent.VK_A) {
			aPressed = false;
		}
		if (codigo == KeyEvent.VK_D) {
			dPressed = false;
		}
		
	}

}
