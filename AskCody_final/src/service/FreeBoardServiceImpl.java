package service;

import java.util.List;

import dao.FreeBoardDao;
import vo.BoardVO;

public class FreeBoardServiceImpl implements FreeBoardService{
	
	FreeBoardDao dao;

	public FreeBoardServiceImpl() {
		super();
	}

	public FreeBoardServiceImpl(FreeBoardDao dao) {
		super();
		this.dao = dao;
	}

	public FreeBoardDao getDao() {
		return dao;
	}

	public void setDao(FreeBoardDao dao) {
		this.dao = dao;
	}

	@Override
	public int writeBoard(BoardVO vo) throws Exception {
		return dao.writeBoard(vo);
	}

	@Override
	public int deleteBoard(int post_id) throws Exception {
		return dao.deleteBoard(post_id);
	}

	@Override
	public int modifyBoard(BoardVO vo) throws Exception{
		return dao.modifyBoard(vo);
	}

	@Override
	public List<BoardVO> boardList() throws Exception {
		return dao.boardList();
	}

	@Override
	public List<BoardVO> moveList(int board_num) throws Exception {
		return dao.moveList(board_num);
	}

	@Override
	public List<BoardVO> post(int post_id) throws Exception {
		return dao.post(post_id);
	}

	@Override
	public int count(BoardVO vo) throws Exception {
		return dao.count(vo);
	}

	@Override
	public int count_move() throws Exception {
		return dao.count_move();
	}

	@Override
	public List<BoardVO> SearchList(String condition, String keyword) throws Exception {
		return dao.searchList(condition,keyword);
	}

	@Override
	public List<BoardVO> moveSearchList(int board_num, String condition, String keyword) throws Exception {
		return dao.moveSearchList(board_num,condition,keyword);
	}

	@Override
	public int count_search_move(String condition, String keyword) throws Exception {
		return dao.count_search_move(condition,keyword);
	}

	
}
