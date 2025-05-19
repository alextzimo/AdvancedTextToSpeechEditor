package commands;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Document;
import model.TTSFacade;
import view.MainApp;
import view.TextToSpeechEditorView;

public class DocumentToSpeech implements ActionListener {

	String fileType;
	String fileName;
	String fileEncoding;
	
	public DocumentToSpeech() {
		
	}
	
	public void setDocument(Document doc) {
		Document document = new Document(fileType, fileName, fileEncoding); 
	}
	
	public void setReplayManager(ReplayManager replayManager) {
		
	}
	
	// We create a TextToSpeechEditorView object which executes the text to audio command.
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TextToSpeechEditorView editorView = new TextToSpeechEditorView();
		editorView.textToSpeechEditorView();
	}	
}