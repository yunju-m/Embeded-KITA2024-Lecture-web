<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="member.MemberInterface"%>
<%@page import="member.MemberDao"%>

<jsp:useBean id="member" class="member.Member" />
<jsp:setProperty name="member" property="*" />

<%
	MemberInterface mi = new MemberDao();
	
	int result = mi.getMember(member);
	if (result < 1) {
		out.print("<script>alert('등록하신 회원정보를 확인하세요!'); location.href='login.jsp';</script>");
	} else {
		session.setAttribute("mid", member.getMid());
		Object userCount = application.getAttribute("userCount");
		application.setAttribute("userCount", userCount==null ? 1 : (Integer)userCount + 1);
		response.sendRedirect("boardListProc.jsp");
	}
%>