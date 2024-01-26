package com.algo.mvc.mypage.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage {
	private int myPageNo;

	private int rowNum;
	
	private String myPageTitle;
	
	private String myPageCategory;
	
	private String myPageCategoryTitle;
	
	private Date myPageDate;
	
	private int myPageView;
	
	private String myPageCheck;
	
	private String adminYN;
	
	private String userId;
}
