package managers;

public class GameManager {
	// Using scenes and levels interchangeable
	/*
	 * Scene 0 -> Main Menu
	 * Scene 1 -> Story Info Scene
	 * Scene 1 to numOfLevels -> Level(s)
	 * Scene numLevels + 2 -> Win Screen (also display a bit of story)
	*/
	private static LevelManager LM = new LevelManager();

	public static void main(String[] args) {
		RunScene(0);	// eventually, we will want to start at the main menu - scene 0
	}
	
	public static void RunScene(int scene) {
		LM.playScene(scene);
	}
}
