package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import commands.SaveDocument;
import input.ExcelReader;
import model.Document;

class SaveExcelAtbashDocumentTest {

	Document doc;
	SaveDocument sd;
	String fileType = "excel";
	String fileName = "resources/xlsx_test_sample.xlsx";
	String fileEncoding = "atbash";
	List<String> list = new ArrayList<>();
	
	@Test
	void test() {
		doc = new Document(this.fileType, this.fileName, this.fileEncoding);
		try {
			doc.fakeSave(this.fileType, this.fileName, this.fileEncoding);
			ExcelReader testReader = new ExcelReader(this.fileType, this.fileName, this.fileEncoding);
			doc.open();
			Assert.assertEquals(Document.contents, testReader.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}