package me.maddin.game.core;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import me.maddin.game.Utility.Vector2Df;
import me.maddin.game.framework.JGameComponent;

public class ActionsHandler {
	
	public static void init(JGameComponent jGameComponent) {
		jGameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "moveUp");
		jGameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "moveDown");
		jGameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'), "moveLeft");
		jGameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'), "moveRight");
		
		jGameComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "quit");
		
		jGameComponent.getActionMap().put("quit", ActionsHandler.quit);
		
		jGameComponent.getActionMap().put("moveUp", ActionsHandler.moveUp);
		jGameComponent.getActionMap().put("moveLeft", ActionsHandler.moveLeft);
		jGameComponent.getActionMap().put("moveDown", ActionsHandler.moveDown);
		jGameComponent.getActionMap().put("moveRight", ActionsHandler.moveRight);
	}

	public static Action moveUp = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840281L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().setVelocity(new Vector2Df(0, -1));
		}
	};
	
	public static Action moveDown = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840282L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().setVelocity(new Vector2Df(0, 1));
		}
	};
	
	public static Action moveRight = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840283L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().setVelocity(new Vector2Df(1, 0));
		}
	};
	
	public static Action moveLeft = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		@Override
		public void actionPerformed(ActionEvent e) {
			CoreHandler.getMainPlayer().setVelocity(new Vector2Df(-1, 0));
		}
	};
	
	public static Action quit = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
}
