package com.board.cha;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.board.cha.bean.Member;
import com.board.cha.service.MemberManagement;

/**
 * Handles requests for the application home page.
 */
@Controller

//모델 객체 mb를 생성하면 request영역에 
//session에 종료되기까지 저장한다.
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MemberManagement mm;
	@Autowired
	HttpSession session;
	ModelAndView mav;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		mav=new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	@RequestMapping(value = "/access", method = RequestMethod.POST)
	public ModelAndView access(@ModelAttribute("mb") Member member){
		mav=new ModelAndView();
		mav.addObject("mb",member);
		mav=mm.memberAccess(member);
		//logger.info("id="+mb.getM_id());
		//logger.info("pw="+mb.getM_pwd());
		return mav;
	}
	@RequestMapping(value = "/joinFrm", method = RequestMethod.GET)
	public ModelAndView joinFrm(){
		mav=new ModelAndView();
		mav.setViewName("joinFrm");//joinFrm.jsp
		return mav;
	}
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public ModelAndView memberInsert(Member mb){
	
		System.out.println("id="+mb.getM_id());
		mav=mm.memberInsert(mb);
		return mav;
	}
	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public String logout(){
	session.invalidate();
		return "home";
	}
}
