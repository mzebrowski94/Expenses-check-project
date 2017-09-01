package mzebrowski.gui.centerPanel;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RaportPanel extends JPanel {

	JEditorPane raportPanel;
	JLabel connectionStatus;
	
	public RaportPanel(String raportPanelName, JEditorPane raportPanel, JLabel connectionStatus) {

		
		setBorder(BorderFactory.createTitledBorder(raportPanelName));
		BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
		setLayout(layout);
		
		this.raportPanel = raportPanel;
		raportPanel.setEditable(false);
		add(raportPanel);
		
		this.connectionStatus = connectionStatus;
		this.connectionStatus.setHorizontalAlignment(JLabel.LEFT);
		add(connectionStatus);
	}

	public void updateData(String raport) {
		
	}
}
