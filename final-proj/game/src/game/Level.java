package game;

import game.game_objects.EntityPlayer;
import game.game_objects.VisibleObject;
import game.game_objects.blocks.Block;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Level {
	public static ArrayList<VisibleObject> imgs = new ArrayList<VisibleObject>();
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<VisibleObject> collidables = new ArrayList<VisibleObject>();
	public static EntityPlayer player = new EntityPlayer(0, 0);
	public static boolean gameOver = false;
	
	public static void setup() {
		try {
            Display.setDisplayMode(new DisplayMode(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
            Display.setTitle("2D Craft"); 
            Display.create();
        } catch (LWJGLException e) {
            System.err.println("Display wasn't initialized correctly.");
            System.exit(1);
        }
        
        Textures.initGL(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        Textures.init();
        
//        imgs.add(player);
	}
	
	
	public static void playerMoveHandling() {
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			if(player.x + player.width < Constants.GAME_WIDTH) {
				player.xVelocity = Constants.MOVE_VELOCITY;
			}
			else {
				player.xVelocity = 0;
			}
		}
    	else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
    		if(player.x > 0) {
    			player.xVelocity = -1 * Constants.MOVE_VELOCITY;
    		}
    		else {
    			player.xVelocity = 0;
    		}
		}
    	else {
    		player.xVelocity = 0;
    	}
    	
    	if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
    		System.out.println("jump");
    		for(Block block : blocks) {
    			if(player.onTopOf(block)) {
        			player.jump();
        			break;
        		}
    		}
    		
    	}
	}
}
