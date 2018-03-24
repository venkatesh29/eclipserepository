package xlreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlreader {
	public String filepath;
	FileInputStream fis=null;;
	Workbook workbook=null;;
	Sheet sheet=null;;
	Row row=null;;
	Cell cell=null;;
	public  FileOutputStream fileOut =null;
	String fileExtension=null;
	
public xlreader(String filepath) throws IOException{
		
		this.filepath = filepath;
		fileExtension = filepath.substring(filepath.indexOf(".x"));
		
	   try {
			fis = new FileInputStream(filepath);
			
			if(fileExtension.equals(".xlsx")){
				
				workbook = new XSSFWorkbook(fis);
				
				
			} else if(fileExtension.equals(".xls")){
				
				workbook = new HSSFWorkbook(fis);
				
			}
			
			sheet = workbook.getSheetAt(0);	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();			
		}}
	   
//returns the row count in a sheet
	public int getRowCount(String sheetname){
		
		int sheetIndex = workbook.getSheetIndex(sheetname);
		if(sheetIndex==-1){			
			return 0;
		} else {			
			sheet = workbook.getSheetAt(sheetIndex);
			int rowsCount = sheet.getLastRowNum()+1;
			return rowsCount;		
		}
		
	}
	
	public String getCellData(String sheetname,int colNum,int rowNum){
		try{
		if(rowNum <=0)
			return "";
		
		int sheetIndex = workbook.getSheetIndex(sheetname);
		
		if(sheetIndex==-1)
			return "";
		
		sheet = workbook.getSheetAt(sheetIndex);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(colNum-1);
		if(cell==null)
			return "";
		
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			  return cell.getStringCellValue();
		  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  return cellText;
		  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		      return "";
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		
	       }catch(Exception e){
	    	   
	    	   e.printStackTrace();
			   return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
	    	   
	       }
	}
	   
	   
	   
		
	
	

	
	
	
}
