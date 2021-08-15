/**
 * @author 318770609
 */
package geometryprimitives;

import java.util.ArrayList;
import java.util.List;

/**
 * create Rectangle and functions support its.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor of rectangle.
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft - the location.
     * @param width     - the width of the rectangle.
     * @param height    -   the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * @return the north west point of the rectangle.
     */
    public Point getA() {
        return this.getUpperLeft();
    }

    /**
     * @return the north east point of the rectangle.
     */
    public Point getB() {
        return new Point(getA().getX() + getWidth(), getA().getY());
    }

    /**
     * @return the south west point of the rectangle.
     */
    public Point getD() {
        return new Point(getA().getX(), getA().getY() + getHeight());
    }

    /**
     * @return the south east point of the rectangle.
     */
    public Point getC() {
        return new Point(getB().getX(), getD().getY());
    }

    /**
     * @return a line which is the north rib.
     */
    public Line getNorth() {
        return new Line(getA(), getB());
    }

    /**
     * @return a line which the east rib.
     */
    public Line getEast() {
        return new Line(getB(), getC());
    }

    /**
     * @return a line which the west rib.
     */
    public Line getWest() {
        return new Line(getA(), getD());
    }

    /**
     * @return a line which the south rib.
     */
    public Line getSouth() {
        return new Line(getD(), getC());
    }

    /**
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line - the line that tested
     * @return list of the intersection points of every rib with the line
     */
    public List<Point> intersectionPoints(Line line) {
        //build list of points
        List<Point> intersectionPoints = new ArrayList<Point>();
        //check and add every intersection point of the line and the rectangle ribs
        if (line.isIntersecting(getNorth())) {
            intersectionPoints.add(line.intersectionWith(getNorth()));
        }
        if (line.isIntersecting(getEast())) {
            intersectionPoints.add(line.intersectionWith(getEast()));
        }
        if (line.isIntersecting(getSouth())) {
            intersectionPoints.add(line.intersectionWith(getSouth()));
        }
        if (line.isIntersecting(getWest())) {
            intersectionPoints.add(line.intersectionWith(getWest()));
        }
        return intersectionPoints;
    }

    /**
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * change the location of the rectangle by set its upperLeft point, by the point given.
     *
     * @param p - the new location point
     */
    public void setPlace(Point p) {
        this.upperLeft = p;
    }
}