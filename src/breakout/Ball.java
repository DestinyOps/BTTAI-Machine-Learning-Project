package breakout;

import java.awt.Color;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;

public class Ball {
    public static final double BALL_RADIUS = 20;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private Ellipse ball; 
    private double ballCenterX;
    private double ballCenterY;
    private double xVelocityI;
    private double yVelocityI;
    private double ballMaxX;
    private double ballMaxY;

    public Ball(double centerX, double centerY, double xVelocity, double yVelocity, double maxX, double maxY){
        this.ball = new Ellipse(centerX, centerY, BALL_RADIUS *2, BALL_RADIUS *2);
        this.ball.setFillColor(Color.BLUE);
        this.ballCenterX = centerX;
        this.ballCenterY = centerY;

        this.xVelocityI = xVelocity;
        this.yVelocityI = yVelocity;

        this.ballMaxX = maxX;
        this.ballMaxY = maxY;

    }

    public double getballCenterX(){
        return ballCenterX;
    }

    public double getballCenterY(){
        return this.ballCenterY;
    }

    public Ellipse getBall(){
        return ball;
       }

    public void addToCanvas(CanvasWindow canvas) {
        ball.setCenter(canvas.getWidth()*.5, canvas.getHeight()*.65);
        canvas.add(ball);
        
    }
   
    public boolean updatePosition() {
        double newcenterX = ballCenterX + xVelocityI;
        double newcenterY = ballCenterY + yVelocityI;

        if (newcenterX > 0 && newcenterX < this.ballMaxX && newcenterY > 0 && newcenterY < this.ballMaxY) {
            this.ball.setCenter(newcenterX, newcenterY);
            this.ballCenterX = newcenterX;
            this.ballCenterY = newcenterY;
            return true;
        }else{
            return false;
        }

    }

    public void collision(Ball ball, CanvasWindow canvas){

        double centerx = ball.getballCenterX();
        double centery = ball.getballCenterY();

        GraphicsObject topLine = canvas.getElementAt(centerx + Ball.BALL_RADIUS, centery);
        GraphicsObject bottomLine = canvas.getElementAt(centerx - Ball.BALL_RADIUS, centery);
        GraphicsObject rightLine = canvas.getElementAt(centerx, centery + Ball.BALL_RADIUS);
        GraphicsObject leftLine = canvas.getElementAt(centerx, centery - Ball.BALL_RADIUS);


        if (topLine != null) {
            this.yVelocityI = -yVelocityI;
        }
    
        if (bottomLine != null) {
            this.yVelocityI = -yVelocityI;
        }
    
        if (leftLine != null) {
            this.xVelocityI = -xVelocityI;
        }
    
        if (rightLine != null) {
            this.xVelocityI = -xVelocityI;
        }

    }

    public void looseLife (Ball ball){
        if(ball.getballCenterY() >= CANVAS_HEIGHT - 4 * Ball.BALL_RADIUS){
            ball.getBall().setPosition(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
            System.out.println("The end");
        }
    }


    public void checkCollision(Ball ball, CanvasWindow canvas){
        if (ball.getballCenterX() - Ball.BALL_RADIUS <= 0 || ball.getballCenterX() + Ball.BALL_RADIUS >= CANVAS_WIDTH){
            ball.reverseX();
        }    
        if (ball.getballCenterY() - Ball.BALL_RADIUS * 2 <= 0){ 
            ball.reverseY();
        }    
        if (ball.getballCenterY() >= CANVAS_HEIGHT) {
            looseLife(ball);
            canvas.draw();
        }
    }  

    public void reverseY() {
        this.yVelocityI = -yVelocityI;
    }

    public void reverseX() {
        this.xVelocityI = -xVelocityI;
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ball);
    }

    public double getxVelocityI() {
        return xVelocityI;
    }
    
    public double getyVelocityI() {
        return yVelocityI;
    }
    

    public double getRadius(){
        return ball.getWidth()/2;
    }


}