/**
 * @author 318770609
 */
package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;
import sets.GameEnvironment;


import java.awt.Color;

/**
 * create spirits that draw a sunny backGround to the level.
 */
public class EasyBackground implements Sprite {
    static final int WIDTH_GUI = 800;
    static final int HEIGHT_GUI = 600;
    static final int BORDERS = 30;

    /**
     * draw the sunny background.
     *
     * @param d - the surface draw on it.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);

        d.drawRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);
        d.fillRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);

        d.setColor(new Color(239, 231, 176));
        d.fillCircle(150, 150, 60);

        int yB = HEIGHT_GUI / 2;
        int x = WIDTH_GUI;
        int start = 150;
        double spare = 0;

        while (x > 0) {
            d.drawLine(start, start, x, yB);
            x -= 1 + spare;
            spare += 0.20;
        }

        d.setColor(new Color(236, 215, 73));
        d.fillCircle(150, 150, 50);
        d.setColor(new Color(225, 225, 24));
        d.fillCircle(150, 150, 40);
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
