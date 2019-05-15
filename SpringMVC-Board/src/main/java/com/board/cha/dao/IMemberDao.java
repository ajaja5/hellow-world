package com.board.cha.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.board.cha.bean.Member;
@Component
public interface IMemberDao {

	public Member getMemberInfo(Member mb);
	
	public boolean MemberInsert(Member mb);
	
	public String getSecurityPwd(String m_id);
	
	public Member getMemberInfo(String m_id);
}
