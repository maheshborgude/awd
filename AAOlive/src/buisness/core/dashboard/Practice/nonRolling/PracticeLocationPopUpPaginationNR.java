package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.Practice.PracticeLocationPopUp;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**Verifies Practice Location Pagination present on Dashboard > Practice >> Select Measure on Location Tab For NOnRolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni<p>
 * Created Date: 21/03/2016
 * 
 */
public class PracticeLocationPopUpPaginationNR extends PracticeLocationPopUp {
	/**
	 * Passes querylocator
	 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
	 * This method verify pagination of Dashboard > Practice >> Select Measure >> Location Tab For NOnRolling Status and click on First last forward backward
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locator
	 * @param elementmethod
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locator,String data)
	{
		boolean result = true;
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("PracticeLocationPopUpPaginationNR");
		query = query.replace("@quartermonth", data);
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
		if (isQuarter(data)) {
			query = query.replace("@flag", "QNR");
		} else {
			query = query.replace("@flag", "QNR");
		}
		try
		{
			WebElement webtable=getWebElement(elementmethod,locator);
			Pagination pagination=new Pagination(webtable);
			if(result) {
				pagination.browseLastPage();
				result = compareGrid(pagination, query, elementmethod, locator);
				if(result) {
					pagination.browsePreviousPage();
					result = compareGrid(pagination, query, elementmethod, locator);
					if(result) {
						pagination.browseNextPage();
						result = compareGrid(pagination, query, elementmethod, locator);
						if(result) {
							pagination.browseFirstPage();
							result = compareGrid(pagination, query, elementmethod, locator);
							if(result) {
								Setup.log.debug("Data on UI and Database matches.");
								Setup.testcase.assertTrue(true);
							}
							else {
								Setup.log.debug("Data on UI and Database does not match.");
								Setup.testcase.fail();
							}
						}
					}
				}
			}
		}
		catch (Exception exc)
		{
			Setup.log.info("Error in Pagnination");
		}
		return result;
	}

	/**
	 * This method when invoked calls getDatabaseGrid() and getWebGrid()<p>
	 * This method also replaces '@pagenumber' text from the query with actual current page<p>
	 * @param pagination Pagination class object<p>
	 * @param query Query to be run on database<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return true or false based on the comparison
	 */
	public boolean compareGrid(Pagination pagination, String query, String elementmethod,String locator) {
		int i = pagination.getCurrentPage();
		String str = Integer.toString(i);
		String replaceQuery = query.replace("@PageNumber", str);
		replaceQuery=replaceQuery.replace( "@loginuser",getLoggedInUser());
/*		replaceQuery=replaceQuery.replace( "@provideruid",getSelectedProvierUID());
		replaceQuery=replaceQuery.replace( "@measureuid",getSelectedMeasureUID())*/;
		PracticeLocationPopUpGrid databaseGrid = getDatabaseGrid(replaceQuery);
		PracticeLocationPopUpGrid webGrid = getWebGrid(elementmethod, locator);
		boolean result = compareTO( webGrid, databaseGrid);
		return result;
	}


	public boolean compareTO(PracticeLocationPopUpGrid databaseGrid,PracticeLocationPopUpGrid webGrid)
	{
		if(webGrid!=null )
		{

			if(databaseGrid!=null )
			{
				if(webGrid.compareTo(databaseGrid) == 0)
				{
					Setup.log.trace("Data on UI and Database matches.");
					Setup.testcase.assertTrue(true);
					return true;
				}
				else
				{
					Setup.log.trace("Data on UI and Database does not match.");
					Setup.testcase.fail();
					return false;
				}
			}

			else
			{
				Setup.log.error("Result in Database is null");
			}
		}
		else
		{
			Setup.log.error("UI grid is null");
		}
		Setup.testcase.fail();
		return false;
	}
}