package input;

public class DocumentReaderFactory {
	
	private ReaderAtbashDecorator readerAtbashDecorator;
	private ReaderRot13Decorator readerRot13Decorator;
	
	public DocumentReaderFactory() {
		
	}
	public DocumentReader createReader(String fileType, String fileName, String fileEncoding) {
		switch(fileType) {
		case "word": 
			return new WordReader(fileType, fileName, fileEncoding);
		case "excel": 
			return new ExcelReader(fileType, fileName, fileEncoding);
		default: return null;
		}
	}	
}