package buisness.util.datastructures.administration.practice;
/**
 * This class is used to compare current row with Target row
 * @author rakesh.kulkarni
 * Date 13/1/2015
 */
public class PracticeRow implements Comparable<PracticeRow> {

	private String	practiceID;
	private String 	practiceName;
	private String 	npi;
	private String 	inactive;
	/**
	 * parameterized constructor with parameter  
	 * @param practiceID
	 * @param practiceName
	 * @param NPI
	 * @param Inactive
	 */
	PracticeRow(String practiceID, String practiceName, String NPI, String Inactive)
	{
		this.practiceID = practiceID;
		this.practiceName = practiceName; 
		this.npi = NPI;      
		this.inactive = Inactive;
		/*
		 * 
		 */
	}
	/**
	 * Getter method to 
	 * @return PracticeID
	 */
	public String getPracticeID() {
		return practiceID;
	}
	/**
	 * Getter method to 
	 * @return PracticeName
	 */
	public String getPracticeName() {
		return practiceName;
	}

	public String getNPI() {
		return npi;
	}

	public String getInactive() {
		return inactive;
	}
	@Override
	public int compareTo(PracticeRow target) {
		
		return(this.practiceID.compareTo(target.practiceID)	
				+this.practiceName.compareTo(target.practiceName)
				+this.npi.compareTo(target.npi)
				+this.inactive.compareTo(target.inactive));
	}	
}

