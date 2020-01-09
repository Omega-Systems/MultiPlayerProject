package io.github.omegasystems.game.tiles;

import java.awt.image.BufferedImage;

public interface ForeGroundTile {

	public BufferedImage getTexture();
	public boolean isinFrontOfEntities();
	
	public void onClick(TileClickEvent event);
}
