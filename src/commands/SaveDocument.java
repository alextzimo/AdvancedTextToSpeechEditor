package commands;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Document;
import view.MainApp;

public class SaveDocument implements ActionListener{
	
	private String fileType;
	private String fileName;
	private String fileEncoding;
	private static String saveFile;
	private Document doc;

	public SaveDocument() {
		
	}
	
	public void setDocument(Document doc) {
			try {
				doc.save(fileType, fileName, fileEncoding);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void setReplayManager(ReplayManager replayManager) {
		
	}
	
	public String fakeSavedFileContents() {
		String s = "fake file for testing.";
		return s;
	}
	
	// Getter for the data of the textArea that we are about to save.
	public String getSaveFile() {
		return saveFile;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!MainApp.atbashButton.isSelected() && !MainApp.rot13Button.isSelected()) {
			JFileChooser fc = new JFileChooser();
			File f =fc.getSelectedFile();
			saveFile = MainApp.textArea.getText();
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String userSaveFile = fc.getSelectedFile().toString();
				String userFileType = userSaveFile.substring(userSaveFile.length() - 4);
				if (userFileType.equals("docx")) {
					Document doc = new Document("word", userSaveFile, null);
					try {
						doc.save("word", userSaveFile, null);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if (userFileType.equals("xlsx")) {
					Document doc = new Document("excel", userSaveFile, null);
					try {
						doc.save("excel", userSaveFile, null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		else if (MainApp.atbashButton.isSelected() && !MainApp.rot13Button.isSelected()) {
			JFileChooser fc = new JFileChooser();
			File f =fc.getSelectedFile();
			saveFile = MainApp.textArea.getText();
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String userSaveFile = fc.getSelectedFile().toString();
				String userFileType = userSaveFile.substring(userSaveFile.length() - 4);
				if (userFileType.equals("docx")) {
					Document doc = new Document("word", userSaveFile, "atbash");
					try {
						doc.save("word", userSaveFile, "atbash");
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if (userFileType.equals("xlsx")) {
					Document doc = new Document("excel", userSaveFile, "atbash");
					try {
						doc.save("excel", userSaveFile, "atbash");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		else if (!MainApp.atbashButton.isSelected() && MainApp.rot13Button.isSelected()) {
			JFileChooser fc = new JFileChooser();
			File f =fc.getSelectedFile();
			saveFile = MainApp.textArea.getText();
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String userSaveFile = fc.getSelectedFile().toString();
				String userFileType = userSaveFile.substring(userSaveFile.length() - 4);
				if (userFileType.equals("docx")) {
					Document doc = new Document("word", userSaveFile, "rot13");
					try {
						doc.save("word", userSaveFile, "rot13");
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if (userFileType.equals("xlsx")) {
					Document doc = new Document("excel", userSaveFile, "rot13");
					try {
						doc.save("excel", userSaveFile, "rot13");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		else {
			JFrame errorFrame = new JFrame();
			JOptionPane.showMessageDialog(errorFrame, "Error. Both Atbash and Rot13 encodings are selected. Please choose one at most.");
		}
	}
}