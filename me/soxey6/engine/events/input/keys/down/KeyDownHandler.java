package me.soxey6.engine.events.input.keys.down;

import me.soxey6.engine.managers.event.EventHandler;

public interface KeyDownHandler extends EventHandler{
	public void onKeyDown(KeyDownEvent keyDownEvent);
}
