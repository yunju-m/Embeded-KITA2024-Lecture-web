<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jspbasic.member.MemberInterface"%>
<%@page import="jspbasic.member.MemberDao"%>

<jsp:useBean id="member" class="jspbasic.member.Member" />
<jsp:setProperty name="member" property="*" />

<%
	MemberInterface mi = new MemberDao();
	boolean loginResult = mi.getMember(member);
	if (loginResult) {
		session.setAttribute("mid", member.getMid());
		out.print("<script>alert('환영합니다!');</script>");
		response.sendRedirect("boardListProc.jsp");
	} else {
		out.print("<script>alert('회원정보가 일치하지 않습니다.'); location.href='login.jsp';</script>");
	}
%>