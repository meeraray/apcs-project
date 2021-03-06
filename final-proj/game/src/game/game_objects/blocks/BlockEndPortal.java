package game.game_objects.blocks;

import managers.Textures;
import utilities.Constants;

public class BlockEndPortal extends Block {
	public BlockEndPortal(int x, int y) {
		super(x, y);
		this.width = Constants.UNITSIZE;
		this.height = Constants.UNITSIZE * 2;
	}
	
	public void update() {
		
	}
	
	public void render() {
		Textures.render(Textures.endportal, x, y, width, height);
	}
}
