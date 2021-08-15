/**
 * @author 318770609
 */
package levels;

import geometryprimitives.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprite.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the dad of the levels - contain final information on the game instruments.
 */
public class Level implements LevelInformation {
    private List<Block> blocks;
    private String name;
    private int ballNumber;

    static final int WIDTH_PADDLE = 90;
    static final int HEIGHT_GUI = 600;

    static final Double SPEED_START = 3.0;
    static final int PADDLE_SPEED = 10;
    static final int BORDERS = 20;

    static final int BLOCK_WIDTH = 51;
    static final int BLOCK_HEIGHT = 25;

    /**
     * the constructor- initialize the blocks arraylist.
     */
    public Level() {
        blocks = new ArrayList<>();
    }

    /**
     * @return -the numbers of the balls in the level.
     */
    @Override
    public int numberOfBalls() {
        return ballNumber;
    }

    /**
     * @return empty array list.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        return null;
    }

    /**
     * @return the original paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * @return the original paddle width.
     */
    @Override
    public int paddleWidth() {
        return WIDTH_PADDLE;
    }

    /**
     * @return the level name.
     */
    @Override
    public String levelName() {
        return this.name;
    }

    /**
     * @return null.
     */
    @Override
    public Sprite getBackground() {
        return null;
    }

    /**
     * @return the list of the level blocks.
     */
    @Override
    public List<Block> blocks() {
        return blocks;
    }

    /**
     * @return the numbers of the blocks.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks.size();
    }

    /**
     * @return rand color.
     */
    public Color randColor() {
        java.util.Random rand = new java.util.Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        return new Color(red, green, blue);
    }

    /**
     * @param block - sets the blocks
     */
    public void setBlocks(List<Block> block) {
        this.blocks = block;
    }

    /**
     * @param balls - sets the ball numbers.
     */
    public void setBallNumber(int balls) {
        this.ballNumber = balls;
    }

    /**
     * @param n - set the name level.
     */
    public void setName(String n) {
        this.name = n;
    }
}
