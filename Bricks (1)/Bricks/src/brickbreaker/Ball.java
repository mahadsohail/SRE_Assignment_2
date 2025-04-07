package brickbreaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ball extends JButton {

    private static final int BALL_WIDTH = 20;
    private static final int BALL_HEIGHT = 15;
    private static final int RIGHT_BOUND = 790;
    private static final String BALL_IMAGE_PATH = "assets/ball.png";
    private static final Logger LOGGER = Logger.getLogger(Ball.class.getName());

    public int xVelocity = 4;
    public int yVelocity = -4;
    public int x = 325;
    public int y = 350;

    public Ball() {
        setPreferredSize(new Dimension(BALL_WIDTH, BALL_HEIGHT));
        setBounds(x, y, BALL_WIDTH, BALL_HEIGHT);
        setBackground(new Color(255, 255, 255, 0));
        setBorderPainted(false);
        setFocusable(false);
        loadBallImage();
    }

    private void loadBallImage() {
        try {
            Image baseImage = ImageIO.read(new File(BALL_IMAGE_PATH))
                    .getScaledInstance(BALL_WIDTH, BALL_HEIGHT, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(baseImage));
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Unable to load ball image: " + BALL_IMAGE_PATH, ex);
        }
    }

    public void moveBall() {
        if (x < 0 || (x + BALL_WIDTH) > RIGHT_BOUND) {
            xVelocity *= -1;
        }
        if (y < 0) {
            yVelocity *= -1;
        }

        x += xVelocity;
        y += yVelocity;
        setBounds(x, y, BALL_WIDTH, BALL_HEIGHT);
    }

    public int getBALL_WIDTH() {
        return BALL_WIDTH;
    }

    public int getBALL_HEIGHT() {
        return BALL_HEIGHT;
    }
}
