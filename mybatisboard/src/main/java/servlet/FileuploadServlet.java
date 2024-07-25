package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileuploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1123123121412L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String realPath = "D:/upload";

		File dir = new File(realPath);
		if (!dir.exists()) dir.mkdirs();

		new MultipartRequest (request, realPath, 5 * 1024 * 1024,
				"utf-8", new DefaultFileRenamePolicy());
	}

} // class