package utilities;

import org.newdawn.slick.opengl.Texture;

public class Animator {
	
	private double fps;
	private int animationFrame = 0;
	private double currTime, animateTime, deltaTime;
	
	private Texture[] frames;
	
	private boolean left, right;
		
	public Animator(double fps) {
		this.fps = fps;
		deltaTime = 1000/fps;
		currTime = System.currentTimeMillis();
		animateTime = System.currentTimeMillis();
		left = false;
		right = true;
	}
	
	public Animator(double fps, Texture[] frames) {
		this.fps = fps;
		this.frames = frames;
		deltaTime = 1000/fps;
		currTime = System.currentTimeMillis();
		animateTime = System.currentTimeMillis();
		left = false;
		right = true;
	}
	
	public void update() {
		currTime = System.currentTimeMillis();
	}
	
	public Texture animFrame(boolean animate, boolean reverse) {
		if (frames.length == 0 || !animate) {
			return frames[0];
		} else {
			 if (currTime - animateTime >= deltaTime) {
				 if (reverse) {
					 if (left) {
						 if (animationFrame == 0) { 
							 right = true; 
							 left = false;
						 } else { animationFrame--; }
					 } else if (right) {
						 if (animationFrame >= frames.length-1) { 
							 left = true; 
							 right = false;
						 } else { animationFrame++; }
					 }
				 } else {
					 if (animationFrame >= frames.length-1) { animationFrame = 0; }
					 else { animationFrame++; }
				 }
				 animateTime = currTime;
			 } 
		}
		return frames[animationFrame];
	}
	
	// getters/setters
	public Texture[] getCurrentFrames() { return frames; }
	public void resetFrames() { animationFrame = 0; }
	public void setFrames(Texture[] frames) { this.frames = frames; }
	public double getFPS() { return fps; }
	public void setFPS(int fps) { this.fps = fps; } 
}