package me.maddin.game.Utility;

import java.io.Serializable;

public class Vector2D implements Cloneable, Serializable{

	/**
	 * 
	 */	
	private static final long serialVersionUID = 3362017869327456942L;
	
	public int x;
	public int y;

	public Vector2D(Vector2D vector) {
		this.x = vector.x;
		this.y = vector.y;		
	}
	
	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;		
	}
	
	public void divide(Vector2D vector2d) {
		this.x /= vector2d.x;
		this.y /= vector2d.y;
	}
	
	public void divide(int x, int y) {
		this.x /= x;
		this.y /= y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector2D) {
			Vector2D vector2d = (Vector2D) obj;
			if(vector2d.x==x&vector2d.y==y) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}
	
	public Vector2D clone() {
		return new Vector2D(this);
	}
	
	public void add(Vector2D vector2D) {
		this.x+=vector2D.x;
		this.y+=vector2D.y;
	}
	
	public void add(int x, int y) {
		this.x+=x;
		this.y+=y;
	}
	
	public void multiply(Vector2D vector2d) {
		this.x*=vector2d.x;
		this.y*=vector2d.y;
	}
	
	public void multiply(int x, int y) {
		this.x+=x;
		this.y+=y;
	}
	
}
