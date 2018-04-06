package testcases.dashboard.practice.nonRolling;

	import java.io.IOException;
	import java.util.Hashtable;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import buisness.frameworkengine.ExcelReader;
	import buisness.frameworkengine.TestExecutor;
	import buisness.managers.ConfigurationManager;
	import configuration.Setup;

	public class TC_ProviderBubbleCountNR extends Setup {
		/*@Author Awadhesh Sengar
		 * 12/15/2017
		 * Testcase to verify if Provider count displayed in Dahboard side bar matches with the database count.
		 */
		
		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe = new TestExecutor();
	    ExcelReader ex = new ExcelReader();	
	    
		@Test(dataProvider="ProviderBubbleCountNR")
		public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
		
			String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
			log.info("\nTC To validate bubble count for Provider on dashboard non rolling");
			exe.testexecute(Filelocation,"PBubbleCountNR",data);
			log.info("\nTC To validate bubble count for Location on dashboard non rolling Ends");
			Setup.testcase.assertAll();
		}
		@DataProvider(name="ProviderBubbleCountNR")
	    public Object[][] dataProvider() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"PBubbleCountNR_Data");
			Setup.log.info("\n For To validate bubble count for Provider on dashboard non rolling, DataFile is used from "+Filelocation);
	        return object;    
	    } 

	}
