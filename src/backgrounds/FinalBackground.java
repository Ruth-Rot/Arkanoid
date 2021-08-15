/**
 * @author 318770609
 */
package backgrounds;

import biuoop.DrawSurface;
import interfaces.Sprite;
import sets.GameEnvironment;

import java.awt.Color;

/**
 * create spirits that draw a rainy backGround to the level.
 */
public class FinalBackground implements Sprite {
    static final int WIDTH_GUI = 800;
    static final int HEIGHT_GUI = 600;
    static final int BORDERS = 30;
    /**
     * draw the rainy background.
     *
     * @param d - the surface draw on it.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0, 168, 249));

        d.drawRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);
        d.fillRectangle(0, 0, WIDTH_GUI, HEIGHT_GUI);

        d.setColor(Color.WHITE);
        int drawLine = 150;
        while (drawLine < 270) {
            drawLine = drawLine + 10;
            d.drawLine(drawLine, 350, drawLine - 20, HEIGHT_GUI);
            d.drawLine(drawLine + 400, 400, drawLine + 400 - 20, HEIGHT_GUI);
        }
        d.setColor(new Color(210, 210, 210));
        d.fillCircle(170, 350, 30);
        d.fillCircle(570, 400, 30);
        d.fillCircle(200, 380, 35);
        d.fillCircle(600, 430, 35);

        d.setColor(new Color(180, 180, 180));
        d.fillCircle(215, 340, 34);
        d.fillCircle(615, 390, 34);

        d.setColor(new Color(165, 165, 165));
        d.fillCircle(240, 390, 30);
        d.fillCircle(640, 440, 30);
        d.fillCircle(260, 350, 35);
        d.fillCircle(660, 400, 35);
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
