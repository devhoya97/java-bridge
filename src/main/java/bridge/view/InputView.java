package bridge.view;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validateStringIsNullOrEmpty(input);
        validateStringOnlyNumber(input);

        int bridgeSize = Integer.parseInt(input);
        validateNumberBetween3And20(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String direction = Console.readLine();
        validateStringUOrD(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryOrQuit = Console.readLine();
        validateStringROrQ(retryOrQuit);
        return retryOrQuit;
    }
    private void validateStringROrQ(String str) {
        if (str.equals("R") || str.equals("Q"))
            return;
        throw new IllegalArgumentException("[ERROR] 입력 값이 R 또는 Q가 아닙니다.");
    }
    private void validateStringUOrD(String str) {
        if (str.equals("U") || str.equals("D"))
            return;
        throw new IllegalArgumentException("[ERROR] 입력 값이 U 또는 D가 아닙니다.");
    }
    private void validateStringOnlyNumber(String str) {
        for(char c : str.toCharArray()){
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("[ERROR] 입력 값이 숫자가 아닙니다.");
        }
    }
    private void validateNumberBetween3And20(int number) {
        if (number < 3 || number > 20)
            throw new IllegalArgumentException("[ERROR] 입력 값이 3 미만이거나 20 초과입니다.");
    }
    private void validateStringIsNullOrEmpty(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
    }
}
