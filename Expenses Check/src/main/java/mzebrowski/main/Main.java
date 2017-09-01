package mzebrowski.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import mzebrowski.gui.MainWindow;
import mzebrowski.gui.MainWindowFactory;


public class Main {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {				
				//Creation Phase: 
					
				//wiring components
				Application application = new Application();
				
				//load data to view
				application.loadData();
				
				//Run Phase
				
			}
		};
		EventQueue.invokeLater(runner);
	}

}
