package bean;

import java.util.ArrayList;
import java.util.List;

public class PageModel {

	public static final int DISABLE_PAGE = 0;
	public static final int NUMBER_OF_MAX_PAGE = 5;
	
	private int currentPage;
	private int totalPage;
	private int nextPage;
	private int prevPage;
	private int firstPage = 1;
	private int lastPage;
	private List<Integer> pageNumberList;
	
	/**
	 * 
	 * 
	 * @param currentPage
	 * @param totalPage
	 */
	public PageModel(int currentPage, int totalPage) {
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		
		// Nếu là trang đầu tiên ẩn 2 previous  và firstPage
		if(currentPage == this.firstPage) {
			this.prevPage = DISABLE_PAGE;
			this.firstPage = DISABLE_PAGE;
		} else {
			this.prevPage = currentPage - 1;
		}
		// Nếu trang cuối cùng thì ẩn 2 nút next và lastPage
		if(currentPage == totalPage) {
			this.nextPage = DISABLE_PAGE;
			this.lastPage = DISABLE_PAGE;
		} else {
			this.nextPage = currentPage + 1;
			this.lastPage = totalPage;
		}
		
		this.pageNumberList = getPageNumberList(currentPage, totalPage, NUMBER_OF_MAX_PAGE);
	}
	private List<Integer> getPageNumberList(int currentPage, int totalPage, int numberOfMaxPage) {
		List<Integer> pageNumberList = new ArrayList<Integer>();
		
		int pageMin, pageMax;
		pageMin = currentPage - (numberOfMaxPage - 1) /2;
		pageMax = currentPage + (numberOfMaxPage - 1) /2;
		
		if(pageMin <= 0) {
			pageMin = 1;
			pageMax = numberOfMaxPage;
		}
		
		if(pageMax > totalPage) {
			pageMax = totalPage;
			pageMin = totalPage - numberOfMaxPage + 1;
		}
		
		for(int i = pageMin; i <= pageMax; i++) {
			if(i > 0) {
				pageNumberList.add(i);
			}
		}
		return pageNumberList;
	}
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the nextPage
	 */
	public int getNextPage() {
		return nextPage;
	}
	/**
	 * @param nextPage the nextPage to set
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	/**
	 * @return the prevPage
	 */
	public int getPrevPage() {
		return prevPage;
	}
	/**
	 * @param prevPage the prevPage to set
	 */
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	/**
	 * @return the firstPage
	 */
	public int getFirstPage() {
		return firstPage;
	}
	/**
	 * @param firstPage the firstPage to set
	 */
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	/**
	 * @return the lastPage
	 */
	public int getLastPage() {
		return lastPage;
	}
	/**
	 * @param lastPage the lastPage to set
	 */
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	/**
	 * @return the pageNumberList
	 */
	public List<Integer> getPageNumberList() {
		return pageNumberList;
	}
	/**
	 * @param pageNumberList the pageNumberList to set
	 */
	public void setPageNumberList(List<Integer> pageNumberList) {
		this.pageNumberList = pageNumberList;
	}
	
	
}
