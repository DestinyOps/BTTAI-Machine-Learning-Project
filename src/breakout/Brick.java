package breakout;
import java.awt.Color;
import edu.macalester.graphics.Rectangle;

/* 
 * Select individual brick, brick manager does what?
 * just creatings a signular box
 * to then be used in brick managers which will manage the boxes as a whole
 * like program widget and buble mamger
 * 
 */

public class Brick extends Rectangle {

    public static int NUM_LAYERS = 5;
    public static Color BRICK_COLOR = new Color(201,150,216,55);


    public Brick(double x, double y, double width, double height){
        super(x,y,width,height);

        setStrokeWidth(Math.rint((width + height) / 40 + 1) * 0.5);
    }

}
