package buisness.core.dashboard;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import buisness.util.datastructures.dashboard.PopupLocationGrid;
import configuration.Setup;

/**
 * 
 * @author abhishek.gaikwad
 *
 */
public class Location extends Basics{
	
	
	/**
	 * 
	 * @param locator
	 * @return
	 */
	public boolean verifyEnlistedLocations(String locator,String practiceid,String QuarterOrMonth)
	{
		PopupLocationGrid uigrid = getDisplayedLocationListing(locator);
		uigrid.print();
		PopupLocationGrid dbgrid = getDBLocationListing(practiceid, QuarterOrMonth);
		dbgrid.print();
		if(uigrid.compareTo(dbgrid) == 0)
			return true;
		
		return false;
	}	
	
	/**
	 * 
	 */
	public PopupLocationGrid getDBLocationListing(String practiceid,String QuarterOrMonth)
	{
		PopupLocationGrid grid = new PopupLocationGrid();
		String	name;
		int 	qualified=0;
		int 	met=0;
		int 	notmet=0;
		double 	performance=0;
		String query = pr.getQuery("PopupLocationGridQuery");
		query = query.replace("@practiceuid", getPracticeuid(practiceid));
		query = query.replace("@QuarterOrMonth", QuarterOrMonth.trim() );
		query = query.replace("@MeasureID", extractMeasureID(getDisplayedMeasureName()));
		
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			
			while(rs.next())
			{
				name = rs.getString("locationname");
				qualified= rs.getInt("qualified");
				met= rs.getInt("met");
				notmet= rs.getInt("notmet");
				performance= rs.getDouble("performance");
				
				//------
				grid.addMeasureRow(name, qualified, met, notmet, performance);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return grid;
	}
	
	/**
	 * 
	 * @param locator
	 */
	public PopupLocationGrid getDisplayedLocationListing(String locator)
	{
		WebElement paginationNextButton;
		List<WebElement> rows = Setup.driver.findElements(By.xpath(locator));
		PopupLocationGrid grid = new PopupLocationGrid();
		String	locationname;
		int		flag=0;
		int 	qualified=0;
		int 	met=0;
		int 	notmet=0;
		double 	performance=0;
		
		//TODO: Code optimization is needed
		
		while(flag==0)
		{
			rows = Setup.driver.findElements(By.xpath(locator));
			for(WebElement current : rows)
			{
				locationname = current.findElement(By.xpath("./td[1]/i/span")).getText();
				qualified = Integer.parseInt(current.findElement(By.xpath("./td[2]")).getText());
				met = Integer.parseInt(current.findElement(By.xpath("./td[3]/a")).getText());
				notmet = Integer.parseInt(current.findElement(By.xpath("./td[4]/a")).getText());
				performance = Double.parseDouble(current.findElement(By.xpath("./td[5]//td[2]")).getText().replace("%", ""));
				grid.addMeasureRow(locationname, qualified, met, notmet, performance);
			}paginationNextButton = checkNextPaginationAvailable(locator);
			if(paginationNextButton != null)
			{
				paginationNextButton.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					//  Auto-generated catch block
				}
			}
			else 
				flag=1;
		}
		return grid;
	}
	
	public MeasureComputationSummaryGrid getDBPerformanceTrendMonQuatData(String locator,String practiceid,String quarterormonth)
	{
		MeasureComputationSummaryGrid db_summary=new MeasureComputationSummaryGrid();
		String monQuat;
		int AllPatients;
		int Met;
		int NotMet;
		float percentage;
		// adding xpath to reach to table as it contain service provider uid as its id
		locator = locator + "/parent::tr/following::tr[1]";
		String provideruid = Setup.driver.findElement(By.xpath(locator)).getAttribute("id").substring(15);
		String measureid = extractMeasureID(getDisplayedMeasureName());
		
		String query = pr.getQuery("LocationPerformanceTrendQuery").toLowerCase();
		
		query = query.replace("@practiceuid", getPracticeuid(practiceid));
		query = query.replace("@measureid", measureid);
		query = query.replace("@locationuid", provideruid);
		query = query.replace("@quarterormonth",quarterormonth.trim());
		
		//System.out.println(query);
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			while(rs.next())
			{
				
				monQuat		= rs.getString("QuarterName");
				AllPatients	= rs.getInt("Denominator");
				Met 		= rs.getInt("Numerator");
				NotMet		= rs.getInt("NotMet");
				percentage	= rs.getFloat("Average");
				
				//System.out.println( monQuat + "\t" +AllPatients + "\t" + Met + "\t" + NotMet + "\t" + percentage) ;				
				db_summary.addMeasureRow(monQuat, Integer.toString(AllPatients), Integer.toString(Met), Integer.toString(NotMet), Float.toString(percentage));
			}
			return db_summary;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public MeasureComputationSummaryGrid getDisplayedPerformanceTrendMonQuatData(String locator)
	{
		locator = locator + "/parent::tr/following::tr[1]//table/tbody/tr" ;
		return super.getDisplayedPerformanceTrendMonQuatData(locator);
	}
	
	public boolean verifyLocationPerformaceTrend(String locator,String practiceid,String monQuat)
	{
		MeasureComputationSummaryGrid uigrid = getDisplayedPerformanceTrendMonQuatData(locator);
		MeasureComputationSummaryGrid dbgrid = getDBPerformanceTrendMonQuatData(locator,practiceid,monQuat);
		
		if( uigrid.compareTo(dbgrid) == 0 )
			return true;
		
		Setup.testcase.fail();
		return false;
	}


}
