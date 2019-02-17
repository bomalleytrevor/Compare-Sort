package com.sort.compare;

public class SortMetric {

	private Integer itemCount;
	private long speedInMs;
	private String sortType;
	
	public Integer getItemCount() {
		return itemCount;
	}
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
	public long getSpeedInMs() {
		return speedInMs;
	}
	public void setSpeedInMs(long speedInMs) {
		this.speedInMs = speedInMs;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
}
