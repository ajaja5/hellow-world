package com.board.cha.dao;

import java.util.List;

import com.board.cha.bean.Board;
import com.board.cha.bean.Reply;

public interface IBoardDao {

	List<Board> getBoardList(int num);

	Board getContents(Integer bNum);

	List<Reply> getReplyList(Integer bNum);
	
}
