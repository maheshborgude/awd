package buisness.util.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import configuration.Setup;

/**
 * WebElement of Table needs to be passed, also works if web element is of any element in table
 * for which the pagination is available. Should not be parameterized with div or inner element 
 * of pagination as, it finds the following div of the current div in which table is present
 * If the pagination is not present the constructor would throw  NoSuchElementException as it
 * confirms for the anchor tag in the div. It provides with functions to browse 
 * <ul> 
 * <li>Next Page</li>
 * <li>Previous Page</li>
 * <li>First Page</li>
 * <li>Last Page</li>
 * <li>To browse specific page</li>
 * </ul>
 * 
 * @author abhishek.gaikwad
 * @since 28 January 2016
 * @version 1.0 
 */
public class Pagination {

	private WebElement paginationDiv;
	private int numberOfPages;
	private int currentPage;
	
	/**
	 * WebElement of Table needs to be passed, also works if web element is of any element in table
	 * for which the pagination is available. Should not be parameterized with div or inner element 
	 * of pagination as, it finds the following div of the current div in which table is present
	 * If the pagination is not present the constructor would throw  NoSuchElementException as it
	 * confirms for the anchor tag in the div
	 * 
	 * @param webTable Should be any element which has pagination not restricted to any tag
	 * @throws NoSuchElementException Would throw if the pagination is not available
	 * @throws IllegalArgumentException If web element is null 
	 */
	public Pagination(WebElement webTable) throws NoSuchElementException,IllegalArgumentException
	{	
		if(webTable==null)
			throw new IllegalArgumentException();
		String xpath="./ancestor::div/following-sibling::div//a/parent::div";
		this.paginationDiv=exactPagination(webTable,xpath);
		setNumberOfPages();
		currentPage=1;
	}
	/**
	 * WebElement of Table needs to be passed, also works if web element is of any element in table
	 * for which the pagination is available. Should not be parameterized with div or inner element 
	 * of pagination as, it finds the following div of the current div in which table is present
	 * If the pagination is not present the constructor would throw  NoSuchElementException as it
	 * confirms for the anchor tag in the div
	 * 
	 * @param webTable Should be any element which has pagination not restricted to any tag
	 * @throws NoSuchElementException Would throw if the pagination is not available
	 * @throws IllegalArgumentException If web element is null 
	 */
	public Pagination(WebElement webTable,String xpath) throws NoSuchElementException,IllegalArgumentException
	{	
		if(webTable==null)
		throw new IllegalArgumentException();
		this.paginationDiv=exactPagination(webTable,xpath);
		setNumberOfPages();
		currentPage=1;
	}
	
	private WebElement exactPagination(WebElement webTable,String xpath) throws NoSuchElementException
	{
		return webTable.findElement(By.xpath(xpath));
	}
	
	
	/**
	 * Clicks on next page of page, it would check if the displayed it last page the nothing 
	 * would be clicked and would return false
	 * 
	 * @return 	True - if page is click able and has been clicked successfully<br>
	 * 			False - if the current page is last page
	 */
	public boolean browseNextPage()
	{
		if(hasNext())
		{
			paginationDiv.findElement(By.xpath("./a[last()-1]")).click();
			currentPage++;
			return true;
		}
		else
		{
			Setup.log.warn("No next page available, already on next page");
			return false;
		}
	}
	

	/**
	 * Clicks on previous page of page, if the current page is first page then the method would 
	 * return false
	 * 
	 * @return 	True - If the next page is clicked<br>
	 * 			False - If on first page 
	 */
	public boolean browsePreviousPage()
	{
		if(hasPrevious())
		{
			paginationDiv.findElement(By.xpath("./a[2]")).click();
			currentPage--;
			return true;
			
		}
		else
		{
			System.out.println("there is no previous page");
			Setup.log.warn("No previous pages");
			return false;
		}
	}
	
	/**
	 * Clicks on First page, if the current page is first page then the method would 
	 * return false
	 * 
	 * @return 	True - If the First page is clicked<br>
	 * 			False - If is already on first page 
	 */
	public boolean browseFirstPage()
	{
		if(hasPrevious())
		{
			////Updated by awadhesh 11/27/2017
			/*paginationDiv.findElement(By.xpath("./a[1]")).click();
			 * */
			 
			paginationDiv.findElement(By.xpath("./a[1][@class='page']")).click();
			currentPage=1;
			return true;
		}
		else
		{
			Setup.log.warn("Already on First page");
			return false;
		}
	}
	
	/**
	 * Clicks on Last page, if the current page is Last page then the method would 
	 * return false
	 * 
	 * @return 	True - If the Last page is clicked<br>
	 * 			False - If is already on Last page 
	 */
	public boolean browseLastPage()
	{
		if(hasNext())
		{
			/*
			paginationDiv.findElement(By.xpath("./a[last()]")).click();
			 */
			paginationDiv.findElement(By.xpath("./a[last()][@class='page']")).click();
			currentPage=numberOfPages;
			return true;
		}
		else
		{
			Setup.log.debug("Already on last page");
			return false;
		}
	}
	
	/**
	 * Clicks on specified page. Would return false if the current page is specified page 
	 *  Would return false if the specified page is beyond the maximum number of pages
	 * 
	 * Note: If the page is present but not visible, (e.g currently page number 1 to 5 is displayed
	 * and tried to jump to page number 7) then the {@link NoSuchElementException} would be thrown 
	 * 
	 * @return 	True - If the Last page is clicked<br>
	 * 			False - If is already on Last page 
	 */
	public boolean browsePageNumber(int pageNumber)
	{
		if(pageNumber<=numberOfPages && pageNumber!=currentPage)
		{
			String xpathForPage ="./a[@page"+pageNumber+"]";
			paginationDiv.findElement(By.xpath(xpathForPage)).click();
			currentPage = pageNumber;
			return true;
		}
		else
		{
			Setup.log.warn("Page number "+pageNumber+ " is out of range. Maximum number of pages are " + numberOfPages);
			return false;
		}
	}

	private void setNumberOfPages() 
	{
		//find page number of last page, it is present as attribute in 
		String numberOfPagesStr = paginationDiv.findElement(By.xpath("./a[last()]")).getAttribute("page");
		System.err.println(numberOfPagesStr);
		this.numberOfPages = Integer.parseInt(numberOfPagesStr);
	}

	/**
	 * Check if next page is available to click
	 * 
	 * @return 	True - If there are more pages that could be clicked<br>
	 * 			False - If the current page is last page
	 */
	public boolean hasNext() 
	{
		if(currentPage < numberOfPages)
			return true;
		else
			return false;
	}
	
	/**
	 * Check if previous page is available to click
	 * 
	 * @return 	True - If there are more pages that could be clicked<br>
	 * 			False - If the current page is First page
	 */
	public boolean hasPrevious()
	{
		if(1 < currentPage)
			return true;
		else
			return false;
	}

	public int getCurrentPage() {
		return currentPage;
	}

}
