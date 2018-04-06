package buisness.util.datastructures.dashboard.practice;
/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of Submission Details >> Dashboards >> Practice
 *   >>PQRS Submission Details
 * @author rakesh.kulkarni
 * Date 16/03/2016
 */
public class SubmissionDetailsGridRow implements Comparable<SubmissionDetailsGridRow> {
	private String 	ProviderName;
	private String 	Npi;
	private String 	Tin;
	private String 	DrcfStatus;
	/**
	 * parameterized constructor with parameter  
	 * @param ProviderName : Provider name
	 * @param Npi : Provider Npi
	 * @param Tin : Provider Tin
	 * @param DrcfStatus : Status of DRCF for Submission
	 */
	SubmissionDetailsGridRow(String ProviderName, String Npi, String Tin, String DrcfStatus)
	{
		this.ProviderName = ProviderName;
		this.Npi = Npi;
		this.Tin = Tin;
		this.DrcfStatus = DrcfStatus;
	}
	@Override
	public int compareTo(SubmissionDetailsGridRow target) {

	  return(this.ProviderName.compareTo(target.ProviderName))
					+(this.Npi.compareTo(target.Npi))
						+(this.Tin.compareTo(target.Tin))
							+(this.DrcfStatus.compareTo(target.DrcfStatus));
	}
    /**
     * Method to return ProviderName
     * @return name
     */
	public String getProviderName() {
		return ProviderName;
	}
    /**
     * Method to return Npi of Associated Provider
     * @return Npi
     */
	public String getNpi() {
		return Npi;
	}
    /**
     * Method to return Tin of Associated Provider
     * @return lastName
     */
	public String getTin() {
		return Tin;
	}
    /**
     * Method to return DrcfStatus of Associated Provider
     * @return practiceID
     */
	public String getDrcfStatus() {
		return DrcfStatus;
	}
}

