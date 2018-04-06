package buisness.core.dashboard.Practice.rolling;

import buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour.ProviderSubmission;
import buisness.core.dashboard.Practice.PracticeLocationPopUp;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.pqrssubmission.ProviderSubmissionGrid;
import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**Verifies Practice Location Pagination present on Dashboard > Practice >> Select Measure on Location Tab For Rolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate count.
 * @author Rakesh.kulkarni<p>
 * Created Date: 21/03/2016
 * 
 */
public class 	PracticeLocationPopUpPaginationR extends PracticeLocationPopUp {
	/**
	 * Passes querylocator
	 * Passes Parameters elementmethod and locator to verify() of PqrsAdvancedStatusView class
	 * This method verify pagination of Dashboard > Practice >> Select Measure >> Location Tab For Rolling Status and click on First last forward backward
	 * Method to compare object of PracticeGrid. It check value present on UI with Database 
	 * @param locator
	 * @param elementmethod
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locator,String data)
	{boolean result=true;

		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeLocationPopUpPaginationR");
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		try
		{
			WebElement webtable=getWebElement(elementmethod,locator);
			Pagination pagination=new Pagination(webtable);
			if(isQuarter(data))
			{
				query=query.replace( "@flag","QR");
			}
			else
			{
				query=query.replace( "@flag","QR");
			}
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
								Setup.log.trace("Data on UI and Database matches.");
								Setup.testcase.assertTrue(true);
							}
							else {
								Setup.log.trace("Data on UI and Database does not match.");
								Setup.testcase.fail();
							}
						}
					}
				}
			}
		}
		catch (Exception exc)
		{
			Setup.log.error("Exception occur in pagination");
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
	/*	replaceQuery=replaceQuery.replace( "@loginuser",getLoggedInUser());
		replaceQuery=replaceQuery.replace( "@provideruid",getSelectedProvierUID());
		replaceQuery=replaceQuery.replace( "@measureuid",getSelectedMeasureUID());*/
		PracticeLocationPopUpGrid dbGrid = getDatabaseGrid(replaceQuery);
		PracticeLocationPopUpGrid uiGrid = getWebGrid(elementmethod, locator);
		boolean result = compareTO( uiGrid, dbGrid);
		return result;
	}


	public boolean compareTO(PracticeLocationPopUpGrid uiGrid,PracticeLocationPopUpGrid dbGrid)
	{
		if(uiGrid!=null )
		{

			if(dbGrid!=null )
			{
				if(uiGrid.compareTo(dbGrid) == 0)
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