package brickbreaker;

import java.util.ArrayList;

public class LevelPatterns {

    public static ArrayList<Brick> getBricksForLevel(int level) {
        return switch (level) {
            case 1 -> levelOne();
            case 2 -> levelTwo();
            case 3 -> levelThree();
            case 4 -> levelFour();
            case 5 -> levelFive();
            default -> levelOne(); // fallback to level one
        };
    }

    private static ArrayList<Brick> levelOne() {
        ArrayList<Brick> bricks = new ArrayList<>();
        int xPos = 0, yPos = 50;
        for (int i = 0; i < 28; i++) {
            Brick brick = new Brick(null);
            if (i % 7 == 0) {
                xPos = 0;
                yPos += brick.getBRICK_HEIGHT() + 20;
            }
            brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
            bricks.add(brick);
            xPos += brick.getBRICK_WIDTH() + 20;
        }
        return bricks;
    }

    private static ArrayList<Brick> levelTwo() {
        ArrayList<Brick> bricks = new ArrayList<>();
        int xPos = 70, yPos = 50;
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                Brick brick = new Brick(null);
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                    bricks.add(brick);
                }
                xPos += brick.getBRICK_WIDTH();
            }
            xPos = 70;
            yPos += 30;
        }
        return bricks;
    }

    private static ArrayList<Brick> levelThree() {
        ArrayList<Brick> bricks = new ArrayList<>();

        // Box 1
        int x1 = 30, y1 = 20;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                Brick brick = new Brick(null);
                brick.setBounds(x1, y1, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                x1 += brick.getBRICK_WIDTH();
            }
            x1 = 30;
            y1 += 30;
        }

        // Box 2
        int x2 = 400, y2 = 20;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                Brick brick = new Brick(null);
                brick.setBounds(x2, y2, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                x2 += brick.getBRICK_WIDTH();
            }
            x2 = 400;
            y2 += 30;
        }

        return bricks;
    }

    private static ArrayList<Brick> levelFour() {
        ArrayList<Brick> bricks = new ArrayList<>();
        int x = 120, y = 20, startX = 120, count = 8;

        while (count != 0) {
            for (int i = 0; i < count; i++) {
                Brick brick = new Brick(null);
                brick.setBounds(x, y, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                x += brick.getBRICK_WIDTH();
            }
            count--;
            startX += 35;
            x = startX;
            y += 30;
        }

        return bricks;
    }

    private static ArrayList<Brick> levelFive() {
        ArrayList<Brick> bricks = new ArrayList<>();

        // Triangle 1
        int x1 = 150, y1 = 50, nextX1 = 150, count1 = 1;
        while (count1 <= 5) {
            for (int i = 0; i < count1; i++) {
                Brick brick = new Brick(null);
                brick.setBounds(x1, y1, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                x1 += brick.getBRICK_WIDTH();
            }
            count1++;
            nextX1 -= 35;
            x1 = nextX1;
            y1 += 30;
        }

        // Triangle 2
        int x2 = 550, y2 = 50, nextX2 = 550, count2 = 1;
        while (count2 <= 5) {
            for (int i = 0; i < count2; i++) {
                Brick brick = new Brick(null);
                brick.setBounds(x2, y2, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                x2 += brick.getBRICK_WIDTH();
            }
            count2++;
            nextX2 -= 35;
            x2 = nextX2;
            y2 += 30;
        }

        return bricks;
    }
}
