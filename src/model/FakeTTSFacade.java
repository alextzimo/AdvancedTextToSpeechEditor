

/*
 * 
 * This class is implemented for testing.
 * 
 */

package model;

public class FakeTTSFacade extends TTSFacade implements ITTSFacade {

	private float volume;
	private int pitch;
	private int rate;
	
	public FakeTTSFacade() {
	}
	
	@Override
	public void play(String text) {
		setPlayedContents(text);
		String playedContents = getPlayedContents();
		playedContents = text;
		super.play(text);
	}
	
	@Override
	public void setVolume(float x) {
		this.volume = x;
		super.setVolume(x);
	}
	
	@Override
	public void setPitch(int x) {
		this.pitch = x;
		super.setPitch(x);
	}
	
	@Override
	public void setRate(int x) {
		this.rate = x;
		super.setRate(x);
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
}