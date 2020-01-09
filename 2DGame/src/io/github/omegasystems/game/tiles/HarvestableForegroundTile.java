package io.github.omegasystems.game.tiles;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.gui.inventory.ItemStack;

public class HarvestableForegroundTile implements ForeGroundTile {
	
	private ItemStack ressource;
	private BufferedImage texture;
	private boolean inFrontOfEntities;
	private Tile tile;
	
	public HarvestableForegroundTile(ItemStack itemStack, BufferedImage tex, Tile tile, boolean inFrontLayer) {
		this.tile=tile;
		this.ressource = itemStack;
		this.texture = tex;
		this.inFrontOfEntities = inFrontLayer;
	}
	
	@Override
	public BufferedImage getTexture() {
		return texture;
	}
	
	public ItemStack getRessource( ) {
		return ressource;
	}
	
	public boolean harvest(int amount) {
		if(ressource.getAmount()>=amount) {
			if(ressource.getAmount()==amount) {
				tile.setFGTile(null);
			} else {
				ressource.setAmount(amount);
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isinFrontOfEntities() {
		return inFrontOfEntities;
	}

}
