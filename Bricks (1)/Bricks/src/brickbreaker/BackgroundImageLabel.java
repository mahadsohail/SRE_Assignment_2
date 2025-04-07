package brickbreaker;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundImageLabel extends JLabel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    private static final String BACKGROUND_IMAGE_PATH = "assets/bg.jpg";
    private static final Logger LOGGER = Logger.getLogger(BackgroundImageLabel.class.getName());

    public BackgroundImageLabel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBounds(0, 0, WIDTH, HEIGHT);
        setBackgroundImage();
    }

    private void setBackgroundImage() {
        try {
            Image backgroundImage = ImageIO.read(new File(BACKGROUND_IMAGE_PATH));
            setIcon(new ImageIcon(backgroundImage));
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Unable to load background image: " + BACKGROUND_IMAGE_PATH, ex);
        }
    }
}
