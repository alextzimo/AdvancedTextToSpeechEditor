package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Document;

public class ReaderAtbashDecorator extends ReaderDecorator{
	
	Document doc;
	static List<String> atbashList = new ArrayList<>(); 
	List<String> decodedAtbashList = new ArrayList<>(); 
	
	public ReaderAtbashDecorator(DocumentReader docReader) {
		super(docReader);
	}

	public List<String> read(String ciphertext){

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
		list = Arrays.asList(plaintext);
		return list;
		}
	
	@Override
	public List<String> read() throws IOException {
		return null;
	}
}