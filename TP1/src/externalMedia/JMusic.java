package externalMedia;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class JMusic {
	
	/**
	 * Metodo para cargar sonidos desde un archivo
	 * @param archivoDeAudio
	 * @return
	 */
    public static Clip cargarSonido(String archivoDeAudio) {
		AudioInputStream audioIn;
        Clip clip = null;
		try 
		{
			audioIn = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(archivoDeAudio));			
			clip = AudioSystem.getClip();
	        clip.open(audioIn);     
		} 
		catch (Exception  e) {
			e.printStackTrace();
		}
		
		return clip;
	}
}