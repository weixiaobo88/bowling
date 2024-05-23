package bowling;

import java.util.List;

public class NormalCalculator {
    int calculateScoreForNormal(List<Frame> throwList, int index) {
        Frame currentFrame = throwList.get(index);
        return currentFrame.getScore();
    }

    public int calculateScore(List<Frame> throwList, int index) {
       return calculateScoreForNormal(throwList, index);
    }
}
