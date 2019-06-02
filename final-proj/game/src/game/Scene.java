package game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import utilities.Constants;
import utilities.Cooldown;

public abstract class Scene {	
	protected boolean pausable;
	private boolean pause = false;
	private Cooldown keyCooldown = new Cooldown(0.1);
	
	public Scene(boolean pausable) { this.pausable = pausable; }
	
	public void setup() {
		try {
            Display.setDisplayMode(new DisplayMode(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
            Display.setTitle("2D Minecraft Terraria Clone"); 
            Display.create();
        } catch (LWJGLException e) {
            System.err.println("Display wasn't initialized correctly.");
            System.exit(1);
        }
        
        Textures.initGL(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        Textures.init();
	}
	
	public void run() {
		while (!Display.isCloseRequested()) {
			keyCooldown.update();
			if (Keyboard.isKeyDown(Keyboard.KEY_P) && pausable && keyCooldown.isCooldownCompleted()) { 
				System.out.println("pausing or unpausing");
				pause = !pause; 
				
				keyCooldown.reset();
			}
			if (!pause) {
	        	update();
	        	render();
			} 
			Display.update();
            Display.sync(Constants.SCREENFPS);
        }
 
        Display.destroy();
        System.exit(0);
	}
	
	protected abstract void update();
	protected abstract void render();
	protected abstract void remove();
}
