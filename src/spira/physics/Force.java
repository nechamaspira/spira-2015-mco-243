package spira.physics;

public class Force {

	double x;
	double y;
	
	public Force(double x, double y){
		this.x = x;
		this.y = y;
	
	}
	
	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void add(Force force){
		this.x += force.x;
		this.y += force.y;

	}
}
