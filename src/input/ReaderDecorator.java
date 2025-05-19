package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ReaderDecorator implements DocumentReader{
	
	public static DocumentReader componentReader;
	DocumentReaderFactory fact = new DocumentReaderFactory();
	String fileType;
	String fileName;
	String fileEncoding;
	List<String> list = new ArrayList<String>();
	
	public ReaderDecorator(DocumentReader componentReader) {
		this.componentReader = componentReader;
	}
	
	@Override
	public abstract List<String> read() throws IOException;
}