package mzebrowski.gui.centerPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CenterPanelView extends JPanel {

	ToolbarView toolbar;
	RecordTableView recordTable;
	
	public CenterPanelView() {
		
		super();
		//setLayout(new BorderLayout());
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		
		// Add toolbar
		toolbar = new ToolbarView();
		add(toolbar);
		
		// Add record table
		recordTable = new RecordTableView();
		recordTable.setPreferredSize(new Dimension(100, 300));
		add(recordTable);
		
		// Add record table
		add(new JTextArea());
		
		// Add status bar
		JLabel statusbar = new JLabel("Statusbar: ");
		add(statusbar);
	}
}
