/**
 * @author 318770609
 */
package levels;

import backgrounds.DirectBackgroung;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Velocity;

import interfaces.Sprite;
import sprite.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * create the level direct hit with black background and one ball.
 */
public class DirectHit extends Level {
    static final int BALLS_NUMBER = 1;

    /**
     * the Constructor of the direct hit level- set the name of the level,
     * the number of balls,builds its blocks and organize them.
     */
    public DirectHit() {
        super();
        this.setName("Direct Hit");
        this.setBallNumber(BALLS_NUMBER);

        //create the block:
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(375, 175), 50, 50), Color.red));
        this.setBlocks(blocks);
    }

    /**
     * @return direct background - a spirits draw black background to the game.
     */
    @Override
    public Sprite getBackground() {
        return new DirectBackgroung();
    }


    /**
     * @return the velocities of the balls.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(0, SPEED_START));
        return velocities;
    }
}
