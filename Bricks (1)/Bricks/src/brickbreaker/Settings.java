package brickbreaker;

/**
 * Global game settings for music and sound effects.
 * Singleton pattern ensures consistent state across app.
 */
public class Settings {

    private boolean backgroundMusicOn = true;
    private boolean soundEffectsOn = false;

    private static Settings instance;

    private Settings() {
        // private constructor to prevent instantiation
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public boolean isBackgroundMusicOn() {
        return backgroundMusicOn;
    }

    public boolean isSoundEffectsOn() {
        return soundEffectsOn;
    }

    public void setBackgroundMusicOn(boolean backgroundMusicOn) {
        this.backgroundMusicOn = backgroundMusicOn;
    }

    public void setSoundEffectsOn(boolean soundEffectsOn) {
        this.soundEffectsOn = soundEffectsOn;
    }
}
