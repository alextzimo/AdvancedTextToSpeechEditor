// The class for turning into audio specific parts of the file.

package commands;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.TTSFacade;
import view.MainApp;
import view.TextToSpeechEditorView;

public class PlaySelectedDocument implements ActionListener {

	private String s;

	public PlaySelectedDocument() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s = TextToSpeechEditorView.getSelectedText();
		TTSFacade facade = new TTSFacade();
		facade.setVolume((float) (TextToSpeechEditorView.slider.getValue() * 0.1));
		facade.setPitch(TextToSpeechEditorView.slider_1.getValue());
		facade.setRate(TextToSpeechEditorView.slider_2.getValue());
		facade.play(s);
	}
	
	public String getText() {
		return s;
	}
}