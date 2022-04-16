package baseball;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameProcessorTest {

    GameProcessor gameProcessor = new GameProcessor();

    @ParameterizedTest
    @CsvSource({"123,231,0", "532,351,1", "498,349,2"})
    void isBall_ReturnTrue_GivenArgs(String targetNum, String inputNum, int idx) {
        //when
        boolean ball = gameProcessor.isBall(targetNum, inputNum, idx);

        //then
        assertThat(ball).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"245,231,0", "532,643,1"})
    void isBall_ReturnFalse_GivenArgs(String targetNum, String inputNum, int idx) {
        //when
        boolean ball = gameProcessor.isBall(targetNum, inputNum, idx);

        //then
        assertThat(ball).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"261,253,0", "349,341,1", "419,529,2"})
    void isStrike_ReturnTrue_GivenArgs(String targetNum, String inputNum, int idx) {
        //when
        boolean strike = gameProcessor.isStrike(targetNum, inputNum, idx);

        //then
        assertThat(strike).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"461,253,0", "419,341,1", "415,529,2"})
    void isStrike_ReturnFalse_GivenArgs(String targetNum, String inputNum, int idx) {
        //when
        boolean strike = gameProcessor.isStrike(targetNum, inputNum, idx);

        //then
        assertThat(strike).isFalse();
    }

}