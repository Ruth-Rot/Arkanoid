package geometryprimitives;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 318770609
 */

public class Line {
    private Point start;
    private Point end;

    /**
     * Constructor of line, get two points start anf end.
     * and initializes the line by the points that given.
     *
     * @param start - the start point of the line.
     * @param end   - the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor of line, get four double values.
     * and initializes the line by build a points of start and end by them.
     *
     * @param x1 - the x value in the start point of the line.
     * @param y1 - the y value in the start point of the line.
     * @param x2 - the x value in the end point of the line.
     * @param y2 - the y value in the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * calculate the length of the line and return it.
     *
     * @return value of the length of the line.
     */
    public double length() {
        double x1 = this.start.getX(), x2 = this.end.getX(), y1 = this.start.getY(), y2 = this.end.getY();
        return Math.cbrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 * y2)));
    }

    /**
     * calculate the middle point of the line and return it.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * calculate the incline between two points.
     *
     * @param a - the first point.
     * @param b - the second point.
     * @return - the value of incline.
     */
    private double incline(Point a, Point b) {
        if (a.getY() - b.getY() == 0) {
            return 0;
        }
        // cant divide by zero
        if (a.getX() - b.getX() != 0) {
            return (a.getY() - b.getY()) / (a.getX() - b.getX());
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    /**
     * calculate the b value in the straight equation.
     *
     * @param m - the incline of the straight equation.
     * @param a - the coefficient of the incline in the straight equation..
     * @return the valve of b.
     */
    private double findB(double m, Point a) {
        return a.getY() - m * a.getX();
    }

    /**
     * check if the point is in the range of the two lines.
     *
     * @param l1 - one of the lines.
     * @param l2 - second of the lines.
     * @param p  - the point
     * @return - true if the point in the range of both lines,
     * else false.
     */
    private boolean isInRange(Line l1, Line l2, Point p) {
        //if the point is not in range of line l1
        if (!isPointInLine(l1, p)) {
            return false;
        }
        //if the point is not in range of line l2
        if (!isPointInLine(l2, p)) {
            return false;
        }
        return true;
    }

    /**
     * check if the point can be in the line.
     *
     * @param l - a line.
     * @param p - a point.
     * @return true if yes, else false.
     */
    private boolean isPointInLine(Line l, Point p) {
        //check if x in the point bigger then the max value of x in the line
        if (p.getX() > Math.max(l.start.getX(), l.end.getX())) {
            return false;
        }
        //check if x in the point little then the min value of x in the line
        if (p.getX() < Math.min(l.start.getX(), l.end.getX())) {
            return false;
        }
        //if y in the point bigger then the max value of y in the line
        if (p.getY() > Math.max(l.start.getY(), l.end.getY())) {
            return false;
        }
        //if y in the point little then the min value of y in the line
        if (p.getY() < Math.min(l.start.getY(), l.end.getY())) {
            return false;
        }
        return true;
    }

    /**
     * check if the lines intersect.
     *
     * @param other - the other line.
     * @return return true if yes, else false.
     */
    public boolean isIntersecting(Line other) {
        //if the intersection point of the lines is null
        if (this.intersectionWith(other) != null) {
            return true;
        }
        return false;
    }

    /**
     * calculate the intersection point between two lines.
     *
     * @param other - the second line.
     * @return the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double x, y, b;
        // get the incline of both lines.
        double m1 = incline(this.start, this.end), m2 = incline(other.start, other.end);

        // check if the inclines not equals.
        if (m1 != m2) {
            //calculate the intersection:
            //when one of the lines isn"t have incline
            if (m1 == Double.POSITIVE_INFINITY) { //when this line isn"t have incline
                x = this.start.getX();
                b = findB(m2, other.start);
                y = x * m2 + b;
            } else if (m2 == Double.POSITIVE_INFINITY) { //when other line isn"t have incline
                x = other.start.getX();
                b = findB(m1, this.start);
                y = x * m1 + b;
            } else if (m1 == 0) {
                y = this.start.getY();
                b = findB(m2, other.start);
                x = (y - b) / m2;
            } else if (m2 == 0) {
                y = other.start.getY();
                b = findB(m1, this.start);
                x = (y - b) / m1;
            } else {
                // find the point
                double b1 = findB(m1, this.start), b2 = findB(m2, other.start);
                x = (b2 - b1) / (m1 - m2);
                y = m1 * x + b1;
            }
            Point p = new Point(x, y);
            //check if the point is in the range of the lines.
            if (isInRange(this, other, p)) {
                return p;
            }
            return null;
        }
        // if the inclines equals and the sides points of the lines is meet:
        if (this.start.equals(other.start)) {
            return this.start;
        }
        if (this.end.equals(other.start)) {
            return this.end;
        }
        if (this.start.equals(other.end)) {
            return this.start;
        }
        if (this.end.equals(other.end)) {
            return this.end;
        }
        //if one of the line is a point:
        if (this.start.equals(this.end) && isPointInLine(other, this.start)) {
            return this.start;
        }
        if (other.start.equals(other.end) && isPointInLine(this, other.start)) {
            return other.start;
        }
        return null;
    }

    /**
     * check if the lines equals.
     *
     * @param other - the other line.
     * @return - true if yes, else false.
     */
    public boolean equals(Line other) {
        // if the starts and ends of both lines equal
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        // if the start and end of one line equal to the end and start of the other
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;
    }

    //extra for ex3:

    /**
     * return true of the point in this line, else false.
     * by use the function isPointInLine that get line and point
     *
     * @param p - the point check
     * @return true if yes, else false
     */
    public boolean isPointInLine(Point p) {
        return isPointInLine(this, p);
    }

    /**
     * find the closet point
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect - the rectangle check
     * @return a point of intersection.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // build the lines of the rectangle sides by the points
        Line north = rect.getNorth();
        Line east = rect.getEast();
        Line south = rect.getSouth();
        Line west = rect.getWest();

        // check if exist intersection point between the line anf the rectangle, if not return null
        if (!this.isIntersecting(north) && !this.isIntersecting(east)
                && !this.isIntersecting(south) && !this.isIntersecting(west)) {

            return null;
        }
        // if yes: find the close one:

        // build List of intersection points
        List<Point> intrectionsP = new ArrayList<>();

        // insert all the intersection points
        if (this.isIntersecting(north)) {
            intrectionsP.add(this.intersectionWith(north));
        }
        if (this.isIntersecting(east)) {
            intrectionsP.add(this.intersectionWith(east));
        }
        if (this.isIntersecting(south)) {
            intrectionsP.add(this.intersectionWith(south));
        }
        if (this.isIntersecting(west)) {
            intrectionsP.add(this.intersectionWith(west));
        }

        Point close = intrectionsP.get(0);
        intrectionsP.remove(0);
        // find the closed point to the start of the line
        while (!intrectionsP.isEmpty()) {
            if (this.start.distance(close) > this.start.distance(intrectionsP.get(0))) {
                close = intrectionsP.get(0);
            }
            intrectionsP.remove(0);
        }
        return close;
    }
}
