package io.github.omegasystems.game.gui;

import java.awt.Graphics2D;

import io.github.omegasystems.game.gui.inventory.InventoryHandler;

public class GUIHandler {

	public static void init() {
		InventoryHandler.init();
	}
	
	public static void render(Graphics2D g2d, int screenWidth, int screenHeight) {
		InventoryHandler.render(g2d, screenWidth, screenHeight);
	}
	
}
