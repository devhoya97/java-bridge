package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> userChoices = new LinkedList<>();
    private boolean canMove;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }
    public boolean move(String direction) {
        userChoices.add(direction);
        int index = userChoices.size()-1;
        if (userChoices.get(index).equals(bridge.get(index))) {
            canMove = true;
            return canMove;
        }
        canMove = false;
        return canMove;
    }

    public List<String> getUserChoices() {
        return userChoices;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userChoices.clear();
    }
    public boolean doesSuccess() {
        return bridge.size() == userChoices.size() && canMove;
    }
}
