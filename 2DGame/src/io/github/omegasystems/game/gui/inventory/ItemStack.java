package io.github.omegasystems.game.gui.inventory;

import java.awt.image.BufferedImage;

public class ItemStack {

	private Ressource ressource;
	private int amount;
	
	public ItemStack(Ressource ressource) {
		this.ressource=ressource;
		amount=1;
	}
	public ItemStack(Ressource ressource, int amount) {
		this.ressource=ressource;
		this.amount=Math.max(amount, 1);
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Ressource getRessource() {
		return ressource;
	}
	
	public BufferedImage getTexture() {
		return ressource.getTexture(amount);
	}
	
	public void setAmount(int amount) {
		if(amount>0) {
			this.amount = amount;
		}
	}
	
}
