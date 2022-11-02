package gameObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	public static final int NUM_LIVES = 3;


	private Level currentLevel;
	private Group myRoot;
	private ArrayList<ArrayList<BadGuy>> currentBadGuys;
	public ArrayList<Level> myLevelArray = new ArrayList<Level>();
	// ship
	public PlayerShip ship = new PlayerShip(PlayerShip.setImage());
	private Rectangle bottomBorder;
	// collection of spawned projectiles
	private int currentScore = 0;
	private TextUI scoreText;
	private TextUI lifeText;

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		populateLevelArray(myLevelArray);
		stage.setScene(CreateScene(SCREEN_WIDTH,SCREEN_HEIGHT,SCREEN_COLOR));
		stage.setTitle("Arcade");
		stage.show();

		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}



	private Scene CreateScene(int sceneWidth, int sceneHeight, Paint background) throws FileNotFoundException {
		myRoot = new Group();
		currentLevel = myLevelArray.get(0);
		currentLevel.addEnemies(myRoot);
		currentLevel.addEnemies(myRoot);

		//add
		scoreText = new TextUI("Score: ", 10, 20, Color.WHITE, 0);
		scoreText.addToScene(myRoot);

		//add life text
		lifeText = new TextUI("Lives Remaining: ", 10, 40, Color.WHITE, 3);
		lifeText.addToScene(myRoot);

		//add bottom border
		bottomBorder = new Rectangle(sceneWidth, 5, background);
		bottomBorder.setY(sceneHeight - 5);
		myRoot.getChildren().add(bottomBorder);

		Scene myScene = new Scene(myRoot, sceneWidth, sceneHeight, background);

		// add ship - Chris
		ship.addGameObjectToGroup(myRoot);

		// add key event handler to the scene - Chris
		myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				ship.handleShipInputs(event.getCode());
				try {
					ship.handleProjectileSpawn(event.getCode(), myRoot);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				event.consume();
			}
		});

		return myScene;

	}

	private void step (double elapsedTime, Stage stage) {
		if(!currentLevel.isGameOver()) {
		currentBadGuys = currentLevel.getBadGuys();
		//projectile movement - Chris
		ArrayList<Projectile> myProjectiles = ship.getMyProjectiles();
		for (Projectile p : myProjectiles) {
			p.move(elapsedTime);
		}
		//bad guy movements - Trevor
		for(int i = 0; i < currentBadGuys.size(); i++) {
			for(int j = 0; j < currentBadGuys.get(i).size(); j++) {
				BadGuy currentBadGuy = currentBadGuys.get(i).get(j);
				currentBadGuy.move(elapsedTime);

				//bottom border intersection -Trevor 
				if(currentBadGuy.isCollision(bottomBorder)) {
					System.out.println("Damage caused");
					currentBadGuy.breakerDied(myRoot);
					currentBadGuys.get(i).remove(j); 
				}
				//projectile logic - Trevor
				for (int x = 0; x < myProjectiles.size(); x++) {
					Projectile currentProjectile = myProjectiles.get(x);
					if(currentBadGuy.isIntersecting(currentProjectile)) {
						currentBadGuy.removeHealth();
						currentProjectile.removeProjectile(myRoot);
						myProjectiles.remove(x);
						currentScore += 1;
						scoreText.Update(currentScore);

						//myProjectiles.remove(p);

						//remove breaker if dead - Trevor
						if(currentBadGuy.getHealth() == 0) {
							currentBadGuy.breakerDied(myRoot);
							currentBadGuys.get(i).remove(j);
							currentLevel.removeEnemy();
						}


					}
				}
			}
		}
		// check for no more bad guys - Chris
		}
		else {
			//game over screen
			return;
		}
		checkNoMoreBadGuys(currentLevel);
	}

	private void checkNoMoreBadGuys(Level currentLevel) {
//		// debug printouts
//		if (currentLevel.getNumEnemies() == 0) {
//			System.out.println("level over");
//		} else {
//			System.out.println(currentLevel.getNumEnemies());
//		}
		
		// need to iterate through levels or game over screen
	}
	
	private void populateLevelArray(ArrayList<Level> levelArray) {
		Level level1 = new Level(4, 6, 0, 2, NUM_LIVES);
		levelArray.add(level1);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}


}
