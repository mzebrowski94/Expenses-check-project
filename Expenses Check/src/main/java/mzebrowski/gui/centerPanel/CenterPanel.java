package mzebrowski.gui.centerPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {

	ComboBoxesToolbar comboBoxesToolbar;
	RecordTable recordTable;
	RaportPanel statusbar;

	public CenterPanel(ComboBoxesToolbar comboBoxesToolbar, RecordTable recordTable, RaportPanel statusbar) {

		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx=0;
		constraints.gridy=0;
		this.comboBoxesToolbar = comboBoxesToolbar;
		this.add(comboBoxesToolbar, constraints);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.weightx=0.8;
		constraints.weighty=0.8;
		this.recordTable = recordTable;
		this.add(recordTable, constraints);
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.weightx=0.2;
		constraints.weighty=0.2;
		this.statusbar = statusbar;
		this.add(statusbar, constraints);
	}

	public ComboBoxesToolbar getComboBoxesToolbar() {
		return comboBoxesToolbar;
	}

	public RecordTable getRecordTable() {
		return recordTable;
	}

	public RaportPanel getStatusbar() {
		return statusbar;
	}

}
