package com.board.cha.bean;

import java.security.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("board")
@Data
public class Board {
	private int b_num;
	private String b_title;
	private String b_contents;
	private String b_mid;
	private String b_date; //시,분,초까지 출력
	private int b_views;
	private String m_name;
	
}
