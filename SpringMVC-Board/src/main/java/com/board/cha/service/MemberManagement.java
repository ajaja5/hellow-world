package com.board.cha.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.board.cha.bean.Member;
import com.board.cha.dao.IMemberDao;

@Component
public class MemberManagement {
	@Autowired
	private IMemberDao mDao;
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;

	/*public ModelAndView getMember(String id) {
		ModelAndView mav=new ModelAndView();
		Member mb=mDao.getMember(id);
		mav.addObject("mb",mb);
		mav.setViewName("home");
		return mav;
	}*/

	public ModelAndView memberAccess(Member mb) {
		mav=new ModelAndView();
		String view=null;
		
		BCryptPasswordEncoder pwdEncoder=new BCryptPasswordEncoder();
		//해당 아이디의 암호화된 비번을 가져옴
		String pwdEncode=mDao.getSecurityPwd(mb.getM_id());
		if(pwdEncoder!=null) {//암호화된 비번이 존재한다면
			if(pwdEncoder.matches(mb.getM_pwd(),pwdEncode)) {
				session.setAttribute("id",mb.getM_id());
				//로그인 후 회원정보 화면에 출력
				mb=mDao.getMemberInfo(mb.getM_id());
				session.setAttribute("mb",mb);
				//view="forward:/boardList";
				//forward:url,post-post,get-get만 가능
				view="redirect:/boardList";
				//redirect:url,post-get----->get 방식만 가능
			}else {//비번 오류
				view="home";
				mav.addObject("check",2);
			}
				
		}else {//아이디 오류 
			view="home";
			mav.addObject("check",2);
		}
		mav.setViewName(view);
		return mav;
		//스프링에선 비번은 암호화는 가능하지만 복호화가 불가능
		/*Member mb2=mDao.getMemberInfo(mb);
		if(mb2!=null) {
			session.setAttribute("id",mb2.getM_id());
			mav.addObject("mb",mb2);
			view="boardList";//jsp
			}else {
				view="home";
				mav.addObject("msg","로그인 실패");
			}
		mav.setViewName(view);
		return mav;*/
	}

	public ModelAndView memberInsert(Member mb) {
		mav=new ModelAndView();
		String view=null;
		//비번을 암호화(Encoding) 할 수 있지만 복호화(Decoding)는 불가능
		BCryptPasswordEncoder pwdEncoder=new BCryptPasswordEncoder();
		mb.setM_pwd(pwdEncoder.encode(mb.getM_pwd()));
		if(mDao.MemberInsert(mb)) {
			mav.addObject("check",1);//회원가입 성공
		}else {
			view="joinFrm";
		}
		mav.setViewName(view);
		return mav;
	}
}
