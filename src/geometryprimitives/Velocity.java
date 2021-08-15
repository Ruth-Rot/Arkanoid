/**
 * @author 318770609
 */

package geometryprimitives;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    // constructor:

    /**
     * Constructor of velocity, get two doubles values the steps that ball center do in every move.
     * and initializes the velocity by the values that given.
     *
     * @param dx - the steps that x move.
     * @param dy - the steps that y move.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Constructor of velocity, get values of angle and speed of the steps that ball center do in every move.
     * calculate dx and dy, initializes the velocity by the values that given.
     * and return the velocity.
     *
     * @param angle - the angle of the vector.
     * @param speed - the speed of the vector.
     * @return the velocity accepted.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians((angle)));
        double dy = speed * Math.cos(Math.toRadians((angle)));
        return new Velocity(dx, -dy);
    }

    // accessors:

    /**
     * calculate the speed of the velocity by Pythagoras.
     *
     * @return the speed of velocity.
     */
    public Double getSpeed() {
        Double speed = Math.sqrt(Math.pow(this.dy, 2) + Math.pow(this.dx, 2));
        return speed;
    }

    /**
     * @return dx -  the steps the ball do every move in x.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return dy -  the steps the ball do every move in y.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * move the center point to the next point in order the velocity of the ball.
     *
     * @param p - the center point of the ball.
     * @return the new position of the point.
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }
}