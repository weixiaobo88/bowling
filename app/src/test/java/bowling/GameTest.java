package bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GameTest {
  private static final int TOTAL_FRAMES = 10;

  @Test
  void test_all_strikes_with_11th_frame_10_and_12th_frame_10() {
    Game game = new Game();
    List<Frame> throwList = new ArrayList<>();
    for (int i = 0; i < TOTAL_FRAMES; i++) {
      if (i == TOTAL_FRAMES - 1) {
        throwList.add(new Frame(10, 10, 10));
      } else {
        throwList.add(new Frame(10, 0));
      }
    }

    int score = game.calculateScore(throwList); 
    
    assertEquals(300, score);
  }

  @Test
  void test_strikes_with_some_normal_frames() {
    Game game = new Game();
    List<Frame> throwList = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      throwList.add(new Frame(10, 0));
    }
    throwList.add(new Frame(4, 5)); 
    throwList.add(new Frame(10, 10, 10)); 
    
    int score = game.calculateScore(throwList);

    assertEquals(262, score);
  }

  @Test
  void test_all_spares_with_11th_frame_5_and_12th_frame_5() {
    Game game = new Game();
    List<Frame> throwList = new ArrayList<>();
    for (int i = 0; i < TOTAL_FRAMES; i++) {
      if (i == TOTAL_FRAMES - 1) {
        throwList.add(new Frame(5, 5, 5));
      } else {
        throwList.add(new Frame(5, 5));
      }
    }

    int score = game.calculateScore(throwList);

    assertEquals(150, score);
  }

    @Test
    void test_all_normal_frames() {
        Game game = new Game();
        List<Frame> throwList = new ArrayList<>();
        for (int i = 0; i < TOTAL_FRAMES; i++) {
            throwList.add(new Frame(4, 4));
        }

        int score = game.calculateScore(throwList);

        assertEquals(80, score);
    }

}
