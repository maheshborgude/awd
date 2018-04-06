package buisness.core.dashboard.provider.rolling;

import org.openqa.selenium.WebElement;

import buisness.core.dashboard.provider.ProviderLocationPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Pagination for Dashboard>>Location and Dashboard>>Provider<p>
 * @author Sachin.Gawade<p>
 * Created Date: 1 Mar 2016
 * @author probeer.roy Updated Date: 19 Dec 2017
 */

public class ProviderPaginationR extends ProviderLocationPagination{
	

	
	/**	
	 * This method verify pagination of PQRS Advanced Status and click  on First last forward backward 
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * @return result true or false
	 */

	public boolean verifyProviderPaginationR(String elementmethod,String locator, String data, String data1)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locator);
		ConfigurationManager config = new ConfigurationManager();
		
		String query = config.getQuery("ProviderPagination");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());

		
		if(isQuarter(data))
		{
			query=query.replace( "@flag",data1);
		}
		else
		{
			query=query.replace( "@flag",data1);
		}
		try
		{
		Pagination pagination=new Pagination(webtable,"./ancestor::div/following-sibling::div/div/a/parent::div");
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
		catch (Exception e)
		{
			Setup.log.error("Pagination is not present for the grid.");
			result=false;
		}
		return result;
	}

}