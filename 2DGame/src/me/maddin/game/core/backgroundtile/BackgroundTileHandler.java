package me.maddin.game.core.backgroundtile;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Vector2D;
import me.maddin.game.core.CoreHandler;

public class BackgroundTileHandler {

	private static Integer[][] tilemap;
	private static HashMap<Integer, Image> tilePalette;

	private static File pictureFile;
	
	public static void init() {
		Vector2D tilesize = CoreHandler.getTileMapSize();
		
		tilemap = new Integer[tilesize.x][tilesize.y];
		tilePalette = new HashMap<Integer, Image>();
		
		pictureFile = FileManager.createDirectory("ressources/backgroundtiles");
		
		tilePalette.put(0, new ImageIcon(FileManager.getFile(pictureFile, "0.png").getPath()).getImage());
		tilePalette.put(1, new ImageIcon(FileManager.getFile(pictureFile, "1.png").getPath()).getImage());
		tilePalette.put(2, new ImageIcon(FileManager.getFile(pictureFile, "2.png").getPath()).getImage());
		//tilePalette.put(3, new ImageIcon(FileManager.getFile(pictureFile, "3.png").getPath()).getImage());
		//tilePalette.put(4, new ImageIcon(FileManager.getFile(pictureFile, "4.png").getPath()).getImage());
		
		Random random = new Random(212344);
		
		for(int x = 0; x < tilemap.length; x++) {
			for(int y = 0; y < tilemap[x].length; y++) {
				tilemap[x][y] = random.nextInt(3);
			}
		}
	}
	
	public static void drawBackground(Graphics2D g2d) {
		
		Vector2D tilesize = CoreHandler.getFrameSize();
		
		tilesize.divide(CoreHandler.getTileMapSize());
		
		for(int x = 0; x < tilemap.length; x++) {
			for(int y = 0; y < tilemap[x].length; y++) {
				g2d.drawImage(tilePalette.get(tilemap[x][y]), x*tilesize.x, y*tilesize.y, tilesize.x, tilesize.y, null);
			}
		}
	}
	
}
