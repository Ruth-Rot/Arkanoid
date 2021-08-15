/**
 * @author 318770609
 */
package sprite;

import biuoop.DrawSurface;
import interfaces.Sprite;
import sets.GameEnvironment;

import java.awt.Color;

/**
 * Name Indicator draw the name of level on the gui surface of the game.
 */
public class NameIndicator implements Sprite {
    private String name;

    /**
     * the constructor of name indicator, initializing the name of the game.
     *
     * @param name - the name of the current level.
     */
    public NameIndicator(String name) {
        this.name = name;
    }

    @Override
    /**
     * draw the name of the level on the given DrawSurface.
     *
     * @param surface - the surface the name drawer on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(580, 15, "Level Name: " + this.name, 15);
    }

    @Override
    /**
     * un used.
     */
    public void timePassed() {

    }

    @Override
    /**
     * un used.
     */
    public void updateBall(GameEnvironment environment) {

    }
}
