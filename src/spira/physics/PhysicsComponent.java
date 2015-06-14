package spira.physics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class PhysicsComponent extends JComponent {

	private PhysicsFrame frame;

	public PhysicsComponent(PhysicsFrame frame) {
		this.frame = frame;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.translate(frame.getHeight() / 2, frame.getWidth() / 2);
		g.drawRect((int) frame.getPosition().x, (int) -frame.getPosition().y, 5,
				5);

	}
}
