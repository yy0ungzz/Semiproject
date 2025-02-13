package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.NutrientService;
import service.impl.NutrientServiceImpl;

@WebServlet("/nutrient/self/result")
public class NutrientSelfTestResultController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	NutrientService nutrientService = new NutrientServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/nutrient/self/result [GET]");
		
		int total = nutrientService.getTotalBySelfTest(req);
		
		req.setAttribute("total", total);
		
		req.getRequestDispatcher("/WEB-INF/views/recommend/self_result.jsp").forward(req, resp);
	}
	
}
