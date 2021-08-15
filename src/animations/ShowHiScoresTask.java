package animations;

import interfaces.Animation;
import interfaces.Task;

public class ShowHiScoresTask implements Task<Void> {
   private AnimationRunner runner;
   private Animation highScoresAnimation;
   public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation) {
      this.runner = runner;
      this.highScoresAnimation = highScoresAnimation;
   }
   public Void run() {
      this.runner.run(this.highScoresAnimation);
      return null;
   }
}