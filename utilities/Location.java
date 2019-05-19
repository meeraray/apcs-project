public class Location {
	private double x;
	private double y;
	private double yVelocity;
	
	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getYVelocity() {
		return yVelocity;
	}
	
	public void setYVelocity(double yVel) {
		this.yVelocity = yVel;
	}
}