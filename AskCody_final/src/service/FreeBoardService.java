package service;

import java.util.List;

import vo.BoardVO;

public interface FreeBoardService {
	
	int writeBoard (BoardVO vo) throws Exception;
	int deleteBoard (int post_id) throws Exception;
	int modifyBoard (BoardVO vo) throws Exception;
	int count (BoardVO vo) throws Exception;
	List<BoardVO> boardList () throws Exception;
	List<BoardVO> SearchList (String condition, String keyword) throws Exception;
	List<BoardVO> moveList (int board_num) throws Exception;
	List<BoardVO> post(int post_id) throws Exception;
	int count_move() throws Exception;
	List<BoardVO> moveSearchList(int board_num,String condition,String keyword) throws Exception;
	int count_search_move(String condition, String keyword) throws Exception;
}
