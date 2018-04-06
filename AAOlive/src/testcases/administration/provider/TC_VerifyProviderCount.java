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
 * Verifies Provider Count.
 * 
 * @author Sachin.Gawade
 * Created Date: 8 Jan 2016
 */

public class TC_VerifyProviderCount extends Setup{
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();

    @Test(dataProvider="TC_VerifyProviderCount")
	public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{

    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
    	Setup.log.info("\nTC_VerifyProviderCount test case starts");
    	exe.testexecute(Filelocation,"TC_VerifyProviderCount",data);
    	Setup.log.info("\nTC_VerifyProviderCount test case ends");
    	Setup.testcase.assertAll();
	}

	@DataProvider(name="TC_VerifyProviderCount")
    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyProviderCount_data");
        return object;    
    }
	
	

}
