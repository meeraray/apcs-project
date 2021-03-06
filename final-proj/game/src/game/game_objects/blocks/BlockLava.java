package game.game_objects.blocks;

import org.newdawn.slick.opengl.Texture;

import managers.Textures;
import utilities.Animator;
import utilities.Constants;

public class BlockLava extends Block {
	private Animator animator;
	private Texture[] lavaFrames = Textures.lava;
	
	private boolean animate, reverse;
	
	public BlockLava(int x, int y) {
		super(x, y);
		animator = new Animator(Constants.LAVAANIMATIONFPS, lavaFrames);
		animate = true;
		reverse = true;
	}
	
	public void update() {
		animator.update();
	}
	
	public void render() {
		Textures.render(animator.animFrame(animate, reverse), x, y, width, height);
	}
}
