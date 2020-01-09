package io.github.omegasystems.game.world;

import java.util.ArrayList;
import java.util.List;

import io.github.omegasystems.game.tiles.TileTemplate;

public class Biome {
	
	private List<TileTemplate> registeredTiles;
	
	public Biome() {
		registeredTiles = new ArrayList<TileTemplate>();
	}
	
	public void registerTile(TileTemplate tile) {
		registeredTiles.add(tile);
	}
	
	public List<TileTemplate> getRegisteredTemplates() {
		return registeredTiles;
	}
	
}
