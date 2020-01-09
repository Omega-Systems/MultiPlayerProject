package io.github.omegasystems.game.gui.inventory;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import io.github.omegasystems.game.Utility.FileManager;
import io.github.omegasystems.game.Utility.Vector2Df;
import io.github.omegasystems.game.main.MainClass;

public class InventoryHandler {

	private static BufferedImage invBGImage;
	private static final int slotSize = 40;
	private static final int materialTexOffset = 4;
	
	private  static Inventory drawnInventory;
	private static float inventoryPositionX;
	private static float inventoryPositionY;
	
	public static void init() {
		invBGImage = FileManager.getImage(FileManager.invRessourceFile, "InvSlot.png");
	}
	
	public static void render(Graphics2D g2d, Integer screenWidth, Integer screenHeight) {
		if(drawnInventory==null) {
			return;
		}
		ItemStack[][] inventory = drawnInventory.getContent();
		int offsetX = (screenWidth-(inventory.length*slotSize))/2;
		int offsetY = (screenHeight-(inventory[0].length*slotSize))/2;
		offsetX-=((-inventoryPositionX+MainClass.getGame().getPlayer().getPosition().x)*MainClass.TILESIZE);
		offsetY-=((-inventoryPositionY+MainClass.getGame().getPlayer().getPosition().y)*MainClass.TILESIZE);
		g2d.translate(offsetX, offsetY);
		
		for (int x = 0; x < inventory.length; x++) {
			for (int y = 0; y < inventory[x].length; y++) {
					int ax = x*slotSize;
					int ay = y*slotSize;
					g2d.drawImage(invBGImage, null, ax, ay);
					if(inventory[x][y]!=null) {
					g2d.drawImage(inventory[x][y].getTexture(), ax+materialTexOffset, ay+materialTexOffset, null);
					/*
					g2d.setColor(Color.WHITE);
					g2d.drawString(Integer.toString(inventory[x][y].getAmount()), ax, ay+slotSize-8);
					*/
				}
			}
		}
		
		g2d.translate(-offsetX, -offsetY);
		
	}
	
	public static void setDrawnInventory(Inventory inventory, Vector2Df position) {
		drawnInventory = inventory;
		if(position==null) {
			inventoryPositionX = 0;
			inventoryPositionY = 0;
		} else {
			inventoryPositionX = position.x;
			inventoryPositionY = position.y;
		}
	}
	
	public static Inventory getDrawnInventory() {
		return drawnInventory;
	}
	
	
	public static Vector2Df getInventoryPosition() {
		return new Vector2Df(inventoryPositionX, inventoryPositionY);
	}
	
}
