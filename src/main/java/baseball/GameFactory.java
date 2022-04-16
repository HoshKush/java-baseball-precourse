package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class GameFactory {

    public Game createGame() {
        String targetNum = generateNumberStr();
        return new Game(targetNum);
    }

    public String generateNumberStr() {
        StringBuilder number = new StringBuilder();
        List<Integer> numbers = generateNumbers();

        Validator.validateNumbersSize(numbers);

        for(int i = 0; i < GameProperties.DIGITS_OF_TARGET_NUMBER; i++) {
            number.append(pollNumberInList(numbers));
        }
        Validator.validateStringIsNumeric(number.toString());
        Validator.validateEachDigitOfNumberIsUnique(number.toString());

        return number.toString();
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        return numbers;
    }


    public String pollNumberInList(List<Integer> numbers) {
        Validator.validateNumbersHasElement(numbers);

        int idx = Randoms.pickNumberInRange(0, numbers.size() - 1);
        String num = String.valueOf(numbers.get(idx));
        Validator.validateNumberIsSingleDigit(num);

        numbers.remove(idx);
        return num;
    }


}
