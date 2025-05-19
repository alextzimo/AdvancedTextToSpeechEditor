package input;

import java.util.*;
import java.io.*;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import output.WordWriter;

public class WordReader implements DocumentReader {
	
	private String fileType;
	private String fileName;
	private String fileEncoding;
	private DocumentReader doc;
	public List<String> list = new ArrayList<String>();
	

	public WordReader(String fileType, String fileName, String fileEncoding) {
		this.fileType = fileType;
		this.fileName = fileName;
		this.fileEncoding = fileEncoding;
	}

	@Override
	public List<String> read() throws IOException{
		XWPFDocument document = null;
		FileInputStream fileInputStream = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XWPFDocument docx = new XWPFDocument(OPCPackage.open(fis));
			XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
			String str = extractor.getText();
			if (fileEncoding == null) {
				list.add(extractor.getText());
			}
			else if (fileEncoding.equals("rot13")) {
				ReaderRot13Decorator rad = new ReaderRot13Decorator(doc);
				list = rad.read(str);
			}
			else if (fileEncoding.equals("atbash")) {
				ReaderAtbashDecorator at = new ReaderAtbashDecorator(doc);
				list = at.read(str);
			}
		} catch (Exception e) {
			System.out.println("We had an error while reading the Word Doc.");
		} finally {
			try {
				if (document != null) {
					document.close();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception ex) {
			}
		}
		return list;
	  }
}