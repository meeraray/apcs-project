package game.game_objects;

public class Projectile {
	private double xDirection;
	private double yDirection;
	
	public Projectile(double xDirection, double yDirection) {
		this.setxDirection(xDirection);
		this.setyDirection(yDirection);
	}

	// getters/setters
	public double getxDirection() { return xDirection; }
	public void setxDirection(double xDirection) { this.xDirection = xDirection; }
	public double getyDirection() { return yDirection; }
	public void setyDirection(double yDirection) { this.yDirection = yDirection; }	
}