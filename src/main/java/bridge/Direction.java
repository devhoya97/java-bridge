package bridge;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

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
}
