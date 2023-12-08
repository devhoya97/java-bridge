package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        System.out.println(bridgeGame.move(Direction.UP));
        System.out.println(bridgeGame.move(Direction.DOWN));
        System.out.println(bridgeGame.move(Direction.UP));

        System.out.println(bridgeGame.doesSucceed());
    }
}
