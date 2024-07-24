<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="mybatisboard.member.MemberInterface"%>
<%@page import="mybatisboard.member.MemberDao"%>

<jsp:useBean id="member" class="mybatisboard.member.Member" />
<jsp:setProperty name="member" property="*" />

<%
	MemberInterface mi = new MemberDao();
	boolean loginResult = mi.getMember(member);
	if (loginResult) {
		session.setAttribute("mid", member.getMid());
		Object userCount = application.getAttribute("userCount");
		application.setAttribute("userCount", userCount==null ? 1 : (Integer)userCount + 1);
		response.sendRedirect("boardListProc.jsp");
	} else {
		out.print("<script>alert('회원정보가 일치하지 않습니다.'); location.href='login.jsp';</script>");
	}
%>