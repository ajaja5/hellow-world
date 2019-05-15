package com.board.cha;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.board.cha.bean.Board;
import com.board.cha.bean.Reply;
import com.board.cha.dao.IBoardDao;
@Service
public class BoardManagement {
	@Autowired
	private IBoardDao bDao;
	@Autowired
	private HttpSession session;
	
	ModelAndView mav;
	public ModelAndView getBoardList(Integer pageNum) {
		mav=new ModelAndView();
		String view=null;
		List<Board> bList=null;
		//if(session.getAttribute("id")!=null) {}
		int num=(pageNum==null)? 1: pageNum;
		bList=bDao.getBoardList(num);
		System.out.println("size="+bList.size());
		mav.addObject("bList",bList);
		view="boardList";
		mav.setViewName(view);
		return mav;
	}
	public ModelAndView getContents(int b_num) {
		mav=new ModelAndView();
		String view=null;
		//로그인 한 경우만 글 내용 보기
		if(session.getAttribute("id")!=null) {
			Board board=bDao.getContents(b_num);
			mav.addObject("board",board);
			System.out.println("b_mid="+board.getB_mid());
			List<Reply> rList=bDao.getReplyList(b_num);
			mav.addObject("rList",rList);
			System.out.println("R_size()="+rList.size());
			view="boardcontentsajax";
		}
		mav.setViewName(view);	
		return mav;
	}

}
