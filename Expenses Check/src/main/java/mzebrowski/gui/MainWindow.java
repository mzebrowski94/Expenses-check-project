package mzebrowski.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import mzebrowski.gui.centerPanel.CenterPanel;
import mzebrowski.gui.menuBar.MenuToolBar;
import mzebrowski.gui.rightPanel.RightPanel;

public class MainWindow extends JFrame {

	MenuToolBar menuToolBar;
	CenterPanel centerPanel;
	RightPanel rightPanel;

	public MainWindow(MenuToolBar menuToolBar, CenterPanel centerPanel, RightPanel rightPanelView) {
		
		this.setTitle("Expenses Check");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		this.setSize(1000, 600);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		this.setLocationRelativeTo(null);
		
		this.menuToolBar = menuToolBar;
		this.setJMenuBar(menuToolBar);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.9;
		constraints.weighty=0.9;
		this.centerPanel = centerPanel;
		this.add(centerPanel, constraints);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.weightx=0.1;
		constraints.weighty=0.1;
		this.rightPanel = rightPanelView;
		this.add(rightPanelView, constraints);
	
		this.setVisible(true);
	}

	public MenuToolBar getMenuToolBar() {
		return menuToolBar;
	}

	public CenterPanel getCenterPanel() {
		return centerPanel;
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}
	
	
}
