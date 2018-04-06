package buisness.core.dashboard;

import java.sql.ResultSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import configuration.Setup;

public class Basics {
	
	protected ConfigurationManager pr;
	protected ElementMethod em;
	
	public Basics() 
	{
		pr = new ConfigurationManager();
		em  = new ElementMethod();
	}
	
	/**
	 * Searches for PracticeUID in practice table of Management Database for given practiceid
	 * Return practiceuid if practice present else returns NULL
	 * 
	 * @param practiceId 
	 * @return practiceuid
	 */
	public String getPracticeuid(String practiceId)
	{
		String query = "select practiceuid c from practice where externalid='" + practiceId+"'";
		
		//System.out.println(query);
		//System.out.println("practice id is :" + practiceId);
		return DatabaseManger.getQuery(query).get(0);
	}
	
	
	/**
	 * 
	 * Changed by Awadhesh
	 * 
	 * 
	 * @param Id
	 * @return
	 */
	public String getMeasureuid(String Id)
	{
		String query = "select Nationalprogramqualitymeasureuid  from nationalprogramqualitymeasure where id = '" +Id+"'";
		
		//System.out.println(query);
		//System.out.println("practice id is :" + practiceId);
		return DatabaseManger.getQuery(query).get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Gets the Date End Date of Quarter of month for give duration eg. for parameter 2014Q2 would return '2014-06-30' 
	 * 
	 * @param QuarterMonth for which end date is required
	 * @return String containing date
	 * @author abhishek.gaikwad
	 */
	public String getQuaterOrMonthDate(String QuarterMonth)
	{
		String query = "select distinct quarterEndDate from ViewMeasureComputationSummary where QuarterName = '" + QuarterMonth + "'";
		
		try 
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			if(rs.next())
				return ( rs.getString("quarterEndDate") );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @author abhishek.gaikwad
	 * @param measureuid
	 * @param practiceId
	 * @param QuarterOrMonth
	 * @return
	 */
	public String getNumerator(String measureuid,String practiceId,String QuarterOrMonth)
	{
		String numerator=null;
		String query = pr.getQuery("numeratorDenominatorQuery").toLowerCase();
		query = query.replace("@measureuid", measureuid);
		query = query.replace("@practiceuid", getPracticeuid(practiceId));
		query = query.replace("@quarterormonth",QuarterOrMonth.replace(" ", "").replace("-", "") );
		//System.out.println(query);
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			if(rs.next())
				numerator = rs.getString("Numerator");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return numerator;
	}
	/**
	 * @author abhishek.gaikwad
	 * @param measureuid
	 * @param practiceId
	 * @param QuarterOrMonth
	 * @return
	 */
	public String getDenominator(String measureuid,String practiceId,String QuarterOrMonth)
	{
		String denominator = null;
		String query = pr.getQuery("numeratorDenominatorQuery").toLowerCase();
		query = query.replace("@measureuid", measureuid);
		query = query.replace("@practiceuid", getPracticeuid(practiceId));
		query = query.replace("@quarterormonth",QuarterOrMonth.replace(" ", "").replace("-", "") );
		//System.out.println(query);
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			if(rs.next())
				denominator = rs.getString("denominator");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return denominator;
	}
	
	/**
	 * when popup is opened with 
	 */
	public String  getDisplayedMeasureName()
	{
		String locator = pr.read_ObjectRepositoryfile("PopupMeasureName");
		
		WebElement  measureelementWE = Setup.driver.findElement(By.xpath(locator));
		
		String measurename = measureelementWE.getText();
		
		return  measurename;
		
	}
	
	
	public String extractMeasureID(String displayedMeasureID)
	{
		Pattern p = Pattern.compile("(^|\\s)([0-9]+)($|\\s)");
	    Matcher m = p.matcher(displayedMeasureID);
	    if (m.find()) 
	    {
	    	displayedMeasureID = m.group(2);
	    }
	    return displayedMeasureID;
	}
	
	/**
	 *  Check if the next button of pagination is available on the current rendered page 
	 *  
	 * @param locator - current selected grid
	 * @return returns nextButton  as WebElement if next button is available the  else returns null
	 */
	public WebElement checkNextPaginationAvailable(String locator)
	{
		String xpath = pr.read_ObjectRepositoryfile("paginationNextButton");
		// as pagination of only that grid should be found out
		// As the xpath given in object repository is for finding path for selef
		xpath = locator + xpath.substring(1);
		List<WebElement> we = Setup.driver.findElements(By.xpath(xpath));
		
		if(we.isEmpty()== true)
			return null;
		else
			return we.get(0);
	}
	/**
	 * 
	 * @param locator Pass the Table rows where measure data is present eg. ".//tbody/tr"
	 * 
	 * @return
	 */
	public MeasureComputationSummaryGrid getDisplayedPerformanceTrendMonQuatData(String locator)
	{
		List<WebElement> rows =   Setup.driver.findElements(By.xpath(locator));
		MeasureComputationSummaryGrid ui_summary = new MeasureComputationSummaryGrid();
		String monQuat;
		int AllPatient;
		int Met;
		int NotMet;
		float percentage;
		
		for(WebElement currentRow : rows)
		{
			monQuat		= currentRow.findElement(By.xpath(".//td[1]")).getText();
			AllPatient	= Integer.valueOf( currentRow.findElement(By.xpath(".//td[2]")).getText());
			Met 		= Integer.valueOf( currentRow.findElement(By.xpath(".//td[3]")).getText());
			NotMet		= Integer.valueOf( currentRow.findElement(By.xpath(".//td[4]")).getText());
			percentage	= Float.valueOf(  currentRow.findElement(By.xpath(".//td[5]")).getText().replace("%", ""));
			
			ui_summary.addMeasureRow(monQuat, Integer.toString(AllPatient), Integer.toString(Met), Integer.toString(NotMet), Float.toString(percentage));
			//System.out.println(monQuat+"\t"+AllPatient +"\t"+Met +"\t"+ NotMet +"\t"+ percentage);
		}
		return ui_summary;
	}
}