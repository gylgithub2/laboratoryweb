<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>教师系统</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/page.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/easyui/local/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/teacherPage.js"></script>
<style>
.ec_tip {
	display: none;
	width: 140px;
	text-align: center;
	padding: 10px;
	position: absolute;
	background: #777;
	color: #fff;
	border: 3px solid #777;
	z-index: 9999;
	text-align: center;
}
</style>
</head>

<body class="easyui-layout">



	<div class="labweb_head"
		data-options="region:'north',border:false,split:false">
		<div class="labweb_head_left">
			<span id="userName" class="headInfo">你好:
				${sessionScope.userName} &nbsp;&nbsp;&nbsp;角色:${sessionScope.role}</span>
		</div>
		<div class="labweb_head_right">
			<span><a href="javascript:void(0);" onclick="cgpassword()">修改密码</a><a href="javascript:void(0);">|</a><a
				href="${pageContext.request.contextPath }/exit" target="_top">安全退出</a></span>
		</div>
		<p id="userAccount" style="display: none;">${sessionScope.userAccount}</p>
	</div>


	<div class="labweb_left"
		data-options="region:'west',border:true,split:false,title:'导航菜单' ,
		collapsible:false">
		<!-- 折叠面板 -->

		<div title="功能分类	" data-options="iconCls:'icon.wrench'">
			<ul class="easyui-tree labweb_tree ulform" style="height: 450px;">
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/teacherIndex"
					iframe="0">首页</a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/laboratoryInfo"
					iframe="0">实验室信息</a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/myClasses"
					iframe="0">我的班级管理</a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/myOrderInfo"
					iframe="0">历史预约信息</a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/experProjectManager"
					iframe="0">开放项目信息</a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/myUpload">数字化资源管理</a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/studyRecord"
					iframe="0">班级学习记录</a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/classManager"
					iframe="0">班级信息</a></li>

			</ul>
		</div>
	</div>
	<!-- 中心 -->
	<div class="labweb_center"
		data-options="region:'center',collapsible:false,split:false">
		<div id="labweb_tabs" class="easyui-tabs"
			data-options="border:false,fit:true">
			<div title="首页"
				data-options="href:'${pageContext.request.contextPath }/teacherIndex',closable:false,iconCls:'icon-tip',cls:'pd3'">


			</div>
		</div>
	</div>
	<div class="labweb_bottom"
		data-options="region:'south',border:true,split:false,collapsible:false">
		<p>版权所有 盗版必究</p>
	</div>

	<!-- 增加的密码修改框 -->
	<div id="password_dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-key'"
		style="width: 320px; height: 270px; padding: 10px;">
		<form id="password_dialog_form" method="post">
			<table>
				<tr>
					<td width="60px" align="right">旧密码</td>
					<td><input type="text" id="oldPassword" name="adminPassword"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">新密码</td>
					<td><input type="text" id="newPassword" name="regDate"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">确认新密码</td>
					<td><input type="text" id="rpNewPassword" name="regDate"
						class="easyui-textbox" /></td>
				</tr>

			</table>
		</form>
	</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/page.js"></script>
</body>
</html>