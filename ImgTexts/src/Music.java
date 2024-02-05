import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.*;
public class Music {
	private static Clip clip;
	public static void Music()
	{
		File music = new File("lib\\music.wav");
		try {
			
			AudioInputStream AudioStream = AudioSystem.getAudioInputStream(music);
			 clip =AudioSystem.getClip();
			clip.open(AudioStream);
                while (true) {  
                    if(Globals.MusicControl)
                    	{
                    		clip.start();
                    		clip.loop(clip.LOOP_CONTINUOUSLY);
                    	}
                    
                    else { clip.stop();
                    }
                    
                } 
            }
			
		//}
		
		  catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
}