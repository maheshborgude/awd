package buisness.core.dashboard.Practice.rolling;

import buisness.core.dashboard.provider.PatientDrillDownPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**
 * Verifies Patient DrillDown Pagination present on Dashboard > Practice > Select measure >> Provider Tab For Rolling<p>
 * Extends PatientDrillDownView<p>
 * This class Query Keyword to Extended PatientDrillDownView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 *
 * @author Rakesh.Kulkarni<p>
 *         Created Date: 23/03/2016
 */

public class PracticeProvidersPatientDrillDownPaginationR extends PatientDrillDownPagination {

    /**
     * Method to compare object Patient DrillDown Pagination present on Dashboard > Practice > Select measure >> Provider Tab For Rolling<p>
     * present on UI with Database
     * @param elementmethod Example xpath, id, etc.<p>
     * @param locator Name of locator in object repository<p>
     * @return result of Test case "Pass" or "Fail"
     * @Param data : quarter or month
     */

    public boolean verify(String elementmethod, String locator, String data) {

        boolean result = true;
        ConfigurationManager config = new ConfigurationManager();
        String query = config.getQuery("PracticeProvidersPatientDrillDownPaginationR");
        query = query.replace("@quartermonth", data);
        query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
        if (isQuarter(data)) {
            query = query.replace("@flag", "QR");
        } else {
            query = query.replace("@flag", "QR");
        }
        try
        {
            WebElement webtable = getWebElement(elementmethod, locator);
            Pagination pagination = new Pagination(webtable);
            if (result) {
                pagination.browseLastPage();
                result = compareGrid(pagination, query, elementmethod, locator);
                if (result) {
                    pagination.browsePreviousPage();
                    result = compareGrid(pagination, query, elementmethod, locator);
                    if (result) {
                        pagination.browseNextPage();
                        result = compareGrid(pagination, query, elementmethod, locator);
                        if (result) {
                            pagination.browseFirstPage();
                            result = compareGrid(pagination, query, elementmethod, locator);
                            if (result) {
                                Setup.log.trace("Data on UI and Database matches.");
                                Setup.testcase.assertTrue(true);
                            } else {
                                Setup.log.trace("Data on UI and Database does not match.");
                                Setup.testcase.fail();
                            }
                        }
                    }
                }
            }
        }catch (Exception exce)
        {

        }
        return result;
    }

}

