package nature1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

public class PlayGround extends PApplet{
	public Ball ball =  new Ball();
	public List<Ball> balls = new ArrayList<Ball>();
	Random rand = new Random();
	public void settings() {
		size(1300,1300);
	}
	public void setup() {
		
		balls.add(new Ball());
		balls.add(new Ball());
		balls.add(new Ball());
		balls.add(new Ball(20,new PVector(500,500),new PVector(0,0)));

	}
    static public void main(String args[]) {
        PApplet.main(new String[] { "nature1.PlayGround" });
     }
    /*
     * the given ball object b attracts all other balls
     */
    public void addGravity(Ball b) {
    	for(Ball b1:balls) {
    		if(b != b1) {
	    		PVector force = b.attract(b1);
	    		b1.addForce(force);
	    		b1.update();
    		}
    	}
    }
	public void draw() {
		
		background(255);
		line(23,90,10,3);
		for(Ball b:balls) {
			addGravity(b);
			b.bounceBack(1300,1300);
			stroke(15);
			fill(123,12,0);
			circle(b.getPosition().x, b.getPosition().y, b.getMass());
		}
		
	}

}
