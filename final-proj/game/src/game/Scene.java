package game;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;

import managers.Textures;
import ui.*;
import utilities.Constants;
import utilities.Cooldown;

public abstract class Scene {	
	protected boolean pausable, winTransition, lostLifeOrLostTransition, outOfTimeTransition;
	protected ArrayList<Button> buttons = new ArrayList<Button>();
	protected ArrayList<Cooldown> cooldowns = new ArrayList<Cooldown>();
	
	private boolean pause = false;
	private Cooldown keyCooldown = new Cooldown(0.3);
	private PauseButton pauseButton;
	
	public Scene(boolean pausable) { this.pausable = pausable; }
	
	public void setup() {
		for (Button button : buttons) { button.setup(); }
		if (pausable) { pauseButton = new PauseButton(Constants.GAME_WIDTH/2-Constants.UNITSIZE/2, 10, Constants.UNITSIZE, Constants.UNITSIZE, Textures.pauseButtonFrames); }
		else { pauseButton = null; }
	}
	
	public void run() {
		while (!Display.isCloseRequested()) {	// will exit if the user pressed the x exit button on the screen (not the quit button in the game)
			keyCooldown.update();
			if (pausable && Keyboard.isKeyDown(Keyboard.KEY_P) && keyCooldown.isCooldownCompleted()) { 
				togglePause(); 
				keyCooldown.reset();
			}
			if (!pause) {
	        	update();
	        	render();
			} else {
				for (Cooldown cd : cooldowns) { cd.pauseUpdate(); }
			}
			if (pausable) {
				pauseButton.pauseButtonUpdate();
				pauseButton.pauseButtonRender();
			}
			Display.update();
            Display.sync(Constants.SCREENFPS);
        }
		
        Display.destroy();
        AL.destroy();
        System.exit(0);
	}
	
	protected abstract void update();
	protected abstract void render();
	public abstract void clear();
	
	// getters/setters
	public boolean isPaused() { return pause; }
	public void togglePause() { 
		pause = !pause; 
		if (pause) { for (Cooldown cd : cooldowns) { cd.pause(); } }
	}
	public boolean isWinTransition() { return winTransition; }
	public boolean isLostLifeOrLostTransition() { return lostLifeOrLostTransition; }
	public boolean isOutOfTimeTransition() { return outOfTimeTransition; }
}
