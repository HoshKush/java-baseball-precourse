package baseball;

import static baseball.MessageEnum.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static GameController gameController;
    public static void main(String[] args) {
        gameController = new GameController();
        GameResult result = startGame();

        String input;
        while(!result.getCode().equals(PROGRESS_QUIT.getCode())) {
            System.out.print(PROGRESS_INPUT_NUMBER.getMessage());
            input = Console.readLine();
            System.out.println(input);
            result = gameController.input(input);
            System.out.println(result.getMessage());
            if(result.getCode().equals(RESULT_WIN.getCode())) {
                System.out.println(PROGRESS_NEW_GAME_OR_QUIT.getMessage());
                input = Console.readLine();
                result = gameController.inputCommand(input);
            }
        }
    }

    public static GameResult startGame() {
        GameResult gameResult = gameController.startNewGame();
        System.out.println(gameResult.getMessage());
        return gameResult;
    }

//    public static  Game
}
