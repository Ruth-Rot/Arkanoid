/**
 * @author 318770609
 */

import animations.FinalScreen;
import animations.KeyPressStoppableAnimation;
import animations.StartScreen;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import levels.DirectHit;
import levels.FinalFour;
import levels.Green3;
import levels.WideEasy;
import animations.AnimationRunner;
import sets.Counter;
import sets.GameFlow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class start a game.
 * the levels can be on an order that the player input or by a fixed order.
 */
public class Ass6Game {
    static final int WIDTH_GUI = 800;
    static final int HEIGHT_GUI = 600;
    static final String DIRECT = "1";
    static final String WIDE = "2";
    static final String GREEN = "3";
    static final String FINAL = "4";
    static final String EMPTY_ARGS = "${args}";
    static File highScore;

    /**
     * The main start a game,
     * if its get in args array run teh game with level organize as un args.
     * else run it with four level by their difficulties.
     *
     * @param args - to organize of levels
     */
    public static void main(String[] args) throws FileNotFoundException {
        List<LevelInformation> levels = new ArrayList<>();
        //check if the args contain levels-
        String get = "";
        for (String s : args) {
            get = get + s;
        }
        // organize the levels by the input order:
        if (!get.equals(EMPTY_ARGS)) {
            if (args.length > 0) {
                for (String s : args) {
                    if (s.equals(DIRECT)) {
                        levels.add(new DirectHit());
                    } else if (s.equals(WIDE)) {
                        levels.add(new WideEasy());
                    } else if (s.equals(GREEN)) {
                        levels.add(new Green3());
                    } else if (s.equals(FINAL)) {
                        levels.add(new FinalFour());
                    }
                }
            } else {
                levels.add(new Green3());
                levels.add(new WideEasy());
                levels.add(new Green3());
                levels.add(new FinalFour());
            }
        } else {
            levels.add(new Green3());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());
        }


        GUI gui = new GUI("Arkanoid", WIDTH_GUI, HEIGHT_GUI);
        AnimationRunner runner = new AnimationRunner(gui);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        Counter score = new Counter();

        /*start Screen*/
        StartScreen start= new StartScreen();
        AnimationRunner r = new AnimationRunner(gui);
        r.run(new KeyPressStoppableAnimation(keyboardSensor,keyboardSensor.SPACE_KEY, start));


        //read the highScore :
        int hS = 0;
        try {
            highScore = new File("highscore.txt");
            if (!highScore.createNewFile()) {
                FileInputStream fReader = new FileInputStream(highScore);
                InputStreamReader iReader = new InputStreamReader(fReader, "UTF8");
                BufferedReader reader = new BufferedReader(iReader);
                String before = reader.readLine();
                hS = Integer.parseInt(before);

                // start a game:
                GameFlow flow = new GameFlow(runner, keyboardSensor, gui, score ,hS);
                flow.runLevels(levels);

                if (hS <  score.getValue()) { //update the highScore in the end
                    String string;
                    string = String.valueOf(score.getValue());
                    try {
                        FileWriter fWriter = new FileWriter(highScore);
                        fWriter.write(string);
                        fWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui.close();
    }
}