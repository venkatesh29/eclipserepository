package Config;

import java.io.IOException;

public class xlreaderinvoke {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyXLSReader myxls=new MyXLSReader("E:\\SeleniumLab\\Day1\\src\\Config\\Zoho.xlsx");
		String c=myxls.getCellData("Data", 1, 1);
		System.out.println(c);
	}

}
