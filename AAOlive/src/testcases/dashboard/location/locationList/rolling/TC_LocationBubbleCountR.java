package testcases.dashboard.location.locationList.rolling;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_LocationBubbleCountR extends Setup {
	/*@Author Awadhesh Sengar
	 * 12/20/2017
	 * Testcase to verify if location count displayed in Dashboard side bar matches with the database count.
	 */
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="LocationBubbleCountR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
		log.info("\nTC To validate bubble count for Location on dashboard non rolling");
		exe.testexecute(Filelocation,"TC_LbubbleCountR",data);
		log.info("\nTC To validate bubble count for Location on dashboard non rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="LocationBubbleCountR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_LbubbleCountR_Data");
		Setup.log.info("\n For To validate bubble count for Location on dashboard non rolling, DataFile is used from "+Filelocation);
        return object;    
    } 

}