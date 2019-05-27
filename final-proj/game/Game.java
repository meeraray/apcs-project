package game;

import game.game_objects.Block;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Game {
	
	public static int WIDTH = 1200;
	public static int HEIGHT = 600;
	
	public static void main(String[] args) {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("2D Craft");
            Display.create();
        } catch (LWJGLException e) {
            System.err.println("Display wasn't initialized correctly.");
            System.exit(1);
        }
        
        Textures.initGL(WIDTH, HEIGHT);
        Textures.init(); 
        
//        Textures.render(Textures.hatsune);
        
        Block b = new Block(128, 256);
        Block b2 = new Block(128, 256);
        b2.x = WIDTH / 2;
        b2.y = HEIGHT / 2;
        while (!Display.isCloseRequested()) {
        	Textures.render(Textures.sky);
        	if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				b.x++;
			}
        	if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				b.x--;
			}
        	if(Keyboard.isKeyDown(Keyboard.KEY_S)){
        		b.y++;
        	}
        	if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
        		b.y--;
        	}
        	b.update();
        	b2.update();
        	if(b.isColliding(b2)) {
        		System.out.println("colliding");
        	}
            Display.update();
            Display.sync(100);
        }
 
        Display.destroy();
        System.exit(0);
	}
}
