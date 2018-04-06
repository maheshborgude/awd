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
 * This test case validate View of AllLocation popup present on Dashboard >> Practice >> select Measure >> All tab for Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Location
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case to validate View of AllLocation popup present on Dashboard >> Practice >> On select Measure >> on All tab for Rolling
 * @author rakesh.kulkarni
 * Date 25/03/2016
 */
public class TC_PracticeAllLocationPopUpViewR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PracticeAllLocationPopUpViewR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");		
		log.info("\nTC To validate View of AllLocation popup present on Dashboard > practice for Rolling");
		exe.testexecute(Filelocation,"TC_PAllLocationPopUpViewR",data);
		log.info("\nTC To validate View of AllLocation popup present on Dashboard > practice for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeAllLocationPopUpViewR")
    public Object[][] dataLocation() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PAllLocationPopUpViewR_Data");
		Setup.log.info("\n For TC To validate View of AllLocation popup present on Dashboard > practice for Rolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
