package bowling;

import java.util.List;

public class StrikeCalculator implements FrameCalculator {

    public int calculateScore(List<Frame> throwList, int index) {
        Frame currentFrame = throwList.get(index);
        int score = currentFrame.getScore();
        if (isNotLastFrame(throwList, index)) {
            Frame nextFrame = getNextFrame(throwList, index);
            score += nextFrame.getScore();

            if (nextFrame.isStrike() && isBeforeSecondToLast(throwList, index)) {
                Frame nextNextFrame = getNextNextFrame(throwList, index);
                score += nextNextFrame.getFirstThrowScore();
            } else if (nextFrame.isStrike() && isSecondToLastFrame(throwList, index)) {
                score -= nextFrame.getThirdThrowScore();
            }
        }
        return score;
    }

    private boolean isBeforeSecondToLast(List<Frame> throwList, int index) {
        return index < throwList.size() - 2;
    }

    private boolean isSecondToLastFrame(List<Frame> throwList, int index) {
        return index == throwList.size() - 2;
    }

    private boolean isNotLastFrame(List<Frame> throwList, int index) {
        return index < throwList.size() - 1;
    }

    private Frame getNextNextFrame(List<Frame> throwList, int index) {
        return throwList.get(index + 2);
    }

    private Frame getNextFrame(List<Frame> throwList, int index) {
        return throwList.get(index + 1);
    }
}
