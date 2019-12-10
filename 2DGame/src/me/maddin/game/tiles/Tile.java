package me.maddin.game.tiles;

import java.awt.image.BufferedImage;

public class Tile {

	private BufferedImage backgroundImage;
	private BufferedImage foregroundImage;
	
	private boolean hasForeground;
	
	public Tile(BufferedImage image) {
		this.backgroundImage = image;
		hasForeground=false;
	}
	public Tile(BufferedImage backgroundImage, BufferedImage foregroundImage) {
		this.backgroundImage = backgroundImage;
		this.foregroundImage = foregroundImage;
		hasForeground=true;
	}
	
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}
	
	public BufferedImage getForegroundImage() {
		return foregroundImage;
	}
	
	public boolean hasForeground() {
		return hasForeground;
	}
	
	public void setForeground(boolean vivible) {
		this.hasForeground=vivible;
	}
}
