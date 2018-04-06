package buisness.keywords.gprosubmission;


import buisness.keywords.Common;
import configuration.UtilityFunction;
import buisness.core.Submission.AddPatientVisit;
import buisness.core.Submission.gproSubmission.milestonethree.GproAdvancedStatusPagination;
import buisness.core.Submission.gproSubmission.milestonethree.GproAdvancedStatusPopupPagination;
import buisness.core.Submission.gproSubmission.milestonethree.GproAdvancedStatusPopupSort;
import buisness.core.Submission.gproSubmission.milestonethree.GproAdvancedStatusPopupView;
import buisness.core.Submission.gproSubmission.milestonethree.GproAdvancedStatusSort;
import buisness.core.Submission.gproSubmission.milestonethree.GproAdvancedStatusView;
import buisness.core.Submission.gproSubmission.milestonethree.GproRepPatientVisitsPagination;
import buisness.core.Submission.gproSubmission.milestonethree.GproReportedPatientVisitsCount;
import buisness.core.Submission.gproSubmission.milestonethree.GproReportedPatientVisitsSearch;
import buisness.core.Submission.gproSubmission.milestonethree.GproReportedPatientVisitsSort;
import buisness.core.Submission.gproSubmission.milestonethree.GproReportedPatientVisitsView;
import buisness.core.Submission.gproSubmission.milestonetwo.GPROReportingMeasuresViewVerify;
import buisness.core.Submission.gproSubmission.milestonetwo.GPROSelectedReportingMeasures;

/**
 * Keywords for Gpro Submission
 * 
 * @author Sachin.Gawade
 * Created Date: 11 Feb 2016
 * 
 */
public class Gprosubmission extends Common{

	UtilityFunction util=new UtilityFunction();
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
			else if(action.equals("VerifyGproMeasures"))	
			{
				GPROReportingMeasuresViewVerify obj = new GPROReportingMeasuresViewVerify();
				result=obj.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("DatePicker"))	
			{
				AddPatientVisit obj= new AddPatientVisit();
				result=obj.setDatePicker(locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("VerifyReportedPatientVisits"))	
			{
				GproReportedPatientVisitsView obj=new GproReportedPatientVisitsView();
				result=obj.verify(elementmethod,locator)?"Pass":"Fail";				
			}
			else if(action.equals("SearchReportedPatientVisits"))	
			{
				GproReportedPatientVisitsSearch obj=new GproReportedPatientVisitsSearch();
				result=obj.verify(elementmethod,locator,data[0])?"Pass":"Fail";				
			}
			else if(action.equals("sortgrid"))	
			{
				GproReportedPatientVisitsSort obj=new GproReportedPatientVisitsSort();
				result=obj.verify(elementmethod,locator,data[0])?"Pass":"Fail";				
			}
			else if(action.equals("VerifyPagination"))	
			{
				GproRepPatientVisitsPagination obj=new GproRepPatientVisitsPagination();
				result=obj.verify(elementmethod,locator)?"Pass":"Fail";				
			}
			else if(action.equals("VerifyCount"))	
			{
				GproReportedPatientVisitsCount obj= new GproReportedPatientVisitsCount();
				result=obj.verify(elementmethod,locator)?"Pass":"Fail";				
			}
			else if(action.equals("GPROAdvancedStatusView"))	
			{
				GproAdvancedStatusView obj = new GproAdvancedStatusView();
				result=obj.verify(elementmethod,locator)?"Pass":"Fail";				
			}
			else if(action.equals("GPROAdvancedStatusSort"))	
			{
				GproAdvancedStatusSort obj = new GproAdvancedStatusSort();
				result=obj.verify(elementmethod,locator,data[0])?"Pass":"Fail";				
			}
			else if(action.equals("GPROAdvancedStatusPagination"))	
			{
				GproAdvancedStatusPagination obj = new GproAdvancedStatusPagination();
				result=obj.verify(elementmethod,locator)?"Pass":"Fail";				
			}
			else if(action.equals("GPROAdvancedStatusPopupView"))	
			{
				GproAdvancedStatusPopupView obj= new GproAdvancedStatusPopupView();
				result=obj.verify(elementmethod,locator,data[0])?"Pass":"Fail";				
			}
			else if(action.equals("GPROAdvancedStatusPopupSort"))	
			{
				GproAdvancedStatusPopupSort obj= new GproAdvancedStatusPopupSort();
				result=obj.verify(elementmethod,locator,data[0],data[1])?"Pass":"Fail";				
			}
			else if(action.equals("GPROAdvancedStatusPopupPagination"))	
			{
				GproAdvancedStatusPopupPagination obj= new GproAdvancedStatusPopupPagination();
				result=obj.verify(elementmethod,locator,data[0])?"Pass":"Fail";				
			}
			else if(action.equals("VerifySelectedGproMeasures"))	
			{
				GPROSelectedReportingMeasures obj= new GPROSelectedReportingMeasures();
				result=obj.verify(elementmethod,locator)?"Pass":"Fail";				
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        	
		return result;		
	}
	
	
	
}