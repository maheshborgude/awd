package buisness.core.Submission.gproSubmission.milestonethree;

import org.openqa.selenium.WebElement;

import buisness.core.Submission.AdvancedStatusPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Pagination for Pqrs Advanced Status Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */
public class GproAdvancedStatusPagination extends AdvancedStatusPagination{
	
	/**	
	 * Method used to compare objects of AdvancedStatusGrid. <p>
	 * It verifies all pagination related scenarios.<p>
	 * @param elementmethod Example xpath, id, etc.
	 * @param locator Name of locator in object repository
	 * @return true or false based on the result
	 */

	public boolean verify(String elementmethod,String locator)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locator); 
		Pagination pagination=new Pagination(webtable);
		
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("GPROAdvancedStatusPagination"); 
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
							Setup.log.trace("Data present on UI of  Gpro Advanced Status Grid matches with Database");
							Setup.testcase.assertTrue(true);
						}
						else {
							Setup.log.trace("Data present on UI of  Gpro Advanced Status Grid does not match with Database");
							Setup.testcase.fail();
						}
					}
				}
			}
		}
		return result;
	}	
	

}