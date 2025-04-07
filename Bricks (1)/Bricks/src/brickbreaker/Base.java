package brickbreaker;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Base extends JButton implements KeyListener {

    private static final int BASE_WIDTH = 130;
    private static final int BASE_HEIGHT = 15;
    private static final int LEFT_BOUND = 5;
    private static final int RIGHT_BOUND = 780;
    private static final int MAX_RIGHT_EDGE = 775;
    private static final int MOVE_STEP = 5;
    private static final String BASE_IMAGE_PATH = "assets/base2.jpg";
    private static final Logger LOGGER = Logger.getLogger(Base.class.getName());

    public int x = 325;
    public int y = 400;
    public int velocity = 0;

    private boolean isRightKeyPressed = false;
    private boolean isLeftKeyPressed = false;

    public Base() {
        setPreferredSize(new Dimension(BASE_WIDTH, BASE_HEIGHT));
        setBounds(x, y, BASE_WIDTH, BASE_HEIGHT);
        setBorderPainted(false);
        setFocusable(true);
        addKeyListener(this);
        loadBaseImage();
    }

    private void loadBaseImage() {
        try {
            Image baseImage = ImageIO.read(new File(BASE_IMAGE_PATH))
                    .getScaledInstance(BASE_WIDTH, BASE_HEIGHT, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(baseImage));
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Unable to load base image: " + BASE_IMAGE_PATH, ex);
        }
    }

    public void move() {
        if (isRightKeyPressed && (x + BASE_WIDTH) < RIGHT_BOUND) {
            x += MOVE_STEP;
        } else if (isLeftKeyPressed && x >= LEFT_BOUND) {
            x -= MOVE_STEP;
        }

        updatePosition();
    }

    private void updatePosition() {
        setBounds(x, y, BASE_WIDTH, BASE_HEIGHT);
        if (x <= LEFT_BOUND || (x + BASE_WIDTH) > MAX_RIGHT_EDGE) {
            velocity = 0;
        }
    }

    public int getBASE_WIDTH() {
        return BASE_WIDTH;
    }

    public int getBASE_HEIGHT() {
        return BASE_HEIGHT;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // no-op
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            isLeftKeyPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            isRightKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            isLeftKeyPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            isRightKeyPressed = false;
        }
    }
}
