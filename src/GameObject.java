import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;


import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Abstract class to create all game objects
 *
 * @author Will Zinkann
 */ 
public abstract class GameObject {
	
	protected ImageView myView;

	
	
	// 
	public GameObject(String imagePath, double sizeWidth, double sizeHeight, Point2D pos) throws FileNotFoundException {
		Image image = new Image(new FileInputStream(imagePath));
        myView = new ImageView(image);
        
        myView.setFitWidth(sizeWidth);
        myView.setFitHeight(sizeHeight);

        myView.setX(pos.getX());
        myView.setY(pos.getY());

	}
	
	protected int getRandomInRange (int min, int max) {
		Random dice = new Random();
        return min + dice.nextInt(max - min) + 1;
    }

	
	Node getView() {
		return myView;
	}
	
	
	public boolean isIntersecting(GameObject other) {
		return this.getBounds().intersects(other.getBounds());
	}
	
	public Bounds getBounds() {
		return myView.getBoundsInParent();
	}


	@Override
	public String toString() {
		return "GameObject [myView=" + myView + "]";
	}

	void move() {
		// TODO Auto-generated method stub
		
	}






}
