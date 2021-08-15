package animations;

import backgrounds.DirectBackgroung;
import backgrounds.EasyBackground;
import backgrounds.FinalBackground;
import biuoop.DrawSurface;
import interfaces.Animation;
import levels.DirectHit;
import levels.WideEasy;

import java.awt.*;

public class StartScreen implements Animation {
    private boolean stop;

    /**
     * Constructor of the animation pause Screen.
     */
    public StartScreen() {
        this.stop = false;
    }

    /**
     * write on the screen message about the pause of the game.
     *
     * @param d - the surface the animation draw on him
     */
    public void doOneFrame(DrawSurface d) {

        int x=1,y=50;
        for(int i=0; i<5; i++){
            d.drawRectangle(x,y,150,50);
            x+=152;
        }
        x=1;
        y=102;
        for(int i=0; i<4;i++){
            d.drawRectangle(x,y,150,50);
            x+=152;
        }
        x=1;
        y=154;
        for(int i=0; i<3;i++){
            d.drawRectangle(x,y,150,50);
            x+=152;
        }

        d.drawCircle(d.getWidth()/2+10,550,5);



        d.setColor(Color.YELLOW);
        x=2;
        y=51;
        for(int i=0;i<5;i++){
            d.fillRectangle(x,y,149,49);
            x+=152;
        }

        d.setColor(Color.CYAN);
        x=2;
        y=102;
        for(int i=0;i<4;i++){
            d.fillRectangle(x,y,149,49);
            x+=152;
        }

        d.setColor(Color.PINK);
        x=2;
        y=154;
        for(int i=0;i<3;i++){
            d.fillRectangle(x,y,149,49);
            x+=152;
        }

        d.setColor(Color.GRAY);
        d.fillRectangle((d.getWidth()-180)/2,d.getHeight()-22,180,20);

        d.setColor(Color.BLACK);
        d.drawText(d.getWidth()/3, d.getHeight() / 2, "press space to start", 30);

    }

    /**
     * @return true when the animation need to stop else return true.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

