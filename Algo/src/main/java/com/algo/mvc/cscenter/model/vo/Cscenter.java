package com.algo.mvc.cscenter.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cscenter {
	
	private int csNo;
	
	private String csTitle;
	
	private String csContent;

	private Data csCreateDate;
	
}
