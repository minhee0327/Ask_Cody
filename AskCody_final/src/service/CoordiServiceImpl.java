package service;

import java.util.List;

import dao.CoordiDAO;
import vo.CoordiVO;

public class CoordiServiceImpl implements CoordiService {
	CoordiDAO dao;

	public CoordiServiceImpl() {}
	public CoordiServiceImpl(CoordiDAO dao) {
		this.dao = dao;
	}
	public CoordiDAO getDao() {
		return dao;
	}
	public void setDao(CoordiDAO dao) {
		this.dao = dao;
	}
	@Override
	public int addCoordi(CoordiVO vo) {
		return dao.saveCoordi(vo);
	}
	@Override
	public List<CoordiVO> loadCoordi(String user_id) {
		return dao.loadCoordi(user_id);
	}
	@Override
	public int retcodyId() throws Exception {
		return dao.retcodyId();
	}
	
	
}
