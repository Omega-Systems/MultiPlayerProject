package io.github.omegasystems.game.world;

import java.util.Random;

import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.tiles.Tile;
import io.github.omegasystems.game.tiles.TileRegistry;

public class SimpleWorldGenerator implements WorldGenerator {

	private Random random;
	
	public SimpleWorldGenerator(long seed) {
		random = new Random(seed);
	}
	
	@Override
	public Tile getNewTile(Vector2D pos) {
		Biome biome = TileRegistry.getBiome(TileRegistry.mountainBiomeID);
		return biome.getRegisteredTemplates().get(random.nextInt(biome.getRegisteredTemplates().size())).getNewTile(pos);
	}

}
