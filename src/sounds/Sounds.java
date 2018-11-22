package sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
	
	public static final String POP = "pop.wav";
	public static final String POP2 = "pop2.wav";
	public static final String ADD = "add.wav";
	public static final String AMBIENCE = "ambience.wav";
	
	public static void initializePop(String sound) {
		File f = new File("./" + sound);
	    AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	   
	}
}
