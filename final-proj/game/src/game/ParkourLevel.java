package game;

import game.game_objects.Block;
import game.game_objects.BlockGrass;
import game.game_objects.Entity;
import game.game_objects.VisibleObject;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class ParkourLevel {
	
	public static ArrayList<VisibleObject> imgs = new ArrayList<VisibleObject>();
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<VisibleObject> collidables = new ArrayList<VisibleObject>();
	
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
	}
	
	public static void levelOneSetup() {
		for(int i = 0; i < Constants.GAME_WIDTH; i += new Block().width) {
			BlockGrass floor = new BlockGrass(i, Game.HEIGHT - new Block().height);
			imgs.add(floor);
			blocks.add(floor);
			collidables.add(floor);
		}
		Block hats = new BlockGrass(200, Game.HEIGHT - 128);
		Block test = new BlockGrass(200, Game.HEIGHT - 400);
		imgs.add(test);
		blocks.add(test);
		collidables.add(test);
		imgs.add(hats);
		blocks.add(hats);
		collidables.add(hats);
	}
	public static void main(String[] args) {
       
		setup();
		levelOneSetup();
//        Textures.render(Textures.hatsune);
        
        Block bl = new BlockGrass(0, Constants.GAME_HEIGHT - 64);
        Entity b = new Entity(0, 0);
        while (!Display.isCloseRequested()) {
        	Textures.render(Textures.sky);
        	if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				b.xVelocity = Constants.MOVE_VELOCITY;
			}
        	else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				b.xVelocity = -1 * Constants.MOVE_VELOCITY;
			}
        	else {
        		b.xVelocity = 0;
        	}
        	
        	if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
        		System.out.println("jump");
        		for(Block block : blocks) {
        			if(b.onTopOf(block)) {
            			b.jump();
            			break;
            		}
        		}
        		
        	}
        	
//        	if(b.yVelocity > 0) {
//        		for(Block block : blocks) {
//            		if(b.isColliding(block) || b.onTopOf(block)) {
//            			System.out.println("on top of");
//            			b.falling = false;
//                		b.y = bl.y - b.height;
//                		b.yVelocity = 0;
//                		break;
//            		}
//            	}
        		//System.out.println(b.y + " " + bl.y);
//        	}
//        	if(b.onTopOf(bl)) {
//        		System.out.println("on top of");
//        		b.falling = false;
//        		b.y = bl.y - b.height;
//        		System.out.println(b.y + " " + bl.y);
//        	}
//        	else {
//        		b.falling = true;
//        	}
        	b.yVelocity += Constants.GRAVITY;
//        	Block test = blocks.get(blocks.size() - 1);
//        	System.out.println(test.y + " " + b.y);
//        	System.out.println("vel = " + b.xVelocity);
        	b.collideStop(collidables);
        	//b.backOff(blocks.get(blocks.size() - 1));
        	b.update();
        	bl.update();
        	
        	System.out.println(Mouse.getX() + " " + Mouse.getY());
        	
        	for(VisibleObject o : imgs) {
        		o.render();
        	}
        	
        	
            Display.update();
            Display.sync(100);
        }
 
        Display.destroy();
        System.exit(0);
	}
}
