package waigoma.FreeSpace;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Testttt{

    String soundName;
    boolean loop;
    public Clip clip;

    public Testttt(String soundName, boolean loop){
        this.soundName = soundName;
        this.loop = loop;
        clip = creatClip(new File(soundName));
    }

    public static Clip creatClip(File path) {
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){

            AudioFormat af = ais.getFormat();

            DataLine.Info dataLine = new DataLine.Info(Clip.class,af);

            Clip c = (Clip)AudioSystem.getLine(dataLine);

            c.open(ais);

            return c;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }
}
