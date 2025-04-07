package brickbreaker;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class AudioPlayback {

    private static final Logger LOGGER = Logger.getLogger(AudioPlayback.class.getName());
    private static final String BACKGROUND_MUSIC_PATH = "assets/bg-music.wav";
    private static final String SOUND_EFFECT_PATH = "assets/break.wav";

    public static void playMusic() {
        Clip musicClip = loadClip(BACKGROUND_MUSIC_PATH);
        if (musicClip != null) {
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();
        }
    }

    public static void playSoundEffect() {
        Clip soundClip = loadClip(SOUND_EFFECT_PATH);
        if (soundClip != null) {
            soundClip.start();
        }
    }

    private static Clip loadClip(String filePath) {
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filePath));
            AudioFormat format = stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            return clip;
        } catch (UnsupportedAudioFileException e) {
            LOGGER.log(Level.SEVERE, "Unsupported audio file: " + filePath, e);
        } catch (LineUnavailableException e) {
            LOGGER.log(Level.SEVERE, "Audio line unavailable for: " + filePath, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "I/O error loading file: " + filePath, e);
        }
        return null;
    }
}