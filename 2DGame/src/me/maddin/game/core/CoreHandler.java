package me.maddin.game.core;

import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Scheduler;
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
		Worldhandler.init();
		
		player = new Player(new Vector2Df(5, 5), 20, "Ibims");
		
		frame = new JFrame("Ibims");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JGameComponent jGameComponent = new JGameComponent();
		frame.add(jGameComponent);
		
		ActionsHandler.init(jGameComponent);
		
		frame.setIconImage(new ImageIcon(EntityHandler.getEnitityRessourceFile()+ "/Barrel.png").getImage());
		frame.setFocusable(true);
		frame.setFocusableWindowState(true);
		frame.pack();
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.requestFocus();
		
		Scheduler.runTaskRepeating(new Runnable() {
			
			@Override
			public void run() {
				CoreHandler.updateFrame();
			}
		}, 10, 33);
		
		Scheduler.runTaskRepeating(new Runnable() {
			
			@Override
			public void run() {
				BackgroundTileHandler.createBackgroundImage();
			}
		}, 2, 33);
	}
	
	public static void updateFrame() {
		frame.repaint();
	}
	
	public static File ressourceFile;
	
	public static Vector2D getFrameSize() {
		Dimension dimension = frame.getSize();
		int x = dimension.width;
		int y = dimension.height;
		return new Vector2D(x, y);
	}
	
	public static Vector2D getTileMapSize() {
		return tilemapsize.clone();
	}
	
	public static Vector2Df getCamOffset() {
		return player.getPosition().clone().add(new Vector2Df(getFrameSize()).multiply(-0.5f));
	}
	
	public static Player getMainPlayer() {
		return player;
	}
}
