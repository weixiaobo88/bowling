package bowling;

import java.util.List;

public class Game {

    public int calculateScore(List<Frame> throwList) {
        int score = 0;

        for (Frame currentFrame : throwList) {
            int index = throwList.indexOf(currentFrame);
            if (currentFrame.isStrike()) {
                score += new StrikeCalculator().calculateScore(throwList, index);
            } else if (currentFrame.isSpare()) {
                score += new SpareCalculator().calculateScore(throwList, index);
            } else {
                score += calculateScoreForNormal(throwList, index);
            }
        }

        return score;
    }

    private int calculateScoreForNormal(List<Frame> throwList, int index) {
        Frame currentFrame = throwList.get(index);
        return currentFrame.getScore();
    }

}
