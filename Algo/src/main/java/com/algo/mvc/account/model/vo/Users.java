package com.algo.mvc.account.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private String agrMarketing;
	private String agrSms     ;
	private String agrEmail     ;
	private String agrLocation     ;
	private String userName    ;
	private Date userBirthday;
	private String userId      ;
	private String userPw      ;
	private String userNick    ;
	private String userPhone   ;
	private String userEmail   ;
	private String userDormant ;
	private String sido        ;
	private String sigungu     ;
	
	
	private Date userDate    ;
	private String userPhoto   ;
	private String adminYn     ;
	
	
	
}
