package buisness.core.Submission.gproSubmission.milestonethree;

import org.openqa.selenium.WebElement;

import buisness.core.Submission.AdvancedStatusPopupPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Pagination for Advanced Status Popup Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 */
public class GproAdvancedStatusPopupPagination extends AdvancedStatusPopupPagination{

	/**	
	 * This method verify pagination of Advanced Status Popup Grid(GPROSubmission)<p>
	 * @param elementmethod Example xpath, id, etc.
	 * @param locator Name of locator in object repository
	 * @param data Measure number
	 * @return true or false
	 */

	public boolean verify(String elementmethod,String locator, String data)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locator); 
		Pagination pagination=new Pagination(webtable);
		
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("GPROAdvancedStatusPopupEligiblePagination"); 
		if(result) {
			pagination.browseLastPage();
			result = compareGrid(pagination, query, elementmethod, locator,data);
			if(result) {
				pagination.browseNextPage();
				result = compareGrid(pagination, query, elementmethod, locator,data);
				if(result) {
					pagination.browseFirstPage();
					result = compareGrid(pagination, query, elementmethod, locator,data);
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
		return result;
	}	

}