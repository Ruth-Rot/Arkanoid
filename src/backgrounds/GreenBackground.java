/**
 * @author 318770609
 */
package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;
import sets.GameEnvironment;

import java.awt.Color;

/**
 * create spirits that draw a green backGround to the level.
 */
public class GreenBackground implements Sprite {
    static final int WIDTH_GUI = 800;
    static final int HEIGHT_GUI = 600;
    static final int BORDERS = 30;
    /**
     * draw the green background.
     *
     * @param d - the surface draw on it.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.GREEN.darker());

        d.drawRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);
        d.fillRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);

        d.setColor(Color.DARK_GRAY.darker().darker());
        int x1 = BORDERS + 50;
        int x2 = BORDERS + 50 + 55;
        int y1 = HEIGHT_GUI - 200;
        int y2 = HEIGHT_GUI;
        d.fillRectangle(x1, y1, x2, y2);
        d.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(x1 + (25 * i + 10), y1 + 40 * j + 10, 15, 30);
            }
        }
        d.setColor(Color.GRAY.darker());
        d.fillRectangle(x1 + 50, y1 - 60, 35, 60);

        d.setColor(Color.GRAY);
        d.fillRectangle(x1 + 62, y1 - 250, 11, 190);

        d.setColor(Color.YELLOW.darker());
        d.fillCircle(147, 150, 15);
        d.setColor(Color.RED);
        d.fillCircle(147, 150, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(147, 150, 5);
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
