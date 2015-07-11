package me.soxey6.engine.events.input.keys.down;

import me.soxey6.engine.managers.event.Event;
import me.soxey6.engine.managers.event.EventListener;

public class KeyDownListener extends EventListener{

	private KeyDownHandler keyDownHandler;
	
	public KeyDownListener(KeyDownHandler keyDownHandler, KeyDownEvent keyDownEvent) {
		super(keyDownHandler, keyDownEvent);
		this.keyDownHandler = keyDownHandler;
	}
	
	
	public KeyDownListener(KeyDownHandler keyDownHandler, KeyDownEvent keyDownEvent, boolean strictFilter) {
		super(keyDownHandler, keyDownEvent, strictFilter);
		this.keyDownHandler = keyDownHandler;
	}
	
	@Override
	public void onEvent()
	{
		keyDownHandler.onEvent(getEvent());
		if(fitsFilter(getEvent()))
			onKeyDown((KeyDownEvent) getEvent());
	}
	
	@Override
	public boolean fitsFilter(Event event)
	{
		return isStrictFiltering()?(((KeyDownEvent) event).getKey().getKeyCode()==((KeyDownEvent)getEventFilter()).getKey().getKeyCode()&&((KeyDownEvent) event).getKey().getKeyAction()==((KeyDownEvent)getEventFilter()).getKey().getKeyAction()):getEventFilter().getClass().equals(event.getClass());
	}
	
	public void onKeyDown(KeyDownEvent keyDownEvent)
	{
		keyDownHandler.onKeyDown(keyDownEvent);
	}
}
