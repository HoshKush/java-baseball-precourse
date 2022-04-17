package baseball;

public enum MessageEnum {
    /**
     * A : 문장에 어떠한 값도 필요 없음(평문출력)
     * B : 문장에 Ball 값 필요(int ball)
     * I : 사용자의 명령어 입력 필요.
     * S : 문장에 Strike 값 필요(int strike)
     * Q : 종료
     * W : 게임 승리
     */

    PLAIN_TEXT("A", "평문출력"),

    COMMAND_NEW_GAME("1", "새게임"),
    COMMAND_QUIT("2", "게임 종료"),

    PROGRESS_GAME_START("A", "게임을 시작합니다"),
    PROGRESS_INPUT_NUMBER("I", "숫자를 입력해주세요: "),
    PROGRESS_NEW_GAME_OR_QUIT("I", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    PROGRESS_QUIT("Q", "게임을 종료합니다."),

    RESULT_NOTHING("A", "낫싱"),
    RESULT_WIN("W", String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", GameProperties.LENGTH_OF_TARGET_NUMBER)),
    RESULT_BALL_AND_STRIKE("BS", "%d볼 %d스트라이크"),
    RESULT_ONLY_BALL("B", "%d볼"),
    RESULT_ONLY_STRIKE("S", "%d스트라이크")
    ;

    private final String code;
    private final String message;

    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return this.code;
    }


}
