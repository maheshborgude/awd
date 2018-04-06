package buisness.keywords.administration;

import buisness.core.administration.provider.*;
import buisness.core.dashboard.provider.nonrolling.ProviderBubbleCountNR;
import buisness.keywords.Common;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * Keywords for Administration>Provider 
 * 
 * @author Sachin.Gawade
 * Created Date: 7 Jan 2016
 * 
 */
public class Provider extends Common{

	UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	ProviderCount pc=new ProviderCount();
	ProviderView pb=new ProviderView();
	SearchProvider sp=new SearchProvider();
	ProviderSort sop=new ProviderSort();
	ProviderPagination pg=new ProviderPagination();

	
	buisness.core.dashboard.provider.rolling.ProviderMeasureViewR providerMeasureView = new buisness.core.dashboard.provider.rolling.ProviderMeasureViewR();
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		result=super.meth(elementmethod, action, locator, data);
		try{
			if(result != null)
			{
				return result;
			}
			else if(action.equals("IsMenuSelected"))	
			{
				result=util.IsMenuSelected(data[0]);
			}
			else if(action.equals("IsSubMenuSelected"))	
			{
				result=util.IsSubMenuSelected(data[0]);
			}
			else if(action.equals("VerifyProviderCount"))	
			{
				result=pc.verify(locator)?"Pass":"Fail";
			}
			else if(action.equals("VerifyProviderTable"))	
			{
				result=pb.verify(locator)?"Pass":"Fail";
			}
			else if(action.equals("SearchProviderTable"))	
			{
				result=sp.verify(locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("SortProvider"))	
			{
				result=sop.verify(locator)?"Pass":"Fail";
			}
			else if(action.equals("VerifyProviderPagination"))	
			{
				result=pg.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ProviderMeasureViewR"))
			{
				result=providerMeasureView.verifyProviderMeasureViewR(elementmethod,locator,data[0],data[1])?"Pass":"Fail";
			}
		

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        	
		return result;		
	}
	
}