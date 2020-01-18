package io.github.omegasystems.game.tiles;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.Utility.Vector2D;
import io.github.omegasystems.game.gui.inventory.BlockItemStack;
import io.github.omegasystems.game.gui.inventory.ItemStack;

public class HarvestableForegroundTile implements ForeGroundTile {
	
	private ItemStack ressource;
	private BufferedImage texture;
	private boolean inFrontOfEntities;
	private Tile tile;
	private Vector2D pos;
	
	public HarvestableForegroundTile(ItemStack itemStack, BufferedImage tex, Tile tile, boolean inFrontLayer, Vector2D pos) {
		this.tile=tile;
		this.ressource = itemStack;
		this.texture = tex;
		this.inFrontOfEntities = inFrontLayer;
		this.pos=pos;
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

	@Override
	public void onClick(TileClickEvent event) {
		if(event.getPlayer().getItemInHand()==null) {
			if(ressource instanceof BlockItemStack) {
				System.out.println("Debug3");
			}
			event.getPlayer().setItemInHand(new ItemStack(ressource.getRessource()));
			if(ressource.getAmount()<=1) {
				event.getPlayer().getCurrentWorld().getTile(pos).setFGTile(null);
			} else {
				ressource.setAmount(ressource.getAmount()-1);
			}
		} else if (event.getPlayer().getItemInHand().getRessource().equals(ressource.getRessource())) {
			if(event.getPlayer().getItemInHand().getAmount()<event.getPlayer().getMaxStackSize()) {
				event.getPlayer().getItemInHand().setAmount(event.getPlayer().getItemInHand().getAmount()+1);
				if(ressource.getAmount()<=1) {
					event.getPlayer().getCurrentWorld().getTile(pos).setFGTile(null);
				} else {
					ressource.setAmount(ressource.getAmount()-1);
				}
			}
		}
	}

}
