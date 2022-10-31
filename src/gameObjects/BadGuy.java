package gameObjects;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class BadGuy extends GameObject  {
	
	private final double WIDTH = 50;
	private final double HEIGHT = 25;
	private Rectangle myBadGuy;
	private int badGuyHealth;
	private String imagePath = "blahblah.gif";
	
	public ArrayList<ArrayList<BadGuy>> myBadGuys= new ArrayList<ArrayList<BadGuy>>();
	
	public BadGuy(String imagePath, double width, double height, Point2D pos) throws FileNotFoundException {
		super(imagePath, width, height, pos);
		//myBadGuy = badGuy;
		myBadGuy.setWidth(width);
		myBadGuy.setHeight(height);
		
//		myBadGuy.setX(x);
//		myBadGuy.setY(y);
//		badGuyHealth = health;
	}

	@Override
	void move(double elapsedTime) {
	
		
	}

	
	@Override
	public Node getView() {
		return myBadGuy;
	}
	
	
	public void breakerDied(Group root) {
		root.getChildren().remove(myBadGuy);
	}
	
	public void removeHealth() {
		badGuyHealth -= 1;
	}

	@Override
	void addGameObjectToGroup(Group root) {
		// TODO Auto-generated method stub
		
	}
	
	

}