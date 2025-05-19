package output;

import java.io.IOException;

public abstract class WriterDecorator implements DocumentWriter{
	
	DocumentWriter compomentWriter;
	String fileType;

	public WriterDecorator(DocumentWriter componentWriter) {
		this.compomentWriter = componentWriter;
	}
	
	@Override
	public void write(String filePath, String saveFile, String fileEncoding) throws IOException {
		
	}
}