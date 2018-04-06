package buisness.keywords.administration;

import buisness.core.administration.location.LocationGridPagination;
import buisness.core.administration.location.LocationGridSearch;
import buisness.core.administration.location.LocationGridSort;
import buisness.core.administration.location.LocationGridView;
import buisness.keywords.Common;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;


/**
 * This class contain keywords for Administration >> Location
 * @author nilesh.patil
 *Created Date:-6 Jan 2015
 */
public class Location extends Common{


	UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	buisness.core.administration.location.LocationCount lc =new   buisness.core.administration.location.LocationCount();

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
				System.err.println("Executing test case for location pagination");

				result=util.IsMenuSelected(data[0]);
			}
			else if(action.equals("IsSubMenuSelected"))	
			{
				result=util.IsSubMenuSelected(data[0]);
			}
			else if(action.equals("verifylocationcount"))	
			{
				System.out.println("reached keyword");
				result=lc.CompareDBAndUI(locator)?"pass":"fail";
			}
			else if(action.equals("verifylocationgrid"))	
			{
				LocationGridView l = new LocationGridView();
				result = l.verifyEnlistedLocations(locator,elementmethod) ? "Pass" : "Fail" ;

			}

			else if(action.equals("verifySearch"))	
			{
				LocationGridSearch l = new LocationGridSearch();
				result = l.verifyEnlistedLocations(locator,elementmethod) ? "Pass" : "Fail" ;

			}
			else if(action.equals("verifySort"))	
			{
				LocationGridSort l = new LocationGridSort();
				result = l.verifyEnlistedLocations(locator,elementmethod) ? "Pass" : "Fail" ;
			}
			else if(action.equals("verifylocationgridForPagination"))	
			{
				LocationGridPagination l =new LocationGridPagination();
				result = l.verify(locator,elementmethod) ? "Pass" : "Fail" ;

			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return result;		
	}

}
