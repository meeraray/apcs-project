package game.game_objects.blocks;

import game.Textures;

public class BlockPortal extends Block {
	public BlockPortal(int x, int y) {
		super(x, y);
		this.width = 64;
		this.height = 128;
	}
	public void render() {
		Textures.render(Textures.portal, x, y, width, height);
	}
}
