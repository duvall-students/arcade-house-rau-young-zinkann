package gameObjects;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public abstract class TextUI {

	private Text myText;
	
	
	public TextUI(String content, double x, double y, Paint textColor) {
		myText = new Text();
		Point2D location = new Point2D(x,y);
		myText.setText(content);
		myText.setFill(textColor);
		myText.setX(location.getX());
		myText.setY(location.getY());
	}
	
	
	public Text getText() {
		return myText;
	}
	
	abstract public void Update(int value);
	
	public void addToScene(Group root) {
		root.getChildren().add(myText);
	}
	
	
	
}

