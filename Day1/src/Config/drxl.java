
package Config;
import java.io.File;
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

public class drxl {
	String filepath = System.getProperty("user.dir")+"\\src\\Config\\ExcelXLS.xls";
	String Test="Login1";
	@Test
	public void x() throws IOException{
	FileInputStream fis=new FileInputStream(filepath);
	Workbook workbook=new HSSFWorkbook(fis);
	Sheet sheet=workbook.getSheet("People");	
	int rownumbers=sheet.getLastRowNum();
	
	int colnumbers=sheet.getRow(0).getLastCellNum();
	System.out.println("Rowscount: "+rownumbers+" Columnscount: "+colnumbers);}}
//	    String[][] exceldata=new String[rownumbers][colnumbers];	
//	    for(int i=1;i<=rownumbers;i++) {
//		for(int j=0;j<colnumbers;j++) {		
//			String k=sheet.getRow(i).getCell(j).getStringCellValue();
//			exceldata[i-1][j]=k;			
//		}}
//
//	for(int i=0;i<rownumbers;i++) {
//		for(int j=0;j<colnumbers;j++) {
//			System.out.println(exceldata[i][j]);}} 
//	        fis.close();}}
//	
//
////	             int TestStartNumber=0;	
////	             String k="";
////	
////	            for(int i=0;i<rownumbers;i++) {
////				Row row=sheet.getRow(i);
////				Cell cell=sheet.getRow(i).getCell(0);				
////				if(cell.getCellType()==Cell.CELL_TYPE_BLANK ) 
////					k="";
////								                 
////                if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
////	                 k=cell.getStringCellValue();	
////	                 
////			         if(k.equals(Test)) {			    	
////			         TestStartNumber=i;
////			         break;}
////	                // System.out.println(k+"  "+TestStartNumber);
////                  }}      
////	            
////
////	   int ColumnStartRow=TestStartNumber+1;
////	   int DataStartRow=TestStartNumber+2;
////	   int DataEndRow=0;
////	   int temp=DataStartRow;	   
////
////       
////     for(temp=DataStartRow;temp<=rownumbers;temp++) {
////   	   if(sheet.getRow(temp).getCell(0).getCellType()==Cell.CELL_TYPE_BLANK) {
////    		   DataEndRow=temp;
////    		  break; 
////    	   }
////       }
////     fis.close();
////       if(DataEndRow==0) {
////	   DataEndRow=rownumbers;}
////     System.out.println(k+"  "+TestStartNumber+"     "+DataEndRow);
////	}}
////   
////       if(DataEndRow==0) {
////    	   DataEndRow=rownumbers;
////      }
////       System.out.println(ColumnStartRow+"      "+DataStartRow+"    "+DataEndRow);  
////       fis.close();
////	}}
////	   
////	   System.out.println("Data starts at "+DataStartRow+" and ends at "+DataEndRow);
////   
////       int totalcolumns=sheet.getRow(ColumnStartRow).getLastCellNum();
////     //  String[][] exceldata=new String[][totalcolumns]; kjkjljljkljl
////       for(int j=0;j<totalcolumns;j++) {
////	   String ColumnHeader=sheet.getRow(ColumnStartRow).getCell(j).getStringCellValue();
////	   String TestData=sheet.getRow(DataStartRow).getCell(j).getStringCellValue();
////	   System.out.println(ColumnHeader);
////	   System.out.println(TestData);
////      // fis.close();   kjkjlkjljk
//// 
////    }
////	fis.close();
