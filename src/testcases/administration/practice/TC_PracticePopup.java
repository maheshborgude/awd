package testcases.administration.practice;
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
 * This class verify Data present on Administration >> practice popup :<p>
 *   1.Verify practice popup<p>
 *   2.Verify all label present on practice popup<p>
 *   3.Verify Cancel button present on practice popup
 * 
 * @author rakesh.kulkarni
 * Created date : 1/7/2015
 */
public class TC_PracticePopup extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="PracticePopup")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{ 
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");		
		log.info("\nTC to Validate practice popup Starts");
		exe.testexecute(Filelocation,"TC_PracticePopup",data);
		log.info("\nTC to Validate practice popup Ends");
	}

	@DataProvider(name="PracticePopup")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PracticePopup_Data");
		Setup.log.info("\n For TC Validate practice Popup, DataFile is used from "+Filelocation);
        return object;    
    } 

}



