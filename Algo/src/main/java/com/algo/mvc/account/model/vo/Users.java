package com.algo.mvc.account.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private String userId      ;
	private String userName    ;
	private String userPw      ;
	private String userPhone   ;
	private String userEmail   ;
	private Date userBirthday;
	private String userAddress ;
	private String userDormant ;
	private Date userDate    ;
	private String userPhoto   ;
	private String userNick    ;
	private String adminYn     ;
	private String sido        ;
	private String sigungu     ;
}
