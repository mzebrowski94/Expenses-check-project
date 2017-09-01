package mzebrowski.gui.rightPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class UserLoginPanel extends JPanel {

	// private int size = 100;
	// private String userLetter;

	ValueField loginField, passwordField;
	JLabel userIconLabel;
	ImageIcon userIcon;

	public UserLoginPanel(ValueField loginField, ValueField passwordField, ImageIcon userIcon) {		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
				
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridy=0;
		constraints.weightx=1;
		constraints.weighty=1;
		this.userIcon = userIcon;
		userIcon.setImage(userIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		userIconLabel = new JLabel(userIcon, JLabel.CENTER);
		userIconLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		add(userIconLabel,constraints);

		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridy=1;
		constraints.weightx=1;
		constraints.weighty=1;
		JPanel loginPane = new JPanel();
		BoxLayout loginPaneLayout = new BoxLayout(loginPane, BoxLayout.X_AXIS);
		loginPane.setLayout(loginPaneLayout);
		
		this.loginField = loginField;
		loginPane.add(loginField);
		this.passwordField = passwordField;
		loginPane.add(passwordField);
		
		
		add(loginPane, constraints);
	}

	// @Override
	// protected void paintComponent(Graphics g) {
	// super.paintComponent(g);
	// // g.drawImage(image, 0, 0, this); // see javadoc for more info on the
	// // parameters
	//
	// g.setColor(Color.WHITE);
	// g.fillRect(0, 0, size, size);
	// }
	// setPreferredSize(new Dimension(size, size));
	// try {
	// image = ImageIO.read(new File("template.png"));
	// } catch (IOException ex) {
	// // handle exception...
	// }
}
