package me.soxey6.engine.events.input.keys.up;

import me.soxey6.engine.managers.event.EventHandler;

public interface KeyUpHandler extends EventHandler{
	public void onKeyUp(KeyUpEvent keyUpEvent);
}
