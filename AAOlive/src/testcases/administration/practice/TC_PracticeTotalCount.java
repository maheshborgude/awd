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
 * This class verify Total count of practice from Administration >> practice :
 *   1.Verify practice Count in DB and UI
 *   
 * @author rakesh.kulkarni
 * Created date : 1/7/2015
 */
public class TC_PracticeTotalCount extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="PracticeTotalCount")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	  
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");		
		log.info("\nTC to Validate Validate Total Record Label Starts");
		exe.testexecute(Filelocation,"TC_PracticeTotalCount",data);
		log.info("\nTC to Validate Validate Validate Total Record Label Ends");
		Setup.testcase.assertAll();
	}

	@DataProvider(name="PracticeTotalCount")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PracticeTotalCount_Data");
		Setup.log.info("\n For TC Validate Total Record Count, DataFile is used from "+Filelocation);
        return object;    
    } 

}



