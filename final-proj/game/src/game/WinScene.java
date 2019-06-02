package game;

import org.lwjgl.input.Keyboard;

public class WinScene extends Scene {
	public WinScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		// TODO setup buttons
	}
	
	public void run() {
		super.run();
	}

	protected void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {	// quit
			System.exit(0);
		} 
		// TODO respond based on button clicks
	}

	protected void render() {
		Textures.render(Textures.winScreen);
	}
	
	protected void remove() {
		// TODO remove button
	}
}
