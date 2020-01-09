package io.github.omegasystems.game.tiles;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.gui.inventory.Inventory;

public class InventoryForegroundTile implements ForeGroundTile{

	private Inventory inventory;
	private BufferedImage texture;
	private boolean inFrontOfEntities;
	
	public InventoryForegroundTile(BufferedImage tex, boolean inFrontLayer, Inventory inventory) {
		this.inventory=inventory;
		this.texture = tex;
		this.inFrontOfEntities = inFrontLayer;
	}
	
	@Override
	public BufferedImage getTexture() {
		return texture;
	}

	@Override
	public boolean isinFrontOfEntities() {
		return inFrontOfEntities;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
}
