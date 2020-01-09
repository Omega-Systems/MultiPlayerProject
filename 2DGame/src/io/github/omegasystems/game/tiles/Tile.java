package io.github.omegasystems.game.tiles;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.Utility.Vector2D;

public class Tile {

	private BufferedImage backgroundImage;
	private ForeGroundTile foreGroundTile;

	private Vector2D pos;
	
	private boolean hasForeground;
	
	public Tile(BufferedImage image) {
		this.backgroundImage = image;
		hasForeground=false;
	}
	
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}
	

	public void setBackgroundImage(BufferedImage backgroundImage, Vector2D pos) {
		this.backgroundImage = backgroundImage;
		this.pos = pos;
	}
	
	public boolean hasForeground() {
		return hasForeground;
	}
	
	public void setFGTile(ForeGroundTile tile) {
		this.foreGroundTile = tile;
		if(tile!=null) {
			this.hasForeground = true;
		} else {
			hasForeground=false;
		}
	}
	
	public ForeGroundTile getForeGroundTile() {
		return foreGroundTile;
	}
	
	public Vector2D getPos() {
		return pos.clone();
	}
}
