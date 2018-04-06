package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.PatientDrillDownPagination;
import buisness.managers.ConfigurationManager;
import buisness.util.helpers.Pagination;
import configuration.Setup;
import org.openqa.selenium.WebElement;

/**
 * Verifies Practice >Location Tab>> Patient DrillDown pagination present on Dashboard > Practice > Select measure >> Location Tab For nonRolling<p>
 * Extends PatientDrillDownView<p>
 * This class Query Keyword to Extended PatientDrillDownView class
 * Returns boolean true if grid from UI and Database match<p>
 * Returns boolean false if grid from UI and Database do not match<p>
 * Return  data to validate Grid.
 *
 * @author Rakesh.Kulkarni<p>
 *         Created Date: 23/03/2016
 */

public class PracticeLocationPatientDrillDownPaginationNR extends PatientDrillDownPagination {

    /**
     * Method to compare object of Pagination data present on Practice >Location Tab>> Patient DrillDown Sorting present on Dashboard > Practice nonRolling <p>
     * present on UI with Database
     *
     * @param elementmethod Example xpath, id, etc.<p>
     * @param locator       Name of locator in object repository<p>
     * @return result of Test case "Pass" or "Fail"
     * @Param data : quarter or month
     */

    public boolean verify(String elementmethod, String locator, String data) {
        boolean result = true;
        WebElement webtable = getWebElement(elementmethod, locator);
        Pagination pagination = new Pagination(webtable);

        ConfigurationManager config = new ConfigurationManager();
        String query = config.getQuery("PracticeLocationPatientDrillDownPaginationNR");
        query = query.replace("@quartermonth", data);
        query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());
        if (isQuarter(data)) {
            query = query.replace("@flag", "QNR");
        } else {
            query = query.replace("@flag", "QNR");
        }
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
        return result;
    }

}

