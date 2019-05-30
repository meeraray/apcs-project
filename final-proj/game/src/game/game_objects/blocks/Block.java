package game.game_objects.blocks;

import game.Textures;
import game.game_objects.VisibleObject;

public class Block extends VisibleObject {
	
	public void render() {
		Textures.render(Textures.hatsune, x, y, width, height);
	}
	
	public Block(int x, int y) {
		super(x, y);
		this.width = 64;
		this.height = 64;
	}
	
	public Block() {
		this(0, 0);
	}
}