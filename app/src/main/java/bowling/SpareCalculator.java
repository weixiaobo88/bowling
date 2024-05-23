package bowling;

import java.util.List;

public class SpareCalculator implements FrameCalculator {

    public int calculateScore(List<Frame> throwList, int index) {
        Frame currentFrame = throwList.get(index);
        int score = currentFrame.getScore();
        if (index < throwList.size() - 1) {
            Frame nextFrame = throwList.get(index + 1);
            score += nextFrame.getFirstThrowScore();
        }
        return score;
    }
}
