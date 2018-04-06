package buisness.util.helpers;

public interface IGrid<T extends Comparable<T>> extends IVerifier
{
	/**
	 * Gets the grid on UI for locator specified
	 * 
	 * @param elementMethod  
	 * @param locator 
	 * @return
	 */
	T getWebGrid(String elementMethod,String locator);
	
	/**
	 * 
	 * @param sqlQuery
	 * @return
	 */
	T getDatabaseGrid(String sqlQuery);
	
	/**
	 * 
	 * @param WebGrid
	 * @param DatabaseGrid
	 * @return
	 */
	boolean compareGrid(T WebGrid,T DatabaseGrid);
	/**
	 * 
	 * @return
	 */
	String generateQuery();
	/**
	 * 
	 * @param elementMethod
	 * @return
	 */
	boolean isElementMethodEmptyOrNULL(String elementMethod);
	/**
	 * 
	 * @param locator
	 * @return
	 */
	boolean isLocatorEmptyOrNULL(String locator);
	/**
	 * 
	 * @param sqlQuery
	 * @return
	 */
	boolean isQueryEmptyOrNULL(String sqlQuery);

	/**
	 * 
	 * @param str
	 * @return
	 */
	default public boolean isStringEmptyOrNull(String str)
	{
		if(str==null)
			return true;
		return str.isEmpty();
	}
	/**
	 * 
	 * @param elementMethod
	 * @param locator
	 * @return
	 */
	@Override
	default public boolean verify(String elementMethod,String locator)
	{
		T WebGrid = getWebGrid(elementMethod,locator);
		String sqlQuery = generateQuery();
		T DatabaseGrid = getDatabaseGrid(sqlQuery);
		return compareGrid(WebGrid,DatabaseGrid);
	}
	

}
