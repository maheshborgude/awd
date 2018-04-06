package buisness.keywords.dashboard;

import buisness.core.dashboard.location.LocationGridPagination;
import buisness.keywords.Common;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;


/**
 * This class contain keywords for Administration >> Location
 *
 * @author nilesh.patil
 *         Created Date:-3 FEB 2016
 */
public class Location extends Common {


    UtilityFunction util = new UtilityFunction();
    UtilityFunctionDashboardProvider util_pro = new UtilityFunctionDashboardProvider();
    //buisness.core.administration.location.LocationCount lc =new   buisness.core.administration.location.LocationCount();
    buisness.core.dashboard.location.rolling.LocationMeasureViewR  locationMeasureViewR = new buisness.core.dashboard.location.rolling.LocationMeasureViewR();
    buisness.core.dashboard.location.rolling.LocationMeasureMeasureComputationSummaryViewR locationMeasureMeasureComputationSummaryViewR = new buisness.core.dashboard.location.rolling.LocationMeasureMeasureComputationSummaryViewR();
    buisness.core.dashboard.location.rolling.LocationMeasureCountR locationMeasureCountR = new buisness.core.dashboard.location.rolling.LocationMeasureCountR();
    buisness.core.dashboard.location.rolling.LocationCountR locationCountR = new buisness.core.dashboard.location.rolling.LocationCountR();
    buisness.core.dashboard.location.rolling.LocationPaginationR locationPaginationR = new buisness.core.dashboard.location.rolling.LocationPaginationR();
    buisness.core.dashboard.location.rolling.LocationViewR locationViewR = new buisness.core.dashboard.location.rolling.LocationViewR();
    buisness.core.dashboard.location.nonRolling.LocationBubbleCountNR LocationBubbleCountNR = new buisness.core.dashboard.location.nonRolling.LocationBubbleCountNR();
	buisness.core.dashboard.location.rolling.LocationBubbleCountR LocationBubbleCountR =  new buisness.core.dashboard.location.rolling.LocationBubbleCountR();
	buisness.core.dashboard.location.nonRolling.LocationCountNR LocationCountNR = new buisness.core.dashboard.location.nonRolling.LocationCountNR();
	@Override
    public String meth(String elementmethod, String action, String locator, String... data) {
        result = super.meth(elementmethod, action, locator, data);
        try {
            if (result != null) {
                return result;
            } else if (action.equals("IsMenuSelected")) {
                result = util.IsMenuSelected(data[0]);
            } else if (action.equals("IsSubMenuSelected")) {
                result = util.IsSubMenuSelected(data[0]);
            }
            else if (action.equals("LocationViewR")) {
                result = locationViewR.verify(elementmethod, locator, data[0]) ? "pass" : "fail";
            }
            else if (action.equals("LocationCountR")) {
                result =locationCountR.verifyLocationCountR(elementmethod, locator, data[0],data[1]) ? "pass" : "fail";
            }
            else if (action.equals("LocationPaginatinR")) {
                result = locationPaginationR.verify(elementmethod, locator, data[0]) ? "pass" : "fail";
            }
            else if (action.equals("verifydashboardlocationMeasureview")) {
            }
            else if (action.equals("LocationMeasureViewR")) {
                result = locationMeasureViewR.verify(elementmethod,locator,data[0]) ? "pass" : "fail";
            }
            else if (action.equals("LocationMeasureMeasureComputationSummaryViewR")) {
                result = locationMeasureMeasureComputationSummaryViewR.verify(elementmethod,locator,data[0]) ? "pass" : "fail";
            }
            else if (action.equals("LocationMeasureCountR")) {
                result = locationMeasureCountR.verify(elementmethod,locator,data[0]) ? "pass" : "fail";
            }
            else if (action.equals("LocationBubbleCountNR")){
            	
            	result = LocationBubbleCountNR.verifyLocationBubbleCountNR(elementmethod, locator, data[0],data[1]) ? "pass" : "fail";
            }
            else if (action.equals("LocationBubbleCountR")){
            
            	result=LocationBubbleCountR.verifyLocationBubbleCountR(elementmethod, locator, data[0],data[1]) ? "pass" : "fail";
            }
            else if (action.equals("LocationCountNR")){
            	result=LocationCountNR.verifyLocationCountNR(elementmethod, locator, data[0],data[1])? "pass" : "fail";
            }
            	
    } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
