package service;

import java.util.List;

import dao.ClothesDAO_Oracle;
import vo.ClothesVO;

public class ClothesService_Imp implements ClothesService {

	ClothesDAO_Oracle dao;	
	
	public ClothesService_Imp() {}
	
	public ClothesService_Imp(ClothesDAO_Oracle dao) {
		this.dao = dao;
	}

	public ClothesDAO_Oracle getDao() {
		return dao;
	}

	public void setDao(ClothesDAO_Oracle dao) {
		this.dao = dao;
	}

	@Override
	public List<ClothesVO> allclothesList() {
		return dao.allClothesList();
	}

	@Override
	public List<ClothesVO> filterclothes(String type, String color) {
		return dao.filterclothes(type, color);
	}

	@Override
	public List<ClothesVO> filteralltypeclothes(String color) {
		return dao.filteralltypeclothes(color);
	}

	@Override
	public List<ClothesVO> filterallcolorclothes(String type) {
		return dao.filterallcolorclothes(type);
	}

}