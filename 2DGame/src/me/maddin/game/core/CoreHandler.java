package me.maddin.game.core;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Vector2D;
import me.maddin.game.Utility.Vector2Df;
import me.maddin.game.core.backgroundtile.BackgroundTileHandler;
import me.maddin.game.entity.EntityHandler;
import me.maddin.game.entity.Player;
import me.maddin.game.framework.JGameComponent;

public class CoreHandler {

	private static JFrame frame;
	
	private static Vector2D tilemapsize;
	
	private static Player player;
	
	public static void init(int x, int y) {
		ressourceFile = FileManager.createDirectory("ressources");
		
		tilemapsize = new Vector2D(x, y);
		
		BackgroundTileHandler.init();
		EntityHandler.init();
		
		player = new Player(new Vector2D(0, 0), new Vector2Df(5, 5), 20, "Ibims");
		
		frame = new JFrame("Ibims");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(400, 400);
		JGameComponent jGameComponent = new JGameComponent();
		frame.add(jGameComponent);
		
		int MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		
		jGameComponent.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, MASK), "moveUp");
		jGameComponent.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, MASK), "moveDown");
		jGameComponent.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, MASK), "moveLeft");
		jGameComponent.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, MASK), "moveRight");
		
		jGameComponent.getActionMap().put("moveUp", ActionsHandler.moveUp);
		jGameComponent.getActionMap().put("moveLeft", ActionsHandler.moveLeft);
		jGameComponent.getActionMap().put("moveDown", ActionsHandler.moveDown);
		jGameComponent.getActionMap().put("moveRight", ActionsHandler.moveRight);
		
		frame.setIconImage(new ImageIcon(EntityHandler.getEnitityRessourceFile()+ "/Barrel.png").getImage());
		frame.setFocusable(true);
		frame.setFocusableWindowState(true);
		frame.pack();
		frame.setVisible(true);
		frame.requestFocus();
	}
	
	public static void updateFrame() {
		frame.repaint();
	}
	
	public static File ressourceFile;
	
	public static Vector2D getCurrentChunkPos() {
		return player.getCurrentChunk().clone();
	}
	
	public static Vector2D getFrameSize() {
		Dimension dimension = frame.getSize();
		int x = dimension.width;
		int y = dimension.height;
		return new Vector2D(x, y);
	}
	
	public static Vector2D getTileMapSize() {
		return tilemapsize.clone();
	}
	
	public static void setCurrentChunk(Vector2D pos) {
		player.setCurrentChunk(pos);
	}
	
	public static Player getMainPlayer() {
		return player;
	}
}
