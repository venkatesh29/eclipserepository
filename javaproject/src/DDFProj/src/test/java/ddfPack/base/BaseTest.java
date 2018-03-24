package ddfPack.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {
	  public Properties prop = null;
		
	  //Initialization
	  public void initialise(){
		  
		  if(prop==null){
				
				prop = new Properties();
				
				File projectConfigFile = new File("src\\test\\resources\\projectconfig.properties");
				
				FileInputStream fis = null;
				
				try {
					
					 fis = new FileInputStream(projectConfigFile);
					 prop.load(fis);
					
				} catch (Exception e) {
			
					e.printStackTrace();
					
				}
				
			}
		  
	  }
}
