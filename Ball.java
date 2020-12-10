package nature1;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;
import java.util.Random;

public class Ball {
	private int mass;
	private PVector position;
	private PVector speed;
	Random rand = new Random();
	public Ball() {
		System.out.println("Test");
		this.mass = rand.nextInt(50);
		this.position = new PVector(rand.nextInt(800),rand.nextInt(800));
		this.speed = new PVector(rand.nextInt(1),rand.nextInt(2));
	}
	public Ball(int mass, PVector position, PVector speed) {
		this.mass = mass;
		this.speed = speed;
		this.position = position;
	}
	//This method adds a force to the object.
	public void addForce(PVector force) {
		PVector accelration = force.div(mass);
		speed = speed.add(accelration);
		accelration.mult(0);
	}	
	public void setSpeed(PVector speed) {
		this.speed = speed;
	}
	/*
	 * takes a ball object and returns a gravity force which attracst the given object
	 */
	public PVector attract(Ball b1) {
		double g_constant = 0.1;
		double distance = PVector.sub(this.position, b1.getPosition()).mag();
		if(distance >= 20) {
			distance = 20;
		}
		else if(distance <= 5) {
			distance = 5;
		}
		PVector direction = PVector.sub(this.position, b1.getPosition()).normalize();
		
		double m1 = this.mass;
		double m2 = b1.getMass();
		double gravity = m1*m2*g_constant/(distance*distance);
		
		return direction.mult((float) gravity);
	}
	public PVector getSpeed() {
		return this.speed;
	}
	public void bounceBack(int x, int y) {
		if(this.getPosition().x <= 0 | this.getPosition().x >= x ) {
			
			this.speed.x *=-1;
		}
		else if(this.getPosition().y <= 0 | this.getPosition().y >= y) {
			this.speed.y *=-1;
		}
		
	}
	public PVector getPosition() {
		return this.position;
	}
	public void update() {
		position.add(speed);
	}
	public int getMass() {
		return this.mass;
	}

}
