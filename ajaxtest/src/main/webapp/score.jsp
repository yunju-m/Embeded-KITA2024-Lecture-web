<%
	request.setCharacterEncoding("utf-8");

	String s1name = request.getParameter("s1name");
	String s1kor = request.getParameter("s1kor");
	String s1eng = request.getParameter("s1eng");
	String s1math = request.getParameter("s1math");
	
	String s2name = request.getParameter("s2name");
	String s2kor = request.getParameter("s2kor");
	String s2eng = request.getParameter("s2eng");
	String s2math = request.getParameter("s2math");
	
	String s3name = request.getParameter("s3name");
	String s3kor = request.getParameter("s3kor");
	String s3eng = request.getParameter("s3eng");
	String s3math = request.getParameter("s3math");

	String jsonOutput = String.format(
	        "[{\"name\":\"%s\",\"kor\":\"%s\",\"eng\":\"%s\",\"math\":\"%s\"}," +
	        "{\"name\":\"%s\",\"kor\":\"%s\",\"eng\":\"%s\",\"math\":\"%s\"}," +
	        "{\"name\":\"%s\",\"kor\":\"%s\",\"eng\":\"%s\",\"math\":\"%s\"}]",
	        s1name, s1kor, s1eng, s1math,
	        s2name, s2kor, s2eng, s2math,
	        s3name, s3kor, s3eng, s3math
	);
	
	out.print(jsonOutput);
	
%>