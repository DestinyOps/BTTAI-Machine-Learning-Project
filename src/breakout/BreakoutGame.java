package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;



public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private double x;
    private double y;
    private double height;
    private double width;
    public static final int NUM_LAYERS = 5;
    public static final Color BRICK_COLOR = new Color(201, 150, 216, 55);


    private CanvasWindow canvas;
    private Ball ball;
    private  BrickManager brickManager;
    private Paddle paddle;
    private int lives = 3;

      public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        ball = new Ball(CANVAS_HEIGHT/2, CANVAS_HEIGHT/2, 1, 1, CANVAS_WIDTH, CANVAS_HEIGHT);
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
        ball.collision(ball, canvas);
        ball.checkCollision(ball, canvas);
        });

        createBrick();

    }

    private void createBrick(){
        for(int i = 0; i < NUM_LAYERS; i++){
            Rectangle rectangle = new Rectangle(x,y,width,height);
            rectangle.setFillColor(BRICK_COLOR);
            rectangle.setFilled(true);
            rectangle.setStroked(false);
            canvas.add(rectangle);
        }
    }


    public void run(){

        GraphicsObject bottomBoundary = canvas.getElementAt(ball.getballCenterX(), ball.getballCenterY());
        if (bottomBoundary instanceof Rectangle && ball.getballCenterY() >= canvas.getHeight() * 0.5){
            ball.reverseY();
        }
        if (bottomBoundary instanceof Brick && ball.getballCenterY() >= canvas.getHeight() * 0.5){
            ball.reverseY();
        }
        roundOver();
    }


    public void roundOver(){
        GraphicsText lose = new GraphicsText();
        lose.setText("Haha! You lost! Loser >:)");

        GraphicsText win = new GraphicsText();
        win.setText("Congrats! You won!");

        if(lives == 0){
            canvas.add(lose);
        }

        if(lives != 0 && brickManager.getNumberOfBricks() == 0){
            canvas.removeAll();
            canvas.add(win);
        }
    }
    }










