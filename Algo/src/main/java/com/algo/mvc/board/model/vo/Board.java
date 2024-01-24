package com.algo.mvc.board.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int postNo;
		
	private int rowNum;
	
	private int writerNo;
	
	private String writerId;
	
	private String smallCategoryId;
	
	private String bigCategoryId;
	
	private String postTitle;
	
	private String postContent;
	
	private Date postDate;
	
	private int postViewCount;
	
	private String postLocation;
	
	private int postLikeCount;
	
	private String postFile1;
	
	private String postFile2;
	
	private String postFile3;
	
	private String postFile4;
	
	private String userNick;
	
}
