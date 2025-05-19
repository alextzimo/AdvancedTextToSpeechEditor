package output;

import java.io.IOException;

public interface DocumentWriter {

	public void write(String filePath, String saveFile, String fileEncoding) throws IOException;
}