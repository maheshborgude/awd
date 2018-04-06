package buisness.util.datastructures.rpc.resetpracticekey;
/**
 * This class is used to compare current row with Target row<p>
 * This class compare Data row of Advanced Status popup row<p>
 * @author rakesh.kulkarni
 * Updated by Sachin Gawade
 * Date 11/3/2016
 */
public class ResetPracticeKeyGridRow implements Comparable<ResetPracticeKeyGridRow> {
	private String 	practiceID; // practiceID of practice
	private String 	practiceName; // practiceName of practice
	private String 	registrationKeyInUse; // RegistrationKeyInUse of practice
	private String 	lastAccessTime; // lastAccessTime of practice
	/**
	 * parameterized constructor with parameter  of AdvancedStatusPopupGridRow class constructor 
	 * @param practiceID: practiceID of practice
	 * @param practiceName: practiceName of practice
	 * @param registrationKeyInUse: registrationKeyInUse of practice
	 * @param lastAccessTime: lastAccessTime of practice
	 * This method will compare source with target that is Data present on UI with data present in Database
	 */
	ResetPracticeKeyGridRow(String practiceID, String practiceName, String registrationKeyInUse, String lastAccessTime)
	{
		this.practiceID = practiceID;
		this.practiceName = practiceName;
		this.registrationKeyInUse = registrationKeyInUse;
		this.lastAccessTime = lastAccessTime;
	}
	@Override
	/**
	 * This method is used to compare two rows<p>
	 * Returns 0 if both rows are same<p>
	 * Returns -1 if both rows are not same
	 */
	public int compareTo(ResetPracticeKeyGridRow target) {

	    return(this.practiceID.compareTo(target.practiceID))
				+(this.practiceName.compareTo(target.practiceName))
					+(this.registrationKeyInUse.compareTo(target.registrationKeyInUse))
						+(this.lastAccessTime.compareTo(target.lastAccessTime));				
	}

	/**
	 * Method to return practiceID of ResetPracticeKey
	 * @return practiceID
	 */
	public String getpracticeID() {
		return practiceID;
	}
	/**
	 * Method to return practiceName of ResetPracticeKey
	 * @return practiceName
	 */
	public String getpracticeName() {
		return practiceName;
	}
	/**
	 * Method to return registrationKeyInUse of ResetPracticeKey
	 * @return registrationKeyInUse
	 */
	public String getregistrationKeyInUse() {
		return registrationKeyInUse;
	}
	/**
	 * Method to return lastAccessTime of ResetPracticeKey
	 * @return lastAccessTime
	 */
	public String getlastAccessTime() {
		return lastAccessTime;
	}
}

