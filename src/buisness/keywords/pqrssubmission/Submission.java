package buisness.keywords.pqrssubmission;

import buisness.keywords.Common;
import configuration.Setup;
import configuration.UtilityFunction;
import testcases.dashboard.provider.UtilityFunctionDashboardProvider;

/**
 * This class contain keywords for Administration >> PQRS Submission
 * 
 * @author rakesh.kulkarni
 * Created date : 08/02/2016
 * Modified date : 08/08/2016
 */
public class Submission extends Common {
    UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderView manageProviderProfileSelectProviderView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderSearch manageProviderProfileSelectProviderSearch = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderSearch();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderSort manageProviderProfileSelectProviderSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderPagination manageProviderProfileSelectProviderPagination = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.SelectProviderPagination(); 
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.TaxIdentificationNumberView taxIdentificationNumberView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.TaxIdentificationNumberView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.TaxIdentificationNumberSort taxIdentificationNumberSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.TaxIdentificationNumberSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRView reportedPatientVisitsView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRSort reportedPatientVisitsSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRSearch reportedPatientVisitsCMGRSearch = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRSearch();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.PqrsReportingOptionIMRView pqrsReportingOptionView = new  buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.PqrsReportingOptionIMRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.PqrsReportingOptionCMGRView pqrsReportingOptionCMGView =new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.PqrsReportingOptionCMGRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.PqrsReportingOptionQCDRRView pqrsReportingOptionQCDRRView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.PqrsReportingOptionQCDRRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRView reportedPatientVisitsQCDRRView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRView(); 
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountIndividualMeasuresReporting countIndividualMeasuresReporting = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountIndividualMeasuresReporting(); 
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountQualifiedClinicalDataRegistryReporting countQualifiedClinicalDataRegistryReporting =new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountQualifiedClinicalDataRegistryReporting();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountCataractsMeasuresGroupReporting countCataractsMeasuresGroupReporting = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountCataractsMeasuresGroupReporting();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountTaxIdentificationNumber countTaxIdentificationNumber = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo.CountTaxIdentificationNumber();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRCount countReportedPatientVisitsCataracts = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRCount();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRPagination reportedPatientVisitsCMGRPagination = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsCMGRPagination();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRView reportedPatientVisitsIMRView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRSearch reportedPatientVisitsIMRSearch = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRSearch();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRSort reportedPatientVisitsIMRSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRPagination reportedPatientVisitsIMRPagination = new 	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRPagination();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRCount reportedPatientVisitsIMRCount = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsIMRCount();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRPagination reportedPatientVisitsQCDRRPagination = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRPagination();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRRSearch reportedPatientVisitsQCDRRRSearch = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRRSearch();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRSort reportedPatientVisitsQCDRRSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRCount reportedPatientVisitsQCDRRCount = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.ReportedPatientVisitsQCDRRCount();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusIMRView pqrsAdvancedStatusIMRView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusIMRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusIMRSort pqrsAdvancedStatusIMRSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusIMRSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusIMRPagination pqrsAdvancedStatusIMRPagination = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusIMRPagination();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusQCDRRView pqrsAdvancedStatusQCDRRView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusQCDRRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusQCDRRSort pqrsAdvancedStatusQCDRRSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusQCDRRSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusQCDRRPagination pqrsAdvancedStatusQCDRRPagination = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusQCDRRPagination();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusCMGRView pqrsAdvancedStatusCMGRView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusCMGRView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusCMGRSort pqrsAdvancedStatusCMGRSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.PqrsAdvancedStatusCMGRSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.GroupPerformanceView groupPerformanceView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.GroupPerformanceView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.GroupPerformanceSort groupPerformanceSort = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree.GroupPerformanceSort();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour.ProviderSubmissionView providerSubmissionView = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour.ProviderSubmissionView();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour.ProviderSubmissionPagination providerSubmissionPagination = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour.ProviderSubmissionPagination();
	buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour.ProviderSubmissionCount providerSubmissionCount = new buisness.core.Submission.pqrsSubmission.submission2015.milestoneFour.ProviderSubmissionCount();
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
			else if(action.equals("ManageProviderProfileSelectProviderView"))	
			{
				result=manageProviderProfileSelectProviderView.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ManageProviderProfileSelectProviderSearch"))	
			{
				result=manageProviderProfileSelectProviderSearch.verifyGrid(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ManageProviderProfileSelectProviderSort"))	
			{
				result=manageProviderProfileSelectProviderSort.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ManageProviderProfileSelectProviderPagination"))	
			{
				result=manageProviderProfileSelectProviderPagination.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("TaxIdentificationNumberView"))	
			{
				result=taxIdentificationNumberView.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("TaxIdentificationNumberSort"))	
			{
				result=taxIdentificationNumberSort.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsView"))	
			{
				result=reportedPatientVisitsView.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsSort"))	
			{
				result=reportedPatientVisitsSort.verifyGrid(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsSearch"))	
			{
				result=reportedPatientVisitsCMGRSearch.verifyGrid(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("PqrsReportingOptionView"))	
			{
				result=pqrsReportingOptionView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("PqrsReportingOptionCMGView"))	
			{
				result=pqrsReportingOptionCMGView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("PqrsReportingOptionQCDRRView"))	
			{
				result=pqrsReportingOptionQCDRRView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsQCDRRView"))	
			{
				result=reportedPatientVisitsQCDRRView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("CountIndividualMeasuresReporting"))	
			{
				result=countIndividualMeasuresReporting.verify(elementmethod,locator)?"Pass":"Fail";
			} 
			else if(action.equals("CountQualifiedClinicalDataRegistryReporting"))	
			{
				result=countQualifiedClinicalDataRegistryReporting.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("CountCataractsMeasuresGroupReporting"))	
			{
				result=countCataractsMeasuresGroupReporting.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("CountTaxIdentificationNumber"))	
			{
				result=countTaxIdentificationNumber.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("CountReportedPatientVisitsCataracts"))	
			{
				result=countReportedPatientVisitsCataracts.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsCMGRPagination"))	
			{
				result=reportedPatientVisitsCMGRPagination.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsIMRView"))	
			{
				result=reportedPatientVisitsIMRView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsIMRSearch"))	
			{
				result=reportedPatientVisitsIMRSearch.verify(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsIMRSort"))	
			{
				result=reportedPatientVisitsIMRSort.verify(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsIMRPagination"))	
			{
				result=reportedPatientVisitsIMRPagination.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsIMRCount"))	
			{
				result=reportedPatientVisitsIMRCount.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsQCDRRPagination"))	
			{
				result=reportedPatientVisitsQCDRRPagination.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsQCDRRRSearch"))	
			{
				result=reportedPatientVisitsQCDRRRSearch.verify(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsQCDRRSort"))	
			{
				result=reportedPatientVisitsQCDRRSort.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ReportedPatientVisitsQCDRRCount"))	
			{
				result=reportedPatientVisitsQCDRRCount.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("PqrsAdvancedStatusIMRView"))	
			{
				result=pqrsAdvancedStatusIMRView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("PqrsAdvancedStatusIMRSort"))	
			{
				result=pqrsAdvancedStatusIMRSort.verify(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("PqrsAdvancedStatusIMRPagination"))	
			{
				result=pqrsAdvancedStatusIMRPagination.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("PqrsAdvancedStatusQCDRRView"))	
			{
				result=pqrsAdvancedStatusQCDRRView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("PqrsAdvancedStatusQCDRRSort"))	
			{
				result=pqrsAdvancedStatusQCDRRSort.verify(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("PqrsAdvancedStatusQCDRRPagination"))	
			{
				result=pqrsAdvancedStatusQCDRRPagination.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("PqrsAdvancedStatusCMGRView"))	
			{
				result=pqrsAdvancedStatusCMGRView.verify(elementmethod,locator)?"Pass":"Fail";
			}  
			else if(action.equals("PqrsAdvancedStatusCMGRSort"))	
			{
				result=pqrsAdvancedStatusCMGRSort.verify(elementmethod,locator,data[0])?"Pass":"Fail";
			}
			else if(action.equals("GroupPerformanceSort"))	
			{
				result=groupPerformanceView.verify(elementmethod,locator)?"Pass":"Fail";
			}      
			else if(action.equals("GroupPerformanceView"))	
			{
				result=groupPerformanceSort.verify(elementmethod,locator)?"Pass":"Fail";
			} 
			else if(action.equals("ProviderSubmissionView"))
			{
				result=providerSubmissionView.verify(elementmethod,locator)?"Pass":"Fail";
			}
			else if(action.equals("ProviderSubmissionPagination"))
			{
				result=providerSubmissionPagination.verify(elementmethod,locator)?"Pass":"Fail";
			}  
			else if(action.equals("ProviderSubmissionCount"))
			{
				result=providerSubmissionCount.verify(elementmethod,locator)?"Pass":"Fail";
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
