package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        String input = Console.readLine().trim();

        return parseIntBridgeSize(input);
    }

    private int parseIntBridgeSize(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("입력된 다리의 길이가 정수가 아닙니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

        return input;
    }
}
