package me.maddin.game.core;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;

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
		frame.setSize(400, 400);
		frame.add(new JGameComponent());
		frame.setVisible(true);
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
	
}
