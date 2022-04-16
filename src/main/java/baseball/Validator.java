package baseball;

import java.util.List;

public class Validator {

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() < GameProperties.DIGITS_OF_TARGET_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "Size of numbers cannot be smaller than GameProperties.DIGITS_OF_TARGET_NUMBER(%d)",
                    GameProperties.DIGITS_OF_TARGET_NUMBER));
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
                    String.format("num should be single digit, number : %s", number)
            );
        }
    }

    public static void validateStringIsNumeric(String str) {
        if(!str.matches("[1-9]*")) {
            throw new IllegalArgumentException(
                    String.format("Given string is not numeric, str : %s", str)
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
}
