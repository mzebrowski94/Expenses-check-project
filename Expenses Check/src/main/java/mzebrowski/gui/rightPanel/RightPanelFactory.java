package mzebrowski.gui.rightPanel;

import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mzebrowski.gui.centerPanel.ComboBoxFilter;

public class RightPanelFactory {
		
		public RightPanel build()
		{
			RightPanel rightPanel = new RightPanel(
						new UserLoginPanel(
								new ValueField(new JTextField(),"User name: ","0"),
								new ValueField(new JPasswordField(),"Password: ","0"),
								new ImageIcon("src/main/resources/images/avatar.png")
								),
						new UserInformationPanel(
								new JLabel("Default Name"),
								new JLabel("100"),
								new JLabel("27.08.2017")
								),
						new ExpenseAddPanel(
								 new ComboBoxFilter("User: "),
								 new ComboBoxFilter("Purchase type: "),
								 new ComboBoxFilter("Date: "),
								 new ValueField(new JFormattedTextField(NumberFormat.getNumberInstance()),"Amount: ","0"),
								 new JButton("Add"),
								 new ValueField(new JTextField(),"Discription:"," ")
								)
					);
		
			return rightPanel;
		}
		
		
}
