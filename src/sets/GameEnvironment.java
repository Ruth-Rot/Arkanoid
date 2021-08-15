/**
 * @author 318770609
 */
package sets;
import geometryprimitives.Line;
import geometryprimitives.Point;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * the environment of the game, contain all the object in the surface the ball can hit.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor of the environment.
     * initialized a empty list of collidables.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * constructor of the environment.
     * initialized a list of collidables and add to her
     *
     * @param blocks - add blocks collidable.
     * @param c      - and another collidable object.
     */
    public GameEnvironment(List<Collidable> blocks, Collidable c) {
        this.collidables = new ArrayList<>(blocks);
        if (c != null) {
            this.collidables.add(c);
        }
    }

    /**
     * @return the lists of the collidables objects.
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c - the collidable given.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * remove collidable from the game environment.
     *
     * @param c - the collidable removed.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory - the line checked
     * @return information on the hit
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point temp;
        CollisionInfo save = null;
        double close = 0;
        Boolean find = false;

        // go on the list, and find the close point of intersection between trajectory and objects
        for (Collidable c : this.collidables) {
            temp = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            //save the first intersection
            if (!find && temp != null) {
                save = new CollisionInfo(temp, c);
                find = true;
                close = save.collisionPoint().distance(trajectory.start());
                // if there are more save the close one
            } else if (temp != null) {
                if (close > temp.distance(trajectory.start())) {
                    save = new CollisionInfo(temp, c);
                    close = save.collisionPoint().distance(trajectory.start());
                }
            }
        }
        //return the collisionInfo - if it no occur its null
        return save;
    }
}