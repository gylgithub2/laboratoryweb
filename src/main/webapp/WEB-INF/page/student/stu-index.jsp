<?xml version="1.0" encoding="UTF-8" ?>
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

	<%
		List<Order> lists = (List<Order>) session.getAttribute("stuNowOrder");
	%>
	<style type="text/css">
.box {
	margin: 0px 50px;
	width: 1200px;
	height: 70%;
}

a {
	text-decoration: none;
}

.row：after, .row::before {
	clear: both;
	display: table;
}

.sbox {
	padding-left: 15px;
	width: 570px;
	height: 300px;
	float: left;
}

.index-table td {
	border: 1px solid #ccc;
}
</style>
	<div class="stuindex">
		<div style="margin-left: 20%; margin-top: 10px;">
			<h1 class="stuHeadLine">欢迎登陆实验室预约管理系统</h1>
		</div>
		<br /> <br />
		<div class="box row">
			<div class="sbox" style="width: 300px; height: 320px;">
				<h2 class="stuindextable">个&nbsp;人&nbsp;信&nbsp;息</h2>
				<table class="index-table"
					style="background-color: white; font-size: 13px; width: 300px;">
					<tr>
						<td>当前预约数:</td>
						<td width="80px">${sessionScope.stuInfoMap.orderNumber }&nbsp;</td>
					</tr>
					<tr>
						<td>历史预约数:</td>
						<td>${sessionScope.stuInfoMap.allOrderNumber }</td>
					</tr>
					<tr>
						<td>累计缺席次数:</td>
						<td>${sessionScope.stuInfoMap.absenceNumber }</td>
					</tr>
					<tr>
						<td>累计迟到次数:</td>
						<td>${sessionScope.stuInfoMap.lateNumber }</td>
					</tr>
					<tr>
						<td>当前违纪积分:</td>
						<td>${sessionScope.stuInfoMap.violateScore }</td>
					</tr>
				</table>
				<p style="font-size: 12px; color: red;">*注:违纪积分达到6分(迟到+1,未预习+1,缺席+2),账号将被限制预约</p>
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

				<h2 class="stuindextable" style="width: 500px; height: 35px;">近&nbsp;期&nbsp;预&nbsp;约</h2>
				<table class="index-table"
					style="background-color: white; font-size: 13px; width: 500px;">
					<tr>
						<td>序号</td>
						<td>实验室</td>
						<td>工位</td>
						<td>实验项目</td>
						<td>实验开始时间</td>
						<td>实验教师</td>

					</tr>

					<%
						for (int i = 0; i < (lists.size() > 5 ? 5 : lists.size()); i++) {
							Order order = lists.get(i);
					%>
					<tr>
						<td><%=i + 1%></td>
						<td><%=order.getRoomName()%></td>
						<td><%=order.getRoomSitId() == null ? "0" : order.getRoomSitId()%></td>
						<td><%=order.getExperProjectAccount() == null ? "无" : order.getExperProjectAccount()%></td>
						<td><%=order.getStartTime()%></td>
						<td><%=order.getStuClass() != null ? order.getUserName() : "无"%></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div class="sbox" style="width: 300px; height: 200px;">
				<h2 class="stuindextable" style="width: 300px; height: 35px;">
					公&nbsp;告&nbsp;信&nbsp;息<a id="blink" href="javascript:void(0);"
						onclick="noticePage()" style="float: right">More&nbsp;</a>
				</h2>
				<table class="index-table"
					style="padding-left: 0px; font-size: 13px; background-color: white; width: 300px;">
					<tr>
						<td>标题</td>
						<td>发布日期</td>
					</tr>
					<tbody id="noticeListTable"></tbody>
				</table>
			</div>
			<div class="sbox"
				style="width: 200px; height: 0px; margin: 100px 50px;">
				<a href="javascript:void(0);" onclick="sendMSG()"> <img
					src="${pageContext.request.contextPath }/resources/img/msg.jpg"
					alt="" />
				</a>
			</div>

		</div>
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
				
		<div id="rule-table"
			style="margin: 0px 0px; padding: 0px; width: 784px; height: 100%;" />

			
	</div>
	<!-- 显示全部通知公告的提示框 -->
	<div id="allNotice-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 800px; height: 600px;">
		<div id="ntc-table"
			style="margin: 0px 0px; padding: 0px; width: 784px; height: 100%;" />
	</div>
	<!-- 显示回复消息 -->
	<div id="appealContent-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 400px; height: 360px; padding: 10px;">
		<div id="appeal-content"></div>
	</div>
	<script type="text/javascript">
	function sendMSG() {
		$("#sendmsg-dialog-form").form("clear");
		$("#sendmsg-dialog").dialog({
			title : "消息留言",
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
	function doSendMSG() {
		var msgContent = $("#msgContent").val();
		var data = {
			"content" : msgContent
		};
		$.ajax({
			url : "/laboratoryweb/msgStore",
			method : "post",
			data : data,
			success : function(data) {
				if (data == "ok") {
					$("#sendmsg-dialog").dialog("close");
					Alert("留言成功！");
				}else{
					Alert("系统异常,请重试..");
					
				}
			}
		})
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
		$(function() {
			findMsg();
			getNoticeList();
		})
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
		function findMsg() {
			$.ajax({
				async : false,
				url : "/laboratoryweb/findUserMsg",
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
			$
					.ajax({
						aysnc : false,
						url : "/laboratoryweb/getNoticeList",
						cache : false,
						method : "GET",
						success : function(data) {
							if (data == null || data == '') {
							} else {
								var str = ""
								for (var i = 0; i < (data.length>4?4:data.length); i++) {
									str += "<tr><td><a href='#' style='text-decoration:none; color:black;' onclick='showNoticeContent("
											+ data[i].noticePKID
											+ ")'>"
											+ data[i].headline.substring(0, 12)
											+ ".."
											+ "</a></td><td>"
											+ "["
											+ data[i].upDateTime.split(' ')[0]
											+ "]" + "</td></tr>";
								}
								$("#noticeListTable").html(str);
							}
						}
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
											width : 150,
											formatter : function(value, row,
													index) {

												return value.split(" ")[0];
											}
										},
										{
											field : " ",
											title : "公告内容",
											width : 100,
											formatter : function(value, row,
													index) {
												return "<a href='#' onclick='showNoticeContent("
														+ row.noticePKID
														+ ")'>" + "查看详细</a>";
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
								url : "/laboratoryweb/getPagerUserNMSG",
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
											width : 200
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
												return "<a href='javascript:void(0);' onclick='scanMSGContent("
														+ row.messagePKID
														+ ")'>" + "查看详细</a>";
											}
										}] ],
								striped : true
							});
		}
		function scanMSGContent(msgId) {
			$.ajax({
				async:false,
				url:"/laboratoryweb/readMsg",
				data:{"id": msgId},
				success:function(data){
					
				}
			});
			$("#msg-table").datagrid("reload");
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
				title : "申请消息",
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
											title : "标题",
											width : 400
										},
										{
											field : "uploadDate",
											title : "发布时间",
											width : 190,
											formatter : function(value, row,
													index) {

												return value.split(" ")[0];
											}
										},
										{
											field : " ",
											title : "详细内容",
											width : 190,
											formatter : function(value, row,
													index) {
												return "<a href='javascript:void(0);' onclick='showRuleContent("
														+ row.labRulePKID
														+ ")'>" + "查看详细</a>";
											}
										}
										 ] ],
								striped : true
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
				title : "内容	",
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
	</script>
</body>
</html>