<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<%
String laboratoryName = (String)session.getAttribute("laboratoryName");
Long laboratoryId = (Long)session.getAttribute("laboratoryId") ;
%>
<body>
	
		<input id="id" name="id" type="hidden" />
		<form id="laboratory_dialog_form" method="post">
			<table>
				<tr>
					<td style="padding: 10px;" width="60px" align="right">实验室名</td>
					<td><input type="text" disabled="disabled" id="laboratoryName" value="<%=laboratoryName %>"
						name="laboratoryName" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;" width="60px" align="right">实验室编号</td>
					<td><input type="text" disabled="disabled" id="laboratoryId" value="<%= laboratoryId%>"
						name="laboratoryId" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;" width="60px" align="right">预约时间</td>
					<td><input type="text" id="orderDay" name="orderDay"
						class="easyui-datebox" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;" width="60px" align="right">预约时间段</td>
					<td><input type="text" id="orderTimeSectionId"
						name="orderTimeSection" class="easyui-combotree"
						data-options="url:'/laboratoryweb/getAllTimeSection',multiple:false,panelHeight:233" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;" width="60px" align="right">预约班级</td>
					<td><input type="text" id="stuClass" name="stuClass"
						class="easyui-combotree"
						data-options="url:'/laboratoryweb/getTeacherStuClass',multiple:false,panelHeight:233" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;" width="60px" align="right">实验项目</td>
					<td><input type="text" id="experProject" name="experProject"
						class="easyui-combotree"
						data-options="url:'/laboratoryweb/getExperProjectByLabId',multiple:false,panelHeight:233" /></td>
				</tr>

			</table>
		</form>
</body>
</html>