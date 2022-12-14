package gameObjects;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Projectile extends GameObject {

	private final static String PROJECTILE_IMAGE = "resources/galagamissile.png";;
	public final int MOVE_SPEED = 50;
	private ImageView myProjectile;
	private Point2D myVelocity;

	public Projectile(String projectileImage, double width, double height, Point2D pos) throws FileNotFoundException {
		super(projectileImage, width, height,  pos);
		myProjectile = super.myView;
		myVelocity = new Point2D(-MOVE_SPEED, -MOVE_SPEED);
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
		root.getChildren().add(myProjectile);
	}

	public static Image setImage() {
		Image image = null;
		try {
			image = new Image(new FileInputStream(PROJECTILE_IMAGE));
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found");
		}
		return image;
	}
	
	public static String getImageURL(){
		return "resources/galagamissile.png";
	}
	
	public void removeProjectile(Group root) {
		root.getChildren().remove(myProjectile);
	}

}