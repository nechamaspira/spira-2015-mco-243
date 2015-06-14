package spira.physics;

import java.awt.geom.Point2D;

public class Body {

	private Force force;
	private Point2D.Double position;
	

	public void update(){
		position.x += force.x;
		position.y += force.y;
	}

	public Force getForce() {
		return force;
	}

	public void setForce(Force force) {
		this.force = force;
	}

	public Point2D.Double getPosition() {
		return position;
	}

	public void setPosition(Point2D.Double position) {
		this.position = position;
	}
}
