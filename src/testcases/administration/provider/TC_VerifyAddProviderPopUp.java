package testcases.administration.provider;


import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/**
 * Verifies Add New Provider Pop Up by checking all labels by XPath.
 * @author Sachin.Gawade
 * Created Date: 7 Jan 2016
 */

public class TC_VerifyAddProviderPopUp extends Setup  {

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
	ExcelReader ex= new ExcelReader();

	@Test(dataProvider="TC_VerifyAddProviderPopUp")
	public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{

		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
		Setup.log.info("\nTC_VerifyAddProviderPopUp test case starts");
		exe.testexecute(Filelocation,"TC_VerifyAddProviderPopUp",data);
		Setup.log.info("\nTC_VerifyAddProviderPopUp test case ends");
		Setup.testcase.assertAll();
	}

	@DataProvider(name="TC_VerifyAddProviderPopUp")
	public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
	{
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
		Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyAddProviderPopUp_data");
		return object;    
	}
}
