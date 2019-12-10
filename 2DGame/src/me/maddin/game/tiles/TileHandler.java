package me.maddin.game.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.main.MainClass;
import me.maddin.game.main.World;

public class TileHandler {
	
	private static HashMap<Integer, BufferedImage> backgroundTilePalette;
	private static HashMap<Integer, BufferedImage> foreGroundTilePallette;

	private static Random random;
	
	public static void init() {		
		backgroundTilePalette = new HashMap<Integer, BufferedImage>();
		foreGroundTilePallette = new HashMap<Integer, BufferedImage>();
		
		try {
			backgroundTilePalette.put(0, ImageIO.read(FileManager.getFile(FileManager.tileRessourceFile, "0.png")));
			backgroundTilePalette.put(1, ImageIO.read(FileManager.getFile(FileManager.tileRessourceFile, "1.png")));
			backgroundTilePalette.put(2, ImageIO.read(FileManager.getFile(FileManager.tileRessourceFile, "2.png")));
			
			foreGroundTilePallette.put(0, FileManager.getImage(FileManager.tileRessourceFile, "BigStone.png"));
			foreGroundTilePallette.put(1, FileManager.getImage(FileManager.tileRessourceFile, "OakTree.png"));
			foreGroundTilePallette.put(2, FileManager.getImage(FileManager.tileRessourceFile, "SmallStone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		random = new Random();
	}
	
	public static void render(Graphics2D g2d, int frameSizeX, int frameSizeY, World world) {
		float offsetX =  (world.getCamOffsetX()*MainClass.TILESIZE) % MainClass.TILESIZE;
		float offsetY = (world.getCamOffsetY()*MainClass.TILESIZE) % MainClass.TILESIZE;
		
		g2d.translate(-offsetX, -offsetY);
		for(int x = -1; x<=frameSizeX/MainClass.TILESIZE+1; x++) {
			for(int y = -1; y<=frameSizeY/MainClass.TILESIZE+1; y++) {
				Tile tile = world.getTile(world.getTileOffsetX()+x, world.getTileOffsetY()+y);
				g2d.drawImage(tile.getBackgroundImage(), null, x*MainClass.TILESIZE, y*MainClass.TILESIZE);
				if(tile.hasForeground()) {
					g2d.drawImage(tile.getForegroundImage(), null, x*MainClass.TILESIZE, y*MainClass.TILESIZE);
				}
			}
		}
		g2d.translate(offsetX, offsetY);
	}
	
	public static int getTileCount() {
		return backgroundTilePalette.size();
	}
	
	private static Tile getNewBackgroundTile() {
		return new Tile(backgroundTilePalette.get(random.nextInt(backgroundTilePalette.size())));
	}
	
	public static Tile getNewTile() {
		if(random.nextInt(10)==0) {
			return new Tile(backgroundTilePalette.get(random.nextInt(backgroundTilePalette.size())), foreGroundTilePallette.get(random.nextInt(foreGroundTilePallette.size())));
		} else {
			return getNewBackgroundTile();
		}
	}
}
