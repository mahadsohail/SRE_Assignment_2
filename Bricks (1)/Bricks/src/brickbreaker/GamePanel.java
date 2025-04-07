package brickbreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    private final Timer timer;
    private final Settings gameSettings;
    private final CollisionManager collisionManager;
    private final LevelManager levelManager;
    private final GameInitializer initializer;
    private final BackgroundImageLabel background;
    private final Base base;
    private final Ball ball;
    private final ArrayList<Brick> bricks;

    public GamePanel() {
        initializer = new GameInitializer();
        background = initializer.getBackground();
        base = initializer.getBase();
        ball = initializer.getBall();

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800, 500));
        this.add(background, BorderLayout.NORTH);

        gameSettings = Settings.getInstance();
        collisionManager = new CollisionManager();
        levelManager = new LevelManager();
        bricks = new ArrayList<>();

        loadNextLevel();

        timer = new Timer(16, this);
        timer.start();
    }

    private void loadNextLevel() {
        ArrayList<Brick> newBricks = levelManager.getNextLevelBricks();
        for (Brick brick : newBricks) {
            bricks.add(brick);
            background.add(brick);
        }
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        base.move();
        ball.moveBall();

        collisionManager.checkBaseCollision(base, ball);
        Brick hitBrick = collisionManager.checkBrickCollisions(bricks, ball);

        if (hitBrick != null) {
            if (gameSettings.isSoundEffectsOn()) {
                AudioPlayback.playSoundEffect();
            }
            background.remove(hitBrick);
        }

        if (bricks.isEmpty()) {
            loadNextLevel();
        }

        if (ball.y >= 500) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Gameover");
        }
    }
}
