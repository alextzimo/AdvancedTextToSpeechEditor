package input;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader implements DocumentReader{
	
	private String fileType;
	private String fileName;
	private String fileEncoding;
	private DocumentReader doc;
	public List<String> list = new ArrayList<String>();
	
	public ExcelReader(String fileType, String fileName, String fileEncoding) {
		this.fileType = fileType;
		this.fileName = fileName;
		this.fileEncoding = fileEncoding;
	}
	
	@Override
	public List<String> read() throws IOException{
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();
		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String str = cell.toString();
				list.add(str);
			}
			list.add("\n");
		}
		wb.close();
		fis.close();
		String str1="";
		for(String s : list)
        {
            str1 = str1 + s + ",";
        }
		if (fileEncoding == null) {
			return list;
		} else if (fileEncoding.equals("rot13")) {
			ReaderRot13Decorator rad = new ReaderRot13Decorator(doc);
			list = rad.read(str1);
		} else if (fileEncoding.equals("atbash")) {
			ReaderAtbashDecorator at = new ReaderAtbashDecorator(doc);
			list = at.read(str1);
		}
		return list;
	}
}