package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Nutrient;

public interface NutrientService {
	
	/**
	 * 식습관 점수에 대한 답변의 총 합을 반환한다.
	 * 
	 * @param req - 답변에 대한 전달 파라미터
	 * @return - 식습관 점수 총합
	 */
	public int getTotalBySelfTest(HttpServletRequest req);
	
	/**
	 * 질문에 대한 form 데이터를 받아 3일 이라고 
	 * 답한 질문에 대한 영양소들의 list를 반환!
	 * 
	 * @return - List<Nutrient>
	 */
	public List<Nutrient> getRecommendNutrientList(HttpServletRequest req);

}
