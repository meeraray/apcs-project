package utilities;

import game.Textures;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;

public class Spritesheet {	
	public static Texture[] spliceLoad(String[] paths, String type) throws IOException {
		int numOfSprites = paths.length;
		
		Texture[] sprites = new Texture[numOfSprites];
		for (int i = 0; i < numOfSprites; i++) {
			sprites[i] = Textures.load(paths[i], type);
		}
		
		return sprites;
	}
}