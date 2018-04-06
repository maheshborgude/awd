package buisness.util.datastructures.pqrsSubmission;
/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone
 *   >>Select Provider tab
 * @author rakesh.kulkarni
 * Date 05/02/2016
 */
public class SelectProviderGridRow implements Comparable<SelectProviderGridRow> {
	private String 	name;
	private String 	emil;
	private String 	npi;
	private String 	reportingType;
	/**
	 * parameterized constructor with parameter  
	 * @param practiceID
	 * @param Name
	 */
	SelectProviderGridRow(String name, String emil, String npi, String reportingType)
	{
		this.name = name;
		this.emil = emil;
		this.npi = npi;
		this.reportingType = reportingType;
	}
	@Override
	public int compareTo(SelectProviderGridRow target) {

	  return(this.name.compareTo(target.name))
					+(this.emil.compareTo(target.emil))
						+(this.npi.compareTo(target.npi))
							+(this.reportingType.compareTo(target.reportingType));				
	}
    /**
     * Method to return name of Associated User
     * @return name
     */
	public String getName() {
		return name;
	}
    /**
     * Method to return emil of Associated Provider
     * @return firstName
     */
	public String getemil() {
		return emil;
	}
    /**
     * Method to return npi of Associated Provider
     * @return lastName
     */
	public String getnpi() {
		return npi;
	}
    /**
     * Method to return practiceID of Associated Provider
     * @return practiceID
     */
	public String getreportingType() {
		return reportingType;
	}
}

