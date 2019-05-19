public abstract class Enemy {
	protected abstract int health;
	protected abstract int damage;
	public Location loc;
	
	public void doDamage(Player p) {
		p.takeDamage(damage);
	}
	
	public void takeDamage(int damage) {
		health -= damage;
		if(health <= 0) {
			die();
		}
	}
	
	private void die() {
		/* animate and disappear*/
	}
	
	public void move(double xChange, double yChange) {
		this.loc.setLocation(loc.getX() + xChange, loc.getY() + YChange);
	}
	
	public void spawn(String filepath) {
		/* to be implemented */
	}
	
	public Enemy(Location loc) {
		this.loc = loc;
		spawn();
	}
}