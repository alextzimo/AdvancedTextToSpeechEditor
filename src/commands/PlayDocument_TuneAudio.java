package commands;

import java.awt.event.ActionEvent;

import model.TTSFacade;
import view.TextToSpeechEditorView;

public class PlayDocument_TuneAudio implements ActionListener {

	private String docText;
	
	public PlayDocument_TuneAudio() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		docText = TextToSpeechEditorView.editorTextArea.getText();
		TTSFacade facade = new TTSFacade();
		facade.setVolume((float) (TextToSpeechEditorView.slider.getValue() * 0.1));
		facade.setPitch(TextToSpeechEditorView.slider_1.getValue());
		facade.setRate(TextToSpeechEditorView.slider_2.getValue());
		facade.play(docText);
	}
}