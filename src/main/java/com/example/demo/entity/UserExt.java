package com.example.demo.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "upt_user_ext")
@Getter
@NoArgsConstructor
public class UserExt {
	
	@Id
	@Column(name = "id")
	private String id; //아이디
	
	@Column(name = "join_date")
	private ZonedDateTime joinDate; // 가입일
	
	@Column(name = "quit_date")
	private ZonedDateTime quitDate; // 탈퇴일
	
	@Column(name = "receive_marketing_info")
	private Long receiveMarketingInfo; // 마케팅 수신동의
	
	@Column(name = "org_bizno")
	private String orgBizno; // 사업자번호
	
	@Column(name = "org_name")
	private String orgName; // 사업자명
	
	
	
	

	

}
