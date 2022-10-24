package gameObjects;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class BadGuy extends GameObject  {
	
	private final int WIDTH = 50;
	private final int HEIGHT = 25;
	private Rectangle myBadGuy;
	private int badGuyHealth;
	
	public ArrayList<ArrayList<BadGuy>> myBadGuys= new ArrayList<ArrayList<BadGuy>>();
	
	public BadGuy(Rectangle badGuy, int x, int y, int health, Paint breakerColor) {
		myBadGuy = badGuy;
		myBadGuy.setWidth(WIDTH);
		myBadGuy.setWidth(HEIGHT);
		myBadGuy.setX(x);
		myBadGuy.setY(y);
		badGuyHealth = health;
	}

	@Override
	void move() {
	
		
	}

	
	@Override
	Node getView() {
		return myBadGuy;
	}
	
	
	public void breakerDied(Group root) {
		root.getChildren().remove(myBadGuy);
	}
	
	public void removeHealth() {
		badGuyHealth -= 1;
	}
	
	

}
