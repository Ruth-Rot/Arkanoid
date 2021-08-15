/**
 * @author 318770609
 */
package interfaces;

import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Velocity;
import sprite.Ball;

/**
 * this interface contain function that handle a hit between objects.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return the rectangle of the object hit
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  - the point the hit occur
     * @param currentVelocity - the velocity of the ball when it hit the collidable
     * @param hitter          - the hit object.
     * @return the new velocity of the ball
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}