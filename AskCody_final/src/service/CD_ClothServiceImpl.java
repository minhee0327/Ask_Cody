package service;

import java.util.List;

import dao.CD_ClothDAO;
import vo.CD_ClothVO;
import vo.SuggestionVO;

public class CD_ClothServiceImpl implements CD_ClothService{
	CD_ClothDAO dao;

	public CD_ClothServiceImpl() {}
	public CD_ClothServiceImpl(CD_ClothDAO dao) {
		this.dao = dao;
	}
	
	
	public CD_ClothDAO getDao() {
		return dao;
	}
	public void setDao(CD_ClothDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int deleteCoordi(int coordi_id) {
		return dao.deleteCoordi(coordi_id);
	}
	@Override
	public int addCoordi(CD_ClothVO vo) {
		return dao.saveCoordi(vo);
	}
	@Override
	public List<CD_ClothVO> loadCoordi(int coordi_id) {
		return dao.loadCoordi(coordi_id);
	}
	@Override
	public List<SuggestionVO> loadSuggestion() {
		return dao.loadSuggestion();
	}
}
