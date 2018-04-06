package buisness.core.Submission;


import buisness.util.helpers.DatePicker;
import configuration.Setup;


/**
 * AddPatientVisit class
 * This class is used for DatePicker keyword
 * @author Sachin.Gawade
 * 11 Feb 2016
 */
public class AddPatientVisit {

	private DatePicker dt= new DatePicker();
	/**
	 * Visit date is selected by the sent parameters below
	 * @param calendarlocator Locator of the DatePicker
	 * @param data Date to be sent in MM-DD-YYYY format
	 * @return true or false
	 * @throws InterruptedException
	 */
	public boolean setDatePicker(String calendarlocator,String data) throws InterruptedException
	{
		// why sleep?
		Thread.sleep(3000);
		try 
		{
		dt.selectDatePicker(calendarlocator,data);
		return true;
		}
		catch (Exception e)
		{
		Setup.testcase.fail();	
		return false;
		}
	}
	
}
