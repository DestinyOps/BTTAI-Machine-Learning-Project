package breakout;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static BrickManager brickManager;
    private CanvasWindow canvas;

    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        brickManager = new BrickManager(canvas);

    }

    public void resetGame(){
        brickManager.removeAllBricks();
        canvas.removeAll();
        brickManager.generateBricks();
        canvas.draw();
    }


    public void run(){
        boolean running = true;
        Ball ball = new Ball(300, 300, 50, 50, canvas.getWidth(), canvas.getHeight());
        Paddle paddle = new Paddle(300, 400);
        brickManager.generateBricks();
        ball.addToCanvas(canvas);
        paddle.createPaddle();
        paddle.addToCanvas(canvas);

        while(running){
            canvas.draw();
            canvas.pause(10);
            ball.updatePosition();
        }
         resetGame();
    }


}
