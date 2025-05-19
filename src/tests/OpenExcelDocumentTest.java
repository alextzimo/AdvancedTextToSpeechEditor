package tests;

import java.io.IOException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import input.ExcelReader;
import model.Document;

class OpenExcelDocumentTest {

	OpenDocument od;
	Document doc;
	String fileType = "excel";
	String fileName = "resources/xlsx_test_sample.xlsx";
	String fileEncoding = null;
	
	@Test
	void test() {
		doc = new Document(this.fileType, this.fileName, this.fileEncoding);
		od = new OpenDocument();
		try {
			doc.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExcelReader er = new ExcelReader(this.fileType, this.fileName, this.fileEncoding);
		try {
			Assert.assertEquals(Document.contents, er.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}