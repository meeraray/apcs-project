package game;

import managers.Sounds;
import managers.Textures;
import ui.Button;
import utilities.AudioType;
import utilities.Constants;

public class ControlsScene extends Scene {
	private Button backButton;
	
	public ControlsScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		Sounds.stopSFX();
		
		backButton = new Button(Constants.GAME_WIDTH-Constants.UNITSIZE*4-20, Constants.GAME_HEIGHT/2-Constants.UNITSIZE*2-10, Constants.UNITSIZE*4, Constants.UNITSIZE*4, Textures.backButtonFrames, 0);
		buttons.add(backButton);
		
		super.setup();
		
		Sounds.play(Sounds.controlsScreenMusic, AudioType.MUSIC);
	}
	
	protected void update() {
		for (Button b : buttons) { b.update(); }
	}

	protected void render() {
		Textures.render(Textures.controlsScreen);
		for (Button b : buttons) { b.render(); }
	}

	public void clear() {
		buttons.clear();
	}
}
