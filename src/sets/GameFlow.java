/**
 * @author 318770609
 */
package sets;

import animations.AnimationRunner;
import animations.FinalScreen;
import animations.KeyPressStoppableAnimation;
import animations.StartScreen;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import java.util.List;

/**
 * game flow is response on the levels flow on by one and action in case of win or lose.
 */
public class GameFlow {
    private biuoop.KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    private Counter score;
    private int hS;

    /**
     * constructor of the game flow.
     * initialize:
     *
     * @param ar  - the runner animations.
     * @param ks  - the keyboard Sensor.
     * @param gui - the Gui surface.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui,Counter score,int h) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.score = score;
        this.hS =h;
    }

    /**
     * run the levels one by one.
     * action when the player win or lose.
     *
     * @param levels - the levels list.
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner, this.gui, score,this.hS);
            level.initialize();
            while (!level.shouldStop()) {
                level.run();
            }
            if (level.isLose()) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, new FinalScreen(false, this.score.getValue())));
                return;
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                KeyboardSensor.SPACE_KEY, new FinalScreen(true, this.score.getValue())));
        return;
    }

}