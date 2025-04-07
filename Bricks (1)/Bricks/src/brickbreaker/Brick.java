package brickbreaker;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Brick extends JButton {

    private static final int BRICK_WIDTH = 70;
    private static final int BRICK_HEIGHT = 30;
    private static final Color DEFAULT_BRICK_COLOR = Color.RED;

    public Brick(ImageIcon brickImage) {
        setPreferredSize(new Dimension(BRICK_WIDTH, BRICK_HEIGHT));
        setBorderPainted(true);
        setFocusable(false);

        if (brickImage != null) {
            setIcon(brickImage);
        } else {
            setBackground(DEFAULT_BRICK_COLOR);
        }
    }

    public int getBRICK_WIDTH() {
        return BRICK_WIDTH;
    }

    public int getBRICK_HEIGHT() {
        return BRICK_HEIGHT;
    }
}
