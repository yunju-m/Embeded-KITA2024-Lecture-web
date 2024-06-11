<%
	// cmd > ipconfig /all
	// teacher pc ip : 192.168.8.254
	// my pc ip : 192.168.8.13
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append("{\"name\":\"myj01\", \"age\":30},");
	sb.append("{\"name\":\"myj02\", \"age\":50}");
	sb.append("]");
	String str = sb.toString();
	out.print(str);
%>