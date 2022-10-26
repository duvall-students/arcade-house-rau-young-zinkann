package gameObjects;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Projectile extends GameObject {
	
	private final int WIDTH = 50;
	private final int HEIGHT = 25;
	public final int MOVE_SPEED = 10;
	private Rectangle myProjectile;
	private Point2D myVelocity;
	
	public Projectile(Point2D pos) {
		super(pos);
		myProjectile = new Rectangle();
		myProjectile.setWidth(WIDTH);
		myProjectile.setHeight(HEIGHT);
		myProjectile.setX(pos.getX());
		myProjectile.setY(pos.getY());
		myVelocity = new Point2D(MOVE_SPEED, MOVE_SPEED);
	}
	

	@Override
	void move(double elapsedTime) {
		myProjectile.setY(myProjectile.getY() + myVelocity.getY() * elapsedTime);
		
	}

	@Override
	public Node getView() {
		return myProjectile;
	}


	@Override
	void addGameObjectToGroup(Group root) {
		// TODO Auto-generated method stub
		
	}

}
