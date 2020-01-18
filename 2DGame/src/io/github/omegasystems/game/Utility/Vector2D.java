package io.github.omegasystems.game.Utility;

import java.awt.Dimension;
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
	
	public Vector2D(Vector2Df vector) {
		this.x = (int) vector.x;
		this.y = (int) vector.y;	
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
	
	public Vector2D add(Vector2D vector2D) {
		this.x+=vector2D.x;
		this.y+=vector2D.y;
		return this;
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
		this.x*=x;
		this.y*=y;
	}
	
	public Vector2D multiply(int i) {
		this.x*=i;
		this.y*=i;
		return this;
	}
	
	public void lerp(Vector2D vector2d, float alpha)
	{
	    this.x =  (int) (x + alpha * (vector2d.x - this.x));
	    this.y =  (int) (y + alpha * (vector2d.y - this.y));
	}
	
	public void lerp(int x, int y, float alpha)
	{
	    this.x =  (int) (this.x + alpha * (x - this.x));
	    this.y =  (int) (this.y + alpha * (y - this.y));
	}
	
	public Dimension toDimension() {
		return new Dimension(x, y);
	}
	
	public Vector2Df asVector2Df() {
		return new Vector2Df(x, y);
	}
}
