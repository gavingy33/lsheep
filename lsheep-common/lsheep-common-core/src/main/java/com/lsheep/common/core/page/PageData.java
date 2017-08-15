package com.lsheep.common.core.page;

import java.util.List;

import com.github.pagehelper.Page;

public class PageData<T> {

	private Integer pageSize;
	private Integer pageNumber;
	private Long total;
	private String searchText = "";
	private String sortName = "";
	private String sortOrder = "";
	private List<T> rows;

	public PageData() {
	}

	public PageData(Page<?> page, PageQuery pageQuery) {
		this.pageSize = page.getPageSize();
		this.pageNumber = page.getPageNum();
		this.total = page.getTotal();
		this.sortOrder = pageQuery.getSortOrder();
		this.sortName = pageQuery.getSortName();
		this.searchText = pageQuery.getSearchText();
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
