package mzebrowski.gui.centerPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {

	Toolbar toolbar;
	RecordTable recordTable;
	StatusBar statusbar;
	
	public CenterPanel(Toolbar toolbar, RecordTable recordTable, StatusBar statusbar) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.toolbar = toolbar;
		this.add(toolbar);
		this.recordTable = recordTable;
		this.add(recordTable);
		this.statusbar = statusbar;
		this.add(statusbar);
	}

	
	
}
