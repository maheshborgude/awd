package buisness.core.Submission.gproSubmission.milestonethree;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;

import buisness.core.Submission.RepPatientVisitsPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;

/**Verifies Pagination for Report Patient Visit Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */

public class GproRepPatientVisitsPagination extends RepPatientVisitsPagination{
	
	/**
	 * This method is used to test all scenarios for Pagination for Reported patient visit grid<p>
	 * First, Last, Next, Previous button are verified.<p>
	 * @param elementmethod Example xpath, id, etc.<p>
	 * @param locator Name of locator in object repository<p>
	 * @return Boolean true or false based on the comparison of ui grid and database <p>
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	
	public boolean verify(String elementmethod,String locator)
	{
		boolean result=true;
		WebElement webtable=getWebElement(elementmethod,locator); 
		Pagination pagination=new Pagination(webtable);
		
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery("GPRORPVPagination"); 
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
							Setup.log.trace("Data present on UI of Report Patient Visit Grid matches with Database");
							Setup.testcase.assertTrue(true);
						}
						else {
							Setup.log.trace("Data present on UI of Report Patient Visit Grid does not match with Database");
							Setup.testcase.fail();
						}
					}
				}
			}
		}
		return result;
	}
	
}
