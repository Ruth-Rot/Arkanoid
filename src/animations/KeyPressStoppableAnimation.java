/**
 * @author 318770609
 */
package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * KeyPressStoppableAnimation collect all the key press animations and activate them.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Constractor - initialize the needed variables.
     *
     * @param sensor    - the keyboard sensor.
     * @param key       - the key to stop.
     * @param animation - the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }


    /**
     * write on the screen message needed and stop the animation when needed.
     *
     * @param d - the surface the animation draw on him
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            isAlreadyPressed = false;
        }
    }

    /**
     * @return true when the animation need to stop else return true.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}