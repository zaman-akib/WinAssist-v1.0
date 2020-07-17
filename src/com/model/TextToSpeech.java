package com.model;

import java.io.IOException;
import com.darkprograms.speech.synthesiser.SynthesiserV2;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class TextToSpeech {
	
	static SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");

	public static void speak(String text) {
		
		Thread thread = new Thread(() -> {
			try {
				
				AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(text));
				player.play();
				
			} catch (IOException | JavaLayerException e) {
				
				e.printStackTrace();
				
			}
		});
		
		thread.setDaemon(false);
		thread.start();
		
	}
	
}

