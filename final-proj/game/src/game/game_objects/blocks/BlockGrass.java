package game.game_objects.blocks;

import game.Textures;

public class BlockGrass extends Block {
	public BlockGrass(int x, int y) {
		super(x, y);
	}
	public void render() {
		Textures.render(Textures.grass, x, y, width, height);
	}

	public void update() {
		
	}
}
