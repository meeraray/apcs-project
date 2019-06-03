package game;

import game.game_objects.Entity;
import game.game_objects.EntityPlayer;
import game.game_objects.Heart;
import game.game_objects.VisibleObject;
import game.game_objects.blocks.Block;
import managers.Sounds;
import utilities.Constants;
import utilities.Cooldown;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

public abstract class Level extends Scene {
	public ArrayList<VisibleObject> imgs = new ArrayList<VisibleObject>();
	public ArrayList<Block> blocks = new ArrayList<Block>();
	public ArrayList<VisibleObject> collidables = new ArrayList<VisibleObject>();
	protected Entity player;
	protected Heart[] hearts;
	protected boolean playWinSound;
	protected Cooldown transitionTime;
	
	public Level(boolean pausable) { super(pausable);  }
	
	public void setup() {
		super.setup();
		Sounds.stopSFX();
		
		playWinSound = false;
		winTransition = false;
		lostLifeOrLostTransition = false;
		
        player = new EntityPlayer(0, 0, Constants.PLAYERANIMATIONFPS);
        hearts = new Heart[player.getLives()];
        
        for (int i = 0; i < hearts.length; i++) { hearts[i] = new Heart(Constants.GAME_WIDTH - Constants.UNITSIZE*(player.getLives() - i), 0); }
        transitionTime = new Cooldown(Constants.TRANSITIONTIME);
        
        cooldowns.add(transitionTime);
	}
	
	protected void update() {
		transitionTime.update();
		
		if (!winTransition && !lostLifeOrLostTransition && !outOfTimeTransition) { playerMoveHandling(); }
		
    	player.yVelocity += Constants.GRAVITY;
    	player.collideStop(collidables);
    	
    	player.setFalling(true);
    	for (Block block : blocks) {
    		if (player.onTopOf(block)) { player.setFalling(false); }
    	}
    	
		for (Heart heart : hearts) { heart.setActive(false); }
		for (int i = 0; i < player.getLives(); i++) { hearts[i].setActive(true); }
	}
	
	protected void playerMoveHandling() {
		if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			if(player.x + player.width < Constants.GAME_WIDTH) {
				player.xVelocity = Constants.MOVE_VELOCITY;
			}
			else {
				player.xVelocity = 0;
			}
		}
    	else if (Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
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
    	
    	if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
    		for(Block block : blocks) {
    			if(player.onTopOf(block)) {
        			player.jump();
        			break;
        		}
    		}
    	}
	}
	
	public void clear() {
		imgs.clear();
		blocks.clear();
		collidables.clear();
		player = null;
		cooldowns.clear();
	}
	
	protected abstract void winTransition();
	protected abstract void lostLifeOrLoseTransition();
}
