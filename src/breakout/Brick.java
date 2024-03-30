package breakout;
import java.awt.Color;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/* 
 * Select individual brick, brick manager does what?
 * just creatings a signular box
 * to then be used in brick managers which will manage the boxes as a whole
 * like program widget and buble mamger
 * 
 */

public class Brick extends GraphicsGroup {

    private double x;
    private double y;
    private double height;
    private double width;
    public static final int NUM_LAYERS = 5;
    public static final Color BRICK_COLOR = new Color(201, 150, 216, 55);

 /**
  * Constructs a bubble centered on the center X/Y with the specified width an 
  */
    public Brick(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setPosition(x,y);
        createBrick();
        
    }

    private void createBrick(){
        for(int i = 0; i < NUM_LAYERS; i++){
            Rectangle rectangle = new Rectangle(x,y,width,height);
            rectangle.setFillColor(BRICK_COLOR);
            rectangle.setFilled(true);
            rectangle.setStroked(false);
            add(rectangle);
        }

    }

}
