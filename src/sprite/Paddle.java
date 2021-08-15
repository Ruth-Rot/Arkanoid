/**
 * @author 318770609
 */
package sprite;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometryprimitives.Line;
import geometryprimitives.Rectangle;
import geometryprimitives.Point;
import geometryprimitives.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import sets.GameLevel;
import sets.GameEnvironment;

import java.awt.Color;

/**
 * build a paddle from rectangle, color, and keyboard sensor.
 * <p>
 * it contain functions that draw it, make it move on the screen in order to the keyboard,
 * return velocity in order to place of the hit and more.
 */
public class Paddle implements Collidable, Sprite {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int rightBorder;
    private int leftBorder;
    private int speed;

    /**
     * constructor of paddle.
     * build new paddle and initialize this variables.
     *
     * @param r        - rectangle.
     * @param color    - the color of the paddle.
     * @param left     - the border of paddle in the left.
     * @param right    - the border of paddle in the right.
     * @param keyboard - the sensor give information about the keyboard.
     * @param speed    - the speed of the paddle.
     */
    public Paddle(Rectangle r, Color color, int left, int right, biuoop.KeyboardSensor keyboard, int speed) {
        this.rectangle = r;
        this.color = color;
        this.rightBorder = right;
        this.leftBorder = left;
        this.keyboard = keyboard;
        this.speed = speed;
    }

    // Sprite:
    @Override
    /**
     * draw the paddle in its and place of its rectangle and fill it by the color of the paddle
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    @Override
    /**
     * check every call if the keyboard move the paddle,
     * and move it according.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * move the paddle left,according to the border of the screen.
     */
    public void moveLeft() {
        if (rectangle.getA().getX() > this.leftBorder) {
            if (rectangle.getA().getX() - speed > this.leftBorder) {
                this.rectangle.setPlace(new Point(this.rectangle.getUpperLeft().getX() - speed,
                        this.rectangle.getUpperLeft().getY()));
            } else {
                this.rectangle.setPlace(new Point(this.leftBorder + 1,
                        this.rectangle.getUpperLeft().getY()));
            }
        }
    }

    /**
     * move the paddle right ,according to the border of the screen.
     */
    public void moveRight() {
        if (rectangle.getB().getX() < this.rightBorder) {
            if (rectangle.getB().getX() + speed < this.rightBorder) {
                this.rectangle.setPlace(new Point(this.rectangle.getUpperLeft().getX() + speed,
                        this.rectangle.getUpperLeft().getY()));
            } else {
                this.rectangle.setPlace(new Point(this.rightBorder - 1 - this.rectangle.getWidth(),
                        this.rectangle.getUpperLeft().getY()));

            }
        }
    }


    // Collidable
    @Override
    /**
     * return the rectangle of the paddle
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    @Override
    /**
     * return new velocity in order to the place of the hit on the paddle.
     *
     * the paddle is divided to 5 equal area, and every area return diffrent velocity:
     * (from the left to right)
     * area 1 - return velocity of angle =300
     * area 2 - return velocity of angle =330
     * area 3 - return the currentVelocity with change of the signal of dy
     * area 4 - return velocity of angle =30
     * area 5 - return velocity of angle =60
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //situation that the ball came from the floor of the game
        if (currentVelocity.getDy() < 0) {
            return currentVelocity;
        }

        //sort the paddle to five areas:
        Line area1, area2, area3, area4, area5;
        Velocity newVelocity = null;
        area1 = new Line(this.rectangle.getA(),
                new Point(this.rectangle.getA().getX() + (this.rectangle.getWidth() / 5),
                        this.rectangle.getA().getY()));
        area2 = new Line(new Point(area1.end().getX() + 1, area1.end().getY()),
                new Point(this.rectangle.getA().getX() + (2 * (this.rectangle.getWidth() / 5)),
                        this.rectangle.getA().getY()));
        area3 = new Line(new Point(area2.end().getX() + 1, area1.end().getY()),
                new Point(this.rectangle.getA().getX() + (3 * (this.rectangle.getWidth() / 5)),
                        this.rectangle.getA().getY()));
        area4 = new Line(new Point(area3.end().getX() + 1, area1.end().getY()),
                new Point(this.rectangle.getA().getX() + (4 * (this.rectangle.getWidth() / 5)),
                        this.rectangle.getA().getY()));
        area5 = new Line(new Point(area4.end().getX() + 1, area1.end().getY()), this.rectangle.getB());

        //check in which area the ball hit and return the velocity in order to the fun roles
        if (area1.isPointInLine(collisionPoint)) {
            newVelocity = Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        } else if (area2.isPointInLine(collisionPoint)) {
            newVelocity = Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
        } else if (area3.isPointInLine(collisionPoint)) {
            newVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else if (area4.isPointInLine(collisionPoint)) {
            newVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        } else if (area5.isPointInLine(collisionPoint)) {
            newVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        } else {
            newVelocity = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            //situation that the ball hit the sides
        }
        return newVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g - the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * un used.
     *
     * @param environment - the game update environment.
     */
    public void updateBall(GameEnvironment environment) {
    }
}

