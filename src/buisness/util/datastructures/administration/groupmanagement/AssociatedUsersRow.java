package buisness.util.datastructures.administration.groupmanagement;
/**
 * This class is used to compare current row with Target row
 * @author rakesh.kulkarni
 * Date 29/1/2015
 */
public class AssociatedUsersRow implements Comparable<AssociatedUsersRow> {
	private String 	name;
	private String 	firstName;
	private String 	lastName;
	private String 	practiceID;
	private String 	PracticeName;
	private String 	inactive;
	/**
	 * parameterized constructor with parameter  
	 * @param practiceID
	 * @param Name
	 */
	AssociatedUsersRow(String name, String firstName, String lastName, String practiceID, String PracticeName, String inactive)
	{
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.practiceID = practiceID;
		this.PracticeName = PracticeName;
		this.inactive = inactive;
	}
	@Override
	public int compareTo(AssociatedUsersRow target) {

	  return(this.name.compareTo(target.name))
				+(this.firstName.compareTo(target.firstName))
					+(this.lastName.compareTo(target.lastName))
						+(this.practiceID.compareTo(target.practiceID))
							+(this.PracticeName.compareTo(target.PracticeName))
								+(this.inactive.compareTo(target.inactive));				
	}
    /**
     * Method to return name of Associated User
     * @return name
     */
	public String getName() {
		return name;
	}
    /**
     * Method to return firstName of Associated User
     * @return firstName
     */
	public String getFirstName() {
		return firstName;
	}
    /**
     * Method to return lastName of Associated User
     * @return lastName
     */
	public String getLastName() {
		return lastName;
	}
    /**
     * Method to return practiceID of Associated User
     * @return practiceID
     */
	public String getPracticeID() {
		return practiceID;
	}
    /**
     * Method to return PracticeName of Associated User
     * @return PracticeName
     */
	public String getPracticeName() {
		return PracticeName;
	}
    /**
     * Method to return inactive of Associated User
     * @return inactive
     */
	public String getInactive() {
		return inactive;
	}	
	
}

