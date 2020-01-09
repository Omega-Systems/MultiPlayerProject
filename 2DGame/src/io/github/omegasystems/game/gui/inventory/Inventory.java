package io.github.omegasystems.game.gui.inventory;

public class Inventory {
	
	private ItemStack[][] content;
	private String title;
	private int maxStackSize;
	
	public Inventory(int coloums, int rows) {
		setContent(new ItemStack[coloums][rows]);
	}
	public Inventory(int rows, int coloums, String title) {
		setContent(new ItemStack[coloums][rows]);
		this.setTitle(title);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ItemStack[][] getContent() {
		return content;
	}
	public void setContent(ItemStack[][] newContent) {
		if(newContent==null) {
			content = new ItemStack[content.length][content[0].length];
		}
		this.content = newContent;
	}
	
	public int getMaxStackSize() {
		return maxStackSize;
	}
	
	public void setMaxStackSize(int size) {
		if (size>0) {
			this.maxStackSize = size;
		}
	}
	
	public boolean addItem(ItemStack itemStack) {
		return false;
	}
}
