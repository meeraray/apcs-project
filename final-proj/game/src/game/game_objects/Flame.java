package game.game_objects;

import managers.Textures;
import utilities.Animator;
import utilities.Constants;

public class Flame extends VisibleObject {

	private Animator animator = new Animator(Constants.PLAYERANIMATIONFPS);
	private boolean animate, reverseAnim;
	
	public Flame(int x, int y) {
		this.x = x;
		this.y = y;
		width = Constants.UNITSIZE * 2;
		height = Constants.UNITSIZE * 4;
		animate = true;
		reverseAnim = false;
		
		animator.setFrames(Textures.flame);
	}
	
	public void update() {
		animator.update();
	}

	public void render() {
		Textures.render(animator.animFrame(animate, reverseAnim), x, y, width, height);
	}
}
