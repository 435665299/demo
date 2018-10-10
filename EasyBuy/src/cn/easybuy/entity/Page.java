package cn.easybuy.entity;

import java.util.List;

public class Page {
	// 当前页数
	private int currPageNo = 1;
	// 页大小
	private int pageSize = 12;
	// 总条数
	private int totalCount;
	// 总页数
	private int totalPageCount;
	// 数据
	private List<Product> pList;
	private String url;

	public Page(int pageSize, int currPageNo, int totalCount) {
		this.pageSize = pageSize;
		this.currPageNo = currPageNo;
		setTotalCount(totalCount);
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if (totalCount > 0) {
			this.totalPageCount = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize
					: (this.totalCount / this.pageSize) + 1;
		} else {
			this.totalPageCount = 0;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public List<Product> getpList() {
		return pList;
	}

	public void setpList(List<Product> pList) {
		this.pList = pList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
