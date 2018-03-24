package Config;

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

public class WriteExcelFiles {

	public static void main(String[] args) throws IOException {
		//Create an array with the data in the same order in which you expect to be filled in excel file
				String valueToWrite[] = {"Mr. E" ,"005" ,"Associate Test Engineer","Pending Submission"};
		       
				String filepath = System.getProperty("user.dir")+ "\\src\\excelHandling";
		 
		        //Write the file using file name , sheet name and the data to be filled
		        writeExcelFile(filepath , "ExcelXLSX.xlsx" , "EmployeeData" , valueToWrite );
		       
		        //Write the file using file name , sheet name and the data to be filled
		       // writeExcelFile(filepath , "ExcelXLS.xls" , "EmployeeData" , valueToWrite);

			}
		 
			public static void writeExcelFile(String filepath,String filename,String sheetname,String[] dataToWrite ) throws IOException{
		       
		       File file = new File(filepath+ "\\"+filename );
		        //Create an object of FileInputStream class to read excel file
		       FileInputStream fis = new FileInputStream(file);
		       Workbook workbook = null ;
		        //Find the file extension by spliting file name in substing and getting only extension name
		       String fileExtension = filename.substring(filename .indexOf("."));
		        //Check condition if the file is xlsx file or xls file
		        if(fileExtension .equals(".xlsx")){
		             
		              //If it is xlsx file then create object of XSSFWorkbook class
		              workbook = new XSSFWorkbook(fis);
		       
		       } else if (fileExtension .equals(".xls")){
		             
		              //If it is xls file then create object of XSSFWorkbook class
		              workbook = new HSSFWorkbook(fis);
		       }
		       
		        //Read excel sheet by sheet name
		        Sheet sheet = workbook .getSheet(sheetname);
		        //Get the current count of rows in excel file
		        int rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		        //Get the first row from the sheet
		        Row row = sheet .getRow(0);
		        //Create a new row and append it at last of sheet
		        Row newRow = sheet .createRow(rowCount+1);
		        //Create a loop over the cell of newly created Row
		        for(int j =0;j<row.getLastCellNum(); j++){
		              //Fill data in row
		             Cell cell = newRow .createCell(j);
		              cell.setCellValue(dataToWrite [j]);
		        }
		       
		        //Close input stream
		        fis.close();
		       
		        //Create an object of FileOutputStream class to create write data in excel file
		        FileOutputStream fos = new FileOutputStream(file);
		        //write data in the excel file
		        workbook.write(fos );
		        //close output stream
		        fos.close();

	}

}
