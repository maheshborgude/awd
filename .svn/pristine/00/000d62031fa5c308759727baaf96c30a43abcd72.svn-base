package buisness.util.datastructures.dashboard.datepicker;

public interface Calendar {
	
    /**
     * 
     * @return current year displayed on Calendar.
     */
    int currentYear();
 
    /**
     * @return the  current month on Calendar.
     */
    int currentMonth();
 
    /**
     * Clicking next year button once, or clicking the next month button
     * 12 times if the next year button is not present on the calendar.
     */
    String nextYear();
 
    /**
     * Clicking next month button once.
     */
    String nextMonth();
 
    /**
     * Clicking previous month button once.
     */
    String previousMonth();
 
    /**
     * Clicking previous year button once, or clicking the previous month
     * button 12 times if the next year button is not present on the calendar.
     */
    String previousYear();
 
    /**
     * Some calendar allows user to select a year from a dropdown(select) or
     * enter a value from an input field. This method is to cater that function.
     * @param year
     */
    String enterYear(int year);
 
    /**
     * Some calendar allows user to select a month from a dropdown(select) or
     * enter a value from an input field. This method is to cater that function.
     * @param month
     */
    String enterMonth(String month);
 
    /**
     * After flipping the calendar to the month user is picking, clicking
     * the day button.
     * @param day
     */
    String pickDay(int day);
}
