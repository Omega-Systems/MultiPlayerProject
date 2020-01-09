package io.github.omegasystems.game.Utility;

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
	
	public Vector2Df(Vector2D vector) {
		this.x = vector.x;
		this.y = vector.y;	
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
	
	public Vector2Df add(Vector2Df vector2Df) {
		this.x+=vector2Df.x;
		this.y+=vector2Df.y;
		return this;
	}
	
	public Vector2Df add(float x, float y) {
		this.x+=x;
		this.y+=y;
		return this;
	}
	
	public void multiply(Vector2D vector2d) {
		this.x*=vector2d.x;
		this.y*=vector2d.y;
	}
	
	public void multiply(float x, float y) {
		this.x*=x;
		this.y*=y;
	}
	
	public Vector2Df multiply(float i) {
		this.x*=i;
		this.y*=i;
		return this;
	}
	
	public float distanceTo(Vector2Df vec) {
		 return distanceTo(vec.x, vec.y);
	}
	
	public float distanceTo(float x, float y) {
		float ax = this.x-x;
		float ay = this.y-y;
		return (float) Math.sqrt(ax*ax+ay*ay);
	}
	
	public void lerp(Vector2D vector2d, float alpha)
	{
	    this.x = (x + alpha * (vector2d.x - this.x));
	    this.y = (y + alpha * (vector2d.y - this.y));
	}
	
	public void lerp(float x, float y, float alpha)
	{
	    this.x = (this.x + alpha * (x - this.x));
	    this.y = (this.y + alpha * (y - this.y));
	}
	
	@Override
	public String toString() {
		return "Vector: x=" + this.x +", y=" +this.y;
	}
	
	public Vector2D toVector2d() {
		return new Vector2D(this);
	}
}
