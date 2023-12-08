package bridge;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        List<String> bridge = getValidBridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
        System.out.println(bridge);
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
}
