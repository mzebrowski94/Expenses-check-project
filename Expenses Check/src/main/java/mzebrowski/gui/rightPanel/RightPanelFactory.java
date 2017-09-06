package mzebrowski.gui.rightPanel;

import java.text.NumberFormat;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mzebrowski.database.domain.E_ExpenseType;
import mzebrowski.database.domain.E_PurchaseType;
import mzebrowski.database.domain.user.User;
import mzebrowski.gui.additionalComponents.ComboBoxFilter;
import mzebrowski.gui.additionalComponents.ValueField;
import mzebrowski.gui.rightPanel.expenseAddPanel.ExpenseAddPanel;
import mzebrowski.gui.rightPanel.userInformationPanel.UserInformationPanel;
import mzebrowski.gui.rightPanel.userLoginPanel.UserLoginPanel;

public class RightPanelFactory {

		public RightPanel build()
		{
			RightPanel rightPanel = new RightPanel(
						new UserLoginPanel(
								new ValueField(new JTextField(),"User name: "),
								new ValueField(new JPasswordField(),"Password: "),
								new ImageIcon("src/main/resources/images/avatar.png"),
								new JButton("Login"),
								new JButton("Logout")
								),
						new UserInformationPanel(
								new JLabel("Mathew"),
								new JLabel("100"),
								new JLabel("02.09.2017")
								),
						new ExpenseAddPanel(
								 new ComboBoxFilter<User>("User: "),
								 new ComboBoxFilter<E_PurchaseType>("Purchase type: "),
								 new ComboBoxFilter<LocalDate>("Date: "),
								 new ComboBoxFilter<E_ExpenseType>("Expense type: "),
								 new ValueField(new JFormattedTextField(getNumberFormat()),"Amount: "),
								 new JButton("Add"),
								 new ValueField(new JTextField(),"Discription:")
								)
					);
		
			return rightPanel;
		}
		
		private NumberFormat getNumberFormat()
		{
			NumberFormat numberFormat = NumberFormat.getNumberInstance();
			numberFormat.setMaximumFractionDigits(2);
			return numberFormat;
		}
}
