package jspbasic.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiledownloadServlet extends HttpServlet {

	private final static long serialVersionUID = 2131212412L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = "D:/upload";
		String filename = request.getParameter("filename");
		String filefullname = dir + "/" + filename;
		try {
			byte[] bArray = new byte[4096];
			
			response.setContentType("application/octet-stream");
			String encName = new String(filename.getBytes("UTF-8"), "8859_1");
			response.setHeader("Content-Disposition", "attachment; filename=" + encName);
			
			InputStream fis = new FileInputStream(filefullname);
			OutputStream os = response.getOutputStream();
			
			int numRead = 0;
			while ((numRead = fis.read(bArray, 0, bArray.length)) != -1) {
				os.write(bArray, 0, numRead);
			}
			os.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}