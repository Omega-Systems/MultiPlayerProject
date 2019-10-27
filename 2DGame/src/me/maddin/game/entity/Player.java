package me.maddin.game.entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import me.maddin.game.Utility.Vector2Df;

public class Player extends Entity {

	private Image playerImage;
	
	public Player(Vector2Df pos, int health, String name) {
		super(pos, health);
		
		playerImage = new ImageIcon(EntityHandler.getEnitityRessourceFile()+ "/Barrel.png").getImage();
		this.setName(name);
	}

	@Override
	public Image getImage() {
		return playerImage;
	}
	
}
