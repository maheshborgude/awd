package buisness.core.gprosubmission;


import buisness.util.helpers.DatePicker;
import configuration.Setup;




public class AddPatientVisit extends DatePicker{
	


	private DatePicker dt= new DatePicker();
	
	public boolean setDatePicker(String data0,String data1) throws InterruptedException
	{
		Thread.sleep(3000);
		try 
		{
		dt.selectDatePicker(data0,data1);
		return true;
		}
		catch (Exception e)
		{
		Setup.testcase.fail();	
		return false;
		}
	}
	
}
