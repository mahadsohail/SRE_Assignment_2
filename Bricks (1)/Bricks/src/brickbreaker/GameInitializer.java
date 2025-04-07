package brickbreaker;

import javax.swing.*;
import java.awt.*;

public class GameInitializer {
    private final Base base;
    private final Ball ball;
    private final BackgroundImageLabel background;

    public GameInitializer() {
        base = new Base();
        ball = new Ball();
        background = new BackgroundImageLabel();
        background.add(ball);
        background.add(base);
    }

    public Base getBase() {
        return base;
    }

    public Ball getBall() {
        return ball;
    }

    public BackgroundImageLabel getBackground() {
        return background;
    }

    public JPanel setupPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(800, 500));
        panel.add(background, BorderLayout.NORTH);
        return panel;
    }
}
