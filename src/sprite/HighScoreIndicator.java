package sprite;

import biuoop.DrawSurface;
import interfaces.Sprite;
import sets.GameEnvironment;

import java.awt.*;

public class HighScoreIndicator implements Sprite {
    private int hS;
    public HighScoreIndicator(int h){
        this.hS=h;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(80, 15, "High Score: " + this.hS, 15);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void updateBall(GameEnvironment environment) {

    }
}
