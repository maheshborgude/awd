package buisness.keywords.dashboard;

import buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownViewNR;
import buisness.core.dashboard.Practice.practiceMeasureGrid.*;
import buisness.core.dashboard.Practice.practiceMeasureGrid.PracticeFavoritesMeasureCountR;
import buisness.core.dashboard.Practice.practiceMeasureGrid.PracticeFavoritesMeasureViewR;
import buisness.core.dashboard.Practice.practiceMeasureGrid.PracticeFavoritesMeasureViewNR;
import buisness.core.dashboard.Practice.practiceMeasureGrid.PracticeMeasureCountR;
import buisness.core.dashboard.Practice.rolling.*;
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
public class Practice extends Common {
	
    UtilityFunction util=new UtilityFunction();
	UtilityFunctionDashboardProvider util_pro=new UtilityFunctionDashboardProvider();
	buisness.core.dashboard.Practice.rolling.PracticeMeasureViewR practiceMeasureViewR = new buisness.core.dashboard.Practice.rolling.PracticeMeasureViewR();
	buisness.core.dashboard.Practice.nonRolling.PracticeMeasureViewNR practiceMeasureViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeMeasureViewNR();
	buisness.core.dashboard.Practice.rolling.PracticeMeasureCountR practiceMeasureCountR = new buisness.core.dashboard.Practice.rolling.PracticeMeasureCountR();
    buisness.core.dashboard.Practice.nonRolling.PracticeMeasureCountNR practiceMeasureCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeMeasureCountNR();
	buisness.core.dashboard.Practice.rolling.PracticeFavoritesMeasureViewR practiceFavoritesMeasureViewR = new buisness.core.dashboard.Practice.rolling.PracticeFavoritesMeasureViewR();
	buisness.core.dashboard.Practice.rolling.PracticeFavoritesMeasureCountR practiceFavoritesMeasureCountR = new buisness.core.dashboard.Practice.rolling.PracticeFavoritesMeasureCountR();
	PracticeFavoritesMeasureCountR practiceFavoritesMeasureCountR1 = new PracticeFavoritesMeasureCountR();
	buisness.core.dashboard.Practice.nonRolling.PracticeFavoritesMeasureCountNR practiceFavoritesMeasureCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeFavoritesMeasureCountNR();
	PracticeFavoritesMeasureCountNR practiceFavoritesMeasureCountNR1  = new PracticeFavoritesMeasureCountNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeFavoritesMeasureViewNR practiceFavoritesMeasureViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeFavoritesMeasureViewNR();
	SubmissionDetailsViewR submissionDetailsViewR = new SubmissionDetailsViewR();
	SubmissionDetailsPaginationR submissionDetailsPaginationR = new SubmissionDetailsPaginationR();
	SubmissionDetailsCountR submissionDetailsCountR = new SubmissionDetailsCountR();
	buisness.core.dashboard.Practice.nonRolling.SubmissionDetailsCountNR submissionDetailsCountNR = new buisness.core.dashboard.Practice.nonRolling.SubmissionDetailsCountNR();
	buisness.core.dashboard.Practice.nonRolling.SubmissionDetailsPaginationNR submissionDetailsPaginationNR =new buisness.core.dashboard.Practice.nonRolling.SubmissionDetailsPaginationNR();
	buisness.core.dashboard.Practice.nonRolling.SubmissionDetailsViewNR submissionDetailsViewNR = new buisness.core.dashboard.Practice.nonRolling.SubmissionDetailsViewNR();
	buisness.core.dashboard.Practice.rolling.PracticeMeasureComputationSummaryViewR practiceMeasureComputationSummaryViewR = new buisness.core.dashboard.Practice.rolling.PracticeMeasureComputationSummaryViewR();
	buisness.core.dashboard.Practice.nonRolling.PracticeMeasureComputationSummaryViewNR practiceMeasureComputationSummaryViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeMeasureComputationSummaryViewNR();
	PracticePatientDrillDownViewR practicePatientDrillDownViewR = new PracticePatientDrillDownViewR();
	PracticePatientDrillDownPaginationR practicePatientDrillDownPaginationR = new PracticePatientDrillDownPaginationR();
	PracticePatientDrillDownSortR practicePatientDrillDownSortR = new PracticePatientDrillDownSortR();
	PracticePatientDrillDownCountR practicePatientDrillDownCountR =new PracticePatientDrillDownCountR();
	buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownCountNR practicePatientDrillDownCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownCountNR();
	buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownPaginationNR practicePatientDrillDownPaginationNR = new buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownPaginationNR();
	buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownSortNR practicePatientDrillDownSortNR = new buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownSortNR();
	buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownViewNR practicePatientDrillDownViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticePatientDrillDownViewNR();
	buisness.core.dashboard.Practice.rolling.PracticeLocationPopUpViewR practiceLocationPopUpViewR= new buisness.core.dashboard.Practice.rolling.PracticeLocationPopUpViewR();
	buisness.core.dashboard.Practice.rolling.PracticeLocationPopUpPaginationR practiceLocationPopUpPaginationR = new buisness.core.dashboard.Practice.rolling.PracticeLocationPopUpPaginationR();
	buisness.core.dashboard.Practice.rolling.PracticeLocationPopUpCountR practiceLocationPopUpCountR = new buisness.core.dashboard.Practice.rolling.PracticeLocationPopUpCountR();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationPopUpViewNR practiceLocationPopUpViewNR= new buisness.core.dashboard.Practice.nonRolling.PracticeLocationPopUpViewNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationPopUpPaginationNR practiceLocationPopUpPaginationNR = new buisness.core.dashboard.Practice.nonRolling.PracticeLocationPopUpPaginationNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationPopUpCountNR practiceLocationPopUpCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeLocationPopUpCountNR();
	buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownCountR practiceLocationPatientDrillDownCountR = new buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownCountR ();
	buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownPaginationR practiceLocationPatientDrillDownPaginationR = new buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownPaginationR();
	buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownSortR practiceLocationPatientDrillDownSortR = new buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownSortR();
	buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownViewR practiceLocationPatientDrillDownViewR = new buisness.core.dashboard.Practice.rolling.PracticeLocationPatientDrillDownViewR();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownCountNR practiceLocationPatientDrillDownCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownCountNR ();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownPaginationNR practiceLocationPatientDrillDownPaginationNR = new buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownPaginationNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownSortNR practiceLocationPatientDrillDownSortNR = new buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownSortNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownViewNR practiceLocationPatientDrillDownViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeLocationPatientDrillDownViewNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeLocationMeasureComputationSummaryViewNR practiceLocationMeasureComputationSummaryViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeLocationMeasureComputationSummaryViewNR();
	buisness.core.dashboard.Practice.rolling.PracticeLocationMeasureComputationSummaryViewR practiceLocationMeasureComputationSummaryViewR = new buisness.core.dashboard.Practice.rolling.PracticeLocationMeasureComputationSummaryViewR();
	buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPopUpCountNR practiceProvidersPopUpCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPopUpCountNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPopUpViewNR practiceProvidersPopUpViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPopUpViewNR();
	buisness.core.dashboard.Practice.rolling.PracticeProvidersPopUpCountR practiceProvidersPopUpCountR = new buisness.core.dashboard.Practice.rolling.PracticeProvidersPopUpCountR();
	buisness.core.dashboard.Practice.rolling.PracticeProvidersPopUpViewR practiceProvidersPopUpViewR = new buisness.core.dashboard.Practice.rolling.PracticeProvidersPopUpViewR();
	buisness.core.dashboard.Practice.rolling.PracticeProviderMeasureComputationSummaryViewR practiceProviderMeasureComputationSummaryViewR = new buisness.core.dashboard.Practice.rolling.PracticeProviderMeasureComputationSummaryViewR();
	buisness.core.dashboard.Practice.nonRolling.PracticeProviderMeasureComputationSummaryViewNR practiceProviderMeasureComputationSummaryViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeProviderMeasureComputationSummaryViewNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownCountNR practiceProvidersPatientDrillDownCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownCountNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownPaginationNR practiceProvidersPatientDrillDownPaginationNR = new buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownPaginationNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownSortNR practiceProvidersPatientDrillDownSortNR = new buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownSortNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownViewNR practiceProvidersPatientDrillDownViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeProvidersPatientDrillDownViewNR();
	buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownCountR practiceProvidersPatientDrillDownCountR = new buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownCountR();
	buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownPaginationR practiceProvidersPatientDrillDownPaginationR = new buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownPaginationR();
	buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownSortR practiceProvidersPatientDrillDownSortR = new buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownSortR();
	buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownViewR practiceProvidersPatientDrillDownViewR = new buisness.core.dashboard.Practice.rolling.PracticeProvidersPatientDrillDownViewR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPopUpViewNR practiceAllProvidersPopUpViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPopUpViewNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPopUpCountNR practiceAllProvidersPopUpCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPopUpCountNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownViewNR practiceAllProvidersPatientDrillDownViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownViewNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownSortNR practiceAllProvidersPatientDrillDownSortNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownSortNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownPaginationNR practiceAllProvidersPatientDrillDownPaginationNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownPaginationNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownCountNR practiceAllProvidersPatientDrillDownCountNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersPatientDrillDownCountNR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersMeasureComputationSummaryViewNR practiceAllProvidersMeasureComputationSummaryViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllProvidersMeasureComputationSummaryViewNR();
	buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPopUpViewR practiceAllProvidersPopUpViewR = new buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPopUpViewR();
	buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPopUpCountR practiceAllProvidersPopUpCountR = new buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPopUpCountR();
	buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownViewR practiceAllProvidersPatientDrillDownViewR = new buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownViewR();
	buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownSortR practiceAllProvidersPatientDrillDownSortR = new buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownSortR();
	buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownPaginationR practiceAllProvidersPatientDrillDownPaginationR = new buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownPaginationR();
	buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownCountR practiceAllProvidersPatientDrillDownCountR = new buisness.core.dashboard.Practice.rolling.PracticeAllProvidersPatientDrillDownCountR();
	buisness.core.dashboard.Practice.rolling.PracticeAllProvidersMeasureComputationSummaryViewR practiceAllProvidersMeasureComputationSummaryViewR = new buisness.core.dashboard.Practice.rolling.PracticeAllProvidersMeasureComputationSummaryViewR();
	buisness.core.dashboard.Practice.rolling.PracticeAllPerformanceTrendViewR practiceAllPerformanceTrendViewR = new buisness.core.dashboard.Practice.rolling.PracticeAllPerformanceTrendViewR();
	buisness.core.dashboard.Practice.nonRolling.PracticeAllPerformanceTrendViewNR practiceAllPerformanceTrendViewNR = new buisness.core.dashboard.Practice.nonRolling.PracticeAllPerformanceTrendViewNR();
    buisness.core.dashboard.Practice.practicePerformanceTrend.PPTTableView PPTTableViewObj=new buisness.core.dashboard.Practice.practicePerformanceTrend.PPTTableView();
    PracticeMeasureGridViewR defaultmeasuregridviewobj = new PracticeMeasureGridViewR();
	PracticeMeasureCountNR prac = new PracticeMeasureCountNR();
	PracticeFavoritesMeasureViewR prac2 = new PracticeFavoritesMeasureViewR();
	PracticeFavoritesMeasureViewNR prac3 = new PracticeFavoritesMeasureViewNR();
	MeasuresWithHighScores MeasureWithHS = new MeasuresWithHighScores();
	MeasuresWithLowScores MeasureWithLS = new MeasuresWithLowScores();
	MeasuresLastUpdatedDate MeasuresLastUpdateDate = new MeasuresLastUpdatedDate();
	PracticeMeasureCountR practiceMeasureCountR1 = new PracticeMeasureCountR();
	MeasureCountWithHigherScores MCWithHS = new MeasureCountWithHigherScores();
	MeasureCountWithLowerScores MCWithLS = new MeasureCountWithLowerScores();
	
	
    buisness.core.dashboard.Practice.practiceProvider.rolling.PracticeProviderPT_TableViewR PracticeProvPTTableObj=new buisness.core.dashboard.Practice.practiceProvider.rolling.PracticeProviderPT_TableViewR();
	buisness.core.dashboard.Practice.practiceProvider.rolling.PPPatientDrillDownCountR PPpatientCountObj=new buisness.core.dashboard.Practice.practiceProvider.rolling.PPPatientDrillDownCountR();
	buisness.core.dashboard.Practice.practiceProvider.rolling.PracticeProviderPopUpViewR PPPopUpViewObj=new buisness.core.dashboard.Practice.practiceProvider.rolling.PracticeProviderPopUpViewR();
	buisness.core.dashboard.Practice.practiceProvider.rolling.PracticeProvidersPopUpCountR practiceProvPopUpCountR = new 	buisness.core.dashboard.Practice.practiceProvider.rolling.PracticeProvidersPopUpCountR();
	buisness.core.dashboard.Practice.practiceProvider.rolling.PPPatientDrillDownViewR PPpatientViewObj=new buisness.core.dashboard.Practice.practiceProvider.rolling.PPPatientDrillDownViewR();
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
			else if(action.equalsIgnoreCase("verifyPracticeProvidersPopUpCountR"))
			{
				result= practiceProvPopUpCountR.verifyPracticeProviderCount(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("verifyPracticeProviderPopUpView"))
			{
				result=PPPopUpViewObj.verifyPracticeProviderPopUpView(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("verifyPracticeProviderPTTable"))
			{
				result=PracticeProvPTTableObj.verifyPracticeProviderTable(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("verifyPPPatientDrillDownCount"))
			{
				result=PPpatientCountObj.verifyPatientCount(elementmethod,locator,data[0])?"pass":"Fail";
            }
			else if(action.equalsIgnoreCase("verifyPPPatientDrillDownView"))
            {
				System.out.println("Inside Practice Custom Keyword:");
				result=PPpatientViewObj.verifyPatientView(elementmethod,locator,data[0])?"pass":"Fail";
				System.out.println("Result in Practice Custom:"+result);
            }
			else if(action.equalsIgnoreCase("PracticeMeasureViewNR"))
			{
				result=practiceMeasureViewNR.verify(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeMeasureCountR"))
			{
				result=practiceMeasureCountR.verify(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeMeasureCountNR"))
			{
				result=practiceMeasureCountNR.verify(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeFavoritesMeasureViewR"))
			{
				result=practiceFavoritesMeasureViewR.verify(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeFavoritesMeasureCountR"))
			{
				result=practiceFavoritesMeasureCountR1.verifyCount(elementmethod, locator, data[0],data[1])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeFavoritesMeasureViewNR"))
			{
				result=practiceFavoritesMeasureViewNR.verify(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeFavoritesMeasureCountNR"))
			{
				result=practiceFavoritesMeasureCountNR1.verifyCount(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("SubmissionDetailsViewR"))
			{
				result= submissionDetailsViewR.verify(elementmethod,locator)?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("SubmissionDetailsPaginationR"))
			{
				result= submissionDetailsPaginationR.verify(elementmethod,locator)?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("SubmissionDetailsCountR"))
			{
				result= submissionDetailsCountR.verify(elementmethod,locator)?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("SubmissionDetailsCountNR"))
			{
				result= submissionDetailsCountNR.verify(elementmethod,locator)?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("SubmissionDetailsPaginationNR"))
			{
				result= submissionDetailsPaginationNR.verify(elementmethod,locator)?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("SubmissionDetailsViewNR"))
			{
				result= submissionDetailsViewNR.verify(elementmethod,locator)?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeMeasureComputationSummaryViewR"))
			{
				result=practiceMeasureComputationSummaryViewR.verify(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeMeasureComputationSummaryViewNR"))
			{
				result=practiceMeasureComputationSummaryViewNR.verify(elementmethod,locator,data[0])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownViewR"))
			{
				result= practicePatientDrillDownViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownPaginationR"))
			{
				result= practicePatientDrillDownPaginationR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownSortR"))
			{
				result= practicePatientDrillDownSortR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownCountR"))
			{
				result= practicePatientDrillDownCountR.verifyPracticePatientDrillDownCountR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownViewNR"))
			{
				result= practicePatientDrillDownViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownSortNR"))
			{
				result= practicePatientDrillDownSortNR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownPaginationNR"))
			{
				result= practicePatientDrillDownPaginationNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticePatientDrillDownCountNR"))
			{
				result= practicePatientDrillDownCountNR.verifyPracticePatientDrillDownCountNR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPopUpViewR"))
			{
				result= practiceLocationPopUpViewR.verifyPracticeLocationPopUpViewR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPopUpPaginationR"))
			{
				result=practiceLocationPopUpPaginationR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPopUpCountR"))
			{
				result=practiceLocationPopUpCountR.verifyPracticeLocationPopUpCountR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPopUpViewNR"))
			{
				result= practiceLocationPopUpViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPopUpPaginationNR"))
			{
				result=practiceLocationPopUpPaginationNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPopUpCountNR"))
			{
				result=practiceLocationPopUpCountNR.verifyPracticeLocationPopUpCountNR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownCountR"))
			{
				result=practiceLocationPatientDrillDownCountR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownPaginationR"))
			{
				result= practiceLocationPatientDrillDownPaginationR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownSortR"))
			{
				result=practiceLocationPatientDrillDownSortR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownViewR"))
			{
				result=practiceLocationPatientDrillDownViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownCountNR"))
			{
				result=practiceLocationPatientDrillDownCountNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownPaginationNR"))
			{
				result= practiceLocationPatientDrillDownPaginationNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownSortNR"))
			{
				result=practiceLocationPatientDrillDownSortNR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationPatientDrillDownViewNR"))
			{
				result= practiceLocationPatientDrillDownViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationMeasureComputationSummaryViewNR"))
			{
				result= practiceLocationMeasureComputationSummaryViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeLocationMeasureComputationSummaryViewR"))
			{
				result= practiceLocationMeasureComputationSummaryViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPopUpCountNR"))
			{
				result=practiceProvidersPopUpCountNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPopUpViewNR"))
			{
				result= practiceProvidersPopUpViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPopUpCountR"))
			{
				result= practiceProvidersPopUpCountR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPopUpViewR"))
			{
				result= practiceProvidersPopUpViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProviderMeasureComputationSummaryViewR"))
			{
				result= practiceProviderMeasureComputationSummaryViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProviderMeasureComputationSummaryViewNR"))
			{
				result= practiceProviderMeasureComputationSummaryViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPatientDrillDownCountNR"))
			{
				result= practiceProvidersPatientDrillDownCountNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPatientDrillDownPaginationNR"))
			{
				result= practiceProvidersPatientDrillDownPaginationNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPatientDrillDownSortNR"))
			{
				result= practiceProvidersPatientDrillDownSortNR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPatientDrillDownViewNR"))
			{
				result= practiceProvidersPatientDrillDownViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("practiceProvidersPatientDrillDownCountR"))
			{
				result= practiceProvidersPatientDrillDownCountR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPatientDrillDownPaginationR"))
			{
				result= practiceProvidersPatientDrillDownPaginationR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPatientDrillDownSortR"))
			{
				result= practiceProvidersPatientDrillDownSortR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeProvidersPatientDrillDownViewR"))
			{
				result= practiceProvidersPatientDrillDownViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPopUpViewNR"))
			{
				result= practiceAllProvidersPopUpViewNR.verifyPracticeAllProvidersPopUpViewNR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPopUpCountNR"))
			{
				result= practiceAllProvidersPopUpCountNR.verifyPracticeAllProvidersPopUpCountNR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownViewNR"))
			{
				result= practiceAllProvidersPatientDrillDownViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownSortNR"))
			{
				result= practiceAllProvidersPatientDrillDownSortNR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownPaginationNR"))
			{
				result= practiceAllProvidersPatientDrillDownPaginationNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownCountNR"))
			{
				result= practiceAllProvidersPatientDrillDownCountNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersMeasureComputationSummaryViewNR"))
			{
				result= practiceAllProvidersMeasureComputationSummaryViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPopUpViewR"))
			{
				result= practiceAllProvidersPopUpViewR.verifyPracticeAllProvidersPopUpViewR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPopUpCountR"))
			{
				result= practiceAllProvidersPopUpCountR.verifyPracticeAllProvidersPopUpCountR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownViewR"))
			{
				result= practiceAllProvidersPatientDrillDownViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownSortR"))
			{
				result= practiceAllProvidersPatientDrillDownSortR.verify(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownPaginationR"))
			{
				result= practiceAllProvidersPatientDrillDownPaginationR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersPatientDrillDownCountR"))
			{
				result= practiceAllProvidersPatientDrillDownCountR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllProvidersMeasureComputationSummaryViewR"))
			{
				result= practiceAllProvidersMeasureComputationSummaryViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllPerformanceTrendViewR"))
			{
				result= practiceAllPerformanceTrendViewR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PracticeAllPerformanceTrendViewNR"))
			{
				result= practiceAllPerformanceTrendViewNR.verify(elementmethod,locator,data[0]) ? "Pass":"Fail";
			} // Added by Me.
			else if(action.equalsIgnoreCase("VerifyPracticeMeasureGrid"))
			{
				result= defaultmeasuregridviewobj.verifyPracticeMeasureGridR(elementmethod,locator,data[0],data[1]) ? "Pass":"Fail";
			} 
			else if(action.equalsIgnoreCase("PFMViewR"))
			{
				result=prac2.verifyPFMViewR(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			} 
			else if(action.equalsIgnoreCase("PFMViewNR"))
			{
				result=prac3.verifyPFMViewNR(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			} 
			else if(action.equalsIgnoreCase("MeasureWithHS"))
			{
				result=MeasureWithHS.VerifyMeasureHS(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			} 
			else if(action.equalsIgnoreCase("MeasureCountWithHS"))
			{
				result=MCWithHS.verifyMeasureCountwithHS(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("MeasureWithLS"))
			{
				result=MeasureWithLS.VerifyMeasureLS(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("MeasureCountWithLS"))
			{
				result=MCWithLS.verifyMeasureCountwithLS(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("MeasuresLastUpdateDate"))
			{
				result=MeasuresLastUpdateDate.verifyMeasuresLastUpdatedDate(elementmethod,locator,data[0],data[1])?"pass":"Fail";
			}
			else if(action.equalsIgnoreCase("PMCountR"))
			{
				result=practiceMeasureCountR1.verifyPMCountR(elementmethod, locator, data[0],data[1]);
			}
			else if(action.equalsIgnoreCase("PMCountNR"))
			{
				result=prac.verifyPMCountNR(elementmethod, locator, data[0],data[1]);
			
			}
		}
		catch(Exception e)
		{
			System.out.println("You have to initialize the action keywords either in commom class or keyword class.");
			System.out.println(e);
			e.printStackTrace();
			Setup.testcase.fail();
		}
        	
		return result;		
	}
	

}
