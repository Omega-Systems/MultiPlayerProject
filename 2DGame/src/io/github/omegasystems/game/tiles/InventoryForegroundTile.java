package io.github.omegasystems.game.tiles;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.gui.inventory.Inventory;
import io.github.omegasystems.game.gui.inventory.InventoryHandler;

public class InventoryForegroundTile implements ForeGroundTile{

	private Inventory inventory;
	private BufferedImage texture;
	private boolean inFrontOfEntities;
	private Vector2D pos;
	
	public InventoryForegroundTile(BufferedImage tex, boolean inFrontLayer, Inventory inventory, Vector2D pos) {
		this.inventory=inventory;
		this.texture = tex;
		this.inFrontOfEntities = inFrontLayer;
		this.pos = pos;
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

	@Override
	public void onClick(TileClickEvent event) {
		InventoryHandler.setDrawnInventory(inventory, pos.asVector2Df().add(0.5f, 0.5f));
	}
	
}
