<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="cn.gyl.laboratoryweb.model.Notice"%>
<%@page import="cn.gyl.laboratoryweb.model.Message"%>
<%@page import="java.util.List"%>
<%@page import="cn.gyl.laboratoryweb.model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<style type="text/css">
.box {
	margin: 0px 50px;
	width: 1200px;
	height: 70%;
}

.row：after, .row::before {
	clear: both;
	display: table;
}

.sbox {
	padding-left: 15px;
	width: 570px;
	height: 70%;
	float: left;
}

.index-table {
	margin: auto;
	width: 960px;
	border: 1px solid #CCC;
	border-collapse: collapse;
	text-align: center;
}

a {
	text-decoration: none;
}

.index-table td {
	border: 1px solid #ccc;
	height: 20px;
	overflow: hidden;
	word-break: break-all;
}
</style>
	<div class="stuindex">
		<div style="margin-left: 20%; margin-top: 10px;">
			<h1 class="stuHeadLine">欢迎登陆实验室预约管理系统</h1>
		</div>
		<br /> <br />
		<div class="box row">
			<div class="sbox" style="width: 300px; height: 320px;">
				<h2 class="stuindextable">系&nbsp;统&nbsp;信&nbsp;息</h2>
				<table class="index-table"
					style="background-color: white; font-size: 13px; width: 300px; table-layout: fixed;">
					<tr class="tdd">
						<td style="width: 40px;">操作系统:</td>
						<td width="80px">${sessionScope.systemInfo.os }&nbsp;</td>
					</tr>
					<tr>
						<td>操作系统版本:</td>
						<td>${sessionScope.systemInfo.osVersion }</td>
					</tr>

					<tr>
						<td>系统用户名:</td>
						<td>${sessionScope.systemInfo.systemUser }</td>
					</tr>
					<tr>
						<td>JDK版本号:</td>
						<td>${sessionScope.systemInfo.jdkVersion }</td>
					</tr>
					<tr>
						<td>临时文件目录:</td>
						<td>${sessionScope.systemInfo.tempFilePath }</td>
					</tr>
					<tr>
						<td>文件目录:</td>
						<td>${sessionScope.systemInfo.filePath }</td>
					</tr>


				</table>
			</div>
			<div
				style="color: red; width: 150px; text-align: center; background-color: white; height: 30px; border-radius: 4px; position: fixed; top: 120px; left: 200px;">
				<a id="msgFlag" href="javascript:void(0);" onclick="showMSGView()"
					style="font-size: 20px; color: gray;">暂无新消息</a>
			</div>
			<div
				style="color: red; width: 150px; text-align: center; background-color: green; height: 30px; border-radius: 4px; position: fixed; top: 120px; right: 100px;">
				<a id="" href="javascript:void(0);" onclick="showRuleView()"
					style="font-size: 20px; color: yellow;">实验室规章制度</a>
			</div>
			<div class="sbox">

				<h2 class="stuindextable" style="width: 500px; height: 35px;">解&nbsp;封&nbsp;申&nbsp;请</h2>
				<table class="index-table"
					style="background-color: white; font-size: 13px; width: 500px;">
					<tr>
						<td width="38" height="20" style="padding: 5px;">序号</td>
						<td width="60">姓名</td>
						<td width="60">学号</td>
						<td width="170">消息发送时间</td>
						<td>操作</td>
					</tr>
					<tbody id="msgTable"></tbody>
				</table>
				<div
					style="margin: 0px 28px; padding-left: 50px; background-color: white; width: 498px;">
					<a style="text-decoration: none;" href="javascript:void(0);"
						onclick="changeMSGPage(-1)">上一页</a> <span id="allrowsText"
						style="margin: 0px 90px;"></span> <a
						style="text-decoration: none; margin: 0px 50px; float: right"
						href="javascript:void(0);" onclick="changeMSGPage(1)">下一页</a>
				</div>
			</div>
			<div class="sbox" style="width: 330px; height: 200px;">
				<h2 class="stuindextable" style="width: 330px; height: 35px;">
					公&nbsp;告&nbsp;信&nbsp;息<a id="blink" href="javascript:void(0);"
						onclick="noticePage()" style="float: right">More&nbsp;</a>
				</h2>
				<table class="index-table"
					style="padding-left: 0px; font-size: 13px; background-color: white; width: 330px;">
					<tr>
						<td>标题</td>
						<td>发布日期</td>
						<td>操作</td>
					</tr>
					<tbody id="noticeListTable"></tbody>
				</table>
				<div
					style="margin: 0px 0px; padding-left: 0px; border-left: 1px solid #ccc; border-bottom: 1px solid #ccc; background-color: white; width: 330px;">
					<span id="allrowsText" style="margin: 0px 30px;"></span> <a
						style="text-decoration: none; margin: 0px 60px; color: black; font-size: 20px;"
						href="javascript:void(0);" onclick="addNotice()">添加公告</a>
				</div>
			</div>

		</div>
	</div>
	<!-- 学生申请消息的提示框 -->
	<div id="appealContent-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 400px; height: 360px; padding: 10px;">
		<div id="appeal-content"></div>
	</div>
	<!-- 显示公告消息的提示框 -->
	<div id="noticeContent-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 800px; height: 600px; padding: 10px;">

		<div id="notice-head"
			style="font-weight: bold; font-size: 20px; text-align: center;"></div>
		<hr />
		<div id="notice-date" style="text-align: center;"></div>
		<br />
		<div id="notice-content" style="text-indent: 2em; line-height: 30px;"></div>
	</div>
	<!-- 增加公告的提示框 -->
	<div id="notice-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 350px; height: 420px; padding: 10px;">

		<form id="notice-dialog-form" method="post">
			<table>
				<tr>
					<td>公告标题:</td>

				</tr>
				<tr>
					<td><input id="noticeHead" name="noticeHead"
						style="width: 100%;" type="text" /></td>
				</tr>
				<tr>
					<td width="60px">公告内容:</td>
				</tr>
				<tr>
					<td><textarea id="content" name="content"
							style="width: 300px; height: 150px;"
							οnblur="this.value=this.value.trim()"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 新增规章制度 -->
	<div id="rule-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 350px; height: 420px; padding: 10px;">

		<form id="rule-dialog-form" method="post">
			<table>
				<tr>
					<td>标题:</td>

				</tr>
				<tr>
					<td><input id="ruleHead" name="ruleHead"
						style="width: 100%;" type="text" /></td>
				</tr>
				<tr>
					<td width="60px">内容:</td>
				</tr>
				<tr>
					<td><textarea id="rule-content" name="rule-content"
							style="width: 300px; height: 150px;"
							οnblur="this.value=this.value.trim()"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 显示全部通知公告的提示框 -->
	<div id="allNotice-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 800px; height: 600px;">
		<div id="ntc-table"
			style="margin: 0px 0px; padding: 0px; width: 784px; height: 100%;" />
	</div>
	<!-- 显示全部消息的提示框 -->
	<div id="allMSG-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 800px; height: 600px;">
		<div id="msg-table"
			style="margin: 0px 0px; padding: 0px; width: 784px; height: 100%;" />
	</div>
	<!-- 显示全部规章制度告的提示框 -->
	<div id="allRule-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 800px; height: 600px;">
					
				<div id="crule-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			id="addbutton" class="easyui-linkbutton" onclick="addRule()">添加</a>
	</div>
		<div id="rule-table"
			style="margin: 0px 0px; padding: 0px; width: 784px; height: 94%;" />

			
	</div>
			<!-- 显示实验室规章制度的提示框 -->
		<div id="ruleContent-dialog" class="easyui-dialog"
			data-options="closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 600px; padding: 10px;">

			<div id="rule-head"
				style="font-weight: bold; font-size: 20px; text-align: center;"></div>
			<hr />
			<div id="rule-date" style="text-align: center;"></div>
			<br />
			<div id="showrule-content" style="text-indent: 2em; line-height: 30px;"></div>
		</div>
			<!-- 消息发送 -->
	<div id="sendmsg-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 350px; height: 420px; padding: 10px;">

		<form id="sendmsg-dialog-form" method="post">
			<table>
				<tr>
					<td width="60px">*请填写您信息:</td>
				</tr>
				<tr>
					<td><textarea id="msgContent" name="msgContent"
							style="width: 300px; height: 200px;"
							οnblur="this.value=this.value.trim()"></textarea></td>
				</tr>
			</table>
		</form>
		<input id="tempId" type="hidden" />
	</div>
	<script type="text/javascript">
		function addNotice() {
			$("#notice-dialog-form").form("clear");
			$("#notice-dialog").dialog({
				title : "新增公告",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : "确定",
					iconCls : "icon-ok",
					handler : doAddNotice
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#notice-dialog").dialog("close");
					}
				} ]
			});
		}
		function doAddNotice() {
			var content = $("#content").val();
			var noticeHead = $("#noticeHead").val();
			var len = content.length;
			var headlen = noticeHead.length;
			if (len<20||len>1000 || headlen < 4) {
				Alert("标题至少4个字且公告内容需20-1000字");
				return;
			}
			var data = {
				"noticeHead" : noticeHead,
				"content" : content
			};
			$.ajax({
				url : "/laboratoryweb/addNotice",
				method : "post",
				data : data,
				success : function(data) {
					if (data == "ok") {
						$("#notice-dialog").dialog("close");
						$("#ntc-table").datagrid("reload");
						Alert("公告新增成功!");
						getNoticeList();
					} else {
						Alert("系统异常,请重试！");
					}
				}
			})
		}

		$(function() {
			findMsg();
			changeMSGPage(0);
			getNoticeList();
		})
		function findMsg() {
			$.ajax({
				async : false,
				url : "/laboratoryweb/findMsg",
				method : "get",
				success : function(data) {
					if (data == "ok") {
						$("#msgFlag").css("display", "block");
						$("#msgFlag").css("color", "red");
						$("#msgFlag").html("您有新的消息！");

					}
				}
			});
		}
		function getNoticeList() {
			$.ajax({
						aysnc : false,
						url : "/laboratoryweb/getNoticeList",
						cache : false,
						method : "GET",
						success : function(data) {
							if (data == null || data == '') {
							} else {
								var str = "";
								for (var i = 0; i < data.length; i++) {
									str += "<tr><td><a href='#' style='text-decoration:none; color:black;' onclick='showNoticeContent("
											+ data[i].noticePKID
											+ ")'>"
											+ data[i].headline.substring(0, 12)
											+ ".."
											+ "</a></td><td>"
											+ "["
											+ data[i].upDateTime.split(' ')[0]
											+ "]"
											+ "</td><td><a  href='#' style='text-decoration:none; color:blue;' onclick='deleteNotice("
											+ data[i].noticePKID
											+ ")'>删除</a></td></tr>";
								}
								$("#noticeListTable").html(str);
							}
						}
					});
		}
		//解除学生封禁
		function relieveForbidden(msgId) {
			$.ajax({
				url : "/laboratoryweb/relieveForbidden",
				async : false,
				method : "get",
				data : {
					"id" : msgId
				},
				success : function(data) {
					if (data == "ok") {
						Alert("账号解封成功");
						changeMSGPage(0);
					} else {
						Alert("系统异常,请重试")
					}

				}
			});
		}
		//无视学生请求
		function negative(msgId) {
			$.messager.confirm("提示", "确定忽略该条请求?", function(result) {
				if (result) {
					$.ajax({
						url : "/laboratoryweb/readMsg",
						async : false,
						method : "get",
						data : {
							"id" : msgId
						},
						success : function(data) {
							if (data == "ok") {
								Alert("已忽略..");
								changeMSGPage(0);
							} else {
								Alert("系统异常,请重试")
							}
						}
					});
				} else {
					return;
				}
			})
		}
		function addRule() {
			$("#rule-dialog-form").form("clear");
			$("#rule-dialog").dialog({
				title : "新增规章制度",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : "确定",
					iconCls : "icon-ok",
					handler : doAddRule
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#rule-dialog").dialog("close");
					}
				} ]
			});
		}
		function doAddRule() {
			var content = $("#rule-content").val();
			var ruleHead = $("#ruleHead").val();
			var data = {
				"ruleHead" : ruleHead,
				"content" : content
			};
			$.ajax({
				url : "/laboratoryweb/addRule",
				method : "post",
				data : data,
				success : function(data) {
					if (data == "ok") {
						$("#rule-dialog").dialog("close");
						$("#rule-table").datagrid("reload");
						Alert("新增成功!");
					} else {
						Alert("系统异常,请重试！");
					}
				}
			})
		}

		//删除公告
		function deleteNotice(noticeId) {
			$.messager.confirm("提示", "确定删除?", function(result) {
				if (result) {
					$.ajax({
						url : "/laboratoryweb/deleteNotice",
						async : false,
						method : "get",
						data : {
							"id" : noticeId
						},
						success : function(data) {
							if (data == "ok") {
								Alert("删除成功");
								$("#ntc-table").datagrid("reload");
								getNoticeList();
							} else {
								Alert("系统异常,请重试")
							}
						}
					});
				} else {
					return;
				}
			})
		}
		//显示学生请求
		function changeMSGPage(flag) {
			$
					.ajax({
						aysnc : false,
						url : "/laboratoryweb/getPagerMessage",
						cache : false,
						data : {
							"flag" : flag
						},
						method : "GET",
						success : function(data) {
							if (data == null || data == '') {
							} else {
								var str = ""
								for (var i = 0; i < data.rows.length; i++) {
									str += "<tr id='msgtr"+data.rows[i].messagePKID+"'><td>"
											+ (data.offset + i + 1)
											+ "</td><td>"
											+ data.rows[i].userName
											+ "</td><td>"
											+ data.rows[i].userId
											+ "</td><td>"
											+ data.rows[i].msgDate
											+ "</td><td><a href='#' style='text-decoration:none; color:blue;' onclick='relieveForbidden("
											+ data.rows[i].messagePKID
											+ ")'>解封</a>/<a href = '#' style='text-decoration:none; color:blue;' onclick='scanMSGContent("
											+ data.rows[i].messagePKID
											+ ")'>查看明细</a>/<a href='#' style='text-decoration:none; color:blue;' onclick='negative("
											+ data.rows[i].messagePKID
											+ ")'>忽略</a></td></tr>";
								}
								$("#msgTable").html(str);
								$("#allrowsText").html("总条数:" + data.total);
							}
						}
					});
		}
		function scanNMSGContent(msgId){
			$.ajax({
				async:false,
				url:"/laboratoryweb/readMsg",
				data:{"id": msgId},
				success:function(data){
					
				}
			});
			$("#msg-table").datagrid("reload");
			scanMSGContent(msgId);
		}
		function returnMSG(msgId){
			$("#tempId").val(msgId);
			$("#sendmsg-dialog-form").form("clear");
			$("#sendmsg-dialog").dialog({
				title : "回复留言",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : "确定",
					iconCls : "icon-ok",
					handler : doSendMSG
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#sendmsg-dialog").dialog("close");
					}
				} ]
			});
		}
		function doSendMSG(){
			var msgId = $("#tempId").val();
			var msgContent = $("#msgContent").val();
			var data = {
					"id" :msgId,
				"content" : msgContent
			};
			$.ajax({
				url : "/laboratoryweb/returnMSG",
				method : "post",
				data : data,
				success : function(data) {
					if (data == "ok") {
						$("#sendmsg-dialog").dialog("close");
						$("#msg-table").datagrid("reload");
						Alert("回复成功！");
					}else if(data=="fail"){
						Alert("此消息已被回复");
						$("#sendmsg-dialog").dialog("close");
					}
						else{
						Alert("系统异常,请重试..");
						
					}
				}
			})
		}
		//查看学生请求内容
		function scanMSGContent(msgId) {
			var content;
			$.ajax({
				url : "/laboratoryweb/getMsgContent",
				async : false,
				method : "get",
				data : {
					"id" : msgId
				},
				success : function(data) {
					content = data;
				}
			});
			$("#appeal-content").text(content);
			$("#appealContent-dialog").dialog({
				title : "消息内容",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#appealContent-dialog").dialog("close");
					}
				}

				]
			});
		}
		function showNoticeContent(noticeId) {
			var headline;
			var content;
			var date;
			$.ajax({
				url : "/laboratoryweb/getNoticeContent",
				async : false,
				method : "get",
				data : {
					"id" : noticeId
				},
				success : function(data) {
					headline = data.headline;
					content = data.content;
					date = data.date;
				}
			});
			$("#notice-content").text(content);
			$("#notice-head").text(headline);
			$("#notice-date").text(date.split(' ')[0]);
			$("#noticeContent-dialog").dialog({
				title : "公告内容",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#noticeContent-dialog").dialog("close");
					}
				}

				]
			});
		}
		function noticePage() {
			changeNoticePage();
			$("#allNotice-dialog").dialog({
				title : "",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#allNotice-dialog").dialog("close");
					}
				} ]
			});
		}
		function showMSGView() {
			changeNMSGPage();
			$("#allMSG-dialog").dialog({
				title : "",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#allMSG-dialog").dialog("close");
					}
				} ]
			});
		}
		function showRuleContent(ruleId) {
			var headline;
			var content;
			var date;
			$.ajax({
				url : "/laboratoryweb/getRuleContent",
				async : false,
				method : "get",
				data : {
					"id" : ruleId
				},
				success : function(data) {
					headline = data.headline;
					content = data.content;
					date = data.date;
				}
			});
			$("#showrule-content").text(content);
			$("#rule-head").text(headline);
			$("#rule-date").text(date.split(' ')[0]);
			$("#ruleContent-dialog").dialog({
				title : "公告内容",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#ruleContent-dialog").dialog("close");
					}
				}

				]
			});
		}
		function showRuleView() {
			changeRulePage();
			$("#allRule-dialog").dialog({
				title : "",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#allRule-dialog").dialog("close");
					}
				} ]
			});
		}
		function deleteRule(id) {
			$.ajax({
				async:true,
				url : "/laboratoryweb/deleteRule",
				data:{"id":id},
				method:"get",
				success:function(data){
					if(data=="ok"){
						Alert("删除成功");
						$("#rule-table").datagrid("reload");
					}else{
						Alert("服务器异常");
					}
				}
			})
		}
		function changeNoticePage() {
			$("#ntc-table")
					.datagrid(
							{
								title : "&nbsp;&nbsp;&nbsp;&nbsp;全部公告",
								url : "/laboratoryweb/getPagerNotice",
								pagination : true,
								pageSize : 13,
								singleSelect : true,
								pageList : [ 13, 50, 100 ],
								columns : [ [
										{
											field : "headline",
											title : "公告标题",
											width : 532
										},
										{
											field : "upDateTime",
											title : "发布时间",
											width : 90,
											formatter : function(value, row,
													index) {

												return value.split(" ")[0];
											}
										},
										{
											field : " ",
											title : "公告内容",
											width : 80,
											formatter : function(value, row,
													index) {
												return "<a href='javascript:void(0);' onclick='showNoticeContent("
														+ row.noticePKID
														+ ")'>" + "查看详细</a>";
											}
										},
										{
											field : "  ",
											title : "操作",
											width : 80,
											formatter : function(value, row,
													index) {
												return "<a href='javascript:void(0);' onclick='deleteNotice("
														+ row.noticePKID
														+ ")'>" + "删除</a>";
											}
										} ] ],
								striped : true
							});
		}
		function changeRulePage() {
			$("#rule-table")
					.datagrid(
							{
								title : "&nbsp;&nbsp;&nbsp;&nbsp;规章制度",
								url : "/laboratoryweb/getPagerRule",
								pagination : true,
								pageSize : 13,
								singleSelect : true,
								pageList : [ 13, 50, 100 ],
								columns : [ [
										{
											field : "headline",
											title : "公告标题",
											width : 532
										},
										{
											field : "uploadDate",
											title : "发布时间",
											width : 90,
											formatter : function(value, row,
													index) {

												return value.split(" ")[0];
											}
										},
										{
											field : " ",
											title : "详细内容",
											width : 80,
											formatter : function(value, row,
													index) {
												return "<a href='javascript:void(0);' onclick='showRuleContent("
														+ row.labRulePKID
														+ ")'>" + "查看详细</a>";
											}
										},
										{
											field : "  ",
											title : "操作",
											width : 80,
											formatter : function(value, row,
													index) {
												return "<a href='javascript:void(0);' onclick='deleteRule("
														+ row.labRulePKID
														+ ")'>" + "删除</a>";
											}
										} ] ],
								striped : true
							});
		}
		function changeNMSGPage() {
			$("#msg-table")
					.datagrid(
							{
								title : "&nbsp;&nbsp;&nbsp;&nbsp;全部消息",
								url : "/laboratoryweb/getPagerNMSG",
								pagination : true,
								pageSize : 13,
								singleSelect : true,
								pageList : [ 13, 50, 100 ],
								columns : [ [
										{
											field : "userName",
											title : "用户姓名",
											width : 80
										},
										{
											field : "userRole",
											title : "用户角色",
											width : 90,

										},
										{
											field : "msgDate",
											title : "发送时间",
											width : 90,
											formatter : function(value, row,
													index) {

												return value.split(" ")[0];
											}
										},
										{
											field : "status",
											title : "状态",
											width : 80,
											formatter : function(value, row,
													index) {
												if (value == 1) {
													return "未读";
												} else if (value == 2) {
													return "已读";
												} else{
													return "已回复";
												}
											},
										styler : function(value, row, index) {
											if (value == 1) {
												return 'background-color:#E22018;color:white;';
											} else {
												return 'tetx-align:center;background-color:#60D41F;color:white;';
												
											}
										}
										} ,
										{
											field : " ",
											title : "消息内容",
											width : 80,
											formatter : function(value, row,
													index) {
												return "<a href='javascript:void(0);' onclick='scanNMSGContent("
														+ row.messagePKID
														+ ")'>" + "查看详细</a>";
											}
										},{
											field : "  ",
											title : "回复",
											width : 80,
											formatter : function(value, row,
													index) {
												return "<a href='javascript:void(0);' onclick='returnMSG("
														+ row.messagePKID
														+ ")'>" + "回复消息</a>";
											}
										}] ],
								striped : true
							});
		}
	</script>
</body>
</html>