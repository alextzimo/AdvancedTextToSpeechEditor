package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import commands.SaveDocument;
import input.WordReader;
import model.Document;

class SaveWordRot13DocumentTest {

	Document doc;
	SaveDocument sd;
	String fileType = "word";
	String fileName = "resources/docx_test_sample.docx";
	String fileEncoding = "rot13";
	List<String> list = new ArrayList<>();
	
	@Test
	void test() {
		doc = new Document(this.fileType, this.fileName, this.fileEncoding);
		try {
			doc.fakeSave(fileType, fileName, fileEncoding);
			WordReader testReader = new WordReader(this.fileType, this.fileName, this.fileEncoding);
			doc.open();
			Assert.assertEquals(Document.contents, testReader.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}