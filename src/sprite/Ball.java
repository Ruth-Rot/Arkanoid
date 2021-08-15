/**
 * @author 318770609
 */
package sprite;

import biuoop.DrawSurface;
import geometryprimitives.Line;
import geometryprimitives.Point;
import geometryprimitives.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import sets.CollisionInfo;
import sets.GameLevel;
import sets.GameEnvironment;

import java.awt.Color;

/**
 * build a ball, with a center point, radios size, color, velocity and environment.
 * the class include function that draw the ball,
 * move him on the surface in order to the borders or the environment of the ball .
 */

public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity velocity;
    private GameEnvironment environment;

    /**
     * constructor of ball, get point of the center, radios, and the color of him
     * and initializes the ball by the values that given.
     *
     * @param center - the point of the center of the ball.
     * @param r      - the radios of the ball.
     * @param color  - the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * constructor of ball, get a ball
     * and initializes the new ball by the ball that given.
     *
     * @param ball - a ball with initializes values.
     */
    public Ball(Ball ball) {
        this.center = ball.center;
        this.r = ball.r;
        this.color = ball.color;
    }

    /**
     * constructor of ball, get doubles values x and y of the of the ball center, radios, and the color of him.
     * and initializes the ball by the values that given.
     *
     * @param x     -the x value of the point of the center of the ball.
     * @param y     -the y value of the point of the center of the ball.
     * @param r     - the radios of the ball.
     * @param color - the color of the ball.
     */
    public Ball(double x, double y, int r, Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * constructor of ball, get Integers values x and y of the of the ball center, radios, and the color of him.
     * and initializes the ball by the values that given.
     *
     * @param x     -the x value of the point of the center of the ball.
     * @param y     -the y value of the point of the center of the ball.
     * @param r     - the radios of the ball.
     * @param color - the color of the ball.
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point((double) x, (double) y);
        this.r = r;
        this.color = color;
    }

    /**
     * @return the value x of the center point of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the value y  of the center point of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the size of the ball radios.
     */
    public int getSize() {
        return r;
    }

    /**
     * @return the color of the ball.
     */
    public Color getColor() {
        return color;
    }

    /**
     * set the value of velocity.
     *
     * @param v - the new velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * set the value of velocity.
     *
     * @param dx - the x value in the new velocity.
     * @param dy - the y value in the new velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }


    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface - the surface the ball drawer on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * move the ball one step in order to his velocity.
     * its also switch the velocity when the ball hit the borders of the window.
     *
     * @param width  - the width of the window.
     * @param height - the height of the window.
     */
    public void moveOneStep(double width, double height) {
        double dx = this.getVelocity().getDx(), dy = this.getVelocity().getDy();
        // switch the velocity when:
        // the x center of the ball close or less then zero and dx negative.
        if (0 >= Math.floor(this.getX()) - this.getSize() && dx < 0) {
            dx = -dx;
        }
        // the y center of the ball close or less then zero and dy negative.
        if (0 >= Math.floor(this.getY()) - this.getSize() && dy < 0) {
            dy = -dy;
        }
        // the x center of the ball close or more then the width and dx positive.
        if (Math.ceil(this.getX()) + this.getSize() >= width && dx > 0) {
            dx = -dx;
        }
        // the y center of the ball close or more then the height and dy positive.
        if (Math.ceil(this.getY()) + this.getSize() >= height && dy > 0) {
            dy = -dy;
        }
        this.setVelocity(dx, dy);
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * move the ball one step in order to his velocity.
     * its also switch the velocity when the ball hit the borders of the rectangle.
     *
     * @param startX - the x start in the window of the rectangle.
     * @param startY - the y start in the window of the rectangle.
     * @param width  - the x end in the window of the rectangle.
     * @param height - the y end in the window of the rectangle.
     */
    public void moveOneStep(double startX, double startY, double width, double height) {
        double dx = this.getVelocity().getDx(), dy = this.getVelocity().getDy();
        // switch the velocity when:
        // the x center of the ball close or less then start x and dx negative.
        if (startX >= Math.floor(this.getX()) - this.getSize() && dx < 0) {
            dx = -dx;
        }
        // the y center of the ball close or less then start y and dy negative.
        if (startY >= Math.floor(this.getY()) - this.getSize() && dy < 0) {
            dy = -dy;
        }
        // the x center of the ball close or more then the width and dx positive.
        if (Math.ceil(this.getX()) + this.getSize() >= width && dx > 0) {
            dx = -dx;
        }
        // the y center of the ball close or more then the width and dx positive.
        if (Math.ceil(this.getY()) + this.getSize() >= height && dy > 0) {
            dy = -dy;
        }
        this.setVelocity(dx, dy);
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    //extra for ex3:

    /**
     * constructor of ball.
     * build a ball with:
     *
     * @param center - the point of the ball center.
     * @param r      - the radios size.
     * @param color  - the color of the ball.
     * @param e      - the elements on the surface with the ball.
     */
    public Ball(Point center, int r, Color color, GameEnvironment e) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.environment = e;
    }

    /**
     * @return a list with the elements in surface with the ball
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * build a line with describes a line that parallel
     * to the next ball move without hit any element.
     * this line is simulator the trajectory externally according to the velocity.
     * <p>
     * this is mean that if the dx positive:
     * the x of the line will be the x of the the regular trajectory and the radios ball,
     * and less the radios ball else.
     * the y of the line will be the same.
     *
     * @return the line.
     */
    public Line trajectory() {
        //initialize the points of the line
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);

        // check dx:
        //if positive - add radios
        if (this.getVelocity().getDx() > 0) {
            start.setX(this.center.getX() + this.getSize());
            //else - reduce radios
        } else {
            start.setX(this.center.getX() - this.getSize());
        }
        // check dy:
        //if positive - add radios
        if (this.getVelocity().getDy() > 0) {
            start.setY(this.center.getY() + this.getSize());
            //else - reduce radios
        } else {
            start.setY(this.center.getY() - this.getSize());
        }

        //point after the next move
        end.setX(start.getX() + this.getVelocity().getDx());
        end.setY(start.getY() + this.getVelocity().getDy());
        //return the line
        return new Line(start, end);
    }

    /**
     * move the ball in order to his velocity and elements around it.
     * <p>
     * if the move is not cause a hit with the element in the surface-
     * move the ball on order to his regular trajectory.
     * else - get his new velocity, and move him most close to collision point it possible.
     */
    public void moveOneStep() {
        Velocity newV;
        Double x, y;

        //build the trajectory Line
        Line trajectory = trajectory();

        //get information if there a collision in the next move
        CollisionInfo info = this.environment.getClosestCollision(trajectory);
        //if there is no collision do the move
        if (info == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        // else:
        //get the new velocity in order to the hit.
        newV = info.collisionObject().hit(this, info.collisionPoint(), this.getVelocity());

        //put the ball the most close to the collision it possible:
        if (this.getVelocity().getDx() > 0) {
            x = info.collisionPoint().getX() - this.getSize();
        } else {
            x = info.collisionPoint().getX() + this.getSize();
        }
        if (this.getVelocity().getDy() > 0) {
            y = info.collisionPoint().getY() - this.getSize();
        } else {
            y = info.collisionPoint().getY() + this.getSize();
        }

        // change the velocity to the new one
        this.setVelocity(newV.getDx(), newV.getDy());
        // put the ball in his place after the move
        this.center = new Point(x, y);
    }

    @Override
    /**
     * move the ball
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * get new environment and set the ball environment to it.
     *
     * @param env - list of objects that in the surface with the ball
     */
    public void setEnvironment(GameEnvironment env) {
        this.environment = new GameEnvironment();
        for (Collidable c : env.getCollidables()) {
            this.environment.addCollidable(c);
        }
    }

    /**
     * add the ball to the sprite collection of the game.
     *
     * @param g - the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * update the ball environment after a hit.
     * in order that all the balls in the game contain the same environment.
     *
     * @param env - the update environment.
     */
    public void updateBall(GameEnvironment env) {
        this.setEnvironment(env);
    }

    /**
     * remove the ball from the game.
     *
     * @param game - game the ball removed from it.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

}