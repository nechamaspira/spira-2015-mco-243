package spira.physics;

import java.awt.geom.Point2D;

public class Main {

	public static void main(String[] args) {


		Body body = new Body();
		Force force = new Force(0,0);
		Point2D.Double position= new Point2D.Double(0,0);
		body.setPosition(position);
		body.setForce(force);
		Force gravity = new Force(0,-9.8);
		
		force.add(gravity);
		body.setForce(force);
		body.update();
		System.out.println(position.x +", " +position.y);
		
		force.add(gravity);
		body.setForce(force);
		body.update();
		System.out.println(position.x +", " +position.y);
		
		force.add(gravity);
		body.setForce(force);
		body.update();
		System.out.println(position.x +", " +position.y);
		
	}

}
