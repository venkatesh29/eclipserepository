package Day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XlsReader2DataProvider {
	
	
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	String SheetName="People";
	String filepath=System.getProperty("user.dir")+"\\src\\Config\\ExcelXLS.xls";
	String filexntn=filepath.substring(filepath.indexOf(".x"));
	FileInputStream fis;
	
	@Test(dataProvider="SchoolLoginData")
	public void LoginDetails(String Username,String Password) {
		System.out.println("Logged in with"+Username+" "+Password);
	}
	
	@DataProvider(name="SchoolLoginData")
	public Object[][] loginData() throws Exception{
		Object[][] userCredentials=readDataFromExcel();
		return userCredentials;
	}
	
	public String[][] readDataFromExcel() throws Exception {
		
		fis=new FileInputStream(filepath);
		if(filexntn.equalsIgnoreCase(".xlsx")) {
		workbook=new XSSFWorkbook(fis);
	     }
	else if(filexntn.equalsIgnoreCase(".xls")) {
		workbook=new HSSFWorkbook(fis);
	     }
		int rowcount=getRowCount("SchoolLoginData");
		System.out.println(rowcount);
		int columncount=getColumnCount("SchoolLoginData");
		System.out.print(columncount);
		
		String[][] exceldata=new String[rowcount-1][columncount];
		
		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<columncount;j++) {
				exceldata[i-1][j]=getCelldata("SchoolLoginData",j,i);
			}
		}
		return exceldata;
	}
		
	public boolean IsSheetExists(String SheetName) {	
		
		int SheetIndex=workbook.getSheetIndex(SheetName);
			if(SheetIndex==-1) {
				//if(SheetIndex==-1) 
				return false;
				//else
					//return true;
			}
			else
				return true;		
			
	}

	public int getRowCount(String SheetName) {
		
		int SheetIndex=workbook.getSheetIndex(SheetName);
		if(SheetIndex==-1) {
			return 0;
		}
		else {
			sheet=workbook.getSheet(SheetName);
			int rowsCount=sheet.getLastRowNum()+1;
			return rowsCount;
	}}

	public int getColumnCount(String SheetName) {
		sheet=workbook.getSheet(SheetName);
		row=sheet.getRow(0);
		if(row==null) {
			return -1;
		}
		return row.getLastCellNum();
	}
	
	public String getCelldata(String SheetName,int ColNum,int RowNum) {
		//try {
		if(RowNum<=0) {
			return "";
		}
		
//		int SheetIndex=workbook.getSheetIndex(SheetName);
//		if(SheetIndex==-1) {
//			return "";
//		}
//		
//		sheet=workbook.getSheet(SheetName);
//		
//		row=sheet.getRow(RowNum);
//		if(row==null) {
//			return "";
//		}
//		
//		cell=row.getCell(ColNum);
//		
//		if(cell==null) {
//			return "";}
//		
//		
//		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
//			return cell.getStringCellValue();
//		else if(cell.getCellType()==Cell.CELL_TYPE_FORMULA || cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
//			String cellText=String.valueOf(cell.getNumericCellValue());
//			return cellText;
//		}
//		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK) {
//				return "";
//		}
//		else
//			return String.valueOf(cell.getBooleanCellValue());
//		}catch(Exception e) {
//			e.printStackTrace();
//			return "row"+RowNum	+" or column"+ColNum+" does not exist";
//		}	
	
 }}
