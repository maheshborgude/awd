package buisness.util.datastructures.Submission;
/**
 * This class is used to compare current row with Target row<p>
 * This class compare Data row of Advanced Status popup row<p>
 * @author rakesh.kulkarni
 * Updated by Sachin Gawade
 * Date 11/02/2016
 */
public class AdvancedStatusPopupGridRow implements Comparable<AdvancedStatusPopupGridRow> {
	private String 	name; // name of measure  
	private String 	mrn; // MRN of patient
	private String 	gender; // Gender of patient 
	private String 	dateOfVisit; // date Of Visit of patient of treatment 
	private String 	dateofBirth; // date of Birth of patient 
	/**
	 * parameterized constructor with parameter  of AdvancedStatusPopupGridRow class constructor 
	 * @param name: name of patient
	 * @param mrn: mrn of patient
	 * @param gender: gender of patient
	 * @param dateOfVisit: date of visit of patient
	 * @param dateofBirth: date of birth of patient
	 * This method will compare source with target that is Data present on UI with data present in Database
	 */
	AdvancedStatusPopupGridRow(String name, String mrn, String gender, String dateOfVisit, String dateofBirth)
	{
		this.name = name;
		this.mrn = mrn;
		this.gender = gender;
		this.dateOfVisit = dateOfVisit;
		this.dateofBirth = dateofBirth;
	}
	@Override
	/**
	 * This method is used to compare two rows<p>
	 * Returns 0 if both rows are same<p>
	 * Returns -1 if both rows are not same
	 */
	public int compareTo(AdvancedStatusPopupGridRow target) {

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
	 * Method to return dateOfVisit of PQRS Advanced Status popup
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

