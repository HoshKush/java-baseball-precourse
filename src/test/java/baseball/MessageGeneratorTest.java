package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessageGeneratorTest {

    @Test
    void getMessage_ReturnTrue_ResultEnumIsNOTHING() {
        //given
        MessageEnum resultEnum = MessageEnum.RESULT_NOTHING;
        int ball = 0;
        int strike = 0;

        //when
        String message = MessageGenerator.generateMessage(resultEnum, ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(MessageEnum.RESULT_NOTHING.getMessage());
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsWIN() {
        //given
        MessageEnum resultEnum = MessageEnum.RESULT_WIN;
        int ball = 0;
        int strike = GameProperties.LENGTH_OF_TARGET_NUMBER;

        //when
        String message = MessageGenerator.generateMessage(resultEnum, ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.RESULT_WIN.getMessage(), strike));
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsONLY_STRIKE() {
        //given
        MessageEnum resultEnum = MessageEnum.RESULT_ONLY_STRIKE;
        int ball = 0;
        int strike = GameProperties.LENGTH_OF_TARGET_NUMBER - 1;

        //when
        String message = MessageGenerator.generateMessage(resultEnum, ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.RESULT_ONLY_STRIKE.getMessage(), strike));
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsONLY_BALL() {
        //given
        MessageEnum resultEnum = MessageEnum.RESULT_ONLY_BALL;
        int ball = 2;
        int strike = 0;

        //when
        String message = MessageGenerator.generateMessage(resultEnum, ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.RESULT_ONLY_BALL.getMessage(), ball));
    }

    @Test
    void getMessage_ReturnTrue_ResultEnumIsBALL_AND_STRIKE() {
        //given
        MessageEnum resultEnum = MessageEnum.RESULT_BALL_AND_STRIKE;
        int ball = 1;
        int strike = GameProperties.LENGTH_OF_TARGET_NUMBER - 1;

        //when
        String message = MessageGenerator.generateMessage(resultEnum, ball, strike);
        System.out.println("message = " + message);

        //then
        assertThat(message).isEqualTo(String.format(MessageEnum.RESULT_BALL_AND_STRIKE.getMessage(), ball, strike));
    }
}