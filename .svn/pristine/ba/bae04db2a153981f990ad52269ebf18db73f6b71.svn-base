package testcases.logout;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

@Listeners({  buisness.Listeners.Screenshot.class})
public class Logout {

	@Test
	public void test() throws IOException, InvalidFormatException
	{
		
		TestExecutor exe=new TestExecutor();
		ConfigurationManager rd=new ConfigurationManager();
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("logout_excel");
		System.out.println("Logout starts");
		Setup.log.info("\nLogOut test case start");
		exe.testexecute(Filelocation,"Logout");
		System.out.println("Logout end");
		Setup.log.info("\nLogOut test case ends");
	       
	}
	
	
	
	
   
}
