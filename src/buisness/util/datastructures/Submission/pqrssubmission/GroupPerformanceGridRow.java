package buisness.util.datastructures.Submission.pqrssubmission;
/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Tax Identification Number tab
 * @author rakesh.kulkarni
 * Date 04/03/2016
 */
public class GroupPerformanceGridRow implements Comparable<GroupPerformanceGridRow> {
			
	private String 	GroupDenominator; // GroupDenominator of group
	private String 	GroupNumerator; // GroupNumerator of group
	private String 	GroupMedicare; //GroupMedicare of group
	/**
	 * parameterized constructor with parameter  
	 * @param GroupDenominator
	 * @param GroupNumerator
	 * @param GroupMedicare
	 */
	GroupPerformanceGridRow(String GroupDenominator, String GroupNumerator, String GroupMedicare)
	{
		this.GroupDenominator = GroupDenominator;
		this.GroupNumerator = GroupNumerator;
		this.GroupMedicare = GroupMedicare;
	}
	@Override
	public int compareTo(GroupPerformanceGridRow target) {

	  return(this.GroupDenominator.compareTo(target.GroupDenominator))
					+(this.GroupNumerator.compareTo(target.GroupNumerator))
						+(this.GroupMedicare.compareTo(target.GroupMedicare));				
	}
    /**
     * Method to return GroupDenominator
     * @return GroupDenominator
     */
	public String getGroupDenominator() {
		return GroupDenominator;
	}
    /**
     * Method to return GroupNumerator
     * @return GroupNumerator
     */
	public String getGroupNumerator() {
		return GroupNumerator;
	}
    /**
     * Method to return GroupMedicare
     * @return GroupMedicare
     */
	public String getGroupMedicare() {
		return GroupMedicare;
	}
}

