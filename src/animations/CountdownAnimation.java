/**
 * @author 318770609
 */
package animations;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import interfaces.Animation;
import sets.SpriteCollection;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds,
 * before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;

    /**
     * Constructor to the count down animation.
     * initialize:
     *
     * @param numOfSeconds - the numbers of seconds the count will be.
     * @param countFrom    - the number will count from.
     * @param gameScreen   - the game screen will show in the background.
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }

    /**
     * draw the current number in the count on the screen of the game before th starts.
     *
     * @param d - the surface the animation draw on him
     */
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(new Color(239, 228, 176));
        d.drawText(380, 300, String.valueOf(this.countFrom), 100);

        this.countFrom--;

        int millisecondsPerFrame = (int) (1000 / numOfSeconds);
        Sleeper sleeper = new Sleeper();
        long startTime = System.currentTimeMillis(); // timing
        long usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }


    }

    /**
     * @return if the count need to stop.
     */
    public boolean shouldStop() {
        if (this.countFrom >= 0) {
            return false;
        }
        return true;
    }
}