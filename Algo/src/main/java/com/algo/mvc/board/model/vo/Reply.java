package com.algo.mvc.board.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	private int commentNo;

	private int postNo;

	private int writerNo;

	private String writerId;

	private String commentContent;	

	private Date commentDate;
	
	private int commentLikeCount;
	
	private String userNick;

}
