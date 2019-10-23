package me.maddin.game.framework;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import me.maddin.game.core.backgroundtile.BackgroundTileHandler;
import me.maddin.game.entity.EntityHandler;

public class JGameComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910049680908223084L;
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BackgroundTileHandler.drawBackground(g2d);
		EntityHandler.drawEnitites(g2d);
	}
}
