/**
 * @author 318770609
 */
package animations;

import biuoop.DrawSurface;
import interfaces.Animation;

/**
 * this animation pause the game.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * Constructor of the animation pause Screen.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * write on the screen message about the pause of the game.
     *
     * @param d - the surface the animation draw on him
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(d.getWidth()/5, d.getHeight() / 2, "paused -- press space to continue", 30);
    }

    /**
     * @return true when the animation need to stop else return true.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}