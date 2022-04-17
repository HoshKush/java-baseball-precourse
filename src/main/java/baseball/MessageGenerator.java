package baseball;

public class MessageGenerator {
    public static String generateMessage(MessageEnum messageEnum, int ball, int strike) {
        if(messageEnum.getCode().equals(MessageEnum.RESULT_WIN.getCode())) {
            return String.format(messageEnum.getMessage(), strike);
        }
        if(messageEnum.getCode().contains(MessageEnum.PLAIN_TEXT.getCode())) {
            return messageEnum.getMessage();
        }
        return ballOrStrike(ball, strike);
    }

    private static String ballOrStrike(int ball, int strike) {
        StringBuilder message = new StringBuilder();
        if(ball > 0) {
            message.append(String.format(MessageEnum.RESULT_ONLY_BALL.getMessage(), ball));
        }
        if(strike > 0) {
            message.append(String.format(" " + MessageEnum.RESULT_ONLY_STRIKE.getMessage(), strike));
        }

        return message.toString().trim();
    }
}
