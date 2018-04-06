package buisness.util.datastructures.Submission.pqrssubmission;
/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Tax Identification Number tab
 * @author rakesh.kulkarni
 * Date 10/02/2016
 */
public class TaxIdentificationNumberGridRow implements Comparable<TaxIdentificationNumberGridRow> {
	private String 	npi; // NPI of the aloocated TIN
	private String 	startDate; // Start date of  Tax Identification Number
	private String 	endDate; //End date of Tax Identification Number
	/**
	 * parameterized constructor with parameter  
	 * @param npi
	 * @param startDate
	 * @param endDate
	 */
	TaxIdentificationNumberGridRow(String npi, String startDate, String endDate)
	{
		this.npi = npi;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	@Override
	public int compareTo(TaxIdentificationNumberGridRow target) {

	  return(this.npi.compareTo(target.npi))
					+(this.startDate.compareTo(target.startDate))
						+(this.endDate.compareTo(target.endDate));				
	}
    /**
     * Method to return name of Associated User
     * @return name
     */
	public String getnpi() {
		return npi;
	}
    /**
     * Method to return emil of Associated Provider
     * @return firstName
     */
	public String getstartDate() {
		return startDate;
	}
    /**
     * Method to return npi of Associated Provider
     * @return lastName
     */
	public String getendDate() {
		return endDate;
	}
}

