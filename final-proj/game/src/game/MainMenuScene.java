package game;

import org.lwjgl.input.Keyboard;

import managers.GameManager;

public class MainMenuScene extends Scene {
	public MainMenuScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		super.setup();	// super.setup() only needs to be called in the first scene
		// TODO setup buttons
	}
	
	public void run() {
		super.run();
	}

	protected void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_T)) {
			// TODO deinstantiate current running scene LWJGL instance
			GameManager.RunScene(1);	// story scene
		}
		// TODO respond to button clicks
	}

	protected void render() {
		Textures.render(Textures.mainMenuBackground);
	}
	
	protected void remove() {
		// TODO remove buttons
	}
}
