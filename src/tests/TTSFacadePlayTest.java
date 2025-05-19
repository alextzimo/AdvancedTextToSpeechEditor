package tests;

import java.io.IOException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import commands.DocumentToSpeech;
import model.Document;
import model.FakeTTSFacade;

class TTSFacadePlayTest {

	private String fileType = "word";
	private String fileName = "resources/docx_test_sample.docx";
	private String fileEncoding = null;
	
	@Test
	void test() {
		FakeTTSFacade faketts = new FakeTTSFacade();
		Document doc = new Document(this.fileType, this.fileName, this.fileEncoding);
		DocumentToSpeech dts = new DocumentToSpeech();
		dts.setDocument(doc);
		try {
			doc.open();
			String str="";
			for(String s : Document.contents)
	        {
	            str=str + s;
	        }
			faketts.play(str);
		    Assert.assertEquals(str, FakeTTSFacade.getPlayedContents());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}