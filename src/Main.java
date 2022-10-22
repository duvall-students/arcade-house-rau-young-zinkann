import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 500;
	public static final Paint SCREEN_COLOR = Color.BLACK;
	
	@Override
	public void start(Stage stage) {
		stage.setScene(CreateScene(SCREEN_WIDTH,SCREEN_HEIGHT,SCREEN_COLOR));
		stage.setTitle("Breakout");
		stage.show();
	}
	

	
	private Scene CreateScene(int sceneWidth, int sceneHeight, Paint background) {
		Group root = new Group();
		Scene myScene = new Scene(root, sceneWidth, sceneHeight, background);
		return myScene;
				
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
