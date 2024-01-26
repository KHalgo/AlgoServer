package com.algo.mvc.mypage.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inquiry {
	 private int inquiryNo;
	 
	 private int rowNum;
	 
	 private String inquiryTitle;
	 
	 private String inquiryContent;
	 
	 private int inquiryAnswerNo;
	 
	 private String inquiryAnswerContent;
	 
	 private String userId;
	 
	 private Date crateDate;
}
