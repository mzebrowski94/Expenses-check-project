package mzebrowski.gui.menuBar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	public MenuBar() {
		JMenu file = new JMenu("File");
		this.add(file);
	}
}
