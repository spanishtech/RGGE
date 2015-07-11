package me.soxey6.engine.managers.input;

import me.soxey6.engine.render.Display;

public class MousePos {
	private float x;
	private float y;
	
	public MousePos(int x, int y)
	{
		setX((float)x/Display.getDisplay().getSizeX());
		setY((float)y/Display.getDisplay().getSizeY());
	}
	
	public MousePos(float x, float y)
	{
		setX(x);
		setY(y);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setX(int x) {
		this.x = (float)x/Display.getDisplay().getSizeX();
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setY(int y) {
		this.y = (float)y/Display.getDisplay().getSizeY();
	}
}
