/**
 * @author 318770609
 */
package sets;
import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * collection of all the object implement sprite.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * constructor of empty sprite list.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * add sprite to the sprite collection.
     *
     * @param s - the added sprite.
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * remove sprite from the sprite collection.
     *
     * @param s - remove the sprite from the collection.
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }

    /**
     * call to function timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<>(this.spriteList);
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }

    /**
     * update the balls environments.
     *
     * @param environment - the update environment.
     */
    public void updateBallForAll(GameEnvironment environment) {
        List<Sprite> sprites = new ArrayList<>(this.spriteList);
        for (Sprite s : sprites) {
            s.updateBall(environment);
        }
    }

    /**
     * call to function drawOn(d) on all sprites.
     *
     * @param d - the draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.spriteList) {
            s.drawOn(d);
        }
    }
}