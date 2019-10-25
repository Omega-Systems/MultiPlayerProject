package me.maddin.game.core;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import me.maddin.game.Utility.Vector2Df;

public class ActionsHandler {
	
	public static void init(JComponent jComponent) {
		
	}

	public static Action moveUp = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840281L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().move(new Vector2Df(0, -1));
			System.out.println("Moved");
			CoreHandler.updateFrame();
		}
	};
	
	public static Action moveDown = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840282L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().move(new Vector2Df(0, 1));
			System.out.println("Moved");
			CoreHandler.updateFrame();
		}
	};
	
	public static Action moveRight = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840283L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().move(new Vector2Df(1, 0));
			System.out.println("Moved");
CoreHandler.updateFrame();
		}
	};
	
	public static Action moveLeft = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().move(new Vector2Df(-1, 0));
			System.out.println("Moved");
			CoreHandler.updateFrame();
		}
	};
	
}
