/**
 * @author 318770609
 */
package interfaces;
import biuoop.DrawSurface;
import sets.GameEnvironment;

/**
 * interface that draw and updated its object so the game move and continue.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d - the surface draw on it.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * update the ball environment.
     * @param environment - the new environment;
     */
    void updateBall(GameEnvironment environment);
}