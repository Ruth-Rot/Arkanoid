/**
 * @author 318770609
 */
package sets;

import geometryprimitives.Point;
import interfaces.Collidable;

/**
 * build CollisionInfo - a object contain information about collision with object.
 * the information is the point of the collision, and the object hit.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor of CollisionInfo - build it by the point and object given.
     *
     * @param point  - the point of the hit.
     * @param object - the object hit.
     */
    public CollisionInfo(Point point, Collidable object) {
        this.collisionPoint = point;
        this.collisionObject = object;
    }

    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}