package me.soxey6.engine.objects.gui;

import me.soxey6.engine.events.input.mouse.click.MouseClickEvent;
import me.soxey6.engine.events.input.mouse.click.MouseClickHandler;
import me.soxey6.engine.events.input.mouse.click.MouseClickListener;
import me.soxey6.engine.events.input.mouse.move.MouseMoveEvent;
import me.soxey6.engine.events.input.mouse.move.MouseMoveHandler;
import me.soxey6.engine.events.input.mouse.move.MouseMoveListener;
import me.soxey6.engine.events.input.mouse.release.MouseReleaseEvent;
import me.soxey6.engine.events.input.mouse.release.MouseReleaseHandler;
import me.soxey6.engine.events.ticks.render.RenderEvent;
import me.soxey6.engine.events.ticks.render.RenderHandler;
import me.soxey6.engine.events.ticks.render.RenderListener;
import me.soxey6.engine.main.Wrapper;
import me.soxey6.engine.managers.event.Event;

/**
 * The basic GuiElement class used for creating any UI element
*/
public class GuiElement extends Wrapper implements MouseMoveHandler, MouseClickHandler, MouseReleaseHandler, RenderHandler
{
	private String name;
	private Gui gui;
	private float posX;
	private float posY;
	private float sizeX;
	private float sizeY;
	private boolean hovered;
	private boolean clicked;
	private boolean released;
	
	/**
	 * The basic GuiElement class used for creating any UI element
	 * @param name
	 * @param gui 
	 * @param posX
	 * @param posY
	 * @param sizeX
	 * @param sizeY
	 */
	public GuiElement(String name, Gui gui, float posX, float posY, float sizeX, float sizeY)
	{
		this.name=name;
		this.posX=posX;
		this.posY=posY;
		this.sizeX=sizeX;
		this.sizeY=sizeY;
		this.gui=gui;
		this.hovered=false;
		this.clicked=false;
		
		getGui().getGuiElements().add(this);
		
		getEventManager().addListener(new MouseMoveListener(this, new MouseMoveEvent(0, 0, 0, 0)));
		getEventManager().addListener(new MouseClickListener(this, new MouseClickEvent(0, 0, 0)));
		getEventManager().addListener(new RenderListener(this, new RenderEvent()));
		
	}
	

	@Override
	public void onRender(RenderEvent keyUpEvent) {
		render();
		
	}

	@Override
	public void onEvent(Event event) {		
	}

	@Override
	public void onMouseRelease(MouseReleaseEvent mouseReleaseEvent) {
		clicked  = false;
		released = true;
		onRelease(mouseReleaseEvent.getX(), mouseReleaseEvent.getY());
	}

	@Override
	public void onMouseMove(MouseMoveEvent mouseMoveEvent) {
		if(mouseMoveEvent.getX()>=posX&&mouseMoveEvent.getX()<=posX+sizeX&&mouseMoveEvent.getY()>=posY&&mouseMoveEvent.getY()<=posY+sizeY)
		{
			hovered = true;
			onHover(mouseMoveEvent.getX(), mouseMoveEvent.getY());
		}else
			hovered = false;
	}
	

	@Override
	public void onMouseClick(MouseClickEvent mouseClickEvent) {
		
		
		if(isHovered())
		{
			clicked  = true;
			released = false;
			onClick(mouseClickEvent.getX(), mouseClickEvent.getY());
		}
		
	}
	
	/**
	 * Triggered when the mouse clicks within the button
	 * @param mousePosX
	 * @param mousePosY
	 * To be overridden only
	 */
	public void onClick(float mousePosX, float mousePosY)
	{
		
	}
	
	/**
	 * Triggered when the mouse hovers within the button
	 * @param mousePosX
	 * @param mousePosY
	 * To be overridden only
	 */
	public void onHover(float x, float y)
	{		
	}
	
	/**
	 * Triggered when the mouse releases
	 * @param mousePosX
	 * @param mousePosY
	 * To be overridden only
	 */
	public void onRelease(float x, float y)
	{
		
	}

	
	public void render()
	{
		
	}
	
	/**
	 * @return the gui
	 */
	public Gui getGui()
	{
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(Gui gui)
	{
		this.gui = gui;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the posX
	 */
	public float getPosX()
	{
		return posX;
	}

	/**
	 * @return the posY
	 */
	public float getPosY()
	{
		return posY;
	}

	/**
	 * @return the sizeX
	 */
	public float getSizeX()
	{
		return sizeX;
	}

	/**
	 * @return the sizeY
	 */
	public float getSizeY()
	{
		return sizeY;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}


	/**
	 * @param posX the posX to set
	 */
	public void setPosX(float posX)
	{
		this.posX = posX;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(float posY)
	{
		this.posY = posY;
	}

	/**
	 * @param sizeX the sizeX to set
	 */
	public void setSizeX(float sizeX)
	{
		this.sizeX = sizeX;
	}

	/**
	 * @param sizeY the sizeY to set
	 */
	public void setSizeY(float sizeY)
	{
		this.sizeY = sizeY;
	}

	/**
	 * @return the hovered
	 */
	public boolean isHovered()
	{
		return hovered;
	}

	/**
	 * @return the clicked
	 */
	public boolean isClicked()
	{
		return clicked;
	}

	/**
	 * @param hovered the hovered to set
	 */
	public void setHovered(boolean hovered)
	{
		this.hovered = hovered;
	}

	/**
	 * @param clicked the clicked to set
	 */
	public void setClicked(boolean clicked)
	{
		this.clicked = clicked;
	}


	public boolean isReleased() {
		return released;
	}


	public void setReleased(boolean released) {
		this.released = released;
	}
	
}
