package buisness.util.datastructures.dashboard.datepicker;



public class DatePicker {

    JCalendar calendar;
 
    /**
     * Constructor of the DatePicker which taking a Calendar interface.
     *
     * @param jCalendar
     */
    public DatePicker(JCalendar jCalendar) {
        this.calendar = jCalendar;
    }
 
    /**
     * Pick a date by the given parameter.
     * @param month
     * @param day,   an integer representing the day appearing on the calendar
     * @param year,  an integer representing the year appearing on the calendar
     */
  public String pick(String month, int day, int year) 
  {
      try
       {
    	  System.out.println("month is "+month);
    	  System.out.println("dy is "+day);
    	  System.out.println("year is "+year);
          if(calendar.enterYear(year).equalsIgnoreCase("pass"))
          {
        	  if(calendar.enterMonth(month).equalsIgnoreCase("pass"))
        	  {  
        		 if(calendar.pickDay(day).equalsIgnoreCase("pass"))
        		 {
        			 return "Pass";
        		 }
        	  }
        	  else if(calendar.enterMonth(month).equalsIgnoreCase("pass but allowed"))
        		  return "pass";
          }
          else if(calendar.enterYear(year).equalsIgnoreCase("pass but allowed"))
               return "Pass";
          
          return "fail";
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	return "Fail";
        }
    }
}
