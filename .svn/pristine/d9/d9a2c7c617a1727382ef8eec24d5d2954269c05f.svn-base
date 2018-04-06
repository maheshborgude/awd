package testcases.dashboard.practice.practicePerformanceTrend;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_PPTPatientDDView extends Setup  {

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();

    @Test(dataProvider="PPTPatientDDView")

	public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{

    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");

    	Setup.log.info("TC_PPTPatientDDViewR test case starts");
    	exe.testexecute(Filelocation,"TC_PPTPatientDDViewR",data);
    	Setup.log.info("TC_PPTPatientDDViewR case ends");
    	Setup.testcase.assertAll();
	}

	@DataProvider(name="PPTPatientDDView")

    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PPTPatientDDViewR_Data");
        return object;    
    }
}
