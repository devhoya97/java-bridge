package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MSG = "다리 건너기 게임을 시작합니다.";
    private static final String GET_LENGTH_MSG = "다리의 길이를 입력해주세요.";
    private static final String GET_CHOICE_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GET_RETRY_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_MSG = "최종 게임 결과";
    private static final String DOES_SUCCESS_MSG = "게임 성공 여부: ";
    private static final String SUCCESS_MSG = "성공";
    private static final String FAIL_MSG = "실패";
    private static final String TRIAL_MSG = "총 시도한 횟수: ";
    public void printStartMsg() {
        System.out.println(START_MSG);
        System.out.println();
    }
    public void printGetLengthMsg() {System.out.println(GET_LENGTH_MSG);}
    public void printGetChoiceMsg() {System.out.println(GET_CHOICE_MSG);}
    public void printGetRetry() {System.out.println(GET_RETRY_MSG);}
    public void printDoesSuccess(boolean success) {
        System.out.print(DOES_SUCCESS_MSG);
        if (success) {
            System.out.println(SUCCESS_MSG);
            return;
        }
        System.out.println(FAIL_MSG);
    }
    public void printTrialNumber(int trialNumber) {
        System.out.println(TRIAL_MSG+trialNumber);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userchoices, boolean canMove) {
        if (userchoices.size() == 1) {
            printSizeOne(userchoices.get(0), canMove);
            System.out.println();
            return;
        }
        printUpside(userchoices, canMove);
        printDownside(userchoices, canMove);
        System.out.println();
    }
    public void printSizeOne(String userChoice, boolean canMove) {
        if (userChoice.equals("U")) {
            if (canMove) {
                System.out.println("[ 0 ]");
                System.out.println("[   ]");
                return;
            }
            System.out.println("[ X ]");
            System.out.println("[   ]");
            return;
        }
        if (canMove) {
            System.out.println("[   ]");
            System.out.println("[ O ]");
            return;
        }
        System.out.println("[   ]");
        System.out.println("[ X ]");
    }
    public void printUpside(List<String> userChoices, boolean canMove) {
        printFirstUpside(userChoices.get(0), userChoices.size(), canMove);
        printMiddleUpside(userChoices);
        printLastUpside(userChoices.get(userChoices.size()-1), canMove);
    }
    public void printDownside(List<String> userChoices, boolean canMove) {
        if (userChoices.size() == 1) {
            if (canMove) {
                System.out.println("[ O ]");
                return;
            }
            System.out.println("[ X ]");
            return;
        }
        printFirstDownside(userChoices.get(0));
        printMiddleDownside(userChoices);
        printLastDownside(userChoices.get(userChoices.size()-1), canMove);
    }
    public void printFirstUpside(String userChoice, int size, boolean canMove) {
        System.out.print("[");
        if (userChoice.equals("U")) {
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }
    public void printFirstDownside(String userChoice) {
        System.out.print("[");
        if (userChoice.equals("D")) {
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }
    public void printMiddleUpside(List<String> userChices) {
        int size = userChices.size();
        for (int i=1; i<size-1; i++) {
            System.out.print("|");
            if (userChices.get(i).equals("U")) {
                System.out.print(" O ");
                continue;
            }
            System.out.print("   ");
        }
    }
    public void printMiddleDownside(List<String> userChices) {
        int size = userChices.size();
        for (int i=1; i<size-1; i++) {
            System.out.print("|");
            if (userChices.get(i).equals("D")) {
                System.out.print(" O ");
                continue;
            }
            System.out.print("   ");
        }
    }
    public void printLastUpside(String userChoice, boolean canMove) {
        System.out.print("|");
        if (userChoice.equals("U")) {
            if (canMove) {
                System.out.println(" O ]");
                return;
            }
            System.out.println(" X ]");
            return;
        }
        System.out.println("   ]");
    }

    public void printLastDownside(String userChoice, boolean canMove) {
        System.out.print("|");
        if (userChoice.equals("D")) {
            if (canMove) {
                System.out.println(" O ]");
                return;
            }
            System.out.println(" X ]");
            return;
        }
        System.out.println("   ]");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userChoices, boolean canMove) {
        System.out.println(FINAL_RESULT_MSG);
        printMap(userChoices, canMove);
    }
}
