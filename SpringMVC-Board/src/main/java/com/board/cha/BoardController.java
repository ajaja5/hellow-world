package com.board.cha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	private BoardManagement bm; //게시판 서비스 클래스(Model),비지니스 모델
	
	ModelAndView mav;
	@RequestMapping(value = "/boardList")
	public ModelAndView boardList(Integer pageNum) {
		mav=bm.getBoardList(pageNum);
		return mav;
	}
	@RequestMapping(value = "/contents")
	public ModelAndView getContents(Integer b_num) {
		mav=bm.getContents(b_num);
		return mav;
	}
}
