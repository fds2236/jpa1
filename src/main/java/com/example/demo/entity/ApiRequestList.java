package com.example.demo.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "api_request_list")
public class ApiRequestList {

    @Id
    @Column(name = "org_id")
    private Long orgId;
    
    @Column(name = "api_id")
    private Long apiId;

    @Column(name = "api_name")
    private String apiName;

    @CreationTimestamp
    @Column(name = "request_time")
    private Timestamp requestTime;
    
    @Column(name = "call_count")
    @ColumnDefault("0")
    private Long callCount;

    @Column(name = "item_count")
    @ColumnDefault("0")
    private Long itemCount;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getApiId() {
		return apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Timestamp getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	public Long getCallCount() {
		return callCount;
	}

	public void setCallCount(Long callCount) {
		this.callCount = callCount;
	}

	public Long getItemCount() {
		return itemCount;
	}

	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "ApiRequestList [orgId=" + orgId + ", apiId=" + apiId + ", apiName=" + apiName + ", requestTime="
				+ requestTime + ", callCount=" + callCount + ", itemCount=" + itemCount + "]";
	}

  
    

}