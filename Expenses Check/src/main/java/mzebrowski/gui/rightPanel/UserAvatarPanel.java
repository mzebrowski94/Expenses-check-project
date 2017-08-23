package mzebrowski.gui.rightPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UserAvatarPanel extends JPanel {

	private int size = 100;
	private String userLetter;
	
	public UserAvatarPanel() {
		super();
		setPreferredSize(new Dimension(size, size));
		// try {
		// image = ImageIO.read(new File("template.png"));
		// } catch (IOException ex) {
		// // handle exception...
		// }
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.drawImage(image, 0, 0, this); // see javadoc for more info on the
		// parameters

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, size, size);
	}

}
