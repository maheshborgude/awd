

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
 * Sorts Provider grid according to passed parameter<p>
 *  and compares them from UI and DB
 * 
 * @author Sachin.Gawade
 * Created Date: 3 Feb 2016
 */
//TODO: java doc:done
public class TC_SortProviderTable extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_SortProviderTable")
	  //TODO: function name:done
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
	    	//TODO: there should not be new line in log:done
	    	Setup.log.info("TC_SortProviderTable test case starts");
	    	exe.testexecute(Filelocation,"TC_SortProviderTable",data);
	    	Setup.log.info("TC_SortProviderTable test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_SortProviderTable")
		//TODO: function name:done
	    public Object[][] getDataForSortProviderTable() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("admin_provider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_SortProviderTable_Data");
	        return object;    
	    }
}
