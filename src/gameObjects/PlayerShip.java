/**
 * This class creates the ship controlled by the player and is reponsible for spawning projectiles from the ship
 * 
 * @author Chris YOung
 * 
 **/

package gameObjects;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class PlayerShip extends GameObject {

	private final static String SHIP_IMAGE = "resources/galagaship.gif";
	private final int SHIP_SPEED = 20;
	private final int SHIP_SIZE = 75;
	private final int SCREEN_BUFFER = 75;
	private final int PROJECTILE_BUFFER = 5;
	private ImageView myPlayerShip;

	// array list to hold projectiles
	ArrayList<Projectile> myProjectiles = new ArrayList<Projectile>();

	public PlayerShip(Image shipImage) {
		super(shipImage);
		myPlayerShip = new ImageView(shipImage);
		myPlayerShip.setFitHeight(SHIP_SIZE);
		myPlayerShip.setFitWidth(SHIP_SIZE);
		myPlayerShip.setLayoutX(Main.SCREEN_WIDTH / 2 - (SHIP_SIZE / 2));
		myPlayerShip.setLayoutY(Main.SCREEN_HEIGHT - 100);
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

	// Handle ship movement left and right
	public void handleShipInputs(KeyCode code) {
		if (code == KeyCode.LEFT) {
			handleKeyInputLeft();
		}
		else if (code == KeyCode.RIGHT) {
			handleKeyInputRight();
		}
	}

	public void handleProjectileSpawn(KeyCode code, Group root) {
		if (code == KeyCode.SPACE) {
			// create new projectile?
			Projectile p = new Projectile(Projectile.setImage(), 
					new Point2D(myPlayerShip.getLayoutX() + (SHIP_SIZE / 2) - PROJECTILE_BUFFER, 
							myPlayerShip.getLayoutY()));
			myProjectiles.add(p);
			p.addGameObjectToGroup(root);

		}
	}

	private void handleKeyInputLeft() {
		if (myPlayerShip.getLayoutX() > 0) {
			myPlayerShip.setLayoutX(myPlayerShip.getLayoutX() - SHIP_SPEED);
		}
	}

	private void handleKeyInputRight() {
		if (myPlayerShip.getLayoutX() < (Main.SCREEN_WIDTH - SCREEN_BUFFER)) {
			myPlayerShip.setLayoutX(myPlayerShip.getLayoutX() + SHIP_SPEED);
		}
	}

	public ArrayList<Projectile> getMyProjectiles() {
		return myProjectiles;
	}

}
