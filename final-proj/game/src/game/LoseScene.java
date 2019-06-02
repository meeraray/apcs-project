package game;

import org.lwjgl.input.Keyboard;

import managers.GameManager;

public class LoseScene extends Scene {
	public LoseScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		// TODO setup buttons
	}
	
	public void run() {
		super.run();
	}

	protected void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_T)) {	// replay
			GameManager.RunScene(2);
		}
		// TODO respond based on button clicks
	}

	protected void render() {
		Textures.render(Textures.loseScreen);
	}
	
	protected void remove() {
		// TODO remove buttons
	}
}