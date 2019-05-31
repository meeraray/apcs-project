package managers;

import game.*;

public class LevelManager {
	
	int scene;
	private final Level[] levels = { new ParkourLevel() };
	
	public LevelManager(int scene) {
		this.scene = scene;
	}
	
	public void playScene() {
		if (scene < 1) {
			levels[scene].run();
			// eventually, run main menu screen
		} else if (scene >= 1 && scene <= levels.length) {
			levels[scene-1].run();
		} else if (scene == levels.length + 2) {
			// run the win screen
		} else if (scene == levels.length + 3) {
			// run the lose screen
		}
	}
}