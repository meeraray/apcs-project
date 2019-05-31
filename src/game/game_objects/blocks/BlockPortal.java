package game.game_objects.blocks;

import game.Textures;
import utilities.Constants;

public class BlockPortal extends Block {
	public BlockPortal(int x, int y) {
		super(x, y);
		this.width = Constants.UNITSIZE;
		this.height = Constants.UNITSIZE * 2;
	}
	public void render() {
		Textures.render(Textures.portal, x, y, width, height);
	}
}
