package baseball;

public class Game {

    public Game(String targetNum) {
        this.targetNum = targetNum;
        init();
    }

    private final String targetNum;

    private int ball;
    private int strike;

    public void init() {
        ball = 0;
        strike = 0;
    }

    public void increaseBall() {
        ball++;
    }

    public void increaseStrike() {
        strike++;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isWin() {
        return strike == GameProperties.LENGTH_OF_TARGET_NUMBER;
    }

    public String getTargetNum() {
        return targetNum;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
