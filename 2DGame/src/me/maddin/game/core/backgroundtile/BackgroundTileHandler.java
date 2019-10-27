package me.maddin.game.core.backgroundtile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Vector2D;
import me.maddin.game.Utility.Vector2Df;
import me.maddin.game.core.CoreHandler;
import me.maddin.game.core.Worldhandler;

public class BackgroundTileHandler {
	private static HashMap<Integer, BufferedImage> tilePalette;

	private static File pictureFile;
	private static BufferedImage image;
	
	private static int tileSize = 64;
	
	public static void init() {		
		tilePalette = new HashMap<Integer, BufferedImage>();
		
		pictureFile = FileManager.createDirectory("ressources/backgroundtiles");
		
		try {
			tilePalette.put(0, ImageIO.read(FileManager.getFile(pictureFile, "0.png")));
			tilePalette.put(1, ImageIO.read(FileManager.getFile(pictureFile, "1.png")));
			tilePalette.put(2, ImageIO.read(FileManager.getFile(pictureFile, "2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//tilePalette.put(3, new ImageIcon(FileManager.getFile(pictureFile, "3.png").getPath()).getImage());
		//tilePalette.put(4, new ImageIcon(FileManager.getFile(pictureFile, "4.png").getPath()).getImage());
		
		image = new BufferedImage(CoreHandler.getTileMapSize().x*tileSize, CoreHandler.getTileMapSize().y*tileSize, BufferedImage.TYPE_INT_ARGB);
	}
	
	public static void drawBackground(Graphics2D g2d) {
		
		Vector2D tilesize = CoreHandler.getFrameSize();
		
		tilesize.divide(CoreHandler.getTileMapSize());
		
		Vector2Df camOffset = CoreHandler.getCamOffset();
		
		for(int x = 0; x < CoreHandler.getTileMapSize().x; x++) {
			for(int y = 0; y < CoreHandler.getTileMapSize().y; y++) {
				g2d.drawImage(tilePalette.get(Worldhandler.getBackgroundTile(new Vector2D(x, y).add(new Vector2D(camOffset)))), x*tilesize.x, y*tilesize.y, tilesize.x, tilesize.y, null);
			}
		}
	}
	
	public static int getTileCount() {
		return 3;
	}
	
	public static BufferedImage getBackgroundTilesImage() {
		return image;
	}
	
	public static void createBackgroundImage() {
		Graphics2D g2d = image.createGraphics();
		//g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
		Vector2Df camoffset = CoreHandler.getCamOffset();
		Vector2Df tileoffset = new Vector2Df(camoffset.x % 1, camoffset.y % 1);
		for(int x = -1; x<=CoreHandler.getTileMapSize().x; x++) {
			for(int y = -1; y<=CoreHandler.getTileMapSize().y; y++) {
				g2d.drawImage(tilePalette.get(Worldhandler.getBackgroundTile(new Vector2D(x, y).add(new Vector2D(camoffset)))), null, (int) (x*tileSize+(tileoffset.x*tileSize)), (int) (y*tileSize+(tileoffset.y*tileSize)));
			}
		}
	}
	
}
