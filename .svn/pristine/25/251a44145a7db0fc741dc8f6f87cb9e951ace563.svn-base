package buisness.util.datastructures.pqrsSubmission;
/**
 * This class is used to compare current row with Target row
 * This class compare Data row of PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone 
 *     >>Reported Patient Visits 
 *This class implements Comparable<ReportedPatientVisitsGridRow>
 *Compare To method of Comparable<T> interface compare source row amd target row
 * @author rakesh.kulkarni
 * Date 08/02/2016
 */
public class ReportedPatientVisitsGridRow implements Comparable<ReportedPatientVisitsGridRow> {
	private String 	firstName; // First name of reported patient visit
	private String 	lastName; // Last name of reported patient visit
	private String 	grnder; // Gender of reported patient visit
	private String 	dateOfBirth; // Date of birth of reported patient visit
	private String 	mrn; // MRN of reported patient visit
	private String 	medicare; // Medicare of reported patient visit
	private String 	dateOfSurgery; // Date if surgery of reported patient visit
	private String 	operativeEye; // Operative eye of reported patient visit
	/**
	 * parameterized constructor with parameter  
	 * @param firstName
	 * @param lastName
	 * @param grnder
	 * @param dateOfBirth
	 * @param mrn
	 * @param medicare
	 * @param dateOfSurgery
	 * @param operativeEye
	 * 
	 */
	ReportedPatientVisitsGridRow(String firstName, String lastName, String grnder, String dateOfBirth, String mrn, String medicare, String dateOfSurgery, String operativeEye)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.grnder = grnder;
		this.dateOfBirth = dateOfBirth;
		this.mrn = mrn;
		this.medicare = medicare;
		this.dateOfSurgery = dateOfSurgery;
		this.operativeEye = operativeEye;
	}
	@Override
	public int compareTo(ReportedPatientVisitsGridRow target) {

	     return(this.firstName.compareTo(target.firstName))
					+(this.lastName.compareTo(target.lastName))
						+(this.grnder.compareTo(target.grnder))
							+(this.dateOfBirth.compareTo(target.dateOfBirth))
								+(this.mrn.compareTo(target.mrn))
									+(this.medicare.compareTo(target.medicare))
										+(this.dateOfSurgery.compareTo(target.dateOfSurgery))
											+(this.operativeEye.compareTo(target.operativeEye));				
	}

    /**
     * Method to return firstName of Associated Patient
     * @return firstName
     */
	public String getFirstName() {
		return firstName;
	}
    /**
     * Method to return lastName of Associated Patient
     * @return lastName
     */
	public String getLastName() {
		return lastName;
	}
    /**
     * Method to return grnder of Associated Patient
     * @return grnder
     */
	public String getGrnder() {
		return grnder;
	}
    /**
     * Method to return dateOfBirth of Associated Patient
     * @return dateOfBirth
     */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
    /**
     * Method to return mrn of Associated Patient
     * @return mrn
     */
	public String getMrn() {
		return mrn;
	}
    /**
     * Method to return medicare of Associated Patient
     * @return medicare
     */
	public String getMedicare() {
		return medicare;
	}
    /**
     * Method to return dateOfSurgery of Associated Patient
     * @return dateOfSurgery
     */
	public String getDateOfSurgery() {
		return dateOfSurgery;
	}
    /**
     * Method to return operativeEye of Associated Patient
     * @return operativeEye
     */
	public String getOperativeEye() {
		return operativeEye;
	}
	
}

