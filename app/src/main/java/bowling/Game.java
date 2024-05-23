package bowling;

import java.util.List;

public class Game {
    private FrameCalculator buildFrameCalculator(List<Frame> throwList, int index) {
        Frame currentFrame = throwList.get(index);
        if (currentFrame.isStrike()) {
            return new StrikeCalculator();
        } else if (currentFrame.isSpare()) {
            return new SpareCalculator();
        } else {
            return new NormalCalculator();
        }
    }

    public int calculateScore(List<Frame> throwList) {
        int score = 0;

        for (Frame currentFrame : throwList) {
            int index = throwList.indexOf(currentFrame);
            score += buildFrameCalculator(throwList, index).calculateScore(throwList, index);
        }

        return score;
    }
}
