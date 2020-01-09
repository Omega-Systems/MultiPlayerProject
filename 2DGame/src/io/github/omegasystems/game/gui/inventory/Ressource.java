package io.github.omegasystems.game.gui.inventory;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.Utility.FileManager;

public class Ressource {

	public static Ressource stone;
	public static Ressource wood;
	
	private BufferedImage[] textures;
	
	private Ressource(BufferedImage[] textures) {
		this.textures=textures;
	}
	
	public BufferedImage getTexture(int amount) {
		if(amount>textures.length) {
			amount = 3;
		} else if (amount<1) {
			amount = 1;
		}
		return textures[amount];
	}

	public static void loadRessources() {
		BufferedImage[] textures = {FileManager.getImage(FileManager.invRessourceFile, "pebble1.png"), FileManager.getImage(FileManager.invRessourceFile, "pebble2.png"), FileManager.getImage(FileManager.invRessourceFile, "pebble3.png")};
		stone = new Ressource(textures);
	}	
	
}