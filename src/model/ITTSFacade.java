package model;

public interface ITTSFacade {
	
	public void play(String x);
	
	public void setVolume(float x);
	
	public void setPitch(int x);
	
	public void setRate(int x);
	
	public float getVolume();
	
	public int getPitch();
	
	public int getRate();
}