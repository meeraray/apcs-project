/* package utilities;
import utilities.Singleton; */

public class GameManager {
	LevelManager LM = new LevelManager();

	public GameManager(int width, int height) {
		// create screen
	}

	public void startGame() {
		System.out.println("Starting the 2D Minecraft level game!");
		// Began the game
	}

	public static void main(String[] args) {
		final int WIDTH = 800, HEIGHT = 800;

		GameManager GM = new GameManager(WIDTH, HEIGHT);
		GM.startGame();
	}
}