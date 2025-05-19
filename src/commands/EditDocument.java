package commands;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import view.MainApp;

public class EditDocument implements ActionListener{

	public EditDocument() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainApp.textArea.setEditable(true);
	}
}