<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学生系统</title>
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
	src="${pageContext.request.contextPath }/resources/js/studentPage.js"></script>

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
				&nbsp;&nbsp;${sessionScope.userName}
				&nbsp;&nbsp;&nbsp;角色:&nbsp;&nbsp;${sessionScope.role}&nbsp;&nbsp;&nbsp;
				状态:&nbsp;&nbsp;${sessionScope.user.status eq 1?"正常":"禁用"} </span>
		</div>
		<input id="userRole" type="hidden" value="${sessionScope.role}" />
		<div class="labweb_head_right">
			<span><a href="javascript:void(0);" onclick="cgpassword()">修改密码</a><a
				href="javascript:void(0);">|</a><a
				href="${pageContext.request.contextPath }/exit" target="_top">安全退出</a><a
				href="javascript:void(0);">|</a><a href="javascript:void(0);"
				onclick="stuAppeal()">账号申诉</a></span>
		</div>
		<p id="userAccount" style="display: none;">${sessionScope.userAccount}</p>
	</div>


	<div class="labweb_left"
		data-options="region:'west',border:true,split:false,title:'' ,
		collapsible:false">
		<!-- 折叠面板 -->

		<div title="功能分类	" data-options="iconCls:'icon.wrench'">
			<ul class="easyui-tree labweb_tree ulform" style="height: 290px;">

				<li><a href="javascript:void(0);"
					style="background-color: #a62d2d; color: #fff;"
					data-link="${pageContext.request.contextPath }/student/index"
					iframe="0"><p>首页</p></a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/laboratoryInfo"
					iframe="0"><p>实验室信息</p></a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/myOrderInfo"
					iframe="0"><p>我的预约</p></a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/myExperProject"
					iframe="0"><p>我的实验预习</p></a></li>
				<li><a href="javascript:void(0);"
					data-link="${pageContext.request.contextPath }/experProjectInfo"
					iframe="0"><p>项目信息查看</p></a></li>


			</ul>
		</div>
	</div>
	<!-- 中心 -->
	<div class="labweb_center"
		data-options="region:'center',collapsible:false,split:false">
		<div id="labweb_tabs" class="easyui-tabs"
			data-options="border:false,fit:true">
			<div title="首页"
				data-options="href:'${pageContext.request.contextPath }/student/index',closable:false,iconCls:'icon-tip',cls:'pd3'">
			</div>
		</div>
	</div>
	<div class="labweb_bottom"
		data-options="region:'south',border:false,split:false,collapsible:false">
		<p
			style="height: 20px; font-size: 13px; margin: 0px; line-height: 25px;">版权所有
			盗版必究</p>
	</div>

	
	<!-- 增加的密码修改框 -->
	<div id="password_dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-key'"
		style="width: 320px; height: 270px; padding: 10px;">
		<form id="password_dialog_form" method="post">
			<table>
				<tr>
					<td width="60px" align="right">旧密码:</td>
					<td><input type="text" id="adminPassword" name="adminPassword"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">新密码:</td>
					<td><input type="text" id="newPassword" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="80px" align="right">确认密码:</td>
					<td><input type="text" id="rpNewPassword"
						class="easyui-textbox" /></td>
				</tr>

			</table>
		</form>
	</div>
	<!-- 增加的账号申诉 -->
	<div id="stuAppeal-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 350px; height: 420px; padding: 10px;">

		<form id="stuAppeal-dialog-form" method="post">
			<table>
				<tr>
					<td width="60px">*请填写您的申请理由:</td>
				</tr>
				<tr>
					<td><textarea id="content" name="content"
							style="width: 300px; height: 200px;"
							οnblur="this.value=this.value.trim()"></textarea></td>
				</tr>
			</table>
			<p style="text-align: center; font-size: 12px; color: red;">*账号被封禁时使用</p>
		</form>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/page.js"></script>
	<script type="text/javascript">
		function stuAppeal() {
			$("#stuAppeal-dialog-form").form("clear");
			$("#stuAppeal-dialog").dialog({
				title : "账号申诉",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : "确定",
					iconCls : "icon-ok",
					handler : doStuAppeal
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#stuAppeal-dialog").dialog("close");
					}
				} ]
			});
		}
		function doStuAppeal() {
			var appealText = $("#content").val();
			var len = appealText.length;
			if (len<20||len>1000) {
				Alert("请输入20-1000字");
				return;
			}
			var data = {
				"appealText" : appealText
			};
			$.ajax({
				url : "/laboratoryweb/stuAppeal",
				method : "post",
				data : data,
				success : function(data) {
					if (data == "ok") {
						$("#stuAppeal-dialog").dialog("close");
						Alert("申诉成功,请等待管理员处理..");
					} else if (data == "useless") {
						Alert("账号正常,无需申诉");
					} else {
						Alert("系统异常,请重试！");
					}
				}
			})
		}
	</script>
</body>
</html>