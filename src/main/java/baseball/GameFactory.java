package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class GameFactory {

    public Game createGame() {
        String targetNum = generateTargetNum();
        return new Game(targetNum);
    }

    public String generateTargetNum() {
        LinkedHashSet<Integer> pickedNums = pickNums(GameProperties.LENGTH_OF_TARGET_NUMBER);
        String targetNum = makeNumsString(pickedNums);
        Validator.validateInput(targetNum);

        return targetNum;
    }

    public LinkedHashSet<Integer> pickNums(int digit) {
        LinkedHashSet<Integer> pickedNums = new LinkedHashSet<>();
        while(pickedNums.size() < digit) {
            pickedNums.add(Randoms.pickNumberInRange(1, 9));
        }
        return pickedNums;
    }
    
    public String makeNumsString(LinkedHashSet<Integer> pickedNums) {
        StringBuilder sb = new StringBuilder();

        for (Integer pickedNum : pickedNums) {
            sb.append(pickedNum);
        }
        
        return sb.toString();
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
