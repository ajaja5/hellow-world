package com.board.cha.bean;

import java.security.Timestamp;

import org.apache.ibatis.type.Alias;
/*B_NUM NUMBER NOT NULL, --PK
B_CONTENTS NCLOB NOT NULL, --글내용의 문자를 무한대로 주고 싶을 때
B_MID NVARCHAR2(20) NOT NULL, --FK, 부모(M)테이블 M_ID참조
B_DATE DATE DEFAULT SYSDATE,
B_VIEWS NUMBER DEFAULT 0 NOT NULL*/

import lombok.Data;

@Alias("reply")
@Data
public class Reply {
	private int r_num;//댓글 번호
	private int r_bnum;//원글 번호
	private String r_contents;//댓글 내용
	private String r_mid;//작성자
	private String r_date;//댓글 작성일
}
