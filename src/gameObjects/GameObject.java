package gameObjects;
import javafx.scene.Group;
import javafx.scene.Node;

//how do we want to construct this 
public abstract class GameObject {
	
	abstract void move(double elapsedTime);
	
	
	abstract Node getView();
	
	
	abstract void addGameObjectToGroup(Group root);
}
