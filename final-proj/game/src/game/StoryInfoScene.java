package game;

import managers.GameManager;
import utilities.Constants;

public class StoryInfoScene extends Scene {
	private int numOfScenes = Constants.NUMOFSTORYSCREENS, currScene = 0;
	private double screenTime = 3, deltaTime = 1000/(1.0/screenTime), currTime, flipTime;	
	
	public StoryInfoScene(boolean pausable) { super(pausable); }
	
	public void setup() {
		currTime = System.currentTimeMillis();
		flipTime = System.currentTimeMillis();
	}
	
	public void run() { 
		super.run(); 
	}

	protected void update() {
		currTime = System.currentTimeMillis();
		
		if (currTime - flipTime >= deltaTime) { 
			if (currScene < numOfScenes-1) {
				currScene++;
				flipTime = currTime;
			} else {
				GameManager.RunScene(2);
			}
		} 
	}

	protected void render() {
		Textures.render(Textures.storyScreens[currScene]);
	}
	
	protected void remove() {  }
}
