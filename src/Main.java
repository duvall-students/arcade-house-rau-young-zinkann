import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 700;
	public static final Paint SCREEN_COLOR = Color.BLACK;
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	
	private Level currentLevel = new Level(4, 6, 1000, 2);
	private Group myRoot = new Group();
	
	private ArrayList<ArrayList<BadGuy>> currentBadGuys;
	
	@Override
	public void start(Stage stage) {
		
		stage.setScene(CreateScene(SCREEN_WIDTH,SCREEN_HEIGHT,SCREEN_COLOR));
		stage.setTitle("Arcade");
		stage.show();
		
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	

	
	private Scene CreateScene(int sceneWidth, int sceneHeight, Paint background) {
		currentLevel.addEnemies(myRoot);
		Scene myScene = new Scene(myRoot, sceneWidth, sceneHeight, background);
		return myScene;
				
	}
	
	private void step (double elapsedTime, Stage stage) {
		currentBadGuys = currentLevel.getBadGuys();
		for(int i = 0; i < currentBadGuys.size(); i++) {
			for(int j = 0; j < currentBadGuys.get(i).size(); j++) {
				BadGuy currentBadGuy = currentBadGuys.get(i).get(j);
				currentBadGuy.move(elapsedTime);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
