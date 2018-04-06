package buisness.util.datastructures.pqrsSubmission;
/**
 * This class is used to compare current row with Target row
 * Data of UI compare with data present in database row by row
 * This class compare Data row of PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone 
 *     >>PQRS Advanced Status row 
 * @author rakesh.kulkarni
 * Date 10/02/2016
 */
public class PqrsAdvancedStatusGridRow implements Comparable<PqrsAdvancedStatusGridRow> {
	private String 	measure; // ID of measure 
	private String 	eligible; // Count of eligible patient with respect to measure
	private String 	met; // Count of met patient with respect to measure
	private String 	notMet; // Count of notMet patient with respect to measure
	private String 	notApplicable; // Count of notApplicable patient with respect to measure
	private String 	exclusion; // Count of exclusion patient with respect to measure
	/**
	 * parameterized constructor with parameter  of PqrsAdvancedStatusRow class constructor 
	 * will call by add() method of Grid 
	 * @param measure
	 * @param eligible
	 * @param met
	 * @param notMet
	 * @param notApplicable
	 * @param exclusion
	 * 
	 */
	PqrsAdvancedStatusGridRow(String measure, String eligible, String met, String notMet, String notApplicable, String exclusion)
	{
		this.measure = measure;
		this.eligible = eligible;
		this.met = met;
		this.notMet = notMet;
		this.notApplicable = notApplicable;
		this.exclusion = exclusion;
	}
	@Override
	public int compareTo(PqrsAdvancedStatusGridRow target) {

		return(this.measure.compareTo(target.measure))
				+(this.eligible.compareTo(target.eligible))
				+(this.met.compareTo(target.met))
				+(this.notMet.compareTo(target.notMet))
				+(this.notApplicable.compareTo(target.notApplicable))
				+(this.exclusion.compareTo(target.exclusion));				
	}

	/**
	 * Method to return measure of PQRS Advanced Status
	 * @return measure
	 */
	public String getMeasure() {
		return measure;
	}
	/**
	 * Method to return eligible of PQRS Advanced Status
	 * @return lastName
	 */
	public String getEligible() {
		return eligible;
	}
	/**
	 * Method to return met of PQRS Advanced Status
	 * @return met
	 */
	public String getMet() {
		return met;
	}
	/**
	 * Method to return notMet of PQRS Advanced Status
	 * @return notMet
	 */
	public String getNotMet() {
		return notMet;
	}
	/**
	 * Method to return notApplicable of PQRS Advanced Status
	 * @return notApplicable
	 */
	public String getNotApplicable() {
		return notApplicable;
	}
	/**
	 * Method to return exclusion of PQRS Advanced Status
	 * @return exclusion
	 */
	public String getExclusion() {
		return exclusion;
	}	
}

