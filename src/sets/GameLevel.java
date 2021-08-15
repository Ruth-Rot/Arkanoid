/**
 * @author 318770609
 */
package sets;

import animations.AnimationRunner;
import animations.CountdownAnimation;
import animations.KeyPressStoppableAnimation;
import animations.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Velocity;
import hitlistener.BallRemover;
import hitlistener.BlockRemover;
import hitlistener.ScoreTrackingListener;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprite.*;

import java.awt.Color;


/**
 * create level game, with gui window, and collections that treat the occurrence of the game.
 * its initialize the level by final and given values, and run it.
 */
public class GameLevel implements Animation {
    //final variables the game uses
    static final int BALLS_RADIOS = 5;
    static final int HEIGHT_PADDLE = 15;
    static final Point BALLS_START = new Point(400, 572);
    static final int WIDTH_GUI = 800;
    static final int HEIGHT_GUI = 600;
    static final int BORDERS = 20;
    static final double NUM_OF_SECONDS = 2;
    static final int COUNT_FROM = 3;
    // the game collections
    private SpriteCollection sprites;
    private GameEnvironment environment;
    // the window the game occurs on it
    private GUI gui;

    //the counter the game use:
    private Counter counterOfBlocks;
    private Counter counterOfBalls;
    private Counter score;
    private int hS;

    //the sprite update the show score.
    private ScoreIndicator indicator;
    private LevelInformation level;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;


    /**
     * constructor of the game level, initialize its collection, counters anf indicator.
     *
     * @param information - information on the level.
     * @param keyboard    - the keyboard sensor the game uses.
     * @param runner      - the run animation the game use to run the animation unt the game.
     * @param gui         - the Gui of the game.
     * @param s           - the score value.
     */
    public GameLevel(LevelInformation information, biuoop.KeyboardSensor keyboard,
                     AnimationRunner runner, GUI gui, Counter s,int h) {
        this.level = information;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.counterOfBlocks = new Counter();
        this.counterOfBalls = new Counter();
        this.score = s;
        this.indicator = new ScoreIndicator(this.score);
        this.gui = gui;
        this.runner = runner;
        this.keyboard = keyboard;
        this.hS = h;

    }

    /**
     * @return the game environment.
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * add collidable to the game environment.
     *
     * @param c - the collidable added
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * add sprite object to the sprite environment of the game.
     * by the function on the object.
     *
     * @param s - sprite object.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * remove collidable from the game environment.
     *
     * @param c - the collidable removed.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * remove sprite from the game environment.
     *
     * @param s - the sprite removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * @return the sprite collection of the game.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * Initialize a new level in order to the level information:
     * create window, the Blocks and Balls and Paddle
     * and add them to the games collections.
     */
    public void initialize() {
        this.running = true;
        this.sprites.addSprite(this.level.getBackground());

        // build listeners:
        BlockRemover hitListener = new BlockRemover(this, counterOfBlocks); // to the blocks
        BallRemover fallListener = new BallRemover(this, counterOfBalls); //to the DeathRegionBlock
        ScoreTrackingListener scoreListener = new ScoreTrackingListener(score); //to the blocks.

        // set counters
        counterOfBalls.increase(this.level.numberOfBalls());
        this.counterOfBlocks.increase(this.level.numberOfBlocksToRemove());

        for (Block b : this.level.blocks()) {
            //add to them listeners of remove and add point after hit.
            b.addHitListener(hitListener);
            b.addHitListener(scoreListener);
            b.addToGame(this);
        }

        //create borders
        new Block(new Rectangle(new Point(0, 0), WIDTH_GUI, BORDERS), Color.GRAY).addToGame(this);
        new Block(new Rectangle(new Point(0, BORDERS), BORDERS,
                HEIGHT_GUI), Color.GRAY).addToGame(this);
        new Block(new Rectangle(new Point(WIDTH_GUI - BORDERS, BORDERS),
                BORDERS, HEIGHT_GUI), Color.GRAY).addToGame(this);
        DeathRegionBlock deathRegionBlock = new DeathRegionBlock(new Rectangle(new Point(0, HEIGHT_GUI),
                WIDTH_GUI, BORDERS), Color.black);
        deathRegionBlock.addHitListener(fallListener);
        deathRegionBlock.addToGame(this);

        //paddle
        Point start = new Point(WIDTH_GUI / 2 - this.level.paddleWidth() / 2, HEIGHT_GUI - HEIGHT_PADDLE * 1.5);
        Paddle paddle = new Paddle(new Rectangle(start, this.level.paddleWidth(), HEIGHT_PADDLE),
                new Color(253, 217, 49), BORDERS, WIDTH_GUI - BORDERS, keyboard, this.level.paddleSpeed());
        paddle.addToGame(this);

        //balls
        Ball b;
        for (Velocity v : this.level.initialBallVelocities()) {
            b = new Ball(new Point(BALLS_START.getX(), BALLS_START.getY()), BALLS_RADIOS, Color.WHITE);
            b.setVelocity(v);
            b.addToGame(this);
            //associating the ball with the game environment
            b.setEnvironment(this.environment);
        }

        this.indicator.addToGame(this);
        sprites.addSprite(new NameIndicator(this.level.levelName()));
        sprites.addSprite((new HighScoreIndicator(this.hS)));


    }

    /**
     * if the run should stop from some reason - return boolean answer.
     *
     * @return true if need to stop else false.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @return if the user lose - true or win - false in the game.
     */
    public boolean isLose() {
        if (counterOfBalls.getValue() > 0) {
            return false;
        }
        return true;
    }

    /**
     * the function do on move in the game, and show its.
     *
     * @param d - the surface the level spirits drawn on him
     */
    public void doOneFrame(DrawSurface d) {

        this.sprites.notifyAllTimePassed();
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);
        this.sprites.drawAllOn(d);
        //if the game ended in win:
        if (this.counterOfBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        //if all the balls fall end the game:
        if (this.counterOfBalls.getValue() == 0) {
            this.running = false;
        }
        // if the user pressed p pause the game:
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
    }

    /**
     * run the level:
     * with count down before the level start.
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(NUM_OF_SECONDS, COUNT_FROM, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }
}