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
 * This test case validate searching Order of listed practice
 *  The searching is done through the searchKey given in to the .Xlsx
 * @author rakesh.kulkarni
 * Date 20-1-2016
 */
public class TC_PracticeSearch extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="PracticeSearch")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");		
		log.info("\nTC to validate searching of practice");
		exe.testexecute(Filelocation,"TC_PracticeSearch",data);
		log.info("\nTC to validate searching of practice ends");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="PracticeSearch")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PracticeSearch_Data");
		Setup.log.info("\n For TC Validate searching of practice, DataFile is used from "+Filelocation);
        return object;    
    } 

}
