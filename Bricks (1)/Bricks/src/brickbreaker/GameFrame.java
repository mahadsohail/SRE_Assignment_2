package brickbreaker;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 500;

    private final Settings gameSettings;

    public GameFrame() {
        gameSettings = Settings.getInstance();
        setupFrame();
        if (gameSettings.isBackgroundMusicOn()) {
            playBackgroundMusic();
        }
    }

    private void setupFrame() {
        setTitle("Brick Breaker");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setIcon();
        add(new GamePanel());
    }

    private void setIcon() {
        setIconImage(new ImageIcon("assets/icon.png").getImage());
    }

    /**
     * Plays background music loop in a separate thread
     */
    private void playBackgroundMusic() {
        new Thread(AudioPlayback::playMusic).start();
    }
}
