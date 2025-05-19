package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Document;

public class ReaderRot13Decorator extends ReaderDecorator{
		
	public ReaderRot13Decorator(DocumentReader docReader) {
		super(docReader);
	}

	public List<String> read(String value) {
		char[] values = value.toCharArray();
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
		// Convert array to a new String.
		String s = String.valueOf(values);
		list = Arrays.asList(s);
		return list;
	}

	@Override
	public List<String> read() throws IOException {
		return null;
	}
}