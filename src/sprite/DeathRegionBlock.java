/**
 * @author 318770609
 */
package sprite;
import geometryprimitives.Rectangle;
import interfaces.HitListener;
import interfaces.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * special block that removed balls.
 */
public class DeathRegionBlock extends Block implements HitNotifier {
    private List<HitListener> hitListeners;

    /**
     * constructor of block, build him from the values are given.
     *
     * @param r - the rectangle of the block.
     * @param c - the color of the block.
     */
    public DeathRegionBlock(Rectangle r, Color c) {
        super(r, c);
        this.hitListeners = new ArrayList<>();
    }

    /**
     * add the hitListeners to the block.
     *
     * @param hl - the hitListener
     */
    @Override
    public void addHitListener(HitListener hl) {
        super.addHitListener(hl);
    }

    /**
     * remove the hitListeners from the block.
     *
     * @param hl - the hitListener
     */
    @Override
    public void removeHitListener(HitListener hl) {
        super.removeHitListener(hl);
    }
}
