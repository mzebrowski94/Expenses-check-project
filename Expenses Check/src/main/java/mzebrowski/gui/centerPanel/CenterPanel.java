package mzebrowski.gui.centerPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import mzebrowski.gui.GuiElement;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel implements GuiElement {

	ComboBoxesToolbar comboBoxesToolbar;
	RecordTable recordTable;
	RaportPanel raportPanel;

	public CenterPanel(ComboBoxesToolbar comboBoxesToolbar, RecordTable recordTable, RaportPanel raportPanel) {
		this.comboBoxesToolbar = comboBoxesToolbar;
		this.recordTable = recordTable;
		this.raportPanel = raportPanel;
	}

	public ComboBoxesToolbar getComboBoxesToolbar() {
		return comboBoxesToolbar;
	}

	public RecordTable getRecordTable() {
		return recordTable;
	}

	public RaportPanel getStatusbar() {
		return raportPanel;
	}

	public void initLayout() {
		comboBoxesToolbar.initLayout();
		recordTable.initLayout();
		raportPanel.initLayout();
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 0;

		this.add(comboBoxesToolbar, constraints);

		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 0.8;
		constraints.weighty = 0.8;

		this.add(recordTable, constraints);

		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.weightx = 0.2;
		constraints.weighty = 0.2;

		this.add(raportPanel, constraints);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

}
