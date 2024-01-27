package com.algo.mvc.company.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyComment {
	private int industryID;
	
	private String industryName;
	
	private int coRowNum;
	
	private int reviewNo;
	
	private Date postDate;
	
	private double baseRate;
	
	private double detailRate1;
	
	private double detailRate2;
	
	private double detailRate3;
	
	private double detailRate4;
	
	private String postComment;
	
	private String userID;
	
	private int like;

}
