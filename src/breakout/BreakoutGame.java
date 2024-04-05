package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;

/*
 * It doesn't quite work all the way but it has the spirit
 */

/*
 * DESTINY OSEMWENGIE
 * 4 - 4 - 2024
 * HELP FROM: WILLIAM, RAMA, SAMIRA, STEPHANIE, COURTNEYY!!!
 */

public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    public static final int NUM_LAYERS = 10;
    public static final Color BRICK_COLOR = new Color(201, 150, 216, 55);


    private CanvasWindow canvas;
    private Ball ball;
    private  BrickManager brickManager;
    private Paddle paddle;
    private int lives = 3;


/*
 * Place to actually run the game
 */
      public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        ball = new Ball(CANVAS_HEIGHT/2, CANVAS_HEIGHT/2, 5, 7, CANVAS_WIDTH, CANVAS_HEIGHT);
        ball.addToCanvas(canvas);

        paddle = new Paddle(30,20,CANVAS_WIDTH,CANVAS_HEIGHT);
        paddle.addToCanvas(canvas);

        canvas.onMouseMove(event -> 
        paddle.setX(event.getPosition().getX()));

        brickManager = new BrickManager(canvas);
        brickManager.generateBricks();

        canvas.animate(event -> {
        run();
        ball.updatePosition();
        boolean stillGoing = ball.checkCollision(canvas);

        if(!stillGoing){
        lostLife();
        }

        });


    }

    public void lostLife(){
        lives --;
        
        GraphicsText lose = new GraphicsText();
        lose.setText("Aww, you lost!");

        GraphicsText win = new GraphicsText();
        win.setText("Congrats! You won!");

        if(lives == 0){
            canvas.add(lose);
            canvas.pause(500);
            canvas.closeWindow();
        }

        if(lives != 0 && brickManager.getNumberOfBricks() == 0){
            canvas.removeAll();
            canvas.add(win);
        }
    }

    


    public void run(){

        GraphicsText lives = new GraphicsText("Heelo");
        lives.setFillColor(Color.BLACK);
        lives.setFontSize(48);
        lives.setPosition(300,200);

        GraphicsObject bottomBoundary = canvas.getElementAt(ball.getballCenterX() + ball.getRadius(), ball.getballCenterY() + ball.getRadius());
        GraphicsObject topBoundary = canvas.getElementAt(ball.getballCenterX() - ball.getRadius(), ball.getballCenterY() - ball.getRadius());
        GraphicsObject leftBoundary = canvas.getElementAt(ball.getballCenterX() - ball.getRadius(), ball.getballCenterY() + ball.getRadius());
        GraphicsObject rightBoundary = canvas.getElementAt(ball.getballCenterX() + ball.getRadius(), ball.getballCenterY() - ball.getRadius());

        if(topBoundary != null && topBoundary.getClass().getName() != "edu.macalester.graphics.Ellispe"){
            ball.reverseY();
            removeBrick(topBoundary); 
        }
        else if(bottomBoundary != null && bottomBoundary.getClass().getName() == "edu.macalester.graphics.Rectangle"){
            ball.reverseY();
            removeBrick(bottomBoundary);
        }
        else if(leftBoundary != null && leftBoundary.getClass().getName() != "edu.macalester.graphics.Ellispe"){
            ball.reverseX();
            removeBrick(leftBoundary);
        }
        else if(rightBoundary != null && rightBoundary.getClass().getName() != "edu.macalester.graphics.Ellispe"){
            ball.reverseX();
            removeBrick(rightBoundary);
        }
    }

    public void removeBrick(GraphicsObject boundary){

    if(boundary.getClass().getName() == "breakout.Brick"){
       Brick hitBrick = brickManager.getBrick(boundary);
       brickManager.popBrick(hitBrick);
        }
    }

    }










