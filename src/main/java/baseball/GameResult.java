package baseball;

public class GameResult {
    private String code;
    private String message;
    private int ball;
    private int strike;

    public static GameResult create(MessageEnum resultEnum, int ball, int strike) {
        GameResult gameResult = new GameResult();
        gameResult.setCode(resultEnum.getCode());
        gameResult.setMessage(resultEnum.getMessage(ball, strike));
        gameResult.setBall(ball);
        gameResult.setStrike(strike);

        return gameResult;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
