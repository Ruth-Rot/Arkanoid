package geometryprimitives;
/**
 * @author 318770609
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor for Point.
     * Initializes the point by the values given.
     *
     * @param x - double value of x in the point.
     * @param y - double value of y in the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * The function calculate the distance between two points(this and other) and return it.
     *
     * @param other - the second point.
     * @return the distance between the points.
     */
    public double distance(Point other) {
        return Math.sqrt((this.x - other.x) * (this.x - other.x) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * check if the points are equal.
     *
     * @param other - the second point compared.
     * @return - a boolean : if yes return true else false.
     */
    public boolean equals(Point other) {
        // if x and y in the points are the same
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }

    /**
     * set the y in this point with the value given.
     *
     * @param yVal - the new value of y
     */
    public void setY(double yVal) {
        this.y = yVal;
    }

    /**
     * set the x in this point with the value given.
     *
     * @param xVal - the new value of y
     */
    public void setX(double xVal) {
        this.x = xVal;
    }

    /**
     * @return the x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y value of this point
     */
    public double getY() {
        return this.y;
    }
}