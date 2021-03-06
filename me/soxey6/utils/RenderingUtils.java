package me.soxey6.utils;

import me.soxey6.engine.render.Colour;
import me.soxey6.engine.render.Display;

import org.lwjgl.opengl.GL11;

/**
 * A bunch of tools used for rendering in OpenGL, a basic wrapper for OpenGL and SlickUtils fonts.
 * @author Spanish
 *
 */
public class RenderingUtils{
	private static RenderingUtils renderingUtils;
	
	public RenderingUtils()
	{
		 renderingUtils=this;
	}
	
	public void drawQuad(float posX1, float posY1, float posX2, float posY2, Colour colour)
	{
		float windowX = Display.getDisplay().getSizeX();
		float windowY = Display.getDisplay().getSizeY();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4f(colour.getR(), colour.getG(), colour.getB(),colour.getA());
		    GL11.glVertex2f(LogicUtils.unNormalize(posX1, windowX), LogicUtils.unNormalize(posY1, windowY));
		    GL11.glVertex2f(LogicUtils.unNormalize(posX2, windowX), LogicUtils.unNormalize(posY1, windowY));
		    GL11.glVertex2f(LogicUtils.unNormalize(posX2, windowX), LogicUtils.unNormalize(posY2, windowY));
		    GL11.glVertex2f(LogicUtils.unNormalize(posX1, windowX), LogicUtils.unNormalize(posY2, windowY));
		GL11.glEnd();
    	GL11.glEnable(GL11.GL_BLEND);
	}

	public static RenderingUtils getRenderingUtils() {
		return renderingUtils;
	}

	public static void setRenderingUtils(RenderingUtils renderingUtils) {
		RenderingUtils.renderingUtils = renderingUtils;
	}
}
