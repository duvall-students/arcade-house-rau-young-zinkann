package gameObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerShipLives extends GameObject {

	private final static String SHIP_IMAGE = "resources/galagaship.gif";
	private static final double SHIP_SIZE = 40;

	//creates a playership iamge for lives
	public PlayerShipLives(int x, int y) throws FileNotFoundException {
		super("resources/galagaship.gif",SHIP_SIZE,SHIP_SIZE, new Point2D(x,y));

	}
	//lose a life
	public void liveLost(Group root) {
		root.getChildren().remove(myView);
	}
}
