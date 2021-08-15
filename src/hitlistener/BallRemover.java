/**
 * @author 318770609
 */
package hitlistener;

import interfaces.HitListener;
import sets.Counter;
import sets.GameLevel;
import sprite.Ball;
import sprite.Block;

/**
 * this listener use to remove a falling ball from the game.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * build and initializes the game and counter.
     *
     * @param game  - the game playing.
     * @param balls - the counter game.
     */
    public BallRemover(GameLevel game, Counter balls) {
        this.remainingBalls = new Counter();
        this.remainingBalls = balls;
        this.game = game;
    }

    /**
     * remove the ball from the game after it hit the death region.
     * remove its from the game, and decrease it from the ball counter.
     *
     * @param beingHit - the block that hit. now it is DeathRegionBlock.
     * @param hitter   - the ball that hit (fall).
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(game);
    }

}
