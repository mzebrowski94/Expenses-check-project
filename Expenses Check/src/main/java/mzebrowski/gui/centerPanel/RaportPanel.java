package mzebrowski.gui.centerPanel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import mzebrowski.gui.GuiElement;

public class RaportPanel extends JPanel implements GuiElement {

	JTextPane raportPanel;
	JLabel connectionStatus;

	public RaportPanel(JTextPane raportPanel, JLabel connectionStatus) {
		this.raportPanel = raportPanel;
		this.connectionStatus = connectionStatus;
	}

	public void updateData(ArrayList<String> raport) {

		String newRaport = "Amount spent this month: \n";
		for (String itr : raport) {
			newRaport += itr + "\n";
		}

		raportPanel.setText(newRaport);
	}

	public void initLayout() {
		setBorder(BorderFactory.createTitledBorder("Raport:"));
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		raportPanel.setEditable(false);
		add(raportPanel);

		this.connectionStatus.setHorizontalAlignment(JLabel.LEFT);
		add(connectionStatus);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}
}
