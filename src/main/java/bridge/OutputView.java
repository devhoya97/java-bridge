package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_DELIMITER = " | ";
    private static final String MOVE_SUCCESS = "O";
    private static final String EMPTY = " ";
    private static final String MOVE_FAIL = "X";
    private static final String ERROR_PREFIX = "[ERROR] ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printMap(List<String> map, boolean doesLastMoveSucceed) {
        printUpperMap(map, doesLastMoveSucceed);
        printLowerMap(map, doesLastMoveSucceed);
    }

    private void printUpperMap(List<String> map, boolean doesLastMoveSucceed) {
        StringBuilder upperMap = new StringBuilder();

        upperMap.append(BRIDGE_START);
        for (int mapIndex = 0; mapIndex < map.size() - 1; mapIndex++) {
            addUpperMapStep(map.get(mapIndex), upperMap);
        }
        addUpperMapLastStep(map.get(map.size() - 1), doesLastMoveSucceed, upperMap);
        upperMap.append(BRIDGE_END);

        System.out.println(upperMap);
    }

    private void addUpperMapStep(String mapStep, StringBuilder upperMap) {
        if (Objects.equals(mapStep, Direction.UP.getSignature())) {
            upperMap.append(MOVE_SUCCESS).append(BRIDGE_DELIMITER);
            return;
        }
        upperMap.append(EMPTY).append(BRIDGE_DELIMITER);
    }

    private void addUpperMapLastStep(String mapStep, boolean doesLastMoveSucceed, StringBuilder upperMap) {
        if (Objects.equals(mapStep, Direction.UP.getSignature())) {
            if (doesLastMoveSucceed) {
                upperMap.append(MOVE_SUCCESS);
                return;
            }
            upperMap.append(MOVE_FAIL);
            return;
        }
        upperMap.append(EMPTY);
    }

    private void printLowerMap(List<String> map, boolean doesLastMoveSucceed) {
        StringBuilder lowerMap = new StringBuilder();

        lowerMap.append(BRIDGE_START);
        for (int mapIndex = 0; mapIndex < map.size() - 1; mapIndex++) {
            addLowerMapStep(map.get(mapIndex), lowerMap);
        }
        addLowerMapLastStep(map.get(map.size() - 1), doesLastMoveSucceed, lowerMap);
        lowerMap.append(BRIDGE_END);

        System.out.println(lowerMap);
    }

    private void addLowerMapStep(String mapStep, StringBuilder upperMap) {
        if (Objects.equals(mapStep, Direction.DOWN.getSignature())) {
            upperMap.append(MOVE_SUCCESS).append(BRIDGE_DELIMITER);
            return;
        }
        upperMap.append(EMPTY).append(BRIDGE_DELIMITER);
    }

    private void addLowerMapLastStep(String mapStep, boolean doesLastMoveSucceed, StringBuilder upperMap) {
        if (Objects.equals(mapStep, Direction.DOWN.getSignature())) {
            if (doesLastMoveSucceed) {
                upperMap.append(MOVE_SUCCESS);
                return;
            }
            upperMap.append(MOVE_FAIL);
            return;
        }
        upperMap.append(EMPTY);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> map, boolean doesSucceed, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(map, true);
        printSuccess(doesSucceed);
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    private void printSuccess(boolean doesSucceed) {
        String whetherSuccess = "실패";

        if (doesSucceed) {
            whetherSuccess = "성공";
        }
        System.out.println("\n게임 성공 여부: " + whetherSuccess);
    }
}
