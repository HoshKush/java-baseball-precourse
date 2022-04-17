package baseball;

import static baseball.MessageEnum.*;

import camp.nextstep.edu.missionutils.Console;

public class GameDisplay {

    private GameController gameController;

    public GameDisplay() {
        this.gameController = new GameController();
    }

    public void playGame() {
        GameResult gameResult = gameController.startNewGame();
        System.out.println(gameResult.getMessage());
        while(!isQuit(gameResult)) {
            gameResult = process(gameResult);
        }
    }

    private GameResult process(GameResult gameResult) {
        if(isWin(gameResult)) {
            return inputCommand();
        }
        return inputNumber();
    }

    private GameResult input() {
        String input = Console.readLine();
        GameResult gameResult = gameController.input(input);
        System.out.println(gameResult.getMessage());
        return gameResult;
    }

    private GameResult inputNumber() {
        System.out.println(PROGRESS_INPUT_NUMBER.getMessage());
        return input();
    }

    private GameResult inputCommand() {
        System.out.println(PROGRESS_NEW_GAME_OR_QUIT.getMessage());
        return input();
    }

    private boolean isWin(GameResult gameResult) {
        return gameResult.getCode().equals(RESULT_WIN.getCode());
    }

    private boolean isQuit(GameResult gameResult) {
        return gameResult.getCode().equals(PROGRESS_QUIT.getCode());
    }
}
