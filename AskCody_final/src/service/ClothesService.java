package service;

import java.util.List;

import vo.ClothesVO;

public interface ClothesService {

	List<ClothesVO> allclothesList();
	List<ClothesVO> filterclothes(String type, String color);
	List<ClothesVO> filteralltypeclothes(String color);
	List<ClothesVO> filterallcolorclothes(String type);
}