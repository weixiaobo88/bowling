package bowling;

import java.util.List;

public class NormalCalculator implements FrameCalculator {

    public int calculateScore(List<Frame> throwList, int index) {
        Frame currentFrame = throwList.get(index);
        return currentFrame.getScore();
    }
}
