package io.github.omegasystems.game.core;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import io.github.omegasystems.game.Utility.Vector2Df;
import io.github.omegasystems.game.entity.Player;
import io.github.omegasystems.game.gui.inventory.Inventory;
import io.github.omegasystems.game.gui.inventory.InventoryHandler;
import io.github.omegasystems.game.main.MainClass;
import io.github.omegasystems.game.tiles.InventoryForegroundTile;

public class ActionsHandler {
	
	public static final int speed = 3;
	
	public ActionsHandler(JComponent keyComponent) {		
		init(keyComponent);
		System.out.println("KeyListener registered!");
	}
	
	private void init(JComponent keyComponent) {
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "moveUp");
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "moveDown");
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "moveLeft");
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "moveRight");
		
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, KeyEvent.ALT_DOWN_MASK), "increaseFPS");
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, KeyEvent.ALT_DOWN_MASK), "decreaseFPS");
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F11"), "fullscreen");
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "quit");
		
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "pickUp");
		keyComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "place");
		
		keyComponent.getActionMap().put("quit", quit);
		keyComponent.getActionMap().put("fullscreen", fullscreen);
		keyComponent.getActionMap().put("increaseFPS", increaseFPS);
		keyComponent.getActionMap().put("decreaseFPS", decreaseFPS);
		
		keyComponent.getActionMap().put("pickUp", pickUp);
		keyComponent.getActionMap().put("place", debugPlaceInv);
		
		keyComponent.getActionMap().put("moveUp", moveUp);
		keyComponent.getActionMap().put("moveLeft", moveLeft);
		keyComponent.getActionMap().put("moveDown", moveDown);
		keyComponent.getActionMap().put("moveRight", moveRight);
	}

	public Action moveUp = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840281L;

		@Override
		public void actionPerformed(ActionEvent e) {
			MainClass.getGame().getPlayer().setVelocity(new Vector2Df(0, -speed));
		}
	};
	
	private Action debugPlaceInv = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840281L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Player player = MainClass.getGame().getPlayer();
			if(!player.getTileStandingOn().hasForeground()) {
				player.getTileStandingOn().setFGTile(new InventoryForegroundTile(Game.playerImage, false, new Inventory(5, 2)));
			} else if (player.getTileStandingOn().getForeGroundTile() instanceof InventoryForegroundTile) {
				InventoryForegroundTile inventoryForegroundTile = (InventoryForegroundTile) player.getTileStandingOn().getForeGroundTile();
				InventoryHandler.setDrawnInventory(inventoryForegroundTile.getInventory(), player.getPosition());
			}
		}
	};
	
	private Action moveDown = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840282L;

		@Override
		public void actionPerformed(ActionEvent e) {
			MainClass.getGame().getPlayer().setVelocity(new Vector2Df(0, speed));
		}
	};
	
	private Action moveRight = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840283L;

		@Override
		public void actionPerformed(ActionEvent e) {
			MainClass.getGame().getPlayer().setVelocity(new Vector2Df(speed, 0));
		}
	};
	
	private Action moveLeft = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		@Override
		public void actionPerformed(ActionEvent e) {
			MainClass.getGame().getPlayer().setVelocity(new Vector2Df(-speed, 0));
		}
	};
	
	private Action quit = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	private Action fullscreen = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;
		private boolean toggle = true;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(toggle) {
				GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setFullScreenWindow(MainClass.getGame().frame);
			} else {
				GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setFullScreenWindow(null);
			}
			toggle = !toggle;
		}
	};
	
	private Action increaseFPS = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Game.targetFPS+=2;
		}
	};
	
	private Action decreaseFPS = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Game.targetFPS-=2;
		}
	};
	
	private Action pickUp = new AbstractAction() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4700153653587840284L;

		//TODO: Playerpos not relative to tilePos in positive directions (&negative?)
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Player player = MainClass.getGame().getPlayer();
			player.getCurrentWorld().getTile(player.getPosition().clone().subtract(0.5f, 0.5f).toVector2d()).setFGTile(null);
		}
	};
}
