package gameObjects;

import javafx.scene.paint.Paint;

public class PointsText extends TextUI {
	
	private String mainBody = "Score: ";

	public PointsText(String content, double x, double y, Paint textColor) {
		super(content, x, y, textColor);
		
	}

	@Override
	public void Update(int value) {
		super.getText().setText(mainBody + value);
	}
	

}
