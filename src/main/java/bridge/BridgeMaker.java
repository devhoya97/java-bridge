package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);

        List<String> bridge = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            addBridgeStep(bridge);
        }

        return bridge;
    }

    private void validateSize(int size) {
        if (size < MIN_BRIDGE_LENGTH || size > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(
                    "다리 길이는 " + MIN_BRIDGE_LENGTH + "부터 " + MAX_BRIDGE_LENGTH +  " 사이의 숫자여야 합니다."
            );
        }
    }

    private void addBridgeStep(List<String> bridge) {
        int number = bridgeNumberGenerator.generate();

        if (number == Direction.DOWN.getValue()) {
            bridge.add(Direction.DOWN.getSignature());
        }
        bridge.add(Direction.UP.getSignature());
    }
}
