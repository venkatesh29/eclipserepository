package Log4j;

import java.util.logging.Logger;

import org.testng.annotations.Test;

public class Testlog4j extends TestBase{
	private static final Logger log=Logger.getLogger(Testlog4j.class.getName());
	
	@Test
	public void testlogin() {
		log.info("starting the test");
		log.info("Executing the method1");	
		log.info("Executing the method2");
		log.info("Execution completed");
	}
}
