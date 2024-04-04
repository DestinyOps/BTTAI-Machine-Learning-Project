package breakout;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/* 
 * Select individual brick, brick manager does what?
 * just creatings a signular box
 * to then be used in brick managers which will manage the boxes as a whole
 * like program widget and buble mamger
 * 
 */

 public class Brick extends Rectangle{


 /**
  * Constructs a brick centered on the center X/Y with the specified width and height
  */

    public Brick(double x, double y, double width, double height){
        super(x,y,width, height);
        this.setPosition(x,y);

    }

 }