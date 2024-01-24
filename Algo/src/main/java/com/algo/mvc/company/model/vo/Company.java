package com.algo.mvc.company.model.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	private int industryID;
	
	private int inRowNum;
	
	private String industryName;
	
	private String industryLc;
	
	private String industryType;
	
	private String industryHp;
	
	private int readCount;
	
	private Date industryDate;
	
	private double baseRate;
	
	private int count;
	
	private String bestComment;
	
	private double detailRate1;
	
	private double detailRate2;
	
	private double detailRate3;
	
	private double detailRate4;
}
