package mzebrowski.gui.centerPanel.raportPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import mzebrowski.gui.GuiElement;

public class RaportPanel extends JPanel implements GuiElement {

	JTextPane groupMonthRaport;
	JTextPane groupAllTimeRaport;
	JTextPane purchaseTypeRaport;
	JLabel connectionStatus;

	public RaportPanel(JLabel connectionStatus) {
		this.groupMonthRaport = new JTextPane();
		this.groupAllTimeRaport = new JTextPane();
		this.purchaseTypeRaport = new JTextPane();
		this.connectionStatus = connectionStatus;
	}

	public void initLayout() {
		setBorder(BorderFactory.createTitledBorder("Raports:"));
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		
		
		JPanel raportPanel = new JPanel();
		raportPanel.setLayout(new GridLayout(0,3));

		groupMonthRaport.setEditable(false);
		raportPanel.add(new JScrollPane(groupMonthRaport));

		groupAllTimeRaport.setEditable(false);
		raportPanel.add(new JScrollPane(groupAllTimeRaport));

		purchaseTypeRaport.setEditable(false);
		raportPanel.add(new JScrollPane(purchaseTypeRaport));

		add(raportPanel);
		this.connectionStatus.setHorizontalAlignment(JLabel.LEFT);
		add(connectionStatus);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

	public JTextPane getGroupMonthRaport() {
		return groupMonthRaport;
	}

	public JTextPane getGroupAllTimeRaport() {
		return groupAllTimeRaport;
	}

	public JTextPane getPurchaseTypeRaport() {
		return purchaseTypeRaport;
	}

	public JLabel getConnectionStatus() {
		return connectionStatus;
	}

}
