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
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          -  the game plays.
     * @param removedBlocks - counter of the blocks int the game.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.remainingBlocks = new Counter();
        this.remainingBlocks = removedBlocks;
        this.game = game;
    }

    /**
     * Blocks that are hit and reach 0 hit-points removed
     * from the game. remove also this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit - the block being hit.
     * @param hitter   - the ball hit him.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
        hitter.setEnvironment(this.game.getEnvironment());
        game.getSprites().updateBallForAll(this.game.getEnvironment());
    }
}