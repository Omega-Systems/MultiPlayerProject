package io.github.omegasystems.game.tiles;

import io.github.omegasystems.game.entity.Player;

public class TileClickEvent {

	private Player player;
	private int mouseKey;
	
	public TileClickEvent(Player player, int mouseKey) {
		this.player = player;
		this.mouseKey = mouseKey;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getmouseButtonCode() {
		return mouseKey;
	}
}
