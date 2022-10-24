package gameObjects;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerShip extends GameObject {

	private final static String SHIP_IMAGE = "resources/galagaship.gif";
	private final int SHIP_SIZE = 75;
	private ImageView myPlayerShip;
	
	
	public PlayerShip(Image shipImage) {
		myPlayerShip = new ImageView(shipImage);
		myPlayerShip.setFitHeight(SHIP_SIZE);
		myPlayerShip.setFitWidth(SHIP_SIZE);
		myPlayerShip.setX(Main.SCREEN_WIDTH / 2 - (SHIP_SIZE / 2));
		myPlayerShip.setY(Main.SCREEN_HEIGHT / 2);
	}

	@Override
	public Node getView() {
		// TODO Auto-generated method stub
		return myPlayerShip;
	}

	public void addGameObjectToGroup(Group root) {
		// TODO Auto-generated method stub
		root.getChildren().add(myPlayerShip);
	}
	
	public static Image setImage() {
		Image image = null;
		try {
			image = new Image(new FileInputStream(SHIP_IMAGE));
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found");
		}
		return image;
	}

	@Override
	void move(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}
