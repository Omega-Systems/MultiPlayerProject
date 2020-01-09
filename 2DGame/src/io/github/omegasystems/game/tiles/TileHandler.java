package me.maddin.game.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.main.MainClass;
import me.maddin.game.world.World;

public class TileHandler {
	
	private static ArrayList<ArrayList<BufferedImage>> backgroundTilePalette;
	private static HashMap<Integer, BufferedImage> foreGroundTilePallette;

	private static Random random;
	
	public static void init() {		
		backgroundTilePalette = new ArrayList<ArrayList<BufferedImage>>();
		foreGroundTilePallette = new HashMap<Integer, BufferedImage>();
		
		//GrassTileset
		ArrayList<BufferedImage> grassPalette = new ArrayList<BufferedImage>();
		grassPalette.add(FileManager.getImage(FileManager.tileRessourceFile, "BG/Grass_0.png"));
		grassPalette.add(FileManager.getImage(FileManager.tileRessourceFile, "BG/Grass_1.png"));
		grassPalette.add(FileManager.getImage(FileManager.tileRessourceFile, "BG/Grass_2.png"));
		
		//StoneTileset
		ArrayList<BufferedImage> stonePalette = new ArrayList<BufferedImage>();
		stonePalette.add(FileManager.getImage(FileManager.tileRessourceFile, "BG/Stone_0.png"));
		
		backgroundTilePalette.add(grassPalette);
		backgroundTilePalette.add(stonePalette);
		
		foreGroundTilePallette.put(0, FileManager.getImage(FileManager.tileRessourceFile, "FG/BigStone.png"));
		foreGroundTilePallette.put(1, FileManager.getImage(FileManager.tileRessourceFile, "FG/OakTree.png"));
		foreGroundTilePallette.put(2, FileManager.getImage(FileManager.tileRessourceFile, "FG/SmallStone.png"));
		
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
	
	private static Tile getNewBackgroundTile(int biome) {
		return new Tile(backgroundTilePalette.get(biome).get(random.nextInt(backgroundTilePalette.get(biome).size())));
	}
	
	private static Tile getNewTileIntern(int biome) {
		return new Tile(backgroundTilePalette.get(biome).get(random.nextInt(backgroundTilePalette.get(biome).size())), foreGroundTilePallette.get(random.nextInt(foreGroundTilePallette.size())));
	}
	
	public static Tile getNewTile(int distance) {
		int biome =0;
		if(distance>0) {
			if(random.nextInt(distance)>10) {
				biome = 1;
			}
		}
		
		if(random.nextInt(10)==0) {
			return getNewTileIntern(biome);
		} else {
			return getNewBackgroundTile(biome);
		}
	}
}
