package output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements DocumentWriter{
	
	private DocumentWriter docWriter;
	String fileEncoding;
	
	public ExcelWriter() {
		
	}

	@Override
	public void write(String filePath, String saveFile, String fileEncoding) throws IOException {
		String cellValue = "";
		saveFile = "," + saveFile;
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("SavedSheet");
		int rowNum = 0;
		int cellNum = 0;
		if (fileEncoding == null){
			char x;
			Row row = sheet.createRow(rowNum);
			Cell cell = row.createCell(cellNum);
			for (int i = 0; i < saveFile.length(); i++){
				x = saveFile.charAt(i);
			    if (x != '\n' & x != ',') {
			    	cellValue += x;
			    }
			    else if (x == ','){
			    	cell.setCellValue(cellValue);
			    	cellValue = "";
			    	cell = row.createCell(cellNum++);
			    }
			    else {
			    	rowNum++;
			    	row = sheet.createRow(rowNum);
			    	cellValue = "";
			    	cellNum = 0;
			    }
				
			} try {
				FileOutputStream out = new FileOutputStream(new File(filePath));
				workbook.write(out);
				out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					workbook.close();
				}
		}
		else if (fileEncoding.equals("atbash")) {
			List<String> atbashList = new ArrayList<>();
			WriterAtbashDecorator wad = new WriterAtbashDecorator(docWriter);
			atbashList = wad.write(saveFile);
			String str = "";
			for(String s : atbashList){
				str =str + s;
			}
			saveFile = str;
			char x;
			Row row = sheet.createRow(rowNum);
			Cell cell = row.createCell(cellNum);
			for (int i = 0; i < saveFile.length(); i++){
				x = saveFile.charAt(i);
			    if (x != '\n' & x != ',') {
			    	cellValue += x;
			    }
			    else if (x == ','){
			    	cell.setCellValue(cellValue);
			    	cellValue = "";
			    	cell = row.createCell(cellNum++);
			    }
			    else {
			    	rowNum++;
			    	row = sheet.createRow(rowNum);
			    	cellValue = "";
			    	cellNum = 0;
			    }
				
			} try {
				FileOutputStream out = new FileOutputStream(new File(filePath));
				workbook.write(out);
				out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					workbook.close();
				}
		}
		else if (fileEncoding.equals("rot13")) {
			List<String> rot13List = new ArrayList<>();
			WriterRot13Decorator wrd = new WriterRot13Decorator(docWriter);
			rot13List = wrd.write(saveFile);
			String str = "";
			for(String s : rot13List){
				str =str + s;
			}
			saveFile = str;
			char x;
			Row row = sheet.createRow(rowNum);
			Cell cell = row.createCell(cellNum);
			for (int i = 0; i < saveFile.length(); i++){
				x = saveFile.charAt(i);
			    if (x != '\n' & x != ',') {
			    	cellValue += x;
			    }
			    else if (x == ','){
			    	cell.setCellValue(cellValue);
			    	cellValue = "";
			    	cell = row.createCell(cellNum++);
			    }
			    else {
			    	rowNum++;
			    	row = sheet.createRow(rowNum);
			    	cellValue = "";
			    	cellNum = 0;
			    }
				
			} try {
				FileOutputStream out = new FileOutputStream(new File(filePath));
				workbook.write(out);
				out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					workbook.close();
				}
		    } 
		}
		
}