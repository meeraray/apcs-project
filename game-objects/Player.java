public class Player {
	private Location loc;
	private int health; 
	private Tool tool;
	public int DAMAGE = 2;
	public double VELOCITY = 5;
	
	public void takeDamage(int damage) {
		health -= damage;
		if(health <= 0) {
			die();
		}
	}
	
	public void doDamage(Block block) {
		block.takeDamage(DAMAGE);
	}
	
	public void doDamage(Enemy enemy) {
		enemy.takeDamage(DAMAGE);
	}
	
	public void walk(double xChange) {
		this.loc.setLocation(loc.getX() + xChange, loc.getY());
	}
	
	public void jump() {
		this.loc.setYVelocity(VELOCITY);
	}
	
	public void spawn(Location loc, String filepath) {
		
	}
	
	public Player(Location loc) {
		this.loc = loc;
		this.health = 10;
		this.tool = null;
	}
	
	private void die() {
		/*put player at the beginning, call level manager to reset everything*/
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	
	public Tool getTool() {
		return tool;
	}
}