package model;

import com.sun.speech.freetts.*;

public class TTSFacade implements ITTSFacade{

	private VoiceManager vm;
	private Voice voice;
	private float volume;
	private int pitch;
	private int rate;
	private static String playedContents;
	
	public TTSFacade() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		vm = VoiceManager.getInstance();
		voice = vm.getVoice("kevin16");
		volume =  voice.getVolume();
		rate = (int) voice.getRate();
		pitch = (int) voice.getPitch();
	}
	
	@Override
	public void play(String x) {
		voice.allocate();
		voice.speak(x);
		System.out.println("Play track:" + x);
	}
	
	@Override
	public void setVolume(float x) {
		volume = x;
		voice.setVolume(x);
		System.out.println("Set volume to: " + x);
	}
	
	@Override
	public void setPitch(int x) {
		pitch = x;
		voice.setPitch(x);
		System.out.println("Set pitch to: " + x);
	}
	
	@Override
	public void setRate(int x) {
		rate = x;
		voice.setRate(x);
		System.out.println("Set rate to: " + x);
	}
	
	@Override
	public float getVolume() {
		return this.volume;
	}
	
	@Override
	public int getPitch() {
		return this.pitch;
	}
	
	@Override
	public int getRate() {
		return this.rate;
	}

	public static String getPlayedContents() {
		return playedContents;
	}
	
	public void setPlayedContents(String playedContents) {
		this.playedContents = playedContents;
	}
}