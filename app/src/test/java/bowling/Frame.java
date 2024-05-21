package bowling;

public class Frame {
  private static final int SCORE_OF_NO_THIRD_THROW = 0;
  private static final int SCORE_OF_STRIKE = 10;
  private static final int SCORE_OF_SPARE = 10;
  private int firstThrow;
  private int secondThrow;
  private Integer thirdThrow;

  public Frame(int firstThrow, int secondThrow) {
    this.firstThrow = firstThrow;
    this.secondThrow = secondThrow;
  }

  public Frame(int firstThrow, int secondThrow, Integer thirdThrow) {
    this.firstThrow = firstThrow;
    this.secondThrow = secondThrow;
    this.thirdThrow = thirdThrow;
  }

  public boolean isStrike() {
    return firstThrow == SCORE_OF_STRIKE || secondThrow == SCORE_OF_STRIKE;
  }

  public int getScore() {
    return firstThrow + secondThrow + (thirdThrow == null ? SCORE_OF_NO_THIRD_THROW : thirdThrow);
  }

  public int getFirstThrowScore() {
    return firstThrow;
  }

  public boolean isSpare() {
    return firstThrow + secondThrow == SCORE_OF_SPARE;
  }

}
