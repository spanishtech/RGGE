package me.soxey6.engine.events.input.mouse.release;

import me.soxey6.engine.managers.event.Event;
import me.soxey6.engine.managers.event.EventListener;

public class MouseReleaseListener extends EventListener{

	private MouseReleaseHandler mouseClickHandler;
	
	public MouseReleaseListener(MouseReleaseHandler mouseReleaseHandler, MouseReleaseEvent mouseReleaseEvent) {
		super(mouseReleaseHandler, mouseReleaseEvent);
		this.mouseClickHandler = mouseReleaseHandler;
	}
	
	public MouseReleaseListener(MouseReleaseHandler mouseReleaseHandler, MouseReleaseEvent mouseReleaseEvent, boolean strictFilter) {
		super(mouseReleaseHandler, mouseReleaseEvent, strictFilter);
		this.mouseClickHandler = mouseReleaseHandler;
	}
	
	@Override
	public void onEvent()
	{
		mouseClickHandler.onEvent(getEvent());
		if(fitsFilter(getEvent()))
			onMouseRelease((MouseReleaseEvent) getEvent());
	}
	
	@Override
	public boolean fitsFilter(Event event)
	{
		if(isStrictFiltering())
			return (((MouseReleaseEvent) event).getX()==((MouseReleaseEvent)getEventFilter()).getX()&&((MouseReleaseEvent) event).getY()==((MouseReleaseEvent)getEventFilter()).getY()&&((MouseReleaseEvent) event).getClickState()==((MouseReleaseEvent)getEventFilter()).getClickState());
		else
			return getEventFilter().getClass().equals(event.getClass());
	}
	
	public void onMouseRelease(MouseReleaseEvent mouseReleaseEvent)
	{
		mouseClickHandler.onMouseRelease(mouseReleaseEvent);
	}
}
