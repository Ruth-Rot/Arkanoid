/**
 * @author 318770609
 */
package sprite;

import biuoop.DrawSurface;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Velocity;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;
import sets.GameLevel;
import sets.GameEnvironment;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * build a block - a rectangle with color and effect on the velocity of objects that hit him
 * the block implements-
 * Collidable - that is take care and give information about the hits of object of the block.
 * Sprite - that is take care a proper game continuation order
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle rectangle;
    private Color color;

    /**
     * constructor of block, build him from the values are given.
     *
     * @param r - the rectangle of the block.
     * @param c - the color of the block.
     */
    public Block(Rectangle r, Color c) {
        this.rectangle = r;
        this.color = c;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * @return the color of the block.
     */
    public Color getColor() {
        return color;
    }


    @Override
    /**
     * return the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    /**
     * return new velocity in order to the information of the hit.
     * <p>
     * check if the hit is on the bases of the block or in the sides.
     * if it in the bases return the velocity with change in the signal of the Dy,
     * else - (the hit on the sides) return the velocity with change in the signal of the Dx.
     *
     * @param hitter          - the hit object.
     * @param collisionPoint  - the point the hit occur
     * @param currentVelocity - the velocity of the ball when it hit the collidable
     * @return the new velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        //get if the hit in the bases of the rectangle
        Boolean north = this.getCollisionRectangle().getNorth().isPointInLine(collisionPoint);
        Boolean south = this.getCollisionRectangle().getSouth().isPointInLine(collisionPoint);
        //check it:
        //if yes- return the velocity with change of the signal od the dy.
        if (north || south) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            //else- its hit on the sides, return the velocity with change of the signal od the dx.
        } else {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }

    }

    /**
     * add the block to the collection of the game.
     *
     * @param g - the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove the block from the game.
     *
     * @param game - the game the block removed from it.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    /**
     * draw the block on surface given, in order to the rectangle of the block and the color.
     */
    public void drawOn(DrawSurface d) {
        Rectangle r = this.getCollisionRectangle();
        d.setColor(this.getColor());
        d.fillRectangle((int) r.getUpperLeft().getX(),
                (int) r.getUpperLeft().getY(), (int) r.getWidth(), (int) r.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) r.getUpperLeft().getX(), (int) r.getUpperLeft().getY(),
                (int) r.getWidth(), (int) r.getHeight());
    }

    @Override
    /**
     *
     */
    public void timePassed() {

    }

    /**
     * @param hl - add this hitListener
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * @param hl -remove this hitListener
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * send to all the listeners.
     *
     * @param hitter - the ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * un used.
     *
     * @param environment - the game environment.
     */
    public void updateBall(GameEnvironment environment) {
    }
}
