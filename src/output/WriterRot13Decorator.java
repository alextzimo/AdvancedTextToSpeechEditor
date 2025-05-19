package output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import input.DocumentReader;

public class WriterRot13Decorator extends WriterDecorator{

	List<String> encodedRot13List = new ArrayList<>();
	DocumentReader docReader;
	String fileName;
	String fileType;
	
	public WriterRot13Decorator(DocumentWriter docWriter) {
		super(docWriter);
	}
	
	public List<String> write(String saveFile) throws IOException {
		char[] values = saveFile.toCharArray();
		for (int i = 0; i < values.length; i++) {
		char letter = values[i];
		if (letter >= 'a' && letter <= 'z') {
		// Rotate lowercase letters.
			if (letter > 'm') {
				letter -= 13;
			} else {
				letter += 13;
			}
			} else if (letter >= 'A' && letter <= 'Z') {
			// Rotate uppercase letters.
				if (letter > 'M') {
					letter -= 13;
				} else {
					letter += 13;
				}
			}
			values[i] = letter;
		}
		String s = String.valueOf(values);
		encodedRot13List = Arrays.asList(s);
		return encodedRot13List;
	}
}