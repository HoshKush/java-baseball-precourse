package baseball;

import static baseball.GameProperties.*;

import java.util.List;

public class Validator {

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() < LENGTH_OF_TARGET_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "Size of numbers cannot be smaller than GameProperties.LENGTH_OF_TARGET_NUMBER(%d)",
                    LENGTH_OF_TARGET_NUMBER));
        }
    }

    public static void validateNumbersHasElement(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("numbers cannot be empty.");
        }
    }

    public static void validateNumberIsSingleDigit(String number) {
        if(number.length() != 1) {
            throw new IllegalArgumentException(
                    String.format("number should be single digit, number : %s", number)
            );
        }
    }

    public static void validateInputLength(String input) {
        if(input.length() != LENGTH_OF_TARGET_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("Length of input differ from LENGTH_OF_TARGET_NUMBER," 
                            + " length of input : %d, LENGTH_OF_TARGET_NUMBER : %d",
                            input.length(), LENGTH_OF_TARGET_NUMBER)
            );
        }
    }
    
    public static void validateInputIsNumeric(String input) {
        if(!input.matches("[0-9]*")) {
            throw new IllegalArgumentException(
                    String.format("input value is not numeric, input : %s", input)
            );
        }
    }

    public static void validateInputContainsZero(String input) {
        if(input.contains("0")) {
            throw new IllegalArgumentException(
                    String.format("input value contains 0, input : %s", input)
            );
        }
    }

    public static void validateEachDigitOfNumberIsUnique(String number) {
        for(int i = 0; i < number.length(); i++) {
            hasSameNum(number, i);
        }
    }

    private static void hasSameNum(String number, int i) {
        String stdNum = number.substring(i, i + 1);
        if(number.indexOf(stdNum) != number.lastIndexOf(stdNum)) {
            throw new IllegalArgumentException(
                    String.format("There are more than two '%s' in '%s'", stdNum, number)
            );
        }
    }

    public static void validateInput(String input) {
        validateInputIsNumeric(input);
        validateInputContainsZero(input);
        validateEachDigitOfNumberIsUnique(input);
        validateInputLength(input);
    }
}
