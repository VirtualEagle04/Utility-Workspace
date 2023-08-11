package co.edu.unbosque.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import co.edu.unbosque.controlador.KeyHandler;

public class GamePanel extends JPanel implements Runnable{
		
	final int originalTileSize = 32;
	final int scale = 1;
	final int tileSize = originalTileSize * scale; //32 x 32px
	
	final int maxScreenCol = 32;
	final int maxScreenRow = 24; //4:3
	final int screenWidth = tileSize * maxScreenCol; //1024px
	final int screenHeight = tileSize * maxScreenRow; //768px
	
	
	//FPS
	int FPS = 60;
	
	Thread gameThread;  //Tiempo
	KeyHandler keyH = new KeyHandler(); //KeyListener
	
	//Jugador
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		setPreferredSize(new Dimension(screenWidth,screenHeight));
		setBackground(Color.DARK_GRAY);
		setDoubleBuffered(true);
		
		addKeyListener(keyH);
		setFocusable(true);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);	
		gameThread.start(); //LLama la función run()
	}
	

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; //1,000,000,000 nanoseg / FPS = 0.01666 seg
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		//Game Loop
		while(gameThread != null) {
			
			update();
			
			repaint();
			
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval; //Resetear cuando se correra el game loop nuevamente
				
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
	}
	
	public void update() {
		
		if (keyH.wPressed == true) {
			playerY -= playerSpeed;
			System.out.println("W");
		}
		else if (keyH.sPressed == true) {
			playerY += playerSpeed;
			System.out.println("S");
		}
		else if (keyH.aPressed == true) {
			playerX -= playerSpeed;
			System.out.println("A");
		}
		else if (keyH.dPressed == true) {
			playerX += playerSpeed;
			System.out.println("D");
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //super = JPanel
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.WHITE);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose(); //Libera la memoria cache
	}
	
}
