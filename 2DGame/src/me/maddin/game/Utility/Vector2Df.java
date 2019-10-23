package me.maddin.game.Utility;

import java.io.Serializable;

public class Vector2Df implements Cloneable, Serializable{

	/**
	 * 
	 */	
	private static final long serialVersionUID = 3362017869327456942L;
	
	public float x;
	public float y;

	public Vector2Df(Vector2Df vector) {
		this.x = vector.x;
		this.y = vector.y;		
	}
	
	public Vector2Df(float x, float y) {
		this.x = x;
		this.y = y;		
	}
	
	public void divide(Vector2Df vector2d) {
		this.x /= vector2d.x;
		this.y /= vector2d.y;
	}
	
	public void divide(float x, float y) {
		this.x /= x;
		this.y /= y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector2Df) {
			Vector2Df vector2d = (Vector2Df) obj;
			if(vector2d.x==x&vector2d.y==y) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}
	
	public Vector2Df clone() {
		return new Vector2Df(this);
	}
	
	public void add(Vector2Df vector2Df) {
		this.x+=vector2Df.x;
		this.y+=vector2Df.y;
	}
	
	public void add(float x, float y) {
		this.x+=x;
		this.y+=y;
	}
	
	public void multiply(Vector2D vector2d) {
		this.x*=vector2d.x;
		this.y*=vector2d.y;
	}
	
	public void multiply(float x, float y) {
		this.x+=x;
		this.y+=y;
	}
}
