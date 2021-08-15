/**
 * @author 318770609
 */
package hitlistener;

import interfaces.HitListener;
import sets.Counter;
import sprite.Ball;
import sprite.Block;

/**
 * this listener update ah score after hit of the ball in the block.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * build and initialize the counter score.
     *
     * @param scoreCounter - the score counter of the game.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * add five point to the counter.
     *
     * @param beingHit - the block hotted.
     * @param hitter   - the ball hit it.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}