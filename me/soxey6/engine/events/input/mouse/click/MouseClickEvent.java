package me.soxey6.engine.events.input.mouse.click;

import me.soxey6.engine.managers.event.Event;

public class MouseClickEvent extends Event{
	
	
	private float x;
	private float y;
	private int mouseButton;
	
	public MouseClickEvent( float x, float y, int mouseButton )
	{
		this.x = x;
		this.y = y;
		this.mouseButton = mouseButton;
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

	public int getMouseButton() {
		return mouseButton;
	}

	public void setMouseButton(int mouseButton) {
		this.mouseButton = mouseButton;
	}


}
