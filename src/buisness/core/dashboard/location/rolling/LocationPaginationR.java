package buisness.core.dashboard.location.rolling;

import buisness.core.administration.practice.Practice;
import buisness.core.dashboard.location.Location;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.administration.practice.PracticeGrid;
import buisness.util.datastructures.dashboard.location.LocationGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**
 * Verifies Practice Performance Trend View present on All tab >> Select Measure >> All Tab >>
 *    For Rolling<p>
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * @author Rakesh.kulkarni<p>
 * Created Date: 30/03/2016
 *
 */
public class LocationPaginationR extends Location {
	/**
	 * Default constructor for object creation
	 */
	public LocationPaginationR(){
	}	

	/**	
	 * This method verify pagination of Location Grid and click on First last forward backward
	 * Method to compare object of LocationGrid. It check value present on UI with Database
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locater Name of locator in object repository<p>
	 * @param data quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locater,String data)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,".//*[@id='accordion']");
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("LocationPaginationR");

		try
		{
			Pagination pagination=new Pagination(webtable);
			if(pagination == null)
			{
				return true;
			}
			if(result) {
				pagination.browseLastPage();
				result = compareGrids(pagination, query, elementmethod, locater);
			}
			if(result) {
				pagination.browsePreviousPage();
				result = compareGrids(pagination, query, elementmethod, locater);
			}
			if(result) {
				pagination.browseNextPage();
				result = compareGrids(pagination, query, elementmethod, locater);
			}
			if(result) {
				pagination.browseFirstPage();
				result = compareGrids(pagination, query, elementmethod, locater);
			}
			if(result) {
				Setup.log.trace("Data present on practice Grid on UI match with Dtabase");
				Setup.testcase.assertTrue(true);
			}
			else {
				Setup.log.trace("Data present on practice Grid on UI not match with Dtabase");
				Setup.testcase.fail();
			}
			return result;
		}
		catch (Exception ecx)
		{
			Setup.log.error("Error in pagination or pagination grid is not present");
			return false;
		}
	}
	public boolean compareTO(LocationGrid uiGrid,LocationGrid dbGrid)
	{
		if(uiGrid.compareTo(dbGrid) == 0) {
			return true;
		}
		else 	{
			return false;
		}
	}

	public boolean compareGrids(Pagination pagination, String query, String elementmethod,String locater) {
		int i = pagination.getCurrentPage();
		String str = Integer.toString(i);
		String replaceQuery = query.replace("@pagenumber", str);
		replaceQuery=replaceQuery.replace( "@loginuser",getLoggedInUser());
	//	replaceQuery=replaceQuery.replace( "@SelectedLocation",getSelectedLocationUID());
	//	replaceQuery=replaceQuery.replace( "@LocationMeasureUID",getMeasureUIDOnLocation());
		LocationGrid dbGrid = getDatabaseGrid(replaceQuery);
		LocationGrid uiGrid = getWebGrid(elementmethod, locater);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}
}