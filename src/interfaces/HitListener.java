/**
 * @author 318770609
 */
package interfaces;

import sprite.Ball;
import sprite.Block;

/**
 * handle hits and their causes.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit - the block hotted.
     * @param hitter   - the ball that hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}