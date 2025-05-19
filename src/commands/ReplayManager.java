package commands;

import model.TTSFacade;

public class ReplayManager {

	private boolean recordingStatus = true;
	
	public ReplayManager(){
		
	}
	
	public void replay(){
		
	}
	
	public void startRecording(){
		
	}
	
	public void endRecording(){
		recordingStatus = false;
	}
	
	public boolean isActiveRecording(){
		return recordingStatus;
	}
}