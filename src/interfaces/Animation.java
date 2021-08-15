/**
 * @author 318770609
 */
package interfaces;

import biuoop.DrawSurface;

/**
 * interface that contain the functions animation need to support.
 */
public interface Animation {
    /**
     * do the action for one frame.
     *
     * @param d - the surface the animation draw on him
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return if the action need to stop - true , else - false.
     */
    boolean shouldStop();
}