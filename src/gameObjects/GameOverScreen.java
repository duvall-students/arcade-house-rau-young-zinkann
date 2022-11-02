package gameObjects;

import java.awt.Color;
import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class GameOverScreen{
	
	public static final String GAME_OVER_TEXT = "Game Over";
	public static final String WON_GAME_TEXT = "You Win";
			
	private  Rectangle gameScreen;
	
	private Text myText;
	private HashMap<Integer, String> textMap = new HashMap<Integer, String>();
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 700;
	
	
	public GameOverScreen(int textChoice) {
		populateMap();
		gameScreen = new Rectangle(SCREEN_WIDTH, SCREEN_HEIGHT, javafx.scene.paint.Color.WHITE);	
		myText = new Text(SCREEN_WIDTH/3, SCREEN_HEIGHT/2, textMap.get(textChoice));
		myText.setFont(Font.font("verdana", FontWeight.BOLD, 50));
	}


	public void addToScreen(Group root) {
		root.getChildren().add(getScreen());
		root.getChildren().add(myText);
		
	}
	
	public void populateMap() {
		textMap.put(1, GAME_OVER_TEXT);
		textMap.put(2, WON_GAME_TEXT);
	}
	
	public Rectangle getScreen() {
		return gameScreen;
	}



}
