/**
 * @author 318770609
 */
package interfaces;

/**
 * the interface contain the function need to update the hit listener.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl - the hitListener
     */
    void addHitListener(HitListener hl);

    /**
     * remove hl from the list of listeners to hit events.
     *
     * @param hl - the hitListener
     */
    void removeHitListener(HitListener hl);
}