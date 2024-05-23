package bowling;

import java.util.List;

public class StrikeCalculator implements FrameCalculator {
    private int calculateScoreForStrike(List<Frame> throwList, int index) {
        Frame currentFrame = throwList.get(index);
        int score = currentFrame.getScore();
        if (index < throwList.size() - 1) {
            Frame nextFrame = throwList.get(index + 1);
            score += nextFrame.getScore();

            if (nextFrame.isStrike() && (index < throwList.size() - 2)) {
                Frame nextNextFrame = throwList.get(index + 2);
                score += nextNextFrame.getFirstThrowScore();
            } else if (nextFrame.isStrike() && (index == throwList.size() - 2)) {
                score -= nextFrame.getThirdThrowScore();
            }
        }
        return score;
    }

    public int calculateScore(List<Frame> throwList, int index) {
        return calculateScoreForStrike(throwList, index);
    }
}
