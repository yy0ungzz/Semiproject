package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Inquiry;
import service.face.InquiryService;
import service.impl.InquiryServiceImpl;
import util.Paging;

@WebServlet("/inquiry/list")
public class InquiryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InquiryService inquiryService = new InquiryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Paging paging = inquiryService.getPaging(req);
		
		List<Inquiry> list = inquiryService.getInquiryList(paging);
		req.setAttribute("list", list);
		req.setAttribute("paging", paging);
		req.getRequestDispatcher("/WEB-INF/views/customer_service/inquirylist.jsp").forward(req, resp);
	}

}