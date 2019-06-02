package managers;

import game.*;

public class LevelManager {
	private final Scene[] scenes = { new MainMenuScene(false), new StoryInfoScene(false), new ParkourLevel(true), new WinScene(false), new LoseScene(false) };
	
	public LevelManager() { /* scenes[0].setup(); */ }
	
	public void playScene(int scene) {
		scenes[scene].setup();
		scenes[scene].run();
	}
}