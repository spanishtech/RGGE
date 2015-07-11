package me.soxey6.engine.events.input.mouse.release;

import me.soxey6.engine.managers.event.Event;
import me.soxey6.engine.managers.input.ClickState;

public class MouseReleaseEvent extends Event{
	
	
	private float x;
	private float y;
	private ClickState clickState;
	
	public MouseReleaseEvent( float x, float y, ClickState clickState )
	{
		this.x = x;
		this.y = y;
		this.setClickState(clickState);
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

	public ClickState getClickState() {
		return clickState;
	}

	public void setClickState(ClickState clickState) {
		this.clickState = clickState;
	}

}
