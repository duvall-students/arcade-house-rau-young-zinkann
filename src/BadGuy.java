import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class BadGuy extends GameObject  {
	
	private final int WIDTH = 50;
	private final int HEIGHT = 25;
	
	private Rectangle myBadGuy;
	private int badGuyHealth;
	private Point2D myVelocity;
	
	public ArrayList<ArrayList<BadGuy>> myBadGuys= new ArrayList<ArrayList<BadGuy>>();
	
	public BadGuy(Rectangle badGuy, int x, int y, int health, double speed, Paint breakerColor) {
		this.myBadGuy = badGuy;
		myBadGuy.setWidth(WIDTH);
		myBadGuy.setHeight(HEIGHT);
		myBadGuy.setX(x);
		myBadGuy.setY(y);
		myBadGuy.setFill(breakerColor);
		badGuyHealth = health;
		myVelocity = new Point2D(speed, speed);
	}

	@Override
	void move(double elapsedTime) {
		myBadGuy.setY(myBadGuy.getY() + myVelocity.getY() * elapsedTime);
		
	}

	
	@Override
	Node getView() {
		return myBadGuy;
	}
	
	
	public void removeHealth() {
		badGuyHealth -= 1;
	}
	
	public boolean isCollision(Rectangle projectile) {
		if(projectile.intersects(myBadGuy.getBoundsInLocal())) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
