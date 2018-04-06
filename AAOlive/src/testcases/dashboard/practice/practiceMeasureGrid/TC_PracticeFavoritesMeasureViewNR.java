package testcases.dashboard.practice.practiceMeasureGrid;

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
 * This test case validate View of Favorites Measure present on Dashboard >> Practice for NonRolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate view of Favorites Measure for nonRolling
 * @author rakesh.kulkarni Created Date 15/03/2016
 * @author probeer.roy Updated Date: 07/12/2017
 */
public class TC_PracticeFavoritesMeasureViewNR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
    public String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("measuregrid_excelpath");	
    
	@Test(dataProvider="PFMViewNR", groups ="MeasureGrid")
	public void test(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{	
		System.out.println("-------------TC_PracticeFavoritesMeasureViewNR-------------");
		log.info("\n Testcase: to validate data favorites measures present on Dashboard: NonRolling");
		exe.testexecute(Filelocation,"TC_PFMViewNR",data);
		log.info("\n Ends Here");
		Setup.testcase.assertAll();
	}
	
	@DataProvider(name="PFMViewNR")
    public Object[][] getDataFromDataProvider() throws IOException, InvalidFormatException
	{
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PFMViewNR_Data");
		//Setup.log.info("\n For TC To validate data(View) of Favorites Measure present on Dashboard > practice for NonRolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
