package mzebrowski.gui.rightPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import mzebrowski.gui.GuiElement;

@SuppressWarnings("serial")
public class ValueField extends JPanel implements GuiElement {

	private JLabel amountLabel;
	private JTextField textValueField;

	public ValueField(JTextField field, String labelDiscription, String defautlText) {
		this.amountLabel = new JLabel(labelDiscription);
		this.textValueField = field;
	}

	public void initLayout() {
		setLayout(new GridLayout(2, 0));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		amountLabel.setLabelFor(textValueField);
		add(amountLabel);
		add(textValueField);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		textValueField.addActionListener(actionListener);
	}
	
	public String getInsertedText()
	{
		return textValueField.getText();
	}

	public void setActionCommandForTextValue(String command) {
		textValueField.setActionCommand(command);
	}
	
	public void setTypingEnabled(boolean enable)
	{
		textValueField.setEnabled(enable);
	}
}
