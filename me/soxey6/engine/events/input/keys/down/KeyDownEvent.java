package me.soxey6.engine.events.input.keys.down;

import me.soxey6.engine.managers.event.Event;
import me.soxey6.engine.managers.input.Key;

public class KeyDownEvent extends Event{
	
	private Key key;
	
	public KeyDownEvent(Key key)
	{
		this.key = key;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
}
