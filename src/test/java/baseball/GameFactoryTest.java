package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class GameFactoryTest {

    GameFactory gameFactory = new GameFactory();

    @Test
    void generateNumberStr_EachDigitIsUnique_NoArgs() {
        //when
        String number = gameFactory.generateNumberStr();

        //then
        assertThat(number).containsOnlyDigits();
    }

    @Test
    void generateNumberStr_LengthEqualsToValueInGameProperties() {
        assertThat(gameFactory.generateNumberStr().length()).isEqualTo(GameProperties.LENGTH_OF_TARGET_NUMBER);
    }


    @ParameterizedTest
    @ValueSource(strings = {"112", "121", "211"})
    void validateEachDigitOfNumberIsUnique_ThrowException_GivenArgs(String number) {
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateEachDigitOfNumberIsUnique(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123","456"})
    void validateEachDigitOfNumberIsUnique_WithoutException_GivenArgs(String number) {
        assertThatNoException()
                .isThrownBy(() -> Validator.validateEachDigitOfNumberIsUnique(number));
    }

    @Test
    void pollNumberInList_ThrowsException_NumbersEmpty() {
        //given
        List<Integer> numbers = new ArrayList<>();

        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gameFactory.pollNumberInList(numbers))
                .withMessageMatching("numbers cannot be empty.");
    }

    @Test
    void pollNumberInList_NumberPolled_PollRandomNumberInNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        //when
        int polledNum = Integer.parseInt(gameFactory.pollNumberInList(numbers));

        //then
        assertThat(polledNum).isGreaterThanOrEqualTo(0).isLessThan(10).isNotIn(numbers);
    }

    @Test
    void pollNumberInList_ThrowException_NotSingleDigitOfNumInNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        int number = 400;
        numbers.add(number);

        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gameFactory.pollNumberInList(numbers))
                .withMessageMatching(String.format("number should be single digit, number : %d", number));
    }
}