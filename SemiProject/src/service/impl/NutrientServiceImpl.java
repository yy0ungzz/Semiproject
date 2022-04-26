package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.NutrientDao;
import dao.impl.NutrientDaoImpl;
import dto.Nutrient;
import service.face.NutrientService;

public class NutrientServiceImpl implements NutrientService{

	NutrientDao nutrientDao = new NutrientDaoImpl();
	
	@Override
	public List<Nutrient> getRecommendNutrientList(HttpServletRequest req) {
		
		//질문에 대하여 선택 값 불러오기
		int[] answerArr = {Integer.parseInt(req.getParameter("q_1"))
				, Integer.parseInt(req.getParameter("q_2"))
				, Integer.parseInt(req.getParameter("q_3"))
				, Integer.parseInt(req.getParameter("q_4"))
				, Integer.parseInt(req.getParameter("q_5"))
				, Integer.parseInt(req.getParameter("q_6"))
				, Integer.parseInt(req.getParameter("q_7"))
				, Integer.parseInt(req.getParameter("q_8"))};
		
		//nutrientNo를 통하여 조회한 정보를 저장할 List 객체
		List<Nutrient> nutrientList = new ArrayList<>();
		
		for (int i=0; i<answerArr.length; i++) {
			
			//질문에 대한 답 값을 통하여 nutrientNo를 담을 객체
			Nutrient nutrientno = new Nutrient();
			
			if (answerArr[i] <= 2) {
				nutrientno.setNutrientNo(i+1);
				nutrientList.add(nutrientDao.selectAllByNutrientNo(JDBCTemplate.getConnection(), nutrientno));
			} //if end
		} //for end
		
		System.out.println("영양소 추천 정보");
		for( Nutrient n : nutrientList ) System.out.println(n);
		
		return nutrientList;
	}
	
	@Override
	public int getTotalBySelfTest(HttpServletRequest req) {
		
		// 각 질문에 대한 답변 값
		int q_1 = Integer.parseInt(req.getParameter("q_1")); 
		int q_2 = Integer.parseInt(req.getParameter("q_2")); 
		int q_3 = Integer.parseInt(req.getParameter("q_3")); 
		int q_4 = Integer.parseInt(req.getParameter("q_4")); 
		int q_5 = Integer.parseInt(req.getParameter("q_5")); 
		int q_6 = Integer.parseInt(req.getParameter("q_6")); 
		int q_7 = Integer.parseInt(req.getParameter("q_7")); 
		int q_8 = Integer.parseInt(req.getParameter("q_8")); 
		int q_9 = Integer.parseInt(req.getParameter("q_9")); 
		int q_10 = Integer.parseInt(req.getParameter("q_10")); 
		int q_11 = Integer.parseInt(req.getParameter("q_11")); 
		int q_12 = Integer.parseInt(req.getParameter("q_12")); 
		int q_13 = Integer.parseInt(req.getParameter("q_13")); 
		int q_14 = Integer.parseInt(req.getParameter("q_14")); 
		int q_15 = Integer.parseInt(req.getParameter("q_15")); 
		int q_16 = Integer.parseInt(req.getParameter("q_16")); 
		int q_17 = Integer.parseInt(req.getParameter("q_17")); 
		int q_18 = Integer.parseInt(req.getParameter("q_18")); 
		int q_19 = Integer.parseInt(req.getParameter("q_19")); 
		int q_20 = Integer.parseInt(req.getParameter("q_20")); 
		
		// 식습관 총합 점수를 저장할 변수
		int total = q_1 + q_2 + q_3 + q_4 + q_5 + q_6 + q_7 + q_8
			+ q_9 + q_10 + q_11 + q_12 + q_13 + q_14 + q_15 + q_16 
			+ q_17 + q_18 + q_19 + q_20; 
			
		return total;
	}
}
