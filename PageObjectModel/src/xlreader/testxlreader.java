package xlreader;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



public class testxlreader {
	public String filepath=System.getProperty("user.dir")+"//src//Config//ExcelXLS.xls";
	public int RowCount;
	public xlreader xlr;
	public String runmode;
	public String testcase="TC_006";
	public int Objectfoundatrow;
	
	@Test(priority=1)
	public void testingxlreader() throws IOException {
		 xlr=new xlreader(filepath);
		RowCount=xlr.getRowCount("SchoolLoginData");
		
	}
	@Test(priority=2)
	public void runmode() {
		getrunmode();		
	}
	
	@Test(priority=3)
	public void Runmodeassertion() {
		
		Assert.assertEquals(runmode, "Y");
		
	}
		
	public void getrunmode() {
		for(int i=2;i<=RowCount;i++) {
			String  xltestcase=xlr.getCellData("SchoolLoginData", 3, i);
			if(xltestcase.equals(testcase)) {
			          runmode=xlr.getCellData("SchoolLoginData", 4, i);	
			}		 
		}		
	}
	

}
