package bridge;

import java.util.Objects;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static GameCommand findGameCommand(String command) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (Objects.equals(gameCommand.command, command)) {
                return gameCommand;
            }
        }

        throw new IllegalArgumentException("올바른 게임 커맨드가 아닙니다.");
    }
}
