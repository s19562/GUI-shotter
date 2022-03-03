import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    void play(String musicLocation){
        try {
            File musicPath = new File(musicLocation);

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                while(true) {
                    clip.start();
                }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
