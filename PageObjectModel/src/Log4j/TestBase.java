package Log4j;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static final Logger log=Logger.getLogger(TestBase.class.getName());

@BeforeTest
public void loadlog4j() {
	String log4jfilepath=System.getProperty("user.dir")+"\\src\\log4j.properties";
	PropertyConfigurator.configure(log4jfilepath);	
}
}
