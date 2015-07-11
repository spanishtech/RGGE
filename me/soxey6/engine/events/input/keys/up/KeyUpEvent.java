package me.soxey6.engine.events.input.keys.up;

import me.soxey6.engine.managers.event.Event;

public class KeyUpEvent extends Event{
	
	private int keyCode;
	
	public KeyUpEvent(int keyCode)
	{
		this.keyCode = keyCode;
	}
	
	public KeyUpEvent()
	{
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

}
