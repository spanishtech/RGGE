package me.soxey6.engine.events.input.mouse.release;

import me.soxey6.engine.managers.event.EventHandler;

public interface MouseReleaseHandler extends EventHandler{
	public void onMouseRelease(MouseReleaseEvent keyUpEvent);
}
