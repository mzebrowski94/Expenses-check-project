package mzebrowski.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import mzebrowski.gui.AppWindowView;

// Initializing the model, view, controller and setting up the connections
public class Main {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {
				
			AppWindowView appWindowView = new AppWindowView();
			
			}

		};
		EventQueue.invokeLater(runner);
	}

}
