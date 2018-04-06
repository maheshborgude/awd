package buisness.core.dashboard.provider.rolling;

import org.openqa.selenium.WebElement;

import buisness.core.dashboard.provider.PatientDrillDownPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Pagination for Patient Drill Down grid of Dashboard>>Provider<p>
 * @author Sachin.Gawade<p>
 * Created Date: 3 Mar 2016
 * 
 */

public class ProviderPatientDrillDownPaginationR extends PatientDrillDownPagination{
	
	/**	
	 * This method verify pagination of Dashboard>>Provider or Dashboard>>Location Patient Drill Down grid
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * @return true or false
	 */

	public boolean verifyProviderPatientDrillDownPaginationR(String elementmethod,String locator, String data, String data1 )
	{boolean result=true;
	WebElement webtable=getWebElement(elementmethod,locator);
	ConfigurationManager config=new ConfigurationManager();
	String query = config.getQuery("ProviderPatientDrillDownPaginationR");
	query=query.replace( "@quartermonth",trimMultiSpace(data));
	query=query.replace( "@loginuser",getLoggedInUser());
	query=query.replace( "@provideruid",newwayProviderUid());
	query=query.replace( "@measureuid",newwayMeasureUid());
//	
//	if(isQuarter(data))
//	{
//		query=query.replace( "@flag",data1);
//		
//	}
//	else
//	{
//		query=query.replace( "@flag",data1);
//	} 
//	
	
	try
	{
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
	catch(Exception e)
	{
		Setup.log.error("Pagination is not present for the grid.");
		result=false;
	}
	
	

	return result;
}	
}

