package simplemvc.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplemvc.command.AgeCommand;
import simplemvc.command.Command;
import simplemvc.command.HobbyCommand;
import simplemvc.command.NameCommand;

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

	public void processRequest(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// command.properties 파일을 읽어서 Properties맵에 저장
		Properties prop = new Properties();
		File file = new File("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture-web\\simplemvc\\src\\main\\java\\simplemvc\\prop\\command.properties");
		prop.load(new FileReader(file));
		
		// properties 파일에 명령 = 명령처리클래스를 매핑한다.
		Command command = null;
		try {
			// 명령에 따른 명령처리클래스 생성
			Class cl = Class.forName((String)prop.get(req.getQueryString()));
			// 명령처리클래스 객체 생성
			command = (Command)cl.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// request에 속성변수 설정
		req.setAttribute("resultObj", command.returnModel());

		// 컨트롤러 역할 3. 생성된 결과를 뷰에 전달
		RequestDispatcher dispatcher = req.getRequestDispatcher((String)command.returnView());
		dispatcher.forward(req, resp);

	}

} // class
