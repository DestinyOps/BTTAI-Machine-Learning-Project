package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Paddle{

    private Rectangle paddle;
    private double x = 300;
    private double y= 400;
    

    public Paddle(double x, double y){
        paddle = new Rectangle(x,y,200, 40);
        this.paddle.setFillColor(Color.BLACK);
        this.x = x;
        this.y = y;
    }

    public void createPaddle(){
        paddle.setPosition(x,y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(paddle);
    }

    
}
