package breakout;

import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import java.util.Random;

public class BrickManager {
/*
 * boxGroup makes it one largers block that contains all the smaller blocks
 */

    private CanvasWindow canvas;
    private List<Brick> bricks;
   

    public BrickManager(CanvasWindow canvas){
        bricks = new ArrayList<>();
        this.canvas = canvas;
    }

    public void generateBricks(){
        int numBricks = 20;
        double x = 40;
        double y = 40;
        for (int i = 0; i < numBricks; i++){
            x = x + 50;
            double height = 60;
            double width = 80;
            Brick brick = new Brick(x,y,height, width);
            brick.setPosition(x, y);
            canvas.add(brick);
            bricks.add(brick);

        }
    }

    private void popBrick(Brick brick) {
        canvas.remove(brick);
        brick.remove(brick);
    }

    public void removeAllBricks(){
        for (Brick brick: bricks){
            canvas.remove(brick);
        }
        bricks.clear();
    }





    
}
