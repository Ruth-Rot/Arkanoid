/**
 * @author 318770609
 */
package levels;

import backgrounds.FinalBackground;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Velocity;
import interfaces.Sprite;
import sprite.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * create the level final four with rainy background and three balls.
 */
public class FinalFour extends Level {
    static final int BALLS_NUMBER = 3;
    static final int PADDLE_SPEED = 15;

    /**
     * the Constructor of the final four level- set the name of the level,
     * the number of balls,builds its blocks and organize them.
     */
    public FinalFour() {
        super();

        this.setName("Final Four");
        this.setBallNumber(BALLS_NUMBER);

        List<Block> blocks = new ArrayList<>();
        Color color;
        int yBlocks, xBlocks;
        Block block;
        //create the block:
        for (int i = 0; i < 7; i++) {
            color = randColor();
            yBlocks = 300 - ((i + 1) * (BLOCK_HEIGHT));
            xBlocks = 780 - (BLOCK_WIDTH);
            for (int j = 1; j <= 15; j++) {
                block = new Block(new Rectangle(new Point(xBlocks, yBlocks), BLOCK_WIDTH, BLOCK_HEIGHT), color);
                blocks.add(block);
                xBlocks = 780 - ((j + 1) * (BLOCK_WIDTH));
            }
        }
        this.setBlocks(blocks);
    }

    /**
     * @return final background - a spirits draw rainy background to the game.
     */
    @Override
    public Sprite getBackground() {
        return new FinalBackground();
    }

    /**
     * @return the velocities of the balls.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(-15, SPEED_START));
        velocities.add(Velocity.fromAngleAndSpeed(15, SPEED_START));
        velocities.add(Velocity.fromAngleAndSpeed(0, SPEED_START));
        return velocities;
    }

    /**
     * @return - the extra speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }
}
