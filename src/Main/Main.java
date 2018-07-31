package Main;

import java.awt.EventQueue;

import View.View;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				View v = new View("Window");
			}
		});
	}

}
