package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        OutputView outputView = new OutputView();

        List<String> bridge = bridgeMaker.makeBridge(5);
        System.out.println(bridge);
        outputView.printMap(bridge, false);
    }
}
