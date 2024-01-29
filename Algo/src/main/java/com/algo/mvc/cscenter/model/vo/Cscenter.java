package com.algo.mvc.cscenter.model.vo;

import lombok.Data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cscenter {
	
	private int csNo;
	
	private int rowNum;
	
	private int csView;
	
	private String csWriterId;
	
	private String csCategory;
	
	private String csTitle;
	
	private String csContent;

	private Date csCreateDate;
	
	private String userId;

}
