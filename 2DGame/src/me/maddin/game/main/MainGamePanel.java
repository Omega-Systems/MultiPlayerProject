package me.maddin.game.main;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class MainGamePanel extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4097997766607298072L;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		MainClass.getGame().render(g2d);
	}
	
}
