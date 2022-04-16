package baseball;

public class GameProcessor {

    public GameResult processGame(Game game, String inputNum) {
        game.init();
        for(int i = 0; i < GameProperties.DIGITS_OF_TARGET_NUMBER; i++) {
            if(isBall(game.targetNum, inputNum, i)) {
                game.increaseBall();
            }
            if(isStrike(game.targetNum, inputNum, i)) {
                game.increaseStrike();
            }
        }
        return getResult(game);
    }

    public boolean isBall(String targetNum, String inputNum, int idx) {
        String restPartOfTargetNum = targetNum.replace(singleStringAt(targetNum, idx), "");
        return restPartOfTargetNum.contains(singleStringAt(inputNum, idx));
    }

    public boolean isStrike(String targetNum, String inputNum, int idx) {
        return targetNum.charAt(idx) == inputNum.charAt(idx);
    }

    public String singleStringAt(String str, int idx) {
        return String.valueOf(str.charAt(idx));
    }

    public GameResult getResult(Game game) {
        if(game.isNothing()) {
            return GameResult.create(MessageEnum.NOTHING, game.getBall(), game.getStrike());
        }
        if(game.isWin()) {
            return GameResult.create(MessageEnum.WIN, game.getBall(), game.getStrike());
        }
        return GameResult.create(MessageEnum.BALL_AND_STRIKE, game.getBall(), game.getStrike());
    }
}
