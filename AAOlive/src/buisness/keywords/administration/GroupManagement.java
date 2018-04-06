package buisness.keywords.administration;
import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * This class contain keywords for Administration >> practice
 * 
 * @author rakesh.kulkarni
 * Created date : 1/7/2015
 * Modified date : 1/8/2015
 */
public class GroupManagement extends Common {
    UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	buisness.core.administration.groupmanagement.UserGroupView validategroupmanagementtable = new buisness.core.administration.groupmanagement.UserGroupView();
	buisness.core.administration.groupmanagement.UserGroupSearch validatesearching = new buisness.core.administration.groupmanagement.UserGroupSearch();
	buisness.core.administration.groupmanagement.UserGroupSort validatesortingorder = new buisness.core.administration.groupmanagement.UserGroupSort();
	buisness.core.administration.groupmanagement.AssociatedUserView verifyassociatedusersgrid = new buisness.core.administration.groupmanagement.AssociatedUserView();
	buisness.core.administration.groupmanagement.AssociatedUsersSearch validatesearchinofassociateduser = new buisness.core.administration.groupmanagement.AssociatedUsersSearch();
	buisness.core.administration.groupmanagement.AssociatedUsersSort validatesortingofassociateduser = new buisness.core.administration.groupmanagement.AssociatedUsersSort();
	buisness.core.administration.groupmanagement.AuthorizedUsersGroupsView validatetableofauthorizedusersgroups = new buisness.core.administration.groupmanagement.AuthorizedUsersGroupsView();
	buisness.core.administration.groupmanagement.AuthorizedUsersGroupsSearch validatesearchinofAuthorizedUsersGroups = new buisness.core.administration.groupmanagement.AuthorizedUsersGroupsSearch();	
	buisness.core.administration.groupmanagement.AuthorizedUsersGroupsSort validatesortingofAuthorizedUsersGroups = new buisness.core.administration.groupmanagement.AuthorizedUsersGroupsSort();
	buisness.core.administration.groupmanagement.UserGroupPagination userGroupPagination = new buisness.core.administration.groupmanagement.UserGroupPagination();
	buisness.core.administration.groupmanagement.AssociatedUsersPagination associatedUsersPagination = new buisness.core.administration.groupmanagement.AssociatedUsersPagination();
	buisness.core.administration.groupmanagement.AuthorizedUsersGroupsPagination authorizedUsersGroupsPagination = new buisness.core.administration.groupmanagement.AuthorizedUsersGroupsPagination();
	
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		result=super.meth(elementmethod, action, locator, data);
		try{
			if(action.equals("IsMenuSelected"))	
			{
				result=util.IsMenuSelected(data[0]);
			}
			else if(action.equals("IsSubMenuSelected"))	
			{
				result=util.IsSubMenuSelected(data[0]);
			}
			else if(action.equals("validateGroupManagementGrid"))	
			{
				 result=validategroupmanagementtable.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}	
			else if(action.equals("ValidateSearching"))	
			{
				 result=validatesearching.verifyGrid(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ValidateSortingOfUserGroup"))	
			{
				 result=validatesortingorder.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ValidateTableOfAssociatedUsers"))	
			{
				System.err.println(locator);
				 result=verifyassociatedusersgrid.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ValidateSearchingOfAssociatedUser"))	
			{
				 result=validatesearchinofassociateduser.verifyGrid(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ValidateSortingOfAssociatedUser"))	
			{
				 result=validatesortingofassociateduser.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ValidateTableOfAuthorizedUsersGroups"))	
			{
				 result=validatetableofauthorizedusersgroups.verifyGrid(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ValidateSearchingOfAuthorizedUsersGroups"))	
			{
				 result=validatesearchinofAuthorizedUsersGroups.verifyGrid(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ValidateSortingOfAuthorizedUsersGroups"))	
			{
				 result=validatesortingofAuthorizedUsersGroups.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ValidateUserGroupPagination"))	
			{
				 result=userGroupPagination.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("AssociatedUsersPagination"))	
			{
				 result=associatedUsersPagination.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("AuthorizedUsersGroupsPagination"))	
			{
				 result=authorizedUsersGroupsPagination.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Setup.testcase.fail();
		}
        	
		return result;		
	}
	

}
