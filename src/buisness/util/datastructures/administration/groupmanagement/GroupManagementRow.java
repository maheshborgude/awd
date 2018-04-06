package buisness.util.datastructures.administration.groupmanagement;
/**
 * This class is used to compare current row with Target row
 * @author rakesh.kulkarni
 * Date 29/1/2015
 */
public class GroupManagementRow implements Comparable<GroupManagementRow> {

	private String 	ExternalID;
	private String 	name;
	/**
	 * parameterized constructor with parameter  
	 * @param practiceID
	 * @param Name
	 */
	GroupManagementRow(String ExternalID, String name)
	{
		this.ExternalID = ExternalID;
		this.name = name;
	}
	/**
	 * Getter method to 
	 * @return PracticeID
	 */
	public String getExternalID() {
		return ExternalID;
	}
	/**
	 * Getter method to 
	 * @return GroupName
	 */
	public String getname() {
		return name;
	}

	public String getNPI() {
		return name;
	}

	@Override
	public int compareTo(GroupManagementRow target) {

		return(this.name.compareTo(target.name))
				+(this.name.compareTo(target.name));				
	}	
}

