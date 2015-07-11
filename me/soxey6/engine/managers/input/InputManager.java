package me.soxey6.engine.managers.input;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F8;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;

import java.util.ArrayList;

import me.soxey6.engine.main.Game;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL11;

/**
 * The input Manager class is used for managing the input of the users peripherals. They simply check to see if there are changes, if so, trigger events that can be hooked.
 * Use is fairly basic but this really shouldn't be touched as it will do what you want it to do.
 * @author pchilds
 *
 */
public class InputManager implements Runnable{
	private static InputManager inputManager;
	/**
	 *  Where we store keys (Even released ones)
	 */
	private ArrayList<Key> keys;

	private GLFWKeyCallback   keyCallback;
	
	boolean shouldStop = false;
	
	long window;
	
	/**
	 * Where the current mouse position is stored.
	 */
	private MousePos mousePos;

	/**
	 * This is where we store the LAST 
	 */
	private Click mouseClick;
	
	/**
	 * This is the DeltaScrolled in this tick
	 */
	private int scroll = 0;
	
	
	public InputManager(long window)
	{
		mouseClick		= null;
		mousePos 		= null;
		keys			= new ArrayList<Key>();
		inputManager	= this;
		this.window		= window;
	}
	
	/**
	 * This function is triggered to update all the input information.
	 */
	public void input()
	{
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if ( glfwInit() != GL11.GL_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");
        glfwSetKeyCallback(Game.getGame().getDisplay().getWindowHandler(), keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if ( key == GLFW_KEY_F8 && action == GLFW_RELEASE && !Game.getGame().getPerformanceThread().isAlive() && !Game.getGame().getPerformanceMonitor().shouldStop)
                	Game.getGame().getPerformanceThread().start();
            }
        });
		while(!shouldStop)
		{
			glfwPollEvents();
		}

	}

	private void updateKeys() {
	}

	private void updateMouse() {
	}
	
	
	public ArrayList<Key> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<Key> keys) {
		this.keys = keys;
	}

	public MousePos getMousePos() {
		return mousePos;
	}

	public void setMousePos(MousePos mousePos) {
		this.mousePos = mousePos;
	}

	public Click getMouseClick() {
		return mouseClick;
	}

	public void setMouseClick(Click mouseClick) {
		this.mouseClick = mouseClick;
	}

	public int getScroll() {
		return scroll;
	}

	public void setScroll(int scroll) {
		this.scroll = scroll;
	}

	public static InputManager getInputManager() {
		return inputManager;
	}

	public static void setInputManager(InputManager inputManager) {
		InputManager.inputManager = inputManager;
	}

	@Override
	public void run() {
		input();
	}
}

