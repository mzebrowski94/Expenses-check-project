package mzebrowski.gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import mzebrowski.gui.centerPanel.CenterPanelView;
import mzebrowski.gui.rightPanel.RightPanelView;

public class AppWindowView {

	JFrame frame;
	CenterPanelView centerPanelView;
	RightPanelView rightPanelView;

	public AppWindowView() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		frame = new JFrame("Expenses check");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		frame.setSize(1000, 600);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setLocationRelativeTo(null);
		
		// Adds menu bar
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		menubar.add(file);
		frame.setJMenuBar(menubar);

		// Add centerPanel
		centerPanelView = new CenterPanelView();
		rightPanelView = new RightPanelView();

		frame.add(centerPanelView);
		frame.add(rightPanelView);


		// JRootPane rootPane = frame.getRootPane();
		// rootPane.setDefaultButton(button);
		frame.setVisible(true);
	}
}
