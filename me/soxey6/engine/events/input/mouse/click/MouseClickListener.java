package me.soxey6.engine.events.input.mouse.click;

import me.soxey6.engine.managers.event.Event;
import me.soxey6.engine.managers.event.EventListener;

public class MouseClickListener extends EventListener{

	private MouseClickHandler mouseClickHandler;
	
	public MouseClickListener(MouseClickHandler mouseClickHandler, MouseClickEvent mouseClickEvent) {
		super(mouseClickHandler, mouseClickEvent);
		this.mouseClickHandler = mouseClickHandler;
	}
	
	public MouseClickListener(MouseClickHandler mouseClickHandler, MouseClickEvent mouseClickEvent, boolean strictFilter) {
		super(mouseClickHandler, mouseClickEvent, strictFilter);
		this.mouseClickHandler = mouseClickHandler;
	}
	
	@Override
	public void onEvent()
	{
		mouseClickHandler.onEvent(getEvent());
		if(fitsFilter(getEvent()))
			onMouseClick((MouseClickEvent) getEvent());
	}
	
	@Override
	public boolean fitsFilter(Event event)
	{
		if(isStrictFiltering())
			return (((MouseClickEvent) event).getX()==((MouseClickEvent)getEventFilter()).getX()&&((MouseClickEvent) event).getY()==((MouseClickEvent)getEventFilter()).getY()&&((MouseClickEvent) event).getMouseButton()==((MouseClickEvent)getEventFilter()).getMouseButton());
		else
			return getEventFilter().getClass().equals(event.getClass());
	}
	
	public void onMouseClick(MouseClickEvent mouseClickEvent)
	{
		mouseClickHandler.onMouseClick(mouseClickEvent);
	}
}
