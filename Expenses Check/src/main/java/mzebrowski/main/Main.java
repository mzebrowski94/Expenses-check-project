package mzebrowski.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import mzebrowski.gui.MainWindow;
import mzebrowski.gui.MainWindowFactory;

// Initializing the model, view, controller and setting up the connections
public class Main {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {				
				//Creation Phase
				ApplicationFactory app = new ApplicationFactory();
			}
		};
		EventQueue.invokeLater(runner);
	}

}
