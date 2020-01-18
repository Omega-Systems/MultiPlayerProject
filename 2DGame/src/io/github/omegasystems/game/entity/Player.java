package io.github.omegasystems.game.entity;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.Utility.Vector2Df;
import io.github.omegasystems.game.core.Game;
import io.github.omegasystems.game.gui.inventory.BlockItemStack;
import io.github.omegasystems.game.gui.inventory.ItemStack;
import io.github.omegasystems.game.tiles.Tile;
import io.github.omegasystems.game.world.World;

public class Player extends Entity {

	private BufferedImage playerImage;
	private World world;
	private ItemStack itemStack;
	
	public Player(Vector2Df pos, int health, String name, World world) {
		super(pos, health);
		playerImage = Game.playerImage;
		this.setName(name);
		this.setNameVisible(true);
		this.world=world;
	}

	@Override
	public BufferedImage getImage() {
		return playerImage;
	}

	public Tile getTileStandingOn() {
		return world.getTile(getPosition().toVector2d());
	}
	
	public ItemStack getItemInHand() {
		return itemStack;
	}
	
	public void setItemInHand(ItemStack itemStack) {
		if(BlockItemStack.class.isInstance(itemStack)) {
			System.out.println("Debug2");
		}
		if(itemStack==null) {
			System.out.println("Debug4");
		}
		System.out.println("Debug5");
		this.itemStack=itemStack;
	}
	
	public int getMaxStackSize() {
		return 3000;
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
