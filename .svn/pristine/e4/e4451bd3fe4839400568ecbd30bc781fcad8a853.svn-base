package testcases.dashboard.practice.practiceAll.provider.nonRolling;

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
 * This test case validate View of AllProvider popup present on Dashboard >> Practice >> select Measure >> All tab for nonRolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case to validate View of AllProvider popup present on Dashboard >> Practice >> On select Measure >> on All tab for nonRolling
 * @author rakesh.kulkarni
 * Date 25/03/2016
 */
public class TC_PracticeAllProvidersPopUpViewNR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
    
	@Test(dataProvider="PracticeAllProvidersPopUpViewNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
				
		log.info("\nTC To validate View of AllProviders popup present on Dashboard > practice for nonRolling");
		exe.testexecute(Filelocation,"TC_PAllProvidersViewNR",data);
		log.info("\nTC To validate View of AllProviders popup present on Dashboard > practice for nonRolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeAllProvidersPopUpViewNR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PAllProvidersViewNR_Data");
		Setup.log.info("\n For TC To validate View of AllProviders popup present on Dashboard > practice for nonRolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
