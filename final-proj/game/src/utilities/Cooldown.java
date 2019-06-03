package utilities;

public class Cooldown {
	private double startTime, previousTime, currTime, deltaTime;

	/* LWJGL does not provide a text implementation. Therefore, I made the time limit for the parkour level hidden using this class. */
	
	public Cooldown(double sec) {
		startTime = System.currentTimeMillis();
		currTime = System.currentTimeMillis();
		previousTime = currTime;
		deltaTime = 1000*sec;
	}
	
	public void update() {
		currTime += System.currentTimeMillis() - previousTime;
		previousTime = currTime;
	}
	
	public void reset() {
		startTime = currTime;
	}
	
	public boolean isCooldownCompleted() {
		return (currTime - startTime >= deltaTime);
	}
	
	// for debugging purposes
	public void printInfo() {
		System.out.println((currTime - startTime)/1000);
	}
}
