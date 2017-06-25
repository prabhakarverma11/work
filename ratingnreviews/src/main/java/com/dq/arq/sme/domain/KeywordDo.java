package com.dq.arq.sme.domain;
// default package
// Generated Nov 21, 2016 1:22:59 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Keyword generated by hbm2java
 */
@Entity
@Table(name = "keyword", catalog = "arq_sme")
public class KeywordDo implements java.io.Serializable,Comparable<Object> {

	private static final long serialVersionUID = 1L;

	public enum Status{
		Enabled,Paused,Removed,Unknown
	}
	public enum MatchType{
		PHRASE,BROAD,EXACT
	}
	private Integer id;
	private AdgroupDo adgroupDo;
	private Long apiId;
	private String text;
	private Status status; 	//1=ENABLED,2=PAUSED,3=REMOVED
	private Double bid;
	private Long avgMonthlySearch;
	private Double competition;
	private Double avgCpc;
	private MatchType matchType;
	private Long adgroupApiId;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public KeywordDo() {
	}

	public KeywordDo(AdgroupDo adgroupDo, String createdBy, Date createdOn) {
		this.adgroupDo = adgroupDo;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public KeywordDo(AdgroupDo adgroupDo, Long apiId, String text,
			String status, Double bid,
			Long avgMonthlySearch, Double competition, Double avgCpc,
			MatchType matchType, Long adgroupApiId, String createdBy,
			Date createdOn, String updatedBy, Date updatedOn) {
		this.adgroupDo = adgroupDo;
		this.apiId = apiId;
		this.text = text;
		this.status = Status.valueOf(status);
		this.bid = bid;
		this.avgMonthlySearch = avgMonthlySearch;
		this.competition = competition;
		this.avgCpc = avgCpc;
		this.matchType = matchType;
		this.adgroupApiId = adgroupApiId;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adgroup_id", nullable = false)
	public AdgroupDo getAdgroupDo() {
		return this.adgroupDo;
	}

	public void setAdgroupDo(AdgroupDo adgroupDo) {
		this.adgroupDo = adgroupDo;
	}

	@Column(name = "api_id")
	public Long getApiId() {
		return this.apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}

	@Column(name = "text", length = 200)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status.name();
	}

	public void setStatus(String status) {
		this.status = Status.valueOf(status);
	}

	@Column(name = "bid", precision = 22, scale = 0)
	public Double getBid() {
		return this.bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	@Column(name = "avg_monthly_search")
	public Long getAvgMonthlySearch() {
		return this.avgMonthlySearch;
	}

	public void setAvgMonthlySearch(Long avgMonthlySearch) {
		this.avgMonthlySearch = avgMonthlySearch;
	}

	@Column(name = "competition", precision = 22, scale = 0)
	public Double getCompetition() {
		return this.competition;
	}

	public void setCompetition(Double competition) {
		this.competition = competition;
	}

	@Column(name = "avg_CPC", precision = 22, scale = 0)
	public Double getAvgCpc() {
		return this.avgCpc;
	}

	public void setAvgCpc(Double avgCpc) {
		this.avgCpc = avgCpc;
	}

	@Column(name = "match_type", length = 20)
	public String getMatchType() {
		return this.matchType.name();
	}

	public void setMatchType(String matchType) {
		this.matchType = MatchType.valueOf(matchType);
	}

	@Column(name = "adgroup_api_id")
	public Long getAdgroupApiId() {
		return this.adgroupApiId;
	}

	public void setAdgroupApiId(Long adgroupApiId) {
		this.adgroupApiId = adgroupApiId;
	}

	@Column(name = "created_by", nullable = false, length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 0)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "updated_by", length = 50)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", length = 0)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int compareTo(Object o) {
		KeywordDo keywordDo = (KeywordDo) o;
		//Sorting in descending order of avgMonthlySearch and increasing order of avgCpc
		if((avgMonthlySearch-keywordDo.avgMonthlySearch)<0)
		{
			return 1;
		}
		else if((avgMonthlySearch-keywordDo.avgMonthlySearch)>0)
		{
			return -1;
		}
		else if((avgCpc - keywordDo.avgCpc) >0)
			 return 1;
		else
			return -1;
			
	}

}
