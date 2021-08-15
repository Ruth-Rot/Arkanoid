/**
 * @author 318770609
 */
package levels;

import backgrounds.EasyBackground;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Velocity;
import interfaces.Sprite;
import sprite.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * create the level wide easy with sunny background, wide paddle and ten balls.
 */
public class WideEasy extends Level {
    static final int BALLS_NUMBER = 10;
    static final int ORANGE = 2;
    static final int YELLOW = 4;
    static final int GREEN = 6;
    static final int BLUE = 9;
    static final int PINK = 11;
    static final int CYAN = 13;


    /**
     * the Constructor of the wide easy level- set the name of the level,
     * the number of balls,builds its blocks and organize them.
     */
    public WideEasy() {
        super();
        this.setName("Wide Easy");
        this.setBallNumber(BALLS_NUMBER);
        List<Block> blocks = new ArrayList<>();
        Color c = Color.RED;
        //create the block:
        for (int i = 0; i < 15; i++) {
            if (i == ORANGE) {
                c = Color.ORANGE;
            } else if (i == YELLOW) {
                c = Color.YELLOW;
            } else if (i == GREEN) {
                c = Color.GREEN;
            } else if (i == BLUE) {
                c = Color.BLUE;
            } else if (i == PINK) {
                c = Color.PINK;
            } else if (i == CYAN) {
                c = Color.CYAN;
            }
            blocks.add(new Block(new Rectangle(new Point(BORDERS + i * BLOCK_WIDTH,
                    HEIGHT_GUI / 2), BLOCK_WIDTH, BLOCK_HEIGHT), c));
        }
        this.setBlocks(blocks);
    }

    /**
     * @return easy background - a spirits draw sunny back ground to the game.
     */
    @Override
    public Sprite getBackground() {
        return new EasyBackground();
    }

    /**
     * @return the width of the wide paddle.
     */
    @Override
    public int paddleWidth() {
        return WIDTH_PADDLE * 7;
    }

    /**
     * @return the velocities of the balls.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        int angle = -45;
        // create the velocities
        for (int i = 0; i < 10; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angle, SPEED_START));
                angle += 10;
        }
        return velocities;
    }
}
