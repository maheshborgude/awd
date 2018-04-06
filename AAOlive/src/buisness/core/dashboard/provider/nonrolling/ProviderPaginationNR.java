package buisness.core.dashboard.provider.nonrolling;

import org.openqa.selenium.WebElement;

import buisness.core.dashboard.provider.ProviderLocationPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Pagination for Dashboard>>Location and Dashboard>>Provider(Non Rolling)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 9 Mar 2016
 */

public class ProviderPaginationNR extends ProviderLocationPagination{
	
	/**	
	 * This method verify pagination of PQRS Advanced Status and click  on First last forward backward 
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @param data quarter or month<p>
	 * @return result true or false
	 */

	public boolean verifyProviderPaginationNR(String elementmethod,String locator, String data,String data1)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locator);
		ConfigurationManager config = new ConfigurationManager();
		
		String query = config.getQuery("ProviderPaginationNR");
		query=query.replace( "@quartermonth",trimMultiSpace(data));
		query=query.replace( "@loginuser",getLoggedInUser());
		//query=query.replace( "@provideruid",getSelectedProvierUID());
		//query=query.replace( "@measureuid",getSelectedMeasureUID());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag","QNR");
		}
		else
		{
			query=query.replace( "@flag","MNR");
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