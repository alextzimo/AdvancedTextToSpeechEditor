package tests;

import java.io.IOException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import input.WordReader;
import model.Document;

class OpenWordRot13DocumentTest {
	
	OpenDocument od;
	Document doc;
	String fileType = "word";
	String fileName = "resources/docx_test_sample.docx";
	String fileEncoding = "rot13";
	
	@Test
	void test() {
		doc = new Document(this.fileType, this.fileName, this.fileEncoding);
		od = new OpenDocument();
		try {
			doc.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
		WordReader wr = new WordReader(this.fileType, this.fileName, this.fileEncoding);
		try {
			Assert.assertEquals(Document.contents, wr.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}