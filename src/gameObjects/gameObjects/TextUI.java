package gameObjects;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class TextUI {

	private Text myText;
	public String mainBody;
	
	
	public TextUI(String content, double x, double y, Paint textColor, int initialValue) {
		mainBody = content;
		myText = new Text();
		Point2D location = new Point2D(x,y);
		myText.setText(content + initialValue);
		myText.setFill(textColor);
		myText.setX(location.getX());
		myText.setY(location.getY());
	}
	
	
	public Text getText() {
		return myText;
	}
	
	public void Update(int value) {
		myText.setText(mainBody + value);
	}
	
	public void addToScene(Group root) {
		root.getChildren().add(myText);
	}
	
	
	
}

