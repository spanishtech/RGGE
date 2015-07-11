package me.soxey6.engine.events.input.mouse.click;

import me.soxey6.engine.managers.event.EventHandler;

public interface MouseClickHandler extends EventHandler{
	public void onMouseClick(MouseClickEvent keyUpEvent);
}
