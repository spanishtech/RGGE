package me.soxey6.engine.events.input.keys.up;

import me.soxey6.engine.managers.event.Event;
import me.soxey6.engine.managers.event.EventListener;

public class KeyUpListener extends EventListener{

	private KeyUpHandler keyUpHandler;
	
	public KeyUpListener(KeyUpHandler keyUpHandler, KeyUpEvent keyUpEvent) {
		super(keyUpHandler, keyUpEvent);
		this.keyUpHandler = keyUpHandler;
	}
	
	public KeyUpListener(KeyUpHandler keyUpHandler, KeyUpEvent keyUpEvent, boolean strictFilter) {
		super(keyUpHandler, keyUpEvent, strictFilter);
		this.keyUpHandler = keyUpHandler;
	}
	
	@Override
	public void onEvent()
	{
		keyUpHandler.onEvent(getEvent());
		if(fitsFilter(getEvent()))
			onKeyUp((KeyUpEvent) getEvent());
	}
	
	@Override
	public boolean fitsFilter(Event event)
	{
		if(isStrictFiltering())
			return (((KeyUpEvent) event).getKeyCode()==((KeyUpEvent)getEventFilter()).getKeyCode());
		else
			return getEventFilter().getClass().equals(event.getClass());
	}
	
	public void onKeyUp(KeyUpEvent keyDownEvent)
	{
		keyUpHandler.onKeyUp(keyDownEvent);
	}
}
