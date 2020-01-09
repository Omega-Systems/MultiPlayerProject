package io.github.omegasystems.game.entity;

import java.awt.image.BufferedImage;

import io.github.omegasystems.game.Utility.Vector2Df;
import io.github.omegasystems.game.core.Tickable;
import io.github.omegasystems.game.world.World;

public abstract class Entity implements Tickable{

	public Entity(Vector2Df pos, World world) {
		this.position = pos;
		this.velocity = new Vector2Df(0, 0);
		this.health = maxhealth;
		
		this.world = world;
		
		world.registerEntity(this);
		Tickable.registerTickable(this);
	}
	
	public Entity(Vector2Df pos, int health, World world) {
		this.position = pos;
		this.velocity = new Vector2Df(0, 0);
		if(health > 0) {
			this.maxhealth=health;
			this.health = health;
		} else {
			this.health=100;
		}
		this.world = world;
		
		world.registerEntity(this);
		Tickable.registerTickable(this);
	}
	
	public Entity(Vector2Df pos) {
		this.position = pos;
		this.velocity = new Vector2Df(0, 0);
		this.health = maxhealth;
		
		this.world = World.getMainWorld();
		
		world.registerEntity(this);
		Tickable.registerTickable(this);
	}
	
	public Entity(Vector2Df pos, int health) {
		this.position = pos;
		this.velocity = new Vector2Df(0, 0);
		if(health > 0) {
			this.health = health;
		} else {
			this.health=maxhealth;
		}
		this.world = World.getMainWorld();
		
		world.registerEntity(this);
		Tickable.registerTickable(this);
	}
	
	private Vector2Df velocity;
	
	private int maxhealth;
	private int health;
	
	private String name;
	private boolean nameVisible;
	
	private Vector2Df position;
	
	private World world;
	
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return this.health;
	}
	public int getMaxHealth() {
		return maxhealth;
	}
	public void setMaxHealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}
	
	public void addDamage(int damage) {
		if(this.health-damage < 1) {
			onDeath();
		}
		this.health-=damage;
	}
	
	public Vector2Df getVelocity() {
		return this.velocity;
	}
	
	public void setVelocity(Vector2Df velocity) {
		if(velocity!=null) {
			this.velocity = velocity;
		}
	}
	
	public void setPosition(Vector2Df position) {
		this.position = position;
	}
	
	public Vector2Df getPosition() {
		return this.position;
	}
	
	public void move(Vector2Df relativePos) {
		getPosition().add(relativePos);
	}
	
	private void onDeath() {
		world.unregisterEntity(this);
		Tickable.unregisterTickable(this);
	}
	
	public abstract BufferedImage getImage();
	
	public String getCustomName() {
		return this.name;
	}
	
	public boolean nameVisible() {
		return nameVisible;
	}
	
	public void setNameVisible(boolean visible) {
		this.nameVisible = visible;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getRoatation() {
		return 0;
	}
	
	@Override
	public void tick(float deltaT) {
		move(velocity.clone().multiply(deltaT));
		velocity.multiply(Math.min(1/(deltaT*1000), 0.99f));
	}
	
	public World getCurrentWorld() {
		return world;
	}
}
