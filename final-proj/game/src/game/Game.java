package game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

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
        
        int x = 0;
        while (!Display.isCloseRequested()) {
        	Textures.render(Textures.sky);
        	if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				x++;
			}
        	if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				x--;
			}
        	Textures.render(Textures.bee, x, 0);
            Display.update();
            Display.sync(100);
        }
 
        Display.destroy();
        System.exit(0);
	}
}
