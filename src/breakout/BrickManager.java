package breakout;

import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;

public class BrickManager {
/*
 * Manages how the bricks are created might delete idk?
 */

    private CanvasWindow canvas;
    private List<Brick> bricks;
   

    public BrickManager(CanvasWindow canvas){
        bricks = new ArrayList<>();
        this.canvas = canvas;
    }

    public void generateBricks(){
        double x = 10;
        double y = 10;
        double height = 60;
        double width = 80;
       
        for (int i = 0; i < 4; i++){
            y = y + 45;
            x = 10;
            for(int j = 0; j < 5; j++){
            Brick brick = new Brick(x,y,height, width);
            x = x + 50;
            brick.setPosition(x, y);
            canvas.add(brick);
            bricks.add(brick);
            }

        }
    }

    void popBrick(Brick brick) {
        canvas.remove(brick);
        bricks.remove(brick);
    }

    public void removeAllBricks(){
        for (Brick brick: bricks){
            canvas.remove(brick);
        }
        bricks.clear();
    }

    public boolean brickStillExist() {
        return bricks.size() > 0;
    }

    public int getNumberOfBricks() {
        return bricks.size();
    }

    
}
