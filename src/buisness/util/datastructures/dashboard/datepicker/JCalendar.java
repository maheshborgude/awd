package buisness.util.datastructures.dashboard.datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuration.Setup;
import configuration.UtilityFunction;



public class JCalendar  implements Calendar{
  
    /**
     * Constructor of the JQueryCalendar, an active WebDriver and a search
     * criteria of the trigger element.
     *
     * @param webDriver
     */
	
	@SuppressWarnings("unused")
	private final WebDriver webDriver;
    
	public JCalendar(WebDriver webDriver)
    { this.webDriver = Setup.driver;      
    }
  
    
    @Override
    public int currentYear() {
      try
      {
    	String []cur=calendar().findElement(By.xpath(".//div[@class='datepicker-days']/table//th[@class='switch']")).getText().split(" ",2);
    	System.out.println(" calendar year is "+cur[1]);
    	return Integer.parseInt(cur[1]);
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
    	  return 0;
      }
    }
 
    @Override
    public int currentMonth() {
     try
      {
    	String []cur=calendar().findElement(By.xpath(".//div[@class='datepicker-days']/table//th[@class='switch']")).getText().split(" ",2);
    	System.out.println(" calendar month is "+cur[0]);
    	System.out.println(UtilityFunction.getMonth(cur[0]));
        return   UtilityFunction.getMonth(cur[0]);
       }
      catch(Exception e)
      {
      	  e.printStackTrace();
      	  return 0;
       } 
    }
 
    @Override
    public String previousYear() {
        for (int i = 0; i < 12; i++) 
        {
            String month_sta=previousMonth(); 
        	if(month_sta.equalsIgnoreCase("fail"))
            	return "fail";
            else if(month_sta.equalsIgnoreCase("pass but allowed"))
            	return "pass but allowed";
        }
        return "pass";
    }
 
    @Override
    public String previousMonth() {
    	String style_prev=calendar().findElement(By.className("prev")).getAttribute("style");
        System.out.println("Style of previous month button is " +style_prev);
        if(style_prev.contains("visible"))
        {	
    	  calendar().findElement(By.className("prev")).click();
    	  return "pass";
        }
        else if(style_prev.contains("hidden"))
        {
        	System.out.println("Previous button is not visible");
        	return "pass but allowed";
        }
        else
        {
        	return "fail";
        }
    }
 
    @Override
    public String nextYear() {
        for (int i = 0; i < 12; i++)
        {
           String year_sta= nextMonth();
           if(year_sta.equalsIgnoreCase("fail"))
        	   return "fail";
           else if( year_sta.equalsIgnoreCase("pass but allowed"))
            	return "pass but allowed";
        }
        return "pass";
    }
 
  
 
    @Override
	public String nextMonth() {
		String style_next=calendar().findElement(By.className("next")).getAttribute("style");
	    System.out.println("Style of next month button is " +style_next);
	    if(style_next.contains("visible"))
	    {	
	      calendar().findElement(By.className("next")).click();
	      return "pass";
	    }
	    else if(style_next.contains("hidden"))
	    {
	    	System.out.println("next button is not visible");
	    	return "pass but allowed";
	    }
	    else
	    {
	    	return "fail";
	    }
	}


	@Override
    public String enterYear(int year) {
       if(flipToYear(year).equalsIgnoreCase("pass"))
    	   return "pass";
       else if(flipToYear(year).equalsIgnoreCase("pass but allowed"))
	       return "pass but allowed";
       else
      	   return "fail";
    
    }
 
    @Override
    public String enterMonth(String month) {
      if(flipToMonth(month).equalsIgnoreCase("pass"))
 	       return "pass";
      else if(flipToMonth(month).equalsIgnoreCase("pass but allowed"))
	       return "pass but allowed";
      else
      	   return "fail";
    
    }
 
    @Override
    public String pickDay(int day) {
        List<WebElement> dayButtons =  calendar().findElements(By.xpath(".//div[@class='datepicker-days']/table//td[contains(@class,'day')]"));
        for (WebElement dayButton : dayButtons) {
            if (dayButton.getText().equals(String.valueOf(day))) {
                dayButton.click();
                System.out.println("date is selected");
                return "pass";
            }
        }
        return "Fail";
    }
 
    public String flipToYear(int year) {
        if(year!=currentYear())
        {
       	   int yearDiffrence = currentYear() - year;
       	   System.out.println("year difference is "+yearDiffrence);
           if (yearDiffrence < 0) 
           {
               for (int i = yearDiffrence; i < 0; i++)
               {
            	  String year_status=nextYear();
                  if(year_status.equalsIgnoreCase("fail"))
                	  return "fail";
                  else if(year_status.equalsIgnoreCase("pass but allowed"))
            	      return "pass but allowed";
                }
           } 
           else if (yearDiffrence > 0) 
           {
             for (int i = 0; i < yearDiffrence; i++) 
             {
            	String year_status=previousYear();
                if(year_status.equalsIgnoreCase("fail"))
                    return "fail";
                else if(year_status.equalsIgnoreCase("pass but allowed"))
                	return "pass but allowed";
              }
            }
         }  
        return "pass";
    }
    
    
    public String flipToMonth(String month) {
    	int monthDifference = currentMonth() - UtilityFunction.getMonth(month);
        System.out.println(" month difference is "+ monthDifference);
        if (monthDifference < 0) 
        {
            for (int i = monthDifference; i < 0; i++) 
            {
               System.out.println(" i is "+i);
               String month_status=nextMonth();
               if(month_status.equalsIgnoreCase("fail"))
                  return "fail";
               else if(month_status.equalsIgnoreCase("pass but allowed"))
               	  return "pass but allowed";
             }
         } 
        else if (monthDifference > 0) 
        {
            for (int i = 0; i < monthDifference; i++) 
            {
            	 System.out.println(" i is "+i);
            	 String month_status=previousMonth();
                if(month_status.equalsIgnoreCase("fail"))
                   return "fail";
                else if(month_status.equalsIgnoreCase("pass but allowed"))
                 	  return "pass but allowed";
            }
        }
        else if(monthDifference==0)
        {
        	return "pass";
        }
       return "pass"; 
    }
    
    
    private WebElement calendar() {
    	  return Setup.driver.findElement(By.xpath(".//div[@class='datepicker datepicker-dropdown dropdown-menu' and contains(@style,'display: block')]"));
    }
 
    
    /**
     * Predicate needed by WebDriverWait for Calendar to become visible
     * it can be used for Calendar to become invisible as well, simply
     *   Predicates.not(new CalendarIsDisplayed()) as used in method 
     *   pickDay.
     */
 /*  private class CalendarIsDisplayed implements Predicate<WebDriver> {
        @Override
        public boolean apply(WebDriver webDriver) {
            return calendar() != null && calendar().isDisplayed();
        }
    }*/   
    
   
}
