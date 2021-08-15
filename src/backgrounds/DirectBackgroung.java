/**
 * @author 318770609
 */
package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;
import sets.GameEnvironment;

import java.awt.Color;

/**
 * create spirits that draw a black backGround to the level.
 */
public class DirectBackgroung implements Sprite {
    static final int WIDTH_GUI = 800;
    static final int HEIGHT_GUI = 600;
    static final int BORDERS = 30;

    /**
     * draw the black background.
     *
     * @param d - the surface draw on it.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);
        d.fillRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);
        d.setColor(Color.BLUE);
        d.drawLine(BORDERS + 190, WIDTH_GUI / 4, BORDERS + 190 + 145, WIDTH_GUI / 4);
        d.drawLine(WIDTH_GUI - BORDERS - 190 - 145, WIDTH_GUI / 4, WIDTH_GUI - BORDERS - 190, WIDTH_GUI / 4);
        d.drawLine(WIDTH_GUI / 2, BORDERS, WIDTH_GUI / 2, BORDERS + 140);
        d.drawLine(WIDTH_GUI / 2, 160 + 70, WIDTH_GUI / 2, 180 + 70 + 140);
        int r = 150;
        for (int i = 0; i < 3; i++) {
            d.drawCircle(WIDTH_GUI / 2, WIDTH_GUI / 4, r);
            r = r - 50;
        }
    }

    /**
     * un used.
     */
    @Override
    public void timePassed() {

    }

    /**
     * un used.
     *
     * @param environment - the new environment;
     */
    @Override
    public void updateBall(GameEnvironment environment) {

    }
}
