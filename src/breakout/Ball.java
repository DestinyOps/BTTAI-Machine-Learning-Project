package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Ball {

    public static final double GRAVITY = -9.8;
    public static final double BALL_RADIUS = 20;

    private Ellipse ball; 
    private double centerX;
    private double centerY;
    public double maxX;
    public double maxY;
    private double xVelocity = 5;
    private double yVelocity = 5;

    public Ball(double centerX, double centerY, double initialSpeed, double initialAngle, double maxX, double maxY){
        ball = new Ellipse(centerX, centerY, 40, 40);
        this.ball.setFillColor(Color.BLACK);
        this.centerX = centerX;
        this.centerY = centerY;
        this.maxX = maxX;
        this.maxY = maxY;

    }

    public double getCenterX(){
        return centerX;
    }

    public double getCenterY(){
        return centerY;
    }

   
    public boolean updatePosition() {
        centerX = centerX + xVelocity;
        centerY = centerY + yVelocity;

        if(centerX + 40 > 600 || centerX + 40 < 0){
            xVelocity = xVelocity * -1;
        }
        if(centerY + 40 > 800 || centerY + 40 < 0){
            yVelocity = yVelocity * -1;
        }

        ball.setPosition(centerX, centerY);
        return true;

    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ball);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ball);
    }

    public double getRadius(){
        return ball.getWidth()/2;
    }

    
}
