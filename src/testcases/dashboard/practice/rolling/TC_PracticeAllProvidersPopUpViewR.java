package testcases.dashboard.practice.rolling;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

/**
 * This test case validate View of AllProvider popup present on Dashboard >> Practice >> select Measure >> All tab for Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case to validate View of AllProvider popup present on Dashboard >> Practice >> On select Measure >> on All tab for Rolling
 * @author rakesh.kulkarni
 * Date 25/03/2016
 */
public class TC_PracticeAllProvidersPopUpViewR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PracticeAllProvidersPopUpViewR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");		
		log.info("\nTC To validate View of AllProviders popup present on Dashboard > practice for Rolling");
		exe.testexecute(Filelocation,"TC_PAllProvidersViewR",data);
		log.info("\nTC To validate View of AllProviders popup present on Dashboard > practice for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeAllProvidersPopUpViewR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PAllProvidersViewR_Data");
		Setup.log.info("\n For TC To validate View of AllProviders popup present on Dashboard > practice for Rolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
