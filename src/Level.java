import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Level {
	
	public final int STARTING_X_VALUE = 10;
	public final int STARTING_Y_VALUE = 0;
	public final int Y_SPACE_VALUE = 35;
	public final int X_SPACE_VALUE = 150;
	
	private int numEnemies;
	private int numRows;
	private int numEnemiesPerRow;
	private int badGuyHealth;
	private ArrayList<ArrayList<BadGuy>> myBadGuys = new ArrayList<ArrayList<BadGuy>>();
	
	public Level(int numRows, int numEnemiesPerRow, int badGuyHealth) {
		numEnemies = numRows * numEnemiesPerRow;
		this.numRows = numRows;
		this.numEnemiesPerRow = numEnemiesPerRow;
		this.badGuyHealth = badGuyHealth;
	}
	
	public void addEnemies(Group root) {
		
		int x = STARTING_X_VALUE;
		int y = STARTING_Y_VALUE;
		for(int i = 0; i < numRows; i++) {
			//reset after one row
			ArrayList<BadGuy> myBreakersRow = new ArrayList<BadGuy>();
			x = STARTING_X_VALUE;
			y += Y_SPACE_VALUE;
			//loop through each row
			for(int j = 0; j < numEnemiesPerRow; j++) {

				Rectangle myRectangle = new Rectangle();
				//create new breaker object
				BadGuy myBadGuy = new BadGuy(myRectangle, x , y, badGuyHealth, Color.BLUE);
				//add to root 
				root.getChildren().add(myBadGuy.getView());
				//add to array
				myBreakersRow.add(myBadGuy);
				//change x value
				x += X_SPACE_VALUE;
			}
			myBadGuys.add(myBreakersRow);
		}
	}
}
