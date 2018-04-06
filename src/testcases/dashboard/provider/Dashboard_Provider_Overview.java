package testcases.dashboard.provider;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * 
 * @author Nikita Desai
 *
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class Dashboard_Provider_Overview extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
	 @Test(dataProvider="hybridData", priority=15)
		public void test(Hashtable <String,String> data) 
		{
		  
		   try
		   {
			String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
			System.out.println("TC DashBoard > Provider Overview Starts");
			configuration.Setup.log.info("\n TC DashBoard > Provider Overview starts");
			exe.testexecute(Filelocation,"provider",data);
			System.out.println("TC DashBoard > Provider Overview Ends");
			Setup.log.info("\nTC DashBoard > Provider Overview Ends");
		   }
		   catch(Exception e)
			  {
				  e.printStackTrace();
				 Setup.log.fatal(e.toString());
			 }
			    
		      
		}
		
		@DataProvider(name="hybridData")
	    public Object[][] getDataFromDataprovider14() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"duration");
			Setup.log.info("\n For TC DashBoard > Provider Overview, Use Data from duration sheet of file "+Filelocation);
	        return object;    
	    }
}
