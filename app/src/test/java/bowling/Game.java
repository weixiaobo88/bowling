package bowling;

import java.util.List;

public class Game {

  public int calculateScore(List<Frame> throwList) {
    int score = 0;

    for (Frame currentFrame : throwList) {
      int index = throwList.indexOf(currentFrame);
      if (currentFrame.isStrike()) {
        score += calculateScoreForStrike(throwList, currentFrame, index);
      } else if (currentFrame.isSpare()) {
        score += calculateScoreForSpare(throwList, currentFrame, index);
      }
    }

    return score;
  }

  private int calculateScoreForStrike(List<Frame> throwList, Frame currentFrame, int index) {
    int score = currentFrame.getScore();
    if (index < throwList.size() - 2) {
      Frame nextFrame = throwList.get(index + 1);
      score += nextFrame.getScore();
      if (nextFrame.isStrike()) {
        Frame nextNextFrame = throwList.get(index + 2);
        score += nextNextFrame.getScore();
      }
    }
    return score;
  }
  private int calculateScoreForSpare(List<Frame> throwList, Frame currentFrame, int index) {
    int score = currentFrame.getScore();
    if (index < throwList.size() - 1) {
      Frame nextFrame = throwList.get(index + 1);
      score += nextFrame.getFirstThrowScore();
    }
    return score; 
  }
}
