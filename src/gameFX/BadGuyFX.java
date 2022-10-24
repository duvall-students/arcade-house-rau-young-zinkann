package gameFX;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Simple bouncer based on an image that moves and bounces.
 *
 * @author Will Zinkann
 */
public class BadGuyFX {

    public static final int BRICK_SIZE = 25;

    private ImageView myView;


    public BadGuyFX (Image image, int screenWidth, int screenHeight, int xPosition, int yPosition) {
        myView = new ImageView(image);
        
        //int sizeX = screenWidth/GameLoop.NUM_BRICK_COLS;
        int sizeX = BRICK_SIZE;
        int sizeY = BRICK_SIZE;
        
        myView.setFitWidth(sizeX);
        
        myView.setFitHeight(sizeY);


        // make sure it stays within the bounds
        myView.setX(xPosition);
        myView.setY(yPosition);
    }

    /**
     * Returns internal view of brick to interact with other JavaFX methods.
     */
    public ImageView getView () {
        return myView;
    }

}
