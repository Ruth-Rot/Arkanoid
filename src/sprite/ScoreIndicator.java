/**
 * @author 318770609
 */
package sprite;

import biuoop.DrawSurface;
import interfaces.Sprite;
import sets.Counter;
import sets.GameLevel;
import sets.GameEnvironment;

import java.awt.Color;

/**
 * sprite that contain the a counter of the score and draw it on the surface of the game.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * build and initialize the ScoreIndicator.
     *
     * @param c - the score counter of the game.
     */
    public ScoreIndicator(Counter c) {
        score = new Counter();
        score = c;
    }

    /**
     * write the score on the gui surface.
     *
     * @param d - the surface draw on it.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(380, 15, "Score: " + this.score.getValue(), 15);
    }

    /**
     * add this to the game lists.
     *
     * @param g - the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * this not action.
     */
    @Override
    public void timePassed() {
    }

    /**
     * @param environment - the environment of the game.
     */
    @Override
    public void updateBall(GameEnvironment environment) {
    }
}
