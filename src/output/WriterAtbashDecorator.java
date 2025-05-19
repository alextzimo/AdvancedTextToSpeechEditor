package output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import input.DocumentReader;

public class WriterAtbashDecorator extends WriterDecorator{

	
	DocumentReader docReader;
	String fileName;
	String fileType;
	
	public WriterAtbashDecorator(DocumentWriter docWriter) {
		super(docWriter);
	}

	public List<String> write(String ciphertext){
		List<String> encodedAtbashList = new ArrayList<String>();
		String plaintext = "";
		String out = "";
		for(char c : ciphertext.toCharArray()){
			out += c;
		}
		ciphertext = out;
		for(char c : ciphertext.toCharArray()){
			if(Character.isLowerCase(c)){
				plaintext += (char) ('z' + ('a' - c));
			}
			else if(Character.isUpperCase(c)){
				plaintext += (char) ('Z' + ('A' - c));
			}
			else{
				plaintext += c;
			}
		}
		encodedAtbashList = Arrays.asList(plaintext);
		return encodedAtbashList;
	}
}