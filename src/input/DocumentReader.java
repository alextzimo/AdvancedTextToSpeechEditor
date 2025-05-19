package input;

import java.io.IOException;
import java.util.List;

public interface DocumentReader {
	
	public List<String> read() throws IOException;
	
}