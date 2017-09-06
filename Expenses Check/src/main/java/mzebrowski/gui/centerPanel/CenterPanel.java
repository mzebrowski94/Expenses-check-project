package mzebrowski.gui.centerPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mzebrowski.gui.GuiElement;
import mzebrowski.gui.centerPanel.filterToolbar.ComboBoxesToolbar;
import mzebrowski.gui.centerPanel.raportPanel.RaportPanel;
import mzebrowski.gui.centerPanel.recordTable.RecordTable;

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

	public RaportPanel getRaportPanel() {
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
		constraints.weightx = 0.9;
		constraints.weighty = 0.9;

		JScrollPane scrollPanel = new JScrollPane();
		this.add(scrollPanel, constraints);
		recordTable.setPreferredScrollableViewportSize(recordTable.getPreferredSize());
		recordTable.setFillsViewportHeight(true);
		scrollPanel.setViewportView(recordTable);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.weightx = 0.1;
		constraints.weighty = 0.1;

		this.add(raportPanel, constraints);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

}
