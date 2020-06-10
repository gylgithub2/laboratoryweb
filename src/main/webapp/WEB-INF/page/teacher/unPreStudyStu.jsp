<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@page import="cn.gyl.laboratoryweb.model.Watch"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		Object obj = session.getAttribute("watches");
		List<Map<String, String>> watches = null;
		if (obj != null) {
			watches = (List<Map<String, String>>) obj;
		}
	%>

	<table>
		<tr style="font-weight: bold;">
			<td>学生姓名</td>
			<td>学生学号</td>
			<td>观看进度</td>
		</tr>
		<%
			if (watches != null && watches.size() > 0) {
				for (int i = 0; i < watches.size(); i++) {
					Map<String, String> map = watches.get(i);
		%>
		<tr>
			<td width="80px"><%=map.get("stuName")%></td>
			<td width="80px"><%=map.get("stuAccount")%></td>
			<td width="80px"><%=map.get("status")%>%</td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>