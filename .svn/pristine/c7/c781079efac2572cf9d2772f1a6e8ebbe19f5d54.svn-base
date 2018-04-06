package buisness.keywords.dashboard;

import buisness.core.dashboard.Practice.rolling.PracticePatientDrillDownSortR;
import buisness.core.dashboard.provider.nonrolling.ProviderBubbleCountNR;
import buisness.core.dashboard.provider.nonrolling.ProviderCountNR;
import buisness.core.dashboard.provider.nonrolling.ProviderGridViewNR;
import buisness.core.dashboard.provider.nonrolling.ProviderMeasureComputationSummaryViewNR;
import buisness.core.dashboard.provider.nonrolling.ProviderMeasureViewNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPaginationNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownCountNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownPaginationNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownSortNR;
import buisness.core.dashboard.provider.nonrolling.ProviderPatientDrillDownViewNR;
import buisness.core.dashboard.provider.rolling.DetailedPPDrillDownCountR;
import buisness.core.dashboard.provider.rolling.ProviderCountR;
import buisness.core.dashboard.provider.rolling.ProviderGridViewR;
import buisness.core.dashboard.provider.rolling.ProviderMeasureComputationSummaryViewR;
import buisness.core.dashboard.provider.rolling.ProviderMeasureViewR;
import buisness.core.dashboard.provider.rolling.ProviderPaginationR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownCountR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownPaginationR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownSortR;
import buisness.core.dashboard.provider.rolling.ProviderPatientDrillDownViewR;
import buisness.keywords.Common;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

public class Provider extends Common{

	UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	ProviderBubbleCountNR ProviderBubbleCountNR = new ProviderBubbleCountNR();
	buisness.core.dashboard.provider.rolling.ProviderBubbleCountR ProviderBubbleCountR = new buisness.core.dashboard.provider.rolling.ProviderBubbleCountR();
	
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		try
		{
		result=super.meth(elementmethod, action, locator, data);
		if(action.equals("IsMenuSelected"))	
		{
			result=util.IsMenuSelected(data[0]);
		}
		else if(action.equals("selectPractice"))	
		{
			result=util.selectPractice(data[0]);
		}
		else if(action.equals("selectDuration"))	
		{
			result=util.selectDuration(data[0]);
		}	
		else if(action.equals("checkProviderData"))	
		{
			result=util_pro.checkProviderData();
		}	
		else if(action.equals("IsSubMenuSelected"))	
		{
			result=util.IsSubMenuSelected(data[0]);
		}	

		else if(action.equals("getPractice"))
		{
			result=util.getPractice();
		}
		else if(action.equals("checkProvidercount"))
		{
			result=util_pro.checkPrvoiderCount();
		}
		else if (action.equals("checkProviderNameEBC"))
		{
			result=util_pro.checkProviderNameEBC();
		}
		else if(action.equalsIgnoreCase("checkProviderMeasureIdName"))
		{
			result=util_pro.checkProviderMeasureIdName(data[0]);
		}
		else if(action.equalsIgnoreCase("checkProviderUpnDownArrow"))
		{
			result=util_pro.checkProviderUpnDownArrow(data[0]);
		}
		else if(action.equalsIgnoreCase("checkProviderScoreofMeasure"))
		{
			result=util_pro.checkProviderScoreofMeasure(data[0]);
		}
		else if(action.equalsIgnoreCase("checkProviderFavoriteMeasure"))
		{
			result=util_pro.checkProviderFavoriteMeasure(data[0]);
		}	
		else if(action.equalsIgnoreCase("checkProviderMeasureSpecific"))
		{
			result=util_pro.checkProviderMeasureSpecific(data[0],data[1]);
		}
		else if(action.equalsIgnoreCase("checkProviderMeasurePatientDrill"))
		{
			result=util_pro.checkProviderMeasurePatientDrill(data[0],data[1]);
		}
		else if(action.equalsIgnoreCase("checkDefaultduration"))
		{
			result=util_pro.checkDefaultduration(data[0]);
		}
		else if(action.equalsIgnoreCase("checkProviderScoreColor"))
		{
			result=util_pro.checkProviderScoreColor(data[0]);
		}
		else if(action.equalsIgnoreCase("selectFavoriteMeasure"))
		{
			result=util_pro.selectFavoriteMeasure(data[0]);
		}	
		else if(action.equalsIgnoreCase("checkfavorite"))
		{
			result=util_pro.checkfavorite(data[0]);
		}	

		else if(action.equalsIgnoreCase("checkAllMeasures"))
		{
			result=util_pro.checkAllMeasures(data[0]);
		}	
		else if(action.equalsIgnoreCase("wait_implicit"))
		{
			result=element.wait_implicit();
		}			
		else if(action.equalsIgnoreCase("checkdurationlist"))
		{
			result=util.checkdurationlist();
		}	
		else if(action.equalsIgnoreCase("checkProviderRegistryVLine"))
		{
			result=util_pro.checkProviderRegistryVLine(data[0]);
		}
		else if(action.equalsIgnoreCase("checkProviderMeasureDocument"))
		{
			result=util_pro.checkProviderMeasureDocument(data[0]);
		}
		else if(action.equalsIgnoreCase("dselectFavoriteMeasure"))
		{
			result=util_pro.deselectFavoriteMeasure(data[0]);
		}
		else if(action.equalsIgnoreCase("DashboardProviderView"))
		{
			ProviderGridViewR obj = new ProviderGridViewR();
			result=obj.verifyProviderGridViewR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("DashboardProviderPagination"))
		{
			ProviderPaginationR obj = new ProviderPaginationR();
			result=obj.verifyProviderPaginationR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("VerifyCount"))
		{
			ProviderCountR obj = new ProviderCountR();
			result=obj.verifyProviderCountR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderMeasureViewR"))
		{
			ProviderMeasureViewR obj = new ProviderMeasureViewR();
			result=obj.verifyProviderMeasureViewR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownViewR"))
		{
			ProviderPatientDrillDownViewR obj=  new ProviderPatientDrillDownViewR();
			result=obj.verifyProviderPatientDrillDownViewR(elementmethod,locator,data[0])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("PracticePatientDrillDownSortR"))
		{
			PracticePatientDrillDownSortR obj=new PracticePatientDrillDownSortR();
			result=obj.verify(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownPaginationR"))
		{
			ProviderPatientDrillDownPaginationR obj= new ProviderPatientDrillDownPaginationR();
			result=obj.verifyProviderPatientDrillDownPaginationR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownCountR"))
		{
			ProviderPatientDrillDownCountR obj= new ProviderPatientDrillDownCountR();
			result=obj.verifyProviderPatientDrillDownCountR(elementmethod,locator,data[0])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderMeasureComputationSummaryViewR"))
		{
			ProviderMeasureComputationSummaryViewR obj= new ProviderMeasureComputationSummaryViewR();
			result=obj.verifyProviderMeasureComputationSummaryViewR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("DashboardProviderPaginationNR"))
		{
			ProviderPaginationNR obj= new ProviderPaginationNR();
			result=obj.verifyProviderPaginationNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	;
		}
		else if(action.equalsIgnoreCase("DashboardProviderViewNR"))
		{
			ProviderGridViewNR pgvnr= new ProviderGridViewNR();
			result=pgvnr.verifyProviderGridViewNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("VerifyCountNR"))
		{
			ProviderCountNR	obj =new ProviderCountNR();
			result=obj.verifyProviderCountNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderMeasureComputationSummaryViewNR"))
		{
			ProviderMeasureComputationSummaryViewNR obj =new ProviderMeasureComputationSummaryViewNR();
			result=obj.verifyProviderMeasureComputationSummaryViewNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("PracticeMeasureViewNR"))
		{
			ProviderMeasureViewNR obj= new ProviderMeasureViewNR();
			result=obj.verifyProviderMeasureViewNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownPaginationNR"))
		{
			ProviderPatientDrillDownPaginationNR obj= new ProviderPatientDrillDownPaginationNR();
			result=obj.verifyProviderPatientDrillDownPaginationNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownCountNR"))
		{
			ProviderPatientDrillDownCountNR obj= new ProviderPatientDrillDownCountNR();
			result=obj.verifyProviderPatientDrillDownCountNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownSortNR"))
		{
			ProviderPatientDrillDownSortNR obj=new ProviderPatientDrillDownSortNR();
			result=obj.verifyProviderPatientDrillDownSortNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownSortR"))
		{
			ProviderPatientDrillDownSortR obj=new ProviderPatientDrillDownSortR();
			result=obj.verifyProviderPatientDrillDownSortR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("ProviderPatientDrillDownViewNR"))
		{
			ProviderPatientDrillDownViewNR obj=  new ProviderPatientDrillDownViewNR();
			result=obj.verifyProviderPatientDrillDownViewNR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";	
		}
		else if(action.equalsIgnoreCase("verifyDetailedPPDrillDownCountR"))
		{
			DetailedPPDrillDownCountR obj=  new DetailedPPDrillDownCountR();
			result=obj.verifyDetailedPPDrillDownCountR(elementmethod,locator,data[0])?"Pass":"Fail";	
		}
		else if (action.equals("ProviderBubbleCountNR"))
		{
            result = ProviderBubbleCountNR.verifyLocationBubbleCountNR(elementmethod, locator, data[0], data[1])? "Pass":"Fail";
       
		}
		
		else if (action.equals("ProviderBubbleCountR"))
		{
		 result = ProviderBubbleCountR.verifyLocationBubbleCountR(elementmethod, locator, data[0], data[1])? "Pass":"Fail";

		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;

	}

}
