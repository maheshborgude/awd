package testcases.administration.provider;


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
 * This test case Verifies Provider grid Pagination buttons
 * 
 * @author Sachin.Gawade
 * Created Date: 10 Feb 2016
 */
//TODO: java doc:done
public class TC_ProviderPagination extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_ProviderPagination")
	  //TODO: function name:done
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
	    	//TODO: there should not be new line in log:done
	    	Setup.log.info("TC_ProviderPagination test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderPagination",data);
	    	Setup.log.info("TC_ProviderPagination test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderPagination")
		//TODO: function name:done
	    public Object[][] getDataForProviderPagination() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderPagination_data");
	        return object;    
	    }
}
