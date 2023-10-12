package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    private static int trial = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        try {
            run(inputView, outputView);
        }catch(IllegalArgumentException ie){
            System.out.println(ie.getMessage());
        }
    }
    public static void run(InputView inputView, OutputView outputView) {
        outputView.printStartMsg();
        int size = getBridgeSize(inputView, outputView);
        BridgeGame bridgeGame = new BridgeGame(getBridge(size));
        runBridgeGameRoundsUtilQuit(bridgeGame, inputView, outputView);
    }
    public static void runBridgeGameRoundsUtilQuit(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        String retryOrQuit = "R";
        while (retryOrQuit.equals("R")) {
            trial++;
            runBridgeGameRounds(bridgeGame, inputView, outputView);
            if (bridgeGame.doesSuccess()) {
                break;
            }
            bridgeGame.retry();
            retryOrQuit = getRetryOrQuit(inputView, outputView);
        }
        outputView.printResult(bridgeGame.getUserChoices(), bridgeGame.doesSuccess());
        outputView.printDoesSuccess(bridgeGame.doesSuccess());
        outputView.printTrialNumber(trial);
    }
    public static String getRetryOrQuit(InputView inputView, OutputView outputView) {
//        trial++;
        outputView.printGetRetry();
        return inputView.readGameCommand();
    }
    public static void runBridgeGameRounds(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        boolean canMove = true;
        while (canMove) {
            canMove = runBridgeGameRound(bridgeGame, inputView, outputView);
            if (bridgeGame.doesSuccess())
                break;
        }
//        trial++;
//        return canMove;
    }
    public static boolean runBridgeGameRound(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        outputView.printGetChoiceMsg();
        String direction = inputView.readMoving();
        boolean canMove = bridgeGame.move(direction);
        List<String> userChoices = bridgeGame.getUserChoices();
        outputView.printMap(userChoices, canMove);
        return canMove;
    }
    public static int getBridgeSize(InputView inputView, OutputView outputView) {
        outputView.printGetLengthMsg();
        return inputView.readBridgeSize();
    }

    public static List<String> getBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(size);
    }
}
