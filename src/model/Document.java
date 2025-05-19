package model;

import java.io.IOException;
import java.util.*;

import commands.SaveDocument;
import input.DocumentReader;
import input.DocumentReaderFactory;
import output.DocumentWriter;
import output.DocumentWriterFactory;

public class Document {

	public static  List<String> contents = new ArrayList<>();
	private DocumentReader documentReader;
	private DocumentWriter documentWriter;
	private DocumentWriterFactory docWriterFactory = new DocumentWriterFactory();
	private DocumentReaderFactory docReaderFactory = new DocumentReaderFactory();
	private TTSFacade audioManager;
	private String fileType;
	private String fileName;
	private String fileEncoding;
	private String saveFile;
	
	
	
	public Document(String fileType, String fileName, String fileEncoding) {
		this.fileType = fileType;
		this.fileName = fileName;
		this.fileEncoding = fileEncoding;
	}
	
	public void setAudioManager(TTSFacade facade) {
		facade = new TTSFacade();
	}
	
	public void setDocReaderFactory(DocumentReaderFactory docReaderFactory) {
		docReaderFactory = new DocumentReaderFactory();
	}
	
	public void setDocWriterFactory(DocumentWriterFactory docWriterFactory) {
		docWriterFactory = new DocumentWriterFactory();
	}
	
	public void open() throws IOException {
		documentReader = docReaderFactory.createReader(fileType, fileName, fileEncoding);
		contents.addAll(documentReader.read());
	}

	public void save(String fileType, String fileName, String fileEncoding) throws IOException {
		documentWriter = docWriterFactory.createWriter(fileType, fileName, fileEncoding);
		SaveDocument sd = new SaveDocument();
		documentWriter.write(fileName, sd.getSaveFile(), fileEncoding);
	}
	
	public void fakeSave(String fileType, String fileName, String fileEncoding) throws IOException {
		documentWriter = docWriterFactory.createWriter(fileType, fileName, fileEncoding);
		SaveDocument sd = new SaveDocument();
		documentWriter.write(fileName, sd.fakeSavedFileContents(), fileEncoding);
	}
}