package baseball;

public enum MessageEnum {
    WIN("000", String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", GameProperties.DIGITS_OF_TARGET_NUMBER)),
    BALL_AND_STRIKE("100", "%d볼 %d스트라이크"),
    ONLY_BALL("100", "%d볼"),
    ONLY_STRIKE("100", "%d스트라이크"),
    NOTHING("200", "낫싱")
    ;

    private final String code;
    private final String message;

    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage(int ball, int strike) {
        if(code.equals(MessageEnum.WIN.code)) {
            return String.format(this.message, strike);
        }
        if(code.equals(MessageEnum.NOTHING.code)) {
            return this.message;
        }
        return ballOrStrike(ball, strike);
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return this.code;
    }

    private String ballOrStrike(int ball, int strike) {
        StringBuilder message = new StringBuilder();
        if(ball > 0) {
            message.append(String.format(ONLY_BALL.message, ball));
        }
        if(strike > 0) {
            message.append(String.format(" " + ONLY_STRIKE.message, strike));
        }

        return message.toString().trim();
    }
}
