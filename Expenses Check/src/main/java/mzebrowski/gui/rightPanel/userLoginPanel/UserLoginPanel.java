package mzebrowski.gui.rightPanel.userLoginPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import mzebrowski.gui.GuiElement;
import mzebrowski.gui.additionalComponents.ValueField;
import mzebrowski.gui.rightPanel.E_RightPanelActions;

@SuppressWarnings("serial")
public class UserLoginPanel extends JPanel implements GuiElement {

	ValueField loginField, passwordField;
	JButton loginButton, logoutButton;
	JLabel userIconLabel;
	ImageIcon userIcon;

	public UserLoginPanel(ValueField loginField, ValueField passwordField, ImageIcon userIcon, JButton loginButton,
			JButton logoutButton) {
		this.userIcon = userIcon;
		this.loginButton = loginButton;
		this.logoutButton = logoutButton;
		this.loginField = loginField;
		this.passwordField = passwordField;
	}

	private GridBagConstraints createConstraints(int fillType, int gridx, int gridy, double weightx, double weighty) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = fillType;
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		return constraints;
	}

	public void initLayout() {
		loginField.initLayout();
		passwordField.initLayout();

		setLayout(new GridBagLayout());
		userIcon.setImage(userIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		userIconLabel = new JLabel(userIcon, JLabel.CENTER);
		add(userIconLabel, createConstraints(GridBagConstraints.BOTH, 0, 0, 0.6, 0.6));

		JPanel fieldPane = new JPanel();
		fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.X_AXIS));

		fieldPane.add(loginField);

		fieldPane.add(passwordField);

		JPanel buttonPanel = new JPanel();
		GridLayout layout = new GridLayout(2, 0);
		layout.setVgap(10);
		buttonPanel.setLayout(layout);
		buttonPanel.add(loginButton);
		buttonPanel.add(logoutButton);
		buttonPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		fieldPane.add(buttonPanel);
		add(fieldPane, createConstraints(GridBagConstraints.BOTH, 0, 1, 0.4, 0.4));
				
		logoutButton.setEnabled(false);
		loginButton.setEnabled(true);
	}

	public ValueField getLoginField() {
		return loginField;
	}

	public ValueField getPasswordField() {
		return passwordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}
}
