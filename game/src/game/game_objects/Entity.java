package game.game_objects;

import game.Constants;
import game.Textures;

import java.util.ArrayList;

public class Entity extends VisibleObject {
	
	
	public boolean falling = true;

	public void render() {
		Textures.render(Textures.hatsune, x, y, 64, 128);
	}
	
	public void update() {
		super.update();
//		if(falling) {
//			yVelocity += Constants.GRAVITY;
//		}
//		else {
//			yVelocity = 0;
//		}
//		System.out.println("Position: " + x + " " + y + " Velocity: " + xVelocity);
	}
	
	public boolean touchingY(VisibleObject ob) {
		return (this.y > ob.y && this.y < ob.y + ob.height) || (ob.y >= this.y && ob.y < this.y + this.height);
	}
	
	public boolean touchingX(VisibleObject ob) {
		return (this.x > ob.x && this.x < ob.x + ob.width) || (ob.x >= this.x && ob.x < this.x + this.width);
	}
	
	public void collideStop(ArrayList<VisibleObject> collidables) {
		for(VisibleObject ob : collidables) {
			if(xVelocity > 0 && this.touchingY(ob)) {
				int rightDiff = this.x + this.width - ob.x;
				if(rightDiff >= 0 && rightDiff < 5) {
					xVelocity = 0;
					if(this.x + this.width > ob.x) {
						this.x = ob.x - this.width;
					}
				}
			}
			if(xVelocity < 0 && this.touchingY(ob)) {
				int leftDiff = ob.x + ob.width - this.x;
				if(leftDiff >= 0 && leftDiff < 5) {
					xVelocity = 0;
					if(leftDiff > 0) {
						this.x = ob.x + ob.width;
					}
				}
			}
			if(yVelocity > 0 && this.touchingX(ob)) {
				int bottomDif = this.y + this.height - ob.y;
				if(bottomDif >= 0 && bottomDif < ob.height) {
					System.out.println("there");
					yVelocity = 0;
					if(bottomDif > 0) {
						this.y = ob.y - this.height;
					}
				}
			}
			if(yVelocity < 0 && this.touchingX(ob)) {
				int topDif = ob.y + ob.height - this.y;
				if(topDif >= 0 && topDif < 5) {
					yVelocity = 0;
					if(topDif > 0) {
						this.y = ob.y + ob.height;
					}
				}
			}
		}
	}
	
	public void jump() {
		this.falling = true;
		this.yVelocity = Constants.JUMP_VELOCITY;
	}
	
	public Entity(int x, int y) {
		super(x, y);
		this.width = 64;
		this.height = 128;
	}
	
	public boolean moveBy(int x, int y, ArrayList<VisibleObject> collidable) {
		return true;
	}
}
