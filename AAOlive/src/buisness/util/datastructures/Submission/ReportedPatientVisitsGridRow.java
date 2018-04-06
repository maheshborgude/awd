package buisness.util.datastructures.Submission;
/**
 * This class is used to compare current row with Target row
 *This class compare row of Data grid of Reported Patient Visits grid for individual and GproSubmission
 * @author Sachin.Gawade
 * Date 15/02/2016
 */
public class ReportedPatientVisitsGridRow implements Comparable<ReportedPatientVisitsGridRow> {
	private String 	firstname; // First name of reported patient visit
	private String 	lastname; // Last name of reported patient visit
	private String 	gender; // Gender of reported patient visit
	private String 	dateofbirth; // Date of birth of reported patient visit
	private String 	mrn; // MRN of reported patient visit
	private String 	dateofvisit; // Date of visit of reported patient visit
	private String 	reportedmeasures; // Reported measures of reported patient visit
 
	/**
	 * parameterized ReportedPatientVisitsGridRow constructor
	 * @param firstname: first name of patient
	 * @param lastname: last name of patient
	 * @param gender: gender of patient
	 * @param dateofbirth: date of visit of patient
	 * @param mrn: mrn of patient
	 * @param dateofvisit: date of visit of patient
	 * @param reportedmeasures: reported measures for patient visit
	 */
	public ReportedPatientVisitsGridRow(String firstname, String lastname, String gender, String dateofbirth, String mrn, String dateofvisit, String reportedmeasures)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.mrn = mrn;
		this.dateofvisit = dateofvisit;
		this.reportedmeasures = reportedmeasures;
		
	}
	@Override
	/**
	 * This method is used to compare two rows<p>
	 * Returns 0 if both rows are same<p>
	 * Returns -1 if both rows are not same
	 */
	public int compareTo(ReportedPatientVisitsGridRow target) {

	     return(this.firstname.compareTo(target.firstname))
					+(this.lastname.compareTo(target.lastname))
						+(this.gender.compareTo(target.gender))
							+(this.dateofbirth.compareTo(target.dateofbirth))
								+(this.mrn.compareTo(target.mrn))
									+(this.dateofvisit.compareTo(target.dateofvisit))
										+(this.reportedmeasures.compareTo(target.reportedmeasures));
													
	}

    /**
     * Method to return firstname of Associated Patient
     * @return firstname
     */
	public String getfirstname() {
		return firstname;
	}
    /**
     * Method to return lastname of Associated Patient
     * @return lastname
     */
	public String getlastname() {
		return lastname;
	}
    /**
     * Method to return gender of Associated Patient
     * @return gender
     */
	public String getgender() {
		return gender;
	}
    /**
     * Method to return dateofbirth of Associated Patient
     * @return dateofbirth
     */
	public String getdateofbirth() {
		return dateofbirth;
	}
    /**
     * Method to return mrn of Associated Patient
     * @return mrn
     */
	public String getMrn() {
		return mrn;
	}
    /**
     * Method to return dateofvisit of Associated Patient
     * @return dateofvisit
     */
	public String getdateofvisit() {
		return dateofvisit;
	}
    /**
     * Method to return reportedmeasures of Associated Patient
     * @return reportedmeasures
     */
	public String getreportedmeasures() {
		return reportedmeasures;
	}
   
	
}

