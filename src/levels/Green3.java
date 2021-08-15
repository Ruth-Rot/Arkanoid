/**
 * @author 318770609
 */
package levels;

import backgrounds.GreenBackground;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Velocity;
import interfaces.Sprite;
import sprite.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * create the level green3 with green background and two balls.
 */
public class Green3 extends Level {
    static final  int BALLS_NUMBER = 2;

    /**
     * the Constructor of the green3 level- set the name of the level,
     * the number of balls,builds its blocks and organize them.
     */
    public Green3() {
        super();

        this.setName("Green 3");
        this.setBallNumber(BALLS_NUMBER);

        List<Block> blocks = new ArrayList<>();
        Color color;
        int yBlocks, xBlocks;
        Block block;
        //create the block:
        for (int i = 0; i < 5; i++) {
            color = randColor();
            yBlocks = 300 - ((i + 1) * (BLOCK_HEIGHT));
            xBlocks = 780 - (BLOCK_WIDTH);
            for (int j = 1; j < 6 + i; j++) {
                block = new Block(new Rectangle(new Point(xBlocks, yBlocks), BLOCK_WIDTH, BLOCK_HEIGHT), color);
                blocks.add(block);
                xBlocks = 780 - ((j + 1) * (BLOCK_WIDTH));
            }
        }
        this.setBlocks(blocks);
    }
    /**
     * @return green background - a spirits draw green background to the game.
     */
    @Override
    public Sprite getBackground() {
        return new GreenBackground();
    }
    /**
     * @return the velocities of the balls.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(-15, SPEED_START));
        velocities.add(Velocity.fromAngleAndSpeed(15, SPEED_START));
        return velocities;
    }


}
