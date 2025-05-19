package tests;

import java.io.IOException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import commands.DocumentToSpeech;
import model.Document;
import model.FakeTTSFacade;

class TuneAudioTest {

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
			faketts.setVolume((float) 0.9);
			faketts.setPitch(80);
			faketts.setRate(150);
			faketts.play(str);
			Assert.assertEquals(faketts.getVolume(), 0.9, 0.01);
			Assert.assertEquals(faketts.getPitch(), 80);
		    Assert.assertEquals(faketts.getRate(), 150);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}