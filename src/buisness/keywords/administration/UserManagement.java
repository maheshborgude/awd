package buisness.keywords.administration;

import buisness.core.administration.usermanagement.UserManagementGridPagination;
import buisness.core.administration.usermanagement.UserManagementGridSearch;
import buisness.core.administration.usermanagement.UserManagementGridSort;
import buisness.core.administration.usermanagement.UserManagementGridView;
import buisness.keywords.Common;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * Keywords for Administration > User Management
 * 
 * @author Abhishek.Gaikwad
 * Created Date: 7 Jan 2016
 * 
 */
public class UserManagement extends Common{

	UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		result=super.meth(elementmethod, action, locator, data);
		try{
			
			 if(result != null)
				{
					return result;
				}

			if(action.equals("IsMenuSelected"))	
			{
				result=util.IsMenuSelected(data[0]);
			}
			else if(action.equals("IsSubMenuSelected"))	
			{
				result=util.IsSubMenuSelected(data[0]);
			}
			else if(action.equals("verifyusergrid"))	
			{
				UserManagementGridView l = new UserManagementGridView();
				result = l.verify(locator,elementmethod) ? "Pass" : "Fail" ;

			}
			else if(action.equals("verifySearch"))	
			{
				UserManagementGridSearch l = new UserManagementGridSearch();
				result = l.verify(locator,elementmethod) ? "Pass" : "Fail" ;

			}
			else if(action.equals("verifySort"))	
			{
				UserManagementGridSort l = new UserManagementGridSort();
				result = l.verify(locator,elementmethod) ? "Pass" : "Fail" ;

			}
			else if(action.equals("verifyusergridForPagination"))	
			{
				UserManagementGridPagination l =new UserManagementGridPagination();
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