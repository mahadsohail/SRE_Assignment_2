package brickbreaker;

import java.util.ArrayList;

public class LevelManager {
    private int currentLevel = 1;

    public ArrayList<Brick> getNextLevelBricks() {
        ArrayList<Brick> bricks = LevelPatterns.getBricksForLevel(currentLevel);
        currentLevel++;
        return bricks;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}
