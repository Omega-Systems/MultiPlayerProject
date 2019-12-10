package me.maddin.game.entity;

import java.awt.image.BufferedImage;
import java.io.File;

import me.maddin.game.Utility.FileManager;
import me.maddin.game.Utility.Vector2Df;

public class Player extends Entity {

	private BufferedImage playerImage;
	
	public Player(Vector2Df pos, int health, String name, int x) {
		super(pos, health);
		if(!new File(FileManager.entityRessourceFile, "Barrel.png").exists()) {
			System.out.println("File doesnt exist");
		}
		playerImage = FileManager.getImage(FileManager.entityRessourceFile, "Barrel.png");
		System.out.println("Player initialized");
		this.setName(name);
		this.setNameVisible(true);
	}

	@Override
	public BufferedImage getImage() {
		if(playerImage == null) {
			System.out.println("Image Null");
		}
		return playerImage;
	}

	/*
	@Override
	public void tick(float deltaT) {
		move(getVelocity().clone().multiply(deltaT));
		if(isMoving()){
			Vector2Df newVelocity = new Vector2Df(0, 0);
			if(InputMapping.get(InputMapping.moveUp)) {
				newVelocity.add(-1, 0);
			}
			if(InputMapping.get(InputMapping.moveDown)) {
				newVelocity.add(1, 0);
			}
			if(InputMapping.get(InputMapping.moveRight)) {
				newVelocity.add(0, 1);
			}
			if(InputMapping.get(InputMapping.moveLeft)) {
				newVelocity.add(0, -1);
			}
			getVelocity().add(newVelocity).multiply(deltaT);
		} else {
			getVelocity().multiply(1/(deltaT*1000));
		}
	}


	boolean isMoving() {
		return (InputMapping.get(InputMapping.moveDown) | InputMapping.get(InputMapping.moveUp) | InputMapping.get(InputMapping.moveRight) | InputMapping.get(InputMapping.moveLeft));
	}
	*/
	
}
