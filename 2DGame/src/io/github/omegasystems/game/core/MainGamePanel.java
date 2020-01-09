package io.github.omegasystems.game.core;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import io.github.omegasystems.game.main.MainClass;

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
