package game.game_objects;

import java.awt.Rectangle;

public abstract class VisibleObject {
	
	public int x;
	public int y;
	public int xVelocity;
	public double yVelocity;
	
	public int width;
	public int height;
	
	public abstract void update();
	public abstract void render();
	
	public boolean isColliding(VisibleObject other) {
		Rectangle rect1 = new Rectangle(this.x, this.y, this.width, this.height);
		Rectangle rect2 = new Rectangle(other.x, other.y, other.width, other.height);
//		System.out.println("B1: " + this.x + " " + this.y + " " + this.width + " " + this.height);
//		System.out.println("B2: " + other.x + " " + other.y + " " + other.width + " " + other.height);
		return rect1.intersects(rect2);
	}
	
	public boolean backOff(VisibleObject other) {
		if(this.isColliding(other)) {
			if(this.xVelocity > 0) {
				this.x = other.x - this.width;
			}
			else if(this.xVelocity < 0){
				this.x = other.x + other.width;
			}
			if(this.yVelocity > 0) {
				this.y = other.y - this.height;
			}
			else if(this.yVelocity < 0){
				this.y = other.y + other.height;
			}
		}
		return true;
	}
	
	public boolean onTopOf(VisibleObject other) {
		if((this.x >= other.x && this.x <= other.x + other.width) || (this.x < other.x && other.x < this.x + this.width)) {
			int diff = (this.y + this.height) - other.y;
			if(diff >= 0 && diff < 10) {
				return true;
			}
		}
		return false;
	}
	
	public VisibleObject(int x, int y) {
		this.x = x;
		this.y = y;
		xVelocity = 0;
		yVelocity = 0;
	}
	
	public VisibleObject() {
		this(0, 0);
	}
}
