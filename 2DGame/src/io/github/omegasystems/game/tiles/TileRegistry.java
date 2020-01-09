package io.github.omegasystems.game.tiles;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import io.github.omegasystems.game.Utility.FileManager;
import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.gui.inventory.ItemStack;
import io.github.omegasystems.game.gui.inventory.Ressource;
import io.github.omegasystems.game.world.Biome;

public class TileRegistry {

	private static Map<String, Biome> registeredBiomes = new HashMap<String, Biome>();
	private static Map<String, TileTemplate> registeredTiles = new HashMap<String, TileTemplate>();
	
	public static void registerTile(String id, String biomeID, TileTemplate tile) {
		if(registeredBiomes.containsKey(biomeID)) {
			if (!registeredTiles.containsKey(id)) {
				registeredTiles.put(id, tile);
			}
			Biome biome = registeredBiomes.get(biomeID);
			biome.registerTile(tile);
		}
	}
	
	public static void registerBiome(String biomeID, Biome biome) {
		if(!registeredBiomes.containsKey(biomeID)) {
			registeredBiomes.put(biomeID, biome);
		}
	}
	
	public static Biome getBiome(String biomeID) {
		return registeredBiomes.get(biomeID);
	}
	
	
	//Standard Content Stuff down there
	
	public static final String mountainBiomeID = "mountains";
	
	public static BufferedImage stoneBGTex = null;
	public static BufferedImage smallStoneFGTex = null;
	public static BufferedImage bigStoneFGTex = null;
	
	static final TileTemplate MOUNTAIN_TEMPLATE_EMPTY = new TileTemplate() {
		
		@Override
		public Tile getNewTile(Vector2D pos) {
			Tile tile = new Tile(stoneBGTex);
			return tile;
		}
	};
	
	static final TileTemplate MOUNTAIN_TEMPLATE_SMALL_STONE = new TileTemplate() {
		
		@Override
		public Tile getNewTile(Vector2D pos) {
			Tile tile = new Tile(stoneBGTex);
			ForeGroundTile fgTile = new HarvestableForegroundTile(new ItemStack(Ressource.stone, 2), smallStoneFGTex, tile, false);
			tile.setFGTile(fgTile);
			return tile;
		}
	};
	
	static final TileTemplate MOUNTAIN_TEMPLATE_BIG_STONE = new TileTemplate() {
		
		@Override
		public Tile getNewTile(Vector2D pos) {
			Tile tile = new Tile(stoneBGTex);
			ForeGroundTile fgTile = new HarvestableForegroundTile(new ItemStack(Ressource.stone, 4), bigStoneFGTex, tile, false);
			tile.setFGTile(fgTile);
			return tile;
		}
	};
	
	public static void registerTemplates() {
		if(stoneBGTex==null) {
			stoneBGTex = FileManager.getImage(FileManager.tileRessourceFile, "BG/Stone_0.png");
		}
		if(smallStoneFGTex==null) {
			smallStoneFGTex = FileManager.getImage(FileManager.tileRessourceFile, "FG/SmallStone.png");
		}
		if(bigStoneFGTex==null) {
			bigStoneFGTex = FileManager.getImage(FileManager.tileRessourceFile, "FG/BigStone.png");
		}
		
		TileRegistry.registerBiome(mountainBiomeID, new Biome());
		TileRegistry.registerTile("Stone1", mountainBiomeID, MOUNTAIN_TEMPLATE_EMPTY);
		TileRegistry.registerTile("Stone2", mountainBiomeID, MOUNTAIN_TEMPLATE_SMALL_STONE);
		TileRegistry.registerTile("Stone3", mountainBiomeID, MOUNTAIN_TEMPLATE_BIG_STONE);
	}
}
