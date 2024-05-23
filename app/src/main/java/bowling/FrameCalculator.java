package bowling;

import java.util.List;

public interface FrameCalculator {
    int calculateScore(List<Frame> throwList, int index);
}
