/**
 * @author 318770609
 */
package interfaces;

import geometryprimitives.Velocity;
import sprite.Block;

import java.util.List;

/**
 * interface that contain the information the level in to support.
 */
public interface LevelInformation {
    /**
     * @return - the numbers of the balls.
     */
    int numberOfBalls();

    /**
     * @return -  The initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return - the paddle speed.
     */
    int paddleSpeed();

    /**
     * @return - the paddle width.
     */
    int paddleWidth();

    /**
     * @return the level name that will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * @return The Blocks that make up this level, each block contains
     * its size, color and location.
     */
    List<Block> blocks();

    /**
     * @return the number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}