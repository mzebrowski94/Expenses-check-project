package mzebrowski.gui.centerPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Icon;

public class IconShape implements Icon {
	private Color color;

	private int width;
	private int height;
	private Rectangle rectHorizontal;
	private Rectangle rectVertical;
	private IconType iconType;
	public enum IconType{
		PLUS, MINUS, RECT;
	}
	
	public IconShape(Color color, int size, IconType iconType) {
		this.color = color;
		this.width = this.height = size;
		this.iconType = iconType;
		if(iconType == IconType.PLUS)
		{
			int halfWidth = width / 2;
			int halfHeight = height / 2;
			
			rectHorizontal = new Rectangle(0,(int)(halfHeight * 0.75),width,(int)(height * 0.25));
			rectVertical = new Rectangle((int)(halfWidth * 0.75),0,(int)(width * 0.25),height);
		}
		else if(iconType == IconType.MINUS)
		{
			int halfHeight = height / 2;			
			rectHorizontal = new Rectangle(0,(int)(halfHeight * 0.75),width,(int)(height * 0.25));
			rectVertical = null;
		}
		else
		{		
			rectHorizontal = new Rectangle(0,0,width,height);
			rectVertical = null;
		}
	}

	public int getIconHeight() {
		return height;
	}

	public int getIconWidth() {
		return width;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.translate(x, y);
			g.fillRect(rectHorizontal.x,rectHorizontal.y,rectHorizontal.width,rectHorizontal.height);
			if(iconType == IconType.PLUS)
			g.fillRect(rectVertical.x,rectVertical.y,rectVertical.width,rectVertical.height);
			else if(iconType == IconType.RECT)
			{
				g.setColor(Color.DARK_GRAY);
				g.drawRect(rectHorizontal.x,rectHorizontal.y,rectHorizontal.width,rectHorizontal.height);
			}
		g.translate(-x, -y);
	}
}
