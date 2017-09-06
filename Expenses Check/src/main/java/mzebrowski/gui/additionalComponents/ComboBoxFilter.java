package mzebrowski.gui.additionalComponents;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mzebrowski.gui.GuiElement;
import mzebrowski.gui.rightPanel.E_RightPanelActions;

public class ComboBoxFilter<T> extends JPanel implements GuiElement {

	private JLabel filterLabel;
	private JComboBox<String> optionList;
	private int filterAtribute = 0;
	private ArrayList<T> items;
	public static final int ADD_ALL_OPTION = 1;
	
	public ComboBoxFilter(String labelName) {		
		filterLabel = new JLabel(labelName);	
		optionList = new JComboBox<String>();	
	}
	
	public ComboBoxFilter(String labelName, int comboBoxFilterAtribute) {			
		this.filterLabel = new JLabel(labelName);	
		this.optionList = new JComboBox<String>();	
		this.filterAtribute = comboBoxFilterAtribute;
		if(filterAtribute == ADD_ALL_OPTION)
			optionList.addItem(E_ComboBoxFilterEnum.ALL.toString());
	}

	public void setOptionListData(ArrayList<T> items)
	{
		this.items = items;
		for(T itr: items)
		{
			String optionDiscription = itr.toString();
			optionList.addItem(optionDiscription);
		}	
	}

	public void initLayout() {
		setLayout(new GridLayout(2, 0));
		add(filterLabel);
		add(optionList);
	}

	public void initActionsAndListeners(ActionListener actionListener) {
		optionList.setActionCommand(E_RightPanelActions.FILTER_CHANGED.actionName());
		optionList.addActionListener(actionListener);
	}

	public void setChoosingEnabled(boolean enable) {
		optionList.setEnabled(enable);
	}

	public void setActionCommandForComboBox(String actionName) {
		optionList.setActionCommand(actionName);
	}
	
	public Object getSelectedItem()
	{
		if(filterAtribute==this.ADD_ALL_OPTION && ((String) optionList.getSelectedItem())==E_ComboBoxFilterEnum.ALL.toString())
		{
			return null;
		}
		else
		{
			String itemName = (String) optionList.getSelectedItem();
			for(T itr: items)
			{
				if(itr.toString().equals(itemName))
					return itr;
			}
			return null;
		}	
	}
	
}
