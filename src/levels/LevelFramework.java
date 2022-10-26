package levels;

import java.io.FileReader;
import java.util.ArrayList;
import gameObjects.PlayerShip;
import gameObjects.BadGuy;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


/**
 * This is the superclass that provides functionality to the levels
 * Any commented out lines are there to prevent errors due to the fact the other classes aren't done
 * @author Will Zinkann
 *
 */
public abstract class LevelFramework {
	
	
	protected Scene myScene;
	private Group root;
	private int score;
	private Text currentScore;
	

    
	//Returns win continue or lose
	public abstract int run();
	
	//new level with the same score
	public abstract void newLevel(int score);
	
	public void runGame() {

	}
    
	
	
    protected void setupGame(int width, int height, Paint background, /*enemies,*/ PlayerShip player){
		root = new Group();
		
		
		// int highScore = // read from file
		//Text highScoreText = new Text(width/2,height-highScoreOffset,"High Score: " + highScore);
//		currentScore = new Text(width/2,height-scoreOffset,"Current Score: " + score);
//		root.getChildren().add(highScoreText);
//		root.getChildren().add(currentScore);
				
		// Everything but player
		for (shapes d : shapes) {
			root.getChildren().add(d.getSelf());
		}

		myScene = new Scene(root,width,height);
		myScene.setFill(background);

	}
	
    public Scene getScene() {
		return myScene;
	}
    
    public int getScore() {
		return score;
	}
	

	public boolean checkWin() {
		return false;
	}

	
	protected void setScore(int score) {
		this.score = score;
	}
	
	public void increaseScore() {
		score++;
	}
	
	public void updateScore() {
		currentScore.setText("Current Score: " + score);
	}
	
	// Set up where the enemies are 
	public BadGuys[] initilizeEnemies(int enemyRows, int enemyColumns) {
		int badGuySize = (int) ((myScene.getWidth()/enemyColumns));
		BadGuys[] myBadGuys = new BadGuys[enemyRows * enemyColumns];
		for(int row = 0; row < enemyRows; row++) {
			for (int col = 0; col < enemyColumns; col ++) {
				int x = col * enemySize + col;
				int y = row * enemySize + row;
				BadGuy enemy = new BadGuy(x,y,enemySize,enemySize);
				myBadGuys[row*enemyColumns + col] = enemy;				
			}
		}
		return myBadGuys;
	}
	
	
}
