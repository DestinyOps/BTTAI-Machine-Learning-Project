package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Paddle{

    public CanvasWindow canvas;
    private Rectangle paddle;
    public int xPosition = 250;
    

    public Paddle(double x, double y){
        paddle = new Rectangle(x,y,100, 40);
        this.paddle.setFillColor(Color.BLACK);
        
    }

    public void createPaddle(){
        paddle.setPosition(xPosition,600);
        canvas.onMouseDown(event -> {
            xPosition = xPosition + 40;
        });

    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(paddle);
    }



    
}
