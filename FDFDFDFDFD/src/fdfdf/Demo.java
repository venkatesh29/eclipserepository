package fdfdf;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Demo {
  @Test
  public void f() {
	  
		// TODO Auto-generated method stub
		String FilePath=System.getProperty("user.dir")+"\\src\\Config\\RedBusDetails.xlsx";
		FileInputStream fis=new FileInputStream(FilePath);	
		FileOutputStream fout=new FileOutputStream(FilePath);
		
		Workbook workbook=new XSSFWorkbook(FilePath);
	    Sheet sheet=workbook.getSheet("Sheet2");
//	    for(int i=0;i<10;i++) {
//	    	for(int j=0;j<2;j++) {
//	    		
	    		Cell cell=sheet.createRow(1).createCell(2);
	    		cell.setCellValue("Venki");
//	    	}
//	    }
//		
		workbook.write(fout);
		fout.close();
		
	  
  }
}
