package testcases.dashboard.practice.practiceProvider.rolling;

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
 * This class contain Table View for Practice >> Performance View
 * 
 * @author Ashwini.Gore
 * Created date : 02/12/2017
 */


public class TC_PracticeProviderPT_TableViewR extends Setup  {

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();

    @Test(dataProvider="PracticeProviderTableView")

	public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{

    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Practice_Provider");

    	Setup.log.info("TC_PracticeProviderPT_TableView test case starts");
    	exe.testexecute(Filelocation,"TC_PracticeProviderPT_TableView",data);
    	Setup.log.info("TC_PracticeProviderPT_TableView case ends");
    	Setup.testcase.assertAll();
	}

	@DataProvider(name="PracticeProviderTableView")

    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Practice_Provider");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PracticeProviderPT_TableData");
        return object;    
    }
}
