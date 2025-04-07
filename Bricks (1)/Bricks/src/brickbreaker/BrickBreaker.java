package brickbreaker;

/**
 * Entry point for the BrickBreaker game.
 */
public class BrickBreaker {
    public static void main(String[] args) {
        launchGame();
    }

    private static void launchGame() {
        new GameFrame().setVisible(true);
    }
}
