package buisness.util.helpers;

import org.openqa.selenium.By;
import configuration.Setup;

/**
 * This class selects date from DatePicker<p>
 * The date must be sent in MM-DD-YYYY Format
 * @author Sachin.Gawade
 * Created Date: 17 Feb 2016
 */
public class DatePicker extends Setup{
	
	public String calendarlocator;
	public String tabletwolocator;
	public String tablethreelocator;
	public String yearlocator;
	public String monthlocator;
	public String datelocator;
	public String year;
	public String month;
	public String date;

	/**
	 * DatePicker constructor
	 * Intializes yearlocator,monthlocator and datelocator with default locator values
	 */
	public DatePicker()
	{
		yearlocator = "//span[text()='year']";
		monthlocator = "//span[text()='month']";
		datelocator = "//td[@class='day' and text()='date']";
	}
	
	/**replaceMonth() replaces numeric month into String month
	 * Example: 10 is converted to Oct
	 */
	public void replaceMonth()
	{
		switch(this.month){
	    case "01":
	    	this.month="Jan";
	       break;
	    case "02":
	    	this.month="Feb";
		       break; 
	    case "03":
	    	this.month="Mar";
		       break; 
	    case "04":
	    	this.month="Apr";
		       break;
	    case "05":
	    	this.month="May";
		       break;
	    case "06":
	    	this.month="Jun";
		       break;
	    case "07":
	    	this.month="Jul";
		       break;
	    case "08":
	    	this.month="Aug";
		       break;
	    case "09":
	    	this.month="Sep";
		       break; 
	    case "10":
	    	this.month="Oct";
		       break; 
	    case "11":
	    	this.month="Nov";
		       break; 
	    case "12":
	    	this.month="Dec";
		       break; 
	    default : 
	    	this.month="";
		}
	}
	
	/**
	 * This method separates date, month and Year from sent date
	 * @param data must be sent in MM-DD-YYYY Format
	 */
	public void setMonthDateYear(String data)
	{
		int firstindex;
		int lastindex;
		data.replaceAll(" ", "");
		firstindex=data.indexOf('-');
		lastindex=data.lastIndexOf('-');
		this.month=data.substring(0,firstindex); 
		this.date=data.substring(firstindex+1,lastindex);
		this.year=data.substring(lastindex+1,data.length()); 
		addZeroInMonth();
		replaceMonth();
		removeZeroInDate();
	}
	
	/**removeZeroInDate() removes extra zero from date
	 * Example: 01 is converted to 1
	 */
	public void removeZeroInDate()
	{
		if(this.date.substring(0,1).equals("0"))
        {
        	this.date=this.date.substring(1,date.length());
        }
		else
		{
			Setup.log.info("First character in date is not zero: "+date);
		}
	}
	
	/**addZeroInMonth() adds extra zero from in month
	 * Example: 9 is converted to 09
	 */
	public void addZeroInMonth()
	{
		if(this.month.length()==1)
		{
			month="0"+month;
		}
		else
		{
			Setup.log.info("Zero cannot be added for month: "+month);
		}
	}
	
	/**replaceDataInLocator() replaces year,month and date in default initialized locator of year,month and date
	 */
	public void replaceDataInLocator()
	{
		this.yearlocator= this.yearlocator.replace("year", year);
		this.monthlocator= this.monthlocator.replace("month", month);
		this.datelocator= this.datelocator.replace("date", date);
		Setup.log.debug("year:"+ this.yearlocator);
		Setup.log.debug("month:"+ this.monthlocator);
		Setup.log.debug("date:"+ this.datelocator);
	}
	
	/**navigateYear() navigates to the required year using Prev or Next button.
	 */
	public void navigateYear()
	{
		String tempyearrange;
		int minyear;
		int maxyear;
		
		tempyearrange=Setup.driver.findElement(By.xpath(this.tablethreelocator+"/thead/tr/th[2]")).getText();
		minyear=Integer.valueOf(tempyearrange.substring(0, 4));
		maxyear=Integer.valueOf(tempyearrange.substring(5, tempyearrange.length()));
		
		if(Integer.valueOf(year)<minyear)
		{
			for(int i=1;i<=((minyear/10)-(Integer.valueOf(year)/10));i++)
			{
				Setup.driver.findElement(By.xpath(this.tablethreelocator+"//*[@class='prev']")).click();
			}
			
		}
			
		else
		{
			for(int i=1;i<=((Integer.valueOf(year)/10)-(maxyear/10));i++)
			{
				Setup.driver.findElement(By.xpath(this.tablethreelocator+"//*[@class='next']")).click();
			}
		}
	}
	

/**
 * 	This method selects date from the UI
 * @param calendarlocator: Locator of the datepicker/calendar in the UI.
 * @param data: Date to be selected. It must be sent in MM-DD-YYYY Format
 * @return true or false depending on the result
 */
	public boolean selectDatePicker(String calendarlocator,String data)
	{
		int temp;
		this.calendarlocator=calendarlocator;
		setMonthDateYear(data);
		replaceDataInLocator();
		try
		{	
		Setup.driver.findElement(By.xpath(this.calendarlocator+"/thead/tr[1]/th[2]")).click();
		temp=this.calendarlocator.indexOf("]/table");
		this.tabletwolocator=this.calendarlocator.subSequence(0,temp)+"+1"+this.calendarlocator.subSequence(temp,this.calendarlocator.length());
		Setup.log.debug("temploc:"+ this.tabletwolocator);	
		Setup.driver.findElement(By.xpath(this.tabletwolocator+"/thead/tr/th[2]")).click();
		temp=this.tabletwolocator.indexOf("]/table");
		this.tablethreelocator=this.tabletwolocator.subSequence(0,temp)+"+1"+this.tabletwolocator.subSequence(temp,this.tabletwolocator.length());
		navigateYear();
		Setup.driver.findElement(By.xpath(this.tablethreelocator+this.yearlocator)).click();
		Setup.driver.findElement(By.xpath(this.tabletwolocator+this.monthlocator)).click();
		Setup.driver.findElement(By.xpath(this.calendarlocator+this.datelocator)).click();
		return true;
		}
		catch(Exception e)
		{
			Setup.log.error("Could not select date");
		
		}
		return false;
	
		
	}	

}
