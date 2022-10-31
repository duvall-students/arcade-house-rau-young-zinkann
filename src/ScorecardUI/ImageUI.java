package ScorecardUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import gameObjects.PlayerShipLives;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageUI{
	
	public final int STARTING_X_VALUE = 0;
	public final int STARTING_Y_VALUE = 20;
	public final int X_SPACE_VALUE = 40;
	public Point2D location;


	public ArrayList<PlayerShipLives> myLives = new ArrayList<PlayerShipLives>();

	public ImageUI(Group root, int lives) throws FileNotFoundException{
		int x = STARTING_X_VALUE;
		int y = STARTING_Y_VALUE;
		for(int i = 0; i < lives; i++) {
			PlayerShipLives myLife = new PlayerShipLives(x,y);
			root.getChildren().add(myLife.getView());
			
			myLives.add(myLife);
			x += X_SPACE_VALUE;
		}
		

		
	}


	public void Update(Group root, int lives) {
		PlayerShipLives myLife = myLives.get(lives);
		myLife.liveLost(root);
		
		
	}

}
