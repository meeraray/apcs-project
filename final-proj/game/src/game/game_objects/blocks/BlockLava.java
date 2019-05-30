package game.game_objects.blocks;

import game.Textures;

public class BlockLava extends Block {
	public BlockLava(int x, int y) {
		super(x, y);
	}
	public void render() {
		Textures.render(Textures.lava, x, y, width, height);
	}
}
