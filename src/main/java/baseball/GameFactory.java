package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {

    public Game createGame() {
        String targetNum = generateNumberStr();
        return new Game(targetNum);
    }

    public String generateNumberStr() {
        StringBuilder number = new StringBuilder();

        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        validateNumbers(numbers);

        for(int i = 0; i < GameProperties.DIGITS_OF_TARGET_NUMBER; i++) {
            number.append(pollNumberInList(numbers));
        }

        validateEachDigitOfNumberIsUnique(number.toString());
        return number.toString();
    }


    public String pollNumberInList(List<Integer> numbers) {
        validateNumbersHasElement(numbers);

        int idx = Randoms.pickNumberInRange(0, numbers.size() - 1);
        String num = String.valueOf(numbers.get(idx));
        validateNumIsSingleDigit(num);

        numbers.remove(idx);
        return num;
    }

    public void validateNumbers(List<Integer> numbers) {
        if (numbers.size() < GameProperties.DIGITS_OF_TARGET_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "Size of numbers cannot be smaller than GameProperties.DIGITS_OF_TARGET_NUMBER(%d)",
                    GameProperties.DIGITS_OF_TARGET_NUMBER));
        }
    }

    public void validateNumbersHasElement(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("numbers cannot be empty.");
        }
    }

    public void validateNumIsSingleDigit(String num) {
        if(num.length() != 1) {
            throw new IllegalArgumentException(
                    String.format("num should be single digit, num : %s", num));
        }
    }

    public void validateEachDigitOfNumberIsUnique(String number) {
        for(int i = 0; i < number.length(); i++) {
            hasSameNum(number, i);
        }
    }

    private void hasSameNum(String number, int i) {
        String stdNum = number.substring(i, i + 1);
        if(number.substring(i + 1).contains(stdNum)) {
            throw new IllegalArgumentException(
                    String.format("There are more than two '%s' in '%s'", stdNum, number));
        }
    }

}
