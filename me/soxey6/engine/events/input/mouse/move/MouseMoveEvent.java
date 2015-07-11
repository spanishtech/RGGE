package me.soxey6.engine.events.input.mouse.move;

import me.soxey6.engine.managers.event.Event;

public class MouseMoveEvent extends Event{
	
	private float dx;
	private float dy;
	
	private float x;
	private float y;
	
	public MouseMoveEvent( float dx, float dy, float x, float y)
	{
		this.dx = dx;
		this.dy = dy;
		
		this.x = x;
		this.y = y;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
