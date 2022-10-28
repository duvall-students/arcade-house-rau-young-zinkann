package gameObjects;
import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class BadGuy extends GameObject  {
	
	private int badGuyHealth;
	private Point2D myVelocity;
	private ImageView myBadGuy;
	
	//public ArrayList<ArrayList<BadGuy>> myBadGuys= new ArrayList<ArrayList<BadGuy>>();
	
	public BadGuy(String imagePath, double speed, double width, double height, int health, Point2D pos) throws FileNotFoundException {
		super(imagePath, width, height, pos);
		myBadGuy = super.myView;
		badGuyHealth = health;
		myVelocity = new Point2D(speed, speed);
	}

	@Override
	void move(double elapsedTime) {
		myBadGuy.setY(myBadGuy.getY() + myVelocity.getY() * elapsedTime);
	}

	public int getHealth() {
		return badGuyHealth;
	}
	
	
	
	public void breakerDied(Group root) {
		root.getChildren().remove(myBadGuy);
	}
	
	public void removeHealth() {
		badGuyHealth -= 1;
	}

	@Override
	void addGameObjectToGroup(Group root) {
		// TODO Auto-generated method stub
		
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
