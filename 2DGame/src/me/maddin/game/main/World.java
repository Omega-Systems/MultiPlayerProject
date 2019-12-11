package me.maddin.game.main;

import java.util.ArrayList;
import java.util.HashMap;

import me.maddin.game.Utility.Vector2D;
import me.maddin.game.Utility.Vector2Df;
import me.maddin.game.entity.Entity;
import me.maddin.game.tiles.Tile;
import me.maddin.game.tiles.TileHandler;

public class World {
	
	private static World world;
	private ArrayList<Entity> registeredEntities;

	private HashMap<Integer, HashMap<Integer, Tile>> blocks;
	
	private Vector2Df camOffset;
	
	public World() {
		blocks = new HashMap<Integer, HashMap<Integer,Tile>>();		
		world = this;
		this.camOffset = new Vector2Df(0, 0);
		registeredEntities = new ArrayList<Entity>();
	}
	
	public Tile getTile(int x, int y) {
		if(blocks.containsKey(x)) {
			if(!blocks.get(x).containsKey(y)) {
				blocks.get(x).put(y, TileHandler.getNewTile((int) Math.sqrt(x*x+(y*y))));
			}
		} else {
			blocks.put(x, new HashMap<Integer, Tile>());
			blocks.get(x).put(y, TileHandler.getNewTile((int) Math.sqrt(x*x+(y*y))));
		}
		return blocks.get(x).get(y);
	}
	
	public Tile getTile(Vector2D pos) {
		return getTile(pos.x, pos.y);
	}
	
	public float getCamOffsetX() {
		return camOffset.x;
	}
	public float getCamOffsetY() {
		return camOffset.y;
	}
	
	public int getTileOffsetX() {
		return (int) camOffset.x;
	}
	public int getTileOffsetY() {
		return (int) camOffset.y;
	}
	
	public void setCamOffset(Vector2Df camOffset) {
		this.camOffset = camOffset;
	}
	
	public static World getMainWorld() {
		return world;
	}
	
	public ArrayList<Entity> getRegisteredEntities() {
		return registeredEntities;
	}
	
	public void registerEntity(Entity entity) {
		if(!registeredEntities.contains(entity)) {
			registeredEntities.add(entity);
			System.out.println("Entity regstiert!");
		}
	} 
	
	public void unregisterEntity(Entity entity) {
		if(registeredEntities.contains(entity)) {
			registeredEntities.remove(entity);
		}
	}
	
}
