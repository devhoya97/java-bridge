package bridge;

import java.util.Objects;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0),

    NOT_FOUNDED("", -1);

    private final String signature;
    private final int value;

    Direction(String signature, int value) {
        this.signature = signature;
        this.value = value;
    }

    public String getSignature() {
        return signature;
    }

    public int getValue() {
        return value;
    }

    public static Direction findDirection(String signature) {
        for (Direction direction : Direction.values()) {
            if (Objects.equals(direction.signature, signature)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("이동할 칸이 U 또는 D만 가능합니다.");
    }
}
