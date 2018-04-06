package testcases.dashboard.location;
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
 * Test case to verify total Dashboard location of count On UI and compare this count with database. 
 * 
 * @author nilesh.patil
 * Created date : 4 FEB  2015
 */

@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_VerifyGridCount  extends Setup {
	

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
	
	@Test(dataProvider="TC_VerifyGridCount")
	public void providercount(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
		System.out.println("TC_VerifyGridCount Count Starts");
		configuration.Setup.log.info("\n TC_Totallocation_Count Count Starts");
		exe.testexecute(Filelocation,"TC_VerifyGridCount",data);
		System.out.println("TC TC_Totallocation_Count Count End");
		Setup.log.info("\n TC_Totallocation_Count Count End");
		Setup.testcase.assertAll();
	  }
	  catch(Exception e)
	  {
		  Setup.log.fatal(e.toString());
	   }
	       
	 }

	@DataProvider(name="TC_VerifyGridCount")
    public Object[][] getDataFromDataprovider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyGridCount_Data");
        return object;    
    } 
}
