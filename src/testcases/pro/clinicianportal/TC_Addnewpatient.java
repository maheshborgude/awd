package testcases.pro.clinicianportal;

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
 * Test case to verify Add new patient in  clinician portal. 
 * 
 * @author awadhesh sengar
 * Created Date: 11nov 2017
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_Addnewpatient extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();
	
	@Test(dataProvider = "TC_Addnewpatient")
	
	public void testBlankPassword(Hashtable <String,String>data) throws IOException, InvalidFormatException
	
	{
		String Filelocation = System.getProperty("user.dir")+rd.read_Configfile("PRO_Clinicianportal");
		Setup.log.info("\nTest Case: TC_adding new patient starts");
		exe.testexecute(Filelocation, "TC_Addnewpatient",data);
		Setup.log.info("Test Case: TC_adding new patient");
		Setup.testcase.assertAll();
	}
	
		
	@DataProvider(name ="TC_Addnewpatient")
	public Object[][] getDataFromProviderPassword() throws IOException, InvalidFormatException
	
	{
		
		String Filelocation = System.getProperty("+user.dir")+rd.read_Configfile("PRO_Clinicianportal");
		Object [][] object = ex.getDataingrid(Filelocation, "TC_AddnewpatientData");
		return object;
		}
			
		
	}
	
	
	
	

