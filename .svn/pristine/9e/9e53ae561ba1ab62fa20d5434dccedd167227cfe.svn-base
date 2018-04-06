package buisness.util.datastructures.Submission.pqrssubmission;
/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone
 *   >>Select Provider tab
 * @author rakesh.kulkarni
 * Date 09/09/2016
 */
public class ProviderSubmissionGridRow implements Comparable<ProviderSubmissionGridRow> {
	private String 	ProviderName;
	private String 	ReportingOption;
	private String 	DRCFStatus;
	private String 	SubmissionStatus;
	/**
	 * parameterized constructor with parameter  
	 * @param practiceID
	 * @param Name
	 */
	ProviderSubmissionGridRow(String ProviderName, String ReportingOption, String DRCFStatus, String SubmissionStatus)
	{
		this.ProviderName = ProviderName;
		this.ReportingOption = ReportingOption;
		this.DRCFStatus = DRCFStatus;
		this.SubmissionStatus = SubmissionStatus;
	}
	@Override
	public int compareTo(ProviderSubmissionGridRow target) {

	  return(this.ProviderName.compareTo(target.ProviderName))
					+(this.ReportingOption.compareTo(target.ReportingOption))
						+(this.DRCFStatus.compareTo(target.DRCFStatus))
							+(this.SubmissionStatus.compareTo(target.SubmissionStatus));				
	}
    /**
     * Method to return ProviderName of Associated User
     * @return name
     */
	public String getProviderName() {
		return ProviderName;
	}
    /**
     * Method to return ReportingOption of Associated Provider
     * @return firstName
     */
	public String getReportingOption() {
		return ReportingOption;
	}
    /**
     * Method to return DRCFStatus of Associated Provider
     * @return lastName
     */
	public String getDRCFStatus() {
		return DRCFStatus;
	}
    /**
     * Method to return SubmissionStatus of Associated Provider
     * @return practiceID
     */
	public String getSubmissionStatus() {
		return SubmissionStatus;
	}
}

