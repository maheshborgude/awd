package buisness.util.datastructures.Submission.pqrssubmission;
/**
 * This class is used to compare current row with Target row
 * Data of UI compare with data present in database row by row
 * This class compare Data row of PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone 
 *    >>PQRS Advanced Status popup row
 * this class will be used for every popup that will open on click of ELIGIBLE, MET, NOT MET, NOT APPLICABLE,EXCLUSION 
 * @author rakesh.kulkarni
 * Date 11/02/2016
 */
public class PqrsAdvancedStatusPopupGridRow implements Comparable<PqrsAdvancedStatusPopupGridRow> {
	private String 	name; // name of measure  
	private String 	mrn; // MRN of patient
	private String 	gender; // Gender of patient 
	private String 	dateOfVisit; // date Of Visit of patient of treatment 
	private String 	dateofBirth; // date of Birth of patient 
	/**
	 * parameterized constructor with parameter  of PqrsAdvancedStatusRow class constructor 
	 * This constructor will call by add() method of Grid
	 * @param name
	 * @param mrngender
	 * @param dateOfSurgery
	 * @param dateofBirth
	 * This method will compare source with target that is Data present on UI with data present in Database
	 */
	PqrsAdvancedStatusPopupGridRow(String name, String mrn, String gender, String dateOfVisit, String dateofBirth)
	{
		this.name = name;
		this.mrn = mrn;
		this.gender = gender;
		this.dateOfVisit = dateOfVisit;
		this.dateofBirth = dateofBirth;
	}
	@Override
	public int compareTo(PqrsAdvancedStatusPopupGridRow target) {

	    return(this.name.compareTo(target.name))
				+(this.mrn.compareTo(target.mrn))
					+(this.gender.compareTo(target.gender))
						+(this.dateOfVisit.compareTo(target.dateOfVisit))
							+(this.dateofBirth.compareTo(target.dateofBirth));				
	}

	/**
	 * Method to return name of PQRS Advanced Status popup
	 * @return measure
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to return eligible of PQRS Advanced Status popup
	 * @return lastName
	 */
	public String getmrn() {
		return mrn;
	}
	/**
	 * Method to return gender of PQRS Advanced Status popup
	 * @return met
	 */
	public String getgender() {
		return gender;
	}
	/**
	 * Method to return dateOfSurgery of PQRS Advanced Status popup
	 * @return notMet
	 */
	public String getdateOfVisit() {
		return dateOfVisit;
	}
	/**
	 * Method to return dateofBirth of PQRS Advanced Status popup
	 * @return notApplicable
	 */
	public String getdateofBirth() {
		return dateofBirth;
	}	
}

