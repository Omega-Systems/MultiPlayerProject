package me.maddin.game.tiles;

import java.awt.image.BufferedImage;

public class Tile {

	private BufferedImage backgroundImage;
	private BufferedImage foregroundImage;
	private boolean isinFront;
	
	private boolean hasForeground;
	
	public Tile(BufferedImage image) {
		this.backgroundImage = image;
		hasForeground=false;
		isinFront=false;
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
	public void setBackgroundImage(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public void setForegroundImage(BufferedImage foregroundImage) {
		if(foregroundImage==null) {
			hasForeground=false;
		}
		this.foregroundImage = foregroundImage;
	}
	public boolean hasForeground() {
		return hasForeground;
	}
	public void setForegroundVisible(boolean vivible) {
		this.hasForeground=vivible;
	}
	public boolean isInFrontOffEntities() {
		return isinFront;
	}
}
