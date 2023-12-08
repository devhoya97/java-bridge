package bridge;

import java.util.List;
import java.util.Objects;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printStart();

        List<String> bridge = getValidBridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        play(bridgeGame);
    }

    private static List<String> getValidBridge(BridgeMaker bridgeMaker) {
        while (true) {
            try {
                return bridgeMaker.makeBridge(inputView.readBridgeSize());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private static Direction getValidDirection() {
        while (true) {
            try {
                return Direction.findDirection(inputView.readMoving());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private static void play(BridgeGame bridgeGame) {
        int tryCount = 0;
        while (true) {
            bridgeGame.retry();
            tryCount++;
            playOneGame(bridgeGame);

            if (bridgeGame.doesSucceed()) {
                break;
            }
            if (Objects.equals(getValidGameCommand(), GameCommand.QUIT)) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getHistory(), bridgeGame.doesSucceed(), tryCount);
    }

    private static void playOneGame(BridgeGame bridgeGame) {
        while (!bridgeGame.doesSucceed()) {
            boolean canMove = bridgeGame.move(getValidDirection());
            outputView.printMap(bridgeGame.getHistory(), canMove);

            if (!canMove) {
                break;
            }
        }
    }

    private static GameCommand getValidGameCommand() {
        while (true) {
            try {
                return GameCommand.findGameCommand(inputView.readGameCommand());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
