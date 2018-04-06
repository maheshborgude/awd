package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.PatientDrillDownPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**
 * Verifies Practice Patient DrillDown Pagination present on Dashboard > Practice > Measure computation summary For NOnRolling<p>
 * Extends ProviderLocationCount<p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 * @author Rakesh.Kulkarni<p>
 * Created Date: 18/03/2016
 */

public class PracticePatientDrillDownPaginationNR extends PatientDrillDownPagination{
	
	/**
	 * Compares Provider\Location Count for from UI and Database
	 * Passes locator : To Find the element
	 * Passes Parameters elementmethod and locator to verify() Dashboard > Practice > Measure computation summary For NOnRolling
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */

	public boolean verify(String elementmethod,String locator, String data)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locator);
		Pagination pagination=new Pagination(webtable);
		
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticePatientDrillDownView");
		query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
		query=query.replace( "@quartermonth",data);
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","QNR");
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
		return result;
	}	

}

