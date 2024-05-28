package co.edu.unbosque.controller;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

	private static int sec;
	private static int min;
	private Scanner sc;

	public Controller() {
		sec = 0;
		min = 0;
		sc = new Scanner(System.in);
	}

	public void run() {
		System.out.println("Enter Timer Duration in Minutes (can be float): ");
		float duration = sc.nextFloat() * 60;

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				if ((sec + (min * 60)) != duration) {

					sec++;
					if (sec == 60) {
						min++;
						sec = 0;
					}
					clearScreen();
					System.out.printf("%02d:%02d%n", min, sec);
				} else {
					timer.cancel();
					System.err.println("Timer finished!");
				}

			}

		};
		timer.scheduleAtFixedRate(timerTask, 1000, 1000);

	}

	public static void clearScreen() {
		System.out.print("\n".repeat(50));
	}

}
