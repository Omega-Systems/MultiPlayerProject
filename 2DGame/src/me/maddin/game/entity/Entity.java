package me.maddin.game.entity;

import java.awt.Image;

import me.maddin.game.Utility.Vector2Df;

public abstract class Entity {

	public Entity(Vector2Df pos) {
		this.position = pos;
		this.velocity = new Vector2Df(0, 0);
		this.health = maxhealth;
		
		EntityHandler.registerEntity(this);
	}
	
	public Entity(Vector2Df pos, int health) {
		this.position = pos;
		this.velocity = new Vector2Df(0, 0);
		if(health > 1)
			this.health = health;
		
		EntityHandler.registerEntity(this);
	}
	
	private Vector2Df velocity;
	
	private int maxhealth;
	private int health;
	
	private String name;
	
	private Vector2Df position;
	
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
			this.velocity = velocity.clone();
			if(!velocity.equals(new Vector2Df(0, 0))) {
				EntityHandler.registerMovingEntity(this);
			}
		}
	}
	
	/*
	public void move(Vector2Df velocity) {
		position.add(velocity);
		updateChunk();
	}
	*/
	
	public void setPosition(Vector2Df position) {
		this.position = position.clone();
	}
	
	public Vector2Df getPosition() {
		return this.position;
	}
	
	private void onDeath() {
		EntityHandler.unregisterEntity(this);
	}
	
	public abstract Image getImage();
	
	public String getCustomName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getRoatation() {
		return 0;
	}
}
