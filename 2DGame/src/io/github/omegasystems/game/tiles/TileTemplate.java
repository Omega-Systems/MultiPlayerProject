package io.github.omegasystems.game.tiles;

import io.github.omegasystems.game.Utility.Vector2D;

public interface TileTemplate {
	public Tile getNewTile(Vector2D pos);
}
