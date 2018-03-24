package Autofillers;

import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Date d=new Date();
         String date=d.toString();
         String updatedDate= date.replace(" ","_").replace(":","_");
         String FileName=updatedDate+".html";
         String FilePath="reports//"+FileName;
         
         
         
	}

}
