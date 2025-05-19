package commands;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Document;
import view.MainApp;


public class OpenDocument implements ActionListener{

	String fileType;
	String fileName;
	String fileEncoding;
	OpenDocument openDocument;
	CommandsFactory commandsFactory = new CommandsFactory();
	
	public OpenDocument() {
		
	}
	
	// Method to put the contents of the docx file to textArea.
	public void setDocx() {
		List<String> list = model.Document.contents;
		String str="";
		for(String s : list)
        {
            str=str + s;
        }
		MainApp.textArea.setText(str);
	}
	
	// Method to put the contents of the xlsx file to textArea.
	public void setXlsx() {
		List<String> list = model.Document.contents;
		String str="";
		for(String s : list)
        {
            str=str + s + ",";
        }		
		MainApp.textArea.setText(str);
	}
	
	public void setDocument(Document doc) {
		try {
			doc.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setReplayManager(ReplayManager replayManager) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!MainApp.atbashButton.isSelected() && !MainApp.rot13Button.isSelected()) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Word and Excel","docx","xlsx");
			fileChooser.setFileFilter(filter);
			if (fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
		        File f = fileChooser.getSelectedFile();
		        fileName = f.getAbsolutePath();
		        String lastFour = fileName.substring(fileName.length() - 4);
		        if (lastFour.equals("docx")) {
		        	fileType = "word";
		        	MainApp.textArea = new JTextArea();
		    		MainApp.scrollPane.setViewportView(MainApp.textArea);
		    		MainApp.textArea.setEditable(false);
		        	openDocument = (OpenDocument) commandsFactory.createCommand("open");
		        	Document doc = new Document(fileType, fileName, null);
		        	openDocument.setDocument(doc);
		        	openDocument.setDocx();
		        }
		        else if (lastFour.equals("xlsx")) {
		        	fileType = "excel";
		        	MainApp.textArea = new JTextArea();
		    		MainApp.scrollPane.setViewportView(MainApp.textArea);
		    		MainApp.textArea.setEditable(false);
		    		openDocument = (OpenDocument) commandsFactory.createCommand("open");
		        	Document doc = new Document(fileType, fileName, null);
		        	openDocument.setDocument(doc);
		        	openDocument.setXlsx();
		        }
		    }
		} else if (MainApp.atbashButton.isSelected() && !MainApp.rot13Button.isSelected()) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Word and Excel","docx","xlsx");
			fileChooser.setFileFilter(filter);
			if (fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
		        File f = fileChooser.getSelectedFile();
		        fileName = f.getAbsolutePath();
		        String lastFour = fileName.substring(fileName.length() - 4);
		        if (lastFour.equals("docx")) {
		        	fileType = "word";
		        	MainApp.textArea = new JTextArea();
		    		MainApp.scrollPane.setViewportView(MainApp.textArea);
		    		MainApp.textArea.setEditable(false);
		    		openDocument = (OpenDocument) commandsFactory.createCommand("open");
		        	Document doc = new Document(fileType, fileName, "atbash");
		        	openDocument.setDocument(doc);
		        	openDocument.setDocx();
		        }
		        else if (lastFour.equals("xlsx")) {
		        	fileType = "excel";
		        	MainApp.textArea = new JTextArea();
		    		MainApp.scrollPane.setViewportView(MainApp.textArea);
		    		MainApp.textArea.setEditable(false);
		    		openDocument = (OpenDocument) commandsFactory.createCommand("open");
		        	Document doc = new Document(fileType, fileName, "atbash");
		        	openDocument.setDocument(doc);
		        	openDocument.setXlsx();
		        }
		    }
		} else if (!MainApp.atbashButton.isSelected() && MainApp.rot13Button.isSelected()) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Word and Excel","docx","xlsx");
			fileChooser.setFileFilter(filter);
			if (fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
		        File f = fileChooser.getSelectedFile();
		        fileName = f.getAbsolutePath();
		        String lastFour = fileName.substring(fileName.length() - 4);
		        if (lastFour.equals("docx")) {
		        	fileType = "word";
		        	MainApp.textArea = new JTextArea();
		    		MainApp.scrollPane.setViewportView(MainApp.textArea);
		    		MainApp.textArea.setEditable(false);
		    		openDocument = (OpenDocument) commandsFactory.createCommand("open");
		        	Document doc = new Document(fileType, fileName, "rot13");
		        	openDocument.setDocument(doc);
		        	openDocument.setDocx();
		        }
		        else if (lastFour.equals("xlsx")) {
		        	fileType = "excel";
		        	MainApp.textArea = new JTextArea();
		    		MainApp.scrollPane.setViewportView(MainApp.textArea);
		    		MainApp.textArea.setEditable(false);
		    		openDocument = (OpenDocument) commandsFactory.createCommand("open");
		        	Document doc = new Document(fileType, fileName, "rot13");
		        	openDocument.setDocument(doc);
		        	openDocument.setXlsx();
		        }
		    }
		} else {
			JFrame errorFrame = new JFrame();
			JOptionPane.showMessageDialog(errorFrame, "Error. Both Atbash and Rot13 encodings are selected. Please choose one at most.");
		}
	}
}