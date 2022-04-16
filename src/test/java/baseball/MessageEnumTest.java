package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessageEnumTest {

    @Test
    void getMessage_ReturnTrue_ResultEnumIsNOTHING() {
        //given
        MessageEnum resultEnum = MessageEnum.NOTHING;
        int ball = 0;
        int strike = 0;

        //when
        String message = resultEnum.getMessage(ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(MessageEnum.NOTHING.getMessage());
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsWIN() {
        //given
        MessageEnum resultEnum = MessageEnum.WIN;
        int ball = 0;
        int strike = GameProperties.DIGITS_OF_TARGET_NUMBER;

        //when
        String message = resultEnum.getMessage(ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.WIN.getMessage(), strike));
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsONLY_STRIKE() {
        //given
        MessageEnum resultEnum = MessageEnum.ONLY_STRIKE;
        int ball = 0;
        int strike = GameProperties.DIGITS_OF_TARGET_NUMBER - 1;

        //when
        String message = resultEnum.getMessage(ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.ONLY_STRIKE.getMessage(), strike));
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsONLY_BALL() {
        //given
        MessageEnum resultEnum = MessageEnum.ONLY_BALL;
        int ball = 2;
        int strike = 0;

        //when
        String message = resultEnum.getMessage(ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.ONLY_BALL.getMessage(), ball));
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsBALL_AND_STRIKE() {
        //given
        MessageEnum resultEnum = MessageEnum.BALL_AND_STRIKE;
        int ball = 1;
        int strike = GameProperties.DIGITS_OF_TARGET_NUMBER - 1;

        //when
        String message = resultEnum.getMessage(ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.BALL_AND_STRIKE.getMessage(), ball, strike));
    }
}