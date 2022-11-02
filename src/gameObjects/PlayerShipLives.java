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
	private final int SHIP_SIZE = 75;



	public PlayerShipLives(int x, int y) throws FileNotFoundException {
		super("resources/galagaship.gif",40,40, new Point2D(x,y));

	}
	
	public void liveLost(Group root) {
		root.getChildren().remove(myView);
	}


	public Image setImage() {
		Image image = null;
		try {
			image = new Image(new FileInputStream(SHIP_IMAGE));
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found");
		}
		return image;
	}


}
