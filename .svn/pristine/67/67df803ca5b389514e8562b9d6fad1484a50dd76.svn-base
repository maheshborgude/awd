package buisness.core.dashboard;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.managers.DatabaseManger;
import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;
import buisness.util.datastructures.dashboard.PopupProviderGrid;
import configuration.Setup;

/**
 * 
 * @author abhishek.gaikwad
 *
 */
public class Provider extends Basics{
	
	
	/**
	 * 
	 * @param locator
	 * @return
	 */
	public boolean verifyEnlistedProviders(String locator,String practiceid,String QuarterOrMonth)
	{
		PopupProviderGrid dbgrid = getDBLocationListing(practiceid, QuarterOrMonth);
		PopupProviderGrid uigrid = getDisplayedLocationListing(locator);
		//dbgrid.print();
		//System.out.println("db count");
		//uigrid.print();
		
		if(uigrid.compareTo(dbgrid) == 0)
			return true;
		
		Setup.testcase.fail();
		return false;
	}	
	
	/**
	 * 
	 */
	public PopupProviderGrid getDBLocationListing(String practiceid,String QuarterOrMonth)
	{
		PopupProviderGrid grid = new PopupProviderGrid();
		String	name;
		int 	qualified=0;
		int 	met=0;
		int 	notmet=0;
		double 	performance=0;
		String query = pr.getQuery("PopupProviderGridQuery").toLowerCase();
		query = query.replace("@practiceuid", getPracticeuid(practiceid));
		query = query.replace("@quarterormonth", QuarterOrMonth.trim() );
		query = query.replace("@measureuid", extractMeasureID(getDisplayedMeasureName()));
		
		//System.out.println(query);
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			
			while(rs.next())
			{
				name = rs.getString("Providername");
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
	public PopupProviderGrid getDisplayedLocationListing(String locator)
	{
		WebElement paginationNextButton;
		List<WebElement> rows;
		PopupProviderGrid grid = new PopupProviderGrid();
		String	providername;
		int		flag=0;
		int 	qualified=0;
		int 	met=0;
		int 	notmet=0;
		double 	performance=0;
		
		paginationNextButton = checkNextPaginationAvailable(locator);
		
		//TODO: Code optimization is needed
		while(flag==0)
		{
			rows = Setup.driver.findElements(By.xpath(locator));
			//System.out.println(rows.size());
			for(WebElement current : rows)
			{
				providername = current.findElement(By.xpath("./td[1]/i/span")).getText();
				qualified = Integer.parseInt(current.findElement(By.xpath("./td[2]")).getText());
				met = Integer.parseInt(current.findElement(By.xpath("./td[3]/a")).getText());
				notmet = Integer.parseInt(current.findElement(By.xpath("./td[4]/a")).getText());
				performance = Double.parseDouble(current.findElement(By.xpath("./td[5]//td[2]")).getText().replace("%", ""));
				grid.addMeasureRow(providername, qualified, met, notmet, performance);
			}
			paginationNextButton = checkNextPaginationAvailable(locator);
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

	public MeasureComputationSummaryGrid getDBDataForProvider(String locator,String practiceid,String quarterormonth)
	{
		MeasureComputationSummaryGrid db_summary=new MeasureComputationSummaryGrid();
		String monQuat;
		int AllPatients;
		int Met;
		int NotMet;
		float percentage;
		// adding xpath to reach to table as it contain service provider uid as its id
		locator = locator + "/../following::tr//table[@id]";
		String provideruid = Setup.driver.findElement(By.xpath(locator)).getAttribute("id");
		String measureid = extractMeasureID(getDisplayedMeasureName());
		
		String query = pr.getQuery("ProviderPerformanceTrendQuery").toLowerCase();
		
		query = query.replace("@practiceuid", getPracticeuid(practiceid));
		query = query.replace("@measureid", measureid);
		query = query.replace("@provideruid", provideruid);
		query = query.replace("@quarterormonth",quarterormonth.trim());
		
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
				db_summary.addMeasureRow(monQuat, Integer.toString(AllPatients), Integer.toString(Met), Integer.toString(NotMet), Double.toString(percentage));
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
		//adding the xpath to reach tr as required by function
		locator = locator + "/../following::tr//table[@id]/tbody/tr" ;
		return super.getDisplayedPerformanceTrendMonQuatData(locator);
	}
	
	public boolean verifyProviderPerformaceTrend(String locator,String practiceid,String monQuat)
	{
		MeasureComputationSummaryGrid uigrid = getDisplayedPerformanceTrendMonQuatData(locator);
		//uigrid.print();
		MeasureComputationSummaryGrid dbgrid = getDBDataForProvider(locator,practiceid,monQuat);
		//dbgrid.print();
		
		if( uigrid.compareTo(dbgrid) == 0 )
			return true;
		
		Setup.testcase.fail();
		return false;
	}
}
