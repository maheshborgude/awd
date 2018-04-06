package testcases.dashboard.practice.practiceAll.location.nonRolling;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_PracticeAllLocationPopUpCountNR extends Setup {
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");		
    
	@Test(dataProvider="PracticeAllLocationPopUpCountNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
		log.info("\nTC To validate count of AllLocation popup present on Dashboard > practice for Rolling");
		exe.testexecute(Filelocation,"TC_PAllLPopUpCountNR",data);
		log.info("\nTC To validate count of AllLocation popup present on Dashboard > practice for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeAllLocationPopUpCountNR")
    public Object[][] dataLocation() throws IOException, InvalidFormatException
	{
		Object[][] object=ex.getDataingrid(Filelocation,"TC_PAllLPopUpCountNR_Data");
		Setup.log.info("\n For TC To validate count of AllLocation popup present on Dashboard > practice for Rolling, DataFile is used from "+Filelocation);
        return object;    
    } 

}
