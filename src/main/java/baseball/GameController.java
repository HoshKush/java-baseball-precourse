package baseball;

import static baseball.Validator.*;

public class GameController {
    private Game game;
    private GameProcessor gameProcessor;
    private GameFactory gameFactory;

    public GameController() {
        gameProcessor = new GameProcessor();
        gameFactory = new GameFactory();
    }

    public GameResult startNewGame() {
        game = gameFactory.createGame();
        return new GameResult(MessageEnum.PROGRESS_GAME_START);
    }

    public GameResult quit() {
        return new GameResult(MessageEnum.PROGRESS_QUIT);
    }

    public GameResult input(String input) {
        if(isCommand(input)) {
            return inputCommand(input);
        }
        return inputNumber(input);
    }

    public GameResult inputNumber(String input) {
        validateInput(input);
        return gameProcessor.process(game ,input);
    }

    public GameResult inputCommand(String input) {
        if(isNewGameCommand(input)) {
            return startNewGame();
        }
        if(isQuitCommand(input)) {
            return quit();
        }
        throw new IllegalArgumentException("you can input only 1 or 2");
    }

    public boolean isNewGameCommand(String input) {
        return input.equals(MessageEnum.COMMAND_NEW_GAME.getCode());
    }

    public boolean isQuitCommand(String input) {
        return input.equals(MessageEnum.COMMAND_QUIT.getCode());
    }

    private static boolean isCommand(String input) {
        return input.equals(MessageEnum.COMMAND_NEW_GAME.getCode())
                || input.equals(MessageEnum.COMMAND_QUIT.getCode());
    }
}
