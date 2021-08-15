/**
 * @author 318770609
 */
package animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;

/**
 * run the Animations of the game.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * Constructor of thw animation runner, get the gui and show the animation on him.
     *
     * @param g - the gui given.
     */
    public AnimationRunner(GUI g) {
        this.gui = g;
        this.framesPerSecond = 60;
    }

    /**
     * ran the animation that given.
     *
     * @param animation -the given animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        Sleeper sleeper = new Sleeper();

        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}