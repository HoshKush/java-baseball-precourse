package baseball;

public class GameProcessor {

    public GameResult process(Game game, String inputNum) {
        game.init();
        for(int i = 0; i < GameProperties.LENGTH_OF_TARGET_NUMBER; i++) {
            if(isBall(game.getTargetNum(), inputNum, i)) {
                game.increaseBall();
            }
            if(isStrike(game.getTargetNum(), inputNum, i)) {
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
            return GameResult.create(MessageEnum.RESULT_NOTHING, game.getBall(), game.getStrike());
        }
        if(game.isWin()) {
            return GameResult.create(MessageEnum.RESULT_WIN, game.getBall(), game.getStrike());
        }
        return GameResult.create(MessageEnum.RESULT_BALL_AND_STRIKE, game.getBall(), game.getStrike());
    }
}
