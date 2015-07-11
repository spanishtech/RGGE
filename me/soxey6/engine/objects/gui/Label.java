package me.soxey6.engine.objects.gui;

import me.soxey6.engine.render.Colour;

/**
 * A class for rendering text, it defaults to centered text
 * @author Spanish
 *
 */
public class Label extends GuiElement
{
	private int size;
	private String text;
	private Colour colour;
	private boolean centered;
	
	public Label(String name, Gui gui, float posX, float posY, String text, int size, Colour colour)
	{
		super(name, gui, posX, posY, 0, 0);
		this.size=size;
		this.text=text;
		this.colour=colour;
		this.centered=true;
	}
	public Label(String name, Gui gui, float posX, float posY, String text, int size, Colour colour,boolean centered)
	{
		super(name, gui, posX, posY, 0, 0);
		this.size=size;
		this.text=text;
		this.colour=colour;
		this.centered=centered;
	}
	
	
	/**
	 * @return the size of the font to be used
	 */
	public int getSize()
	{
		return size;
	}
	/**
	 * @return the text that this label renders
	 */
	public String getText()
	{
		return text;
	}
	/**
	 * @param the size of the font to set.
	 */
	public void setSize(int size)
	{
		this.size = size;
	}
	/**
	 * @param the text to change the text to
	 */
	public void setText(String text)
	{
		this.text = text;
	}
	public Colour getColor() {
		return colour;
	}
	public void setColor(Colour colour) {
		this.colour = colour;
	}
	public boolean isCentered() {
		return centered;
	}
	public void setCentered(boolean centered) {
		this.centered = centered;
	}
	
	
}
