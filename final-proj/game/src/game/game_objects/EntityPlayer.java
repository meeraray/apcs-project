package game.game_objects;

import java.util.ArrayList;

import game.Textures;

public class EntityPlayer extends Entity {

	public EntityPlayer(int x, int y) {
		super(x, y);
		this.width = 64;
		this.height = 128;
	}
	
	public void render() {
		Textures.render(Textures.player, x, y, 64, 128);
	}

	public void collideStop(ArrayList<VisibleObject> collidables) {
		this.x += 13;
		this.width -= 26;
		this.height -= 4;
		super.collideStop(collidables);
		this.x -= 13;
		this.width += 26;
		this.height += 4;
		
	}
}
