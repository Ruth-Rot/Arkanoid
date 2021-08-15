/**
 * @author 318770609
 */
package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * this animation message about win or loss.
 */
public class FinalScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean win;
    private boolean stop;
    private int score;

    /**
     * Constructor for the animation Final Screen, initialize the score, and the relent flags.
     *
     * @param win - if win true else false.
     * @param score - the score the player gain in the game.
     */
    public FinalScreen(boolean win, int score) {
        this.win = win;
        this.stop = false;
        this.score = score;
    }

    /**
     * write on the screen message about the win or the lose of the game.
     *
     * @param d - the surface the animation draw on him
     */
    public void doOneFrame(DrawSurface d) {
        String w;
        if (this.win) {
            w = "You Win! ";
        } else {
            w = "Game Over. ";
        }
        d.drawText(10, d.getHeight() / 2, w + "Your Score is " + this.score, 40);
    }

    /**
     * @return true when the animation need to stop else return true.
     */
    public boolean shouldStop() {
        return this.stop;
    }

}
