/**
 * 
 */
package com.dq.arq.sme.domain;

/**
 * @author prabhakar
 *
 */
public class KeywordsPerformanceReportDo {
	public enum Status{
		enabled, paused
	}
	private Long keywordApiId;
	private String keywordText;
	private String adgroupName;
	private String campaignName;
	private Long impressions;
	private Long clicks;
	private Double cost; 
	private String cpcBid;
	private String firstPageCpc;
	private String firstPositionCpc;
	private Status Status;
	
	public Long getKeywordApiId() {
		return keywordApiId;
	}
	public void setKeywordApiId(Long keywordApiId) {
		this.keywordApiId = keywordApiId;
	}
	public String getKeywordText() {
		return keywordText;
	}
	public void setKeywordText(String keywordText) {
		this.keywordText = keywordText;
	}
	public String getAdgroupName() {
		return adgroupName;
	}
	public void setAdgroupName(String adgroupName) {
		this.adgroupName = adgroupName;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public Long getImpressions() {
		return impressions;
	}
	public void setImpressions(Long impressions) {
		this.impressions = impressions;
	}
	public Long getClicks() {
		return clicks;
	}
	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getCpcBid() {
		return cpcBid;
	}
	public void setCpcBid(String cpcBid) {
		this.cpcBid = cpcBid;
	}
	public String getFirstPageCpc() {
		return firstPageCpc;
	}
	public void setFirstPageCpc(String firstPageCpc) {
		this.firstPageCpc = firstPageCpc;
	}
	public String getFirstPositionCpc() {
		return firstPositionCpc;
	}
	public void setFirstPositionCpc(String firstPositionCpc) {
		this.firstPositionCpc = firstPositionCpc;
	}
	public String getStatus() {
		return Status.name();
	}
	@SuppressWarnings("static-access")
	public void setStatus(String status) {
		Status = Status.valueOf(status);
	}
	
}