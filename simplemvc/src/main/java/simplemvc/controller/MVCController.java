package simplemvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/controller")
public class MVCController extends HttpServlet {
	
	private static final long serialVersionUID = 13213134131411313L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 파라미터
		String paramRequest = req.getParameter("request") == null ? "" : req.getParameter("request");
		
		// 요청 처리 후 결과를 저장할 객체
		Object resultObj = null;
		
		// 처리 결과를 표현할 View로 사용할 JSP의 경로
		Object viewJSP = null;
		
		// 2. 요청에 따라 결과를 생성하고 뷰를 결정
		if (paramRequest.equals("name")) {
			resultObj = "홍길동";
			viewJSP = "/jsp/name.jsp";
		} else if (paramRequest.equals("age")) {
			resultObj = 30;
			viewJSP = "/jsp/age.jsp";
		} else if (paramRequest.equals("hobby")) {
			resultObj = "축구";
			viewJSP = "/jsp/hobby.jsp";
		}
		
		// request에 속성변수 설정
		req.setAttribute("resultObj", resultObj);
		
		// 3. 생성된 결과를 뷰에 전달
		RequestDispatcher dispatcher = req.getRequestDispatcher((String)viewJSP);
		dispatcher.forward(req, resp);
		
	}
	
} // class
