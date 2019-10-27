package me.maddin.game.core;

import java.util.HashMap;
import java.util.Random;

import me.maddin.game.Utility.Vector2D;
import me.maddin.game.core.backgroundtile.BackgroundTileHandler;

public class Worldhandler {

	private static HashMap<Integer, HashMap<Integer, Integer>> blocks;
	
	private static Random random = new Random();
	
	public static int getBackgroundTile(Vector2D tilepos) {
		if(blocks.containsKey(tilepos.x)) {
			if(!blocks.get(tilepos.x).containsKey(tilepos.y)) {
				blocks.get(tilepos.x).put(tilepos.y, random.nextInt(BackgroundTileHandler.getTileCount()));
			}
		} else {
			blocks.put(tilepos.x, new HashMap<Integer, Integer>());
			blocks.get(tilepos.x).put(tilepos.y, random.nextInt(BackgroundTileHandler.getTileCount()));
		}
		return blocks.get(tilepos.x).get(tilepos.y);
	}
	
	public static void init() {
		blocks = new HashMap<Integer, HashMap<Integer,Integer>>();
	}
}
