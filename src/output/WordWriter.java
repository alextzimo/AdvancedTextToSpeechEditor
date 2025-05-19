package output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriter implements DocumentWriter{
	
	public List<String> encodedList = new ArrayList<String>();
	private DocumentWriter docWriter;
	private String str = "";
	
	public WordWriter() {
		
	}
	
	public String saveFileContents() {
		return str;
	}
	
	@Override
	public void write(String filePath, String saveFile, String fileEncoding) throws IOException {
		XWPFDocument document = new XWPFDocument();
	    FileOutputStream out = new FileOutputStream(new File(filePath));
	    XWPFParagraph paragraph = document.createParagraph();
	    XWPFRun run = paragraph.createRun();
	    if (fileEncoding == null) {
	    	run.setText(saveFile);
	    }
	    else if (fileEncoding.equals("atbash")) {
	    	WriterAtbashDecorator wad = new WriterAtbashDecorator(docWriter);
	    	encodedList = wad.write(saveFile);
	        for(String s : encodedList)
	        {
	            str=str + s;
	        }
	        run.setText(str);
	    }
	    else if (fileEncoding.equals("rot13")){
	    	WriterRot13Decorator wad = new WriterRot13Decorator(docWriter);
	    	encodedList = wad.write(saveFile);
	    	String str="";
	        for(String s : encodedList)
	        {
	            str=str + s;
	        }
	        run.setText(str);
	    }
	    document.write(out);
	    out.close();
	}
}