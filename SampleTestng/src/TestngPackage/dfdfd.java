package TestngPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

public class dfdfd {
@Test
public void dfdfd() throws IOException {
	String FilePath=System.getProperty("user.dir")+"\\src\\Config\\RedBusDetails.xlsx";
	FileInputStream fis=new FileInputStream(FilePath);	
	FileOutputStream fout=new FileOutputStream(FilePath);
	
            Workbook workbook=new XSSFWorkbook(FilePath);
    XSSFSheet sheet=workbook.getSheet("Sheet2");
//    for(int i=0;i<10;i++) {
//    	for(int j=0;j<2;j++) {
//    		
    		XSSFCell cell=sheet.createRow(1).createCell(2);
    		cell.setCellValue("Venki");
//    	}
//    }
//	
	workbook.write(fout);
	fout.close();
}
}
