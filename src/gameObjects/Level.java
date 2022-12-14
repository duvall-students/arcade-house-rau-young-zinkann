package gameObjects;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Level {
	
	public final int STARTING_X_VALUE = 200;
	public final int STARTING_Y_VALUE = 0;
	public final int Y_SPACE_VALUE = 35;
	public final int X_SPACE_VALUE = 100;
	private final double BADGUY_WIDTH = 50;
	private final double BADGUY_HEIGHT = 25;
	
	private int numEnemies;
	private int numRows;
	private int numEnemiesPerRow;
	private int badGuyHealth;
	private ArrayList<ArrayList<BadGuy>> myBadGuys = new ArrayList<ArrayList<BadGuy>>();
	private double badGuySpeed;
	
	
	private HashMap<Integer,String> imageMap = new HashMap<Integer, String>();
	private String imagePath1 = "resources/badGuy.gif";
	private String imagePath2 = "resources/galageEnemy2.png";
	private String imagePath3 = "resources/galagaEnemy3.gif";
	public int numLives;
	private int imageNum;
	
	public Level(int imageNum, int numRows, int numEnemiesPerRow, int badGuyHealth, double badGuySpeed, int numLives) {
		populateImageMap();
		numEnemies = numRows * numEnemiesPerRow;
		this.imageNum = imageNum;
		this.numRows = numRows;
		this.numEnemiesPerRow = numEnemiesPerRow;
		this.badGuyHealth = badGuyHealth;
		this.badGuySpeed = badGuySpeed;
		this.numLives = numLives;
	}
	
	public void addEnemies(Group root) throws FileNotFoundException {
		
		int x = STARTING_X_VALUE;
		int y = STARTING_Y_VALUE;
		for(int i = 0; i < numRows; i++) {
			//reset after one row
			ArrayList<BadGuy> myBadGuysRow = new ArrayList<BadGuy>();
			x = STARTING_X_VALUE;
			y += Y_SPACE_VALUE;
			//loop through each row
			for(int j = 0; j < numEnemiesPerRow; j++) {
				//create new bad guy
				
				Point2D currentPoint = new Point2D(x,y);
				BadGuy myBadGuy = new BadGuy(imageMap.get(imageNum), 10, BADGUY_WIDTH, BADGUY_HEIGHT, badGuyHealth, currentPoint);
				//add to root 
				root.getChildren().add(myBadGuy.getView());
				//add to array
				myBadGuysRow.add(myBadGuy);
				//change x value
				x += X_SPACE_VALUE;
			}
			myBadGuys.add(myBadGuysRow);
		}
	}
	
	//trevor
	public void populateImageMap() {
		imageMap.put(1, imagePath1);
		imageMap.put(2, imagePath2);
		imageMap.put(3, imagePath3);
		
	}
	
	
	public ArrayList getBadGuys() {
		return myBadGuys;
	}
	
	
	
	public int getNumEnemies() {
		return numEnemies;
	}

	public void setNumEnemies(int numEnemies) {
		this.numEnemies = numEnemies;
	}

	public void removeEnemy() {
		numEnemies -= 1;
	}
	public void removeLife() {
		numLives -= 1;
	}
	
	//trevor
	public boolean isLevelBeat() {
		if(numEnemies == 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//trevor
	public boolean isGameOver() {
		if(numLives == 0) {
			return true;
		}
		else return false;
	}
}
