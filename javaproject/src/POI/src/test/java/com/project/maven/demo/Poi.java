package com.project.maven.demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

public class Poi {
	String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\ExcelXLS.xls";
	String Test="Login3";
	
	@Test
	public void x() throws IOException{
	FileInputStream fis=new FileInputStream(filepath);
	Workbook workbook=new HSSFWorkbook(fis);
	Sheet sheet=workbook.getSheet("People");	
	int rownumbers=sheet.getLastRowNum();
	System.out.println(rownumbers);
	for(int i=0;i<rownumbers;i++) {
		Row row=sheet.getRow(i);
		Cell cell=row.getCell(0);
		String s="";
		
		if(cell.getCellTypeEnum()==CellType.BLANK) {
			s="";
		}

		if(cell.getCellTypeEnum()==CellType.STRING) {
			s=cell.getStringCellValue();
			System.out.println(s);}}
	fis.close();
	}	
}

	
	
	
	
	
//	int colnumbers=sheet.getRow(0).getLastCellNum();
//	System.out.println("row numbers are "+rownumbers+" colnumbers are "+colnumbers);
//	
//	String[][] exceldata=new String[rownumbers][colnumbers];
//	
//	for(int i=1;i<=rownumbers;i++) {
//		for(int j=0;j<colnumbers;j++) {
//			
//			String k=sheet.getRow(i).getCell(j).getStringCellValue();
//			exceldata[i-1][j]=k;
//		}
//	}
//	
//	fis.close();
//	for(int i=0;i<rownumbers;i++) {
//		for(int j=0;j<colnumbers;j++) {
//			System.out.println(exceldata[i][j]);
//		}
//	}
	
	
//	
//	int TestStartNumber=0;	
//	String k="";
//	
//	            for(int i=0;i<rownumbers;i++) {
//				Row row=sheet.getRow(i);
//				Cell cell=sheet.getRow(i).getCell(0);				
//				if(cell.getCellType()==Cell.CELL_TYPE_BLANK ) {
//					k="";
//				}					                 
//                if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
//	                 k=cell.getStringCellValue();	
//	                 
//			         if(k.equals(Test)) {			    	
//			         TestStartNumber=i;
//			         break;}}}
//	                 System.out.println(k+"  "+TestStartNumber);
//       fis.close();                                
//}}
