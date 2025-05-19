package output;

public class DocumentWriterFactory {
	
	public DocumentWriterFactory() {
		
	}
	
	public DocumentWriter createWriter(String fileType, String fileName, String fileEncoding) {
		switch(fileType) {
		case "word": return new WordWriter();
		case "excel": return new ExcelWriter();
		default: return null;
		}
	}
}