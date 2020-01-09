package io.github.omegasystems.game.world;

import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.tiles.Tile;

public interface WorldGenerator {
	public Tile getNewTile(Vector2D pos);
}