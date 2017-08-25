package mzebrowski.gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import mzebrowski.gui.centerPanel.CenterPanel;
import mzebrowski.gui.menuBar.MenuBar;
import mzebrowski.gui.rightPanel.RightPanel;

public class MainWindow extends JFrame {

	MenuBar menuBar;
	CenterPanel centerPanelView;
	RightPanel rightPanelView;

	public MainWindow(MenuBar menuBar, CenterPanel centerPanel, RightPanel rightPanelView) {
		
		this.setTitle("Expenses Check");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		this.setSize(1000, 600);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.setLocationRelativeTo(null);
		
		this.menuBar = menuBar;
		this.setJMenuBar(menuBar);
		
		this.centerPanelView = centerPanel;
		this.add(centerPanel);
		
		this.rightPanelView = rightPanelView;
		this.add(rightPanelView);
	
		this.setVisible(true);
	}
}
