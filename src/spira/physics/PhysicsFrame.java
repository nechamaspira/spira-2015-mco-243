package spira.physics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.JFrame;

public class PhysicsFrame extends JFrame {

	private Body body;

	private Force force;
	private Double position;
	private Force gravity;

	private Container contentPane;

	public PhysicsFrame() {
		setSize(400, 400);
		setTitle("PhysicsFrame :)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		body = new Body();
		force = new Force(0, 0);
		position = new Point2D.Double(10, 10);
		body.setPosition(position);
		body.setForce(force);
		gravity = new Force(0, -9.8);

		contentPane.add(new PhysicsComponent(this));

		Thread t = new Thread() {

			public void run() {
				while (true) {
					//position.y<=contentPane.getHeight()
					force.add(gravity);
					body.setForce(force);
					body.update();
					repaint();
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t.start();
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Force getForce() {
		return force;
	}

	public void setForce(Force force) {
		this.force = force;
	}

	public Double getPosition() {
		return position;
	}

	public void setPosition(Double position) {
		this.position = position;
	}

	public Force getGravity() {
		return gravity;
	}

	public void setGravity(Force gravity) {
		this.gravity = gravity;
	}

	public static void main(String[] args) {
		PhysicsFrame smile = new PhysicsFrame();
		smile.setVisible(true);

	}
}