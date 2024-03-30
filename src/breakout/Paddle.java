package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Paddle{

    private Rectangle paddle;
    

    public Paddle(double x, double y){
        paddle = new Rectangle(x,y,100, 40);
        this.paddle.setFillColor(Color.BLACK);
    }

    public void createPaddle(){
        paddle.setPosition(250,600);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(paddle);
    }

    
}
