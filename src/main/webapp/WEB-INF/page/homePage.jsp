<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<title></title>
</head>
<body>
	<style type="text/css">
.box {
	margin: 0px 0px;
	width: 900px;
	height: 70%;
}

.row：after, .row::before {
	clear: both;
	display: table;
}

.stuindex {
	width: 100%;
	height: 613px;
	background-image:
		url(${pageContext.request.contextPath }/resources/img/subg.jpg);
	background-size: 100% 613px;
	margin: 0px 0px;
}

.sbox {
	width: 32%;
	height: 68%;
	float: left;
	margin: 3px;
}

a {
	text-decoration: none;
}

h1 a {
	color: red;
	font-size: 20px;
}

h1 a:hover {
	background-color: #a62d2d;
	color: #fff;
}

.hpindex {
	width: 900px;
	height: 613px;
	margin: 0px;
}

.hpHeadLine {
	width: 100%;
	height: 20%;
	color: #8B0000;
	box-shadow: 3px 3px 10px black;
	line-height: 100px;
	background-image:
		url(${pageContext.request.contextPath }/resources/img/headbg.jpg);
	background-size: 100% 100%;
	text-align: center;
	font-family: 'Times New Roman', Georgia, Serif;
	font-size: 40px;
}

h3 {
	margin: auto;
	width: 300px;
	height: 35px;
	color: white;
	background-color: #4D7262;
}
</style>

	<div class="hpindex" style="margin-left: 20%; margin-top: 10px;">

		<div>
			<h1 class="hpHeadLine">实验室预约管理系统</h1>
			<p id="timep" style="float: right; margin: 5px 20px;"></p>

			<div
				style="width: 100px; margin: 0px 3px; height: 30px; background-color: #74B7E1; text-align: center; border-radius: 4px;">
				<a href="login" type="get"
					style="text-decoration: none; font-size: 20px; font-weight: bold; color: #8B0000;">登录</a>

			</div>
			<hr />

		</div>
		<br />
		<div class="box row">
			<div class="sbox" style="margin: -20px 3px;">
				<h3 style="width: 100%; height: 35px;">
					&nbsp;通知公告<a id="blink" href="javascript:void(0);"
						onclick="noticePage()" style="float: right">More&nbsp;</a>
				</h3>
				<table class="index-table"
					style="background-color: white; color: black; font-size: 13px; width: 100%;">
					<tbody id="noticeListTable"></tbody>
				</table>
			</div>

			<div class="sbox" style="margin: -20px 3px;">
				<h3 style="width: 100%; height: 35px;">
					&nbsp;规章制度<a id="blink3" href="javascript:void(0);"
						onclick="rulePage()" style="float: right">More&nbsp;</a>
				</h3>
				<table class="index-table"
					style="padding-left: 0px; font-size: 13px; background-color: white; width: 100%;">
					<tbody id="RuleTable"></tbody>
				</table>
			</div>
			<div class="sbox" style="margin: -20px 3px;">
				<h3 style="width: 100%; height: 35px;">&nbsp;实验室使用排行</h3>
				<table class="index-table"
					style="padding-left: 0px; font-size: 13px; background-color: white; width: 100%;">
					<thead>
						<tr>
							<td>序号</td>
							<td>实验室名称</td>
							<td>累计人时数</td>
						</tr>
					</thead>
					<tbody id="labRankListTable"></tbody>
				</table>
			</div>
			<div class="sbox" style="width: 25%; margin: -50px 3px;">
				<h3 style="width: 100%; height: 35px;">
					&nbsp;开放性实验<a id="blink1" href="javascript:void(0);"
						onclick="expPage()" style="float: right">More&nbsp;</a>
				</h3>
				<table class="index-table"
					style="padding-left: 0px; font-size: 13px; background-color: white; width: 100%;">
					<thead>
						<tr>
							<td>序号</td>
							<td>实验室名称</td>
						</tr>
					</thead>
					<tbody id="experProjectListTable"></tbody>
				</table>
			</div>
			<div class="sbox" style="width: 25%; margin: -50px 3px;">
				<h3 style="width: 100%; height: 35px;">
					&nbsp;实验室开放<a id="blink2" href="javascript:void(0);"
						onclick="labPage()" style="float: right">More&nbsp;</a>
				</h3>
				<table class="index-table"
					style="padding-left: 0px; font-size: 13px; background-color: white; width: 100%;">
					<thead>
						<tr>
							<td>序号</td>
							<td>实验室名称</td>
						</tr>
					</thead>
					<tbody id="labList"></tbody>
				</table>
			</div>
			<img src="${pageContext.request.contextPath }/resources/img/hpc.jpg"
				style="margin: -50px 3px;" width="350px" height="250px" alt="" />

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
		<!-- 显示实验室规章制度的提示框 -->
		<div id="ruleContent-dialog" class="easyui-dialog"
			data-options="closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 600px; padding: 10px;">

			<div id="rule-head"
				style="font-weight: bold; font-size: 20px; text-align: center;"></div>
			<hr />
			<div id="rule-date" style="text-align: center;"></div>
			<br />
			<div id="rule-content" style="text-indent: 2em; line-height: 30px;"></div>
		</div>
		<!-- 显示全部规章制度的提示框 -->
		<div id="allRule-dialog" class="easyui-dialog"
			data-options="closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 600px;">
			<table id="rules-table"
				style="margin: 0px 0px; padding: 0px; width: 785px; height: 100%;" />
		</div>
		<!-- 显示全部通知公告的提示框 -->
		<div id="allNotice-dialog" class="easyui-dialog"
			data-options="closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 600px;">
			<div id="ntc-table"
				style="margin: 0px 0px; padding: 0px; width: 784px; height: 100%;" />
		</div>
		<!-- 显示全部实验项目的提示框 -->
		<div id="allexp-dialog" class="easyui-dialog"
			data-options="closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 600px;">
			<span id="exp-table"
				style="margin: 0px 0px; padding: 0px; width: 784px; height: 100%;" />
		</div>
		<!-- 显示全部实验室的提示框 -->
		<div id="alllab-dialog" class="easyui-dialog"
			data-options="closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 600px;">
			<span id="lab-table"
				style="margin: 0px 0px; padding: 0px; width: 784px; height: 100%;" />
		</div>

	</div>

	<script type="text/javascript">
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
			$("#rule-content").text(content);
			$("#rule-head").text(headline);
			$("#rule-date").text(date.split(' ')[0]);
			$("#ruleContent-dialog").dialog({
				title : "详细内容",
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
		$(function() {
			var myDate = new Date;
			var year = myDate.getFullYear(); //获取当前年
			var mon = myDate.getMonth() + 1; //获取当前月
			var date = myDate.getDate(); //获取当前日
			var week = myDate.getDay();
			var weeks = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
			$("#timep").html(
					"今天是" + year + "-" + mon + "-" + date + "    "
							+ weeks[week]);
			getNoticeList();
			getRuleList();
			getLabRankList();
			getExperPjtList();
			getLabList();
			
		})
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
				}
				]
			});
		}
		function rulePage() {
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
				}

				]
			});
		}
		function expPage() {
			changeExpPage();
			$("#allexp-dialog").dialog({
				title : "",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#allexp-dialog").dialog("close");
					}
				}

				]
			});
		}
		function labPage() {
			changeLabPage();
			$("#alllab-dialog").dialog({
				title : "",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#alllab-dialog").dialog("close");
					}
				}

				]
			});
		}
		function getNoticeList() {
			$.ajax({    async : false,//同步方式
						url : "/laboratoryweb/getNoticeList",//请求地址
						cache : false,//缓存关闭
						method : "GET",//GET方式请求
						success : function(data) {//AJAX回调函数
							if (data == null || data == '') {
							} else {
								var str = "";
								//动态刷新页面
								for (var i = 0; i < data.length; i++) {
									str += "<tr><td><a href='#' style='text-decoration:none; color:black;' 	"
									+"onclick='showNoticeContent("
											+ data[i].noticePKID
											+ ")'>"
											+ data[i].headline.substring(0, 12)
											+ ".."
											+ "</a></td><td>"
											+ "["
											+ data[i].upDateTime.split(' ')[0]
											+ "]" + "</td></tr>";
								}
								//更新公告表格的内部数据
								$("#noticeListTable").html(str);
							}
						}
					});
		}
		function getRuleList() {
			$
					.ajax({
						async : false,
						url : "/laboratoryweb/getRuleList",
						cache : false,
						method : "GET",
						success : function(data) {
							if (data == null || data == '') {
							} else {
								var str = ""
								for (var i = 0; i < data.length; i++) {
									str += "<tr><td><a href='javascript:void(0);' style='text-decoration:none; color:black;' onclick='showRuleContent("
											+ data[i].labRulePKID
											+ ")'>"
											+ data[i].headline.substring(0, 12)
											+ ".."
											+ "</a></td><td>"
											+ "["
											+ data[i].uploadDate.split(' ')[0]
											+ "]" + "</td></tr>";
								}
								$("#RuleTable").html(str);
							}
						}
					});
		}
		function getLabRankList() {
			$.ajax({
				async : false,
				url : "/laboratoryweb/getLabRankList",
				cache : false,
				method : "GET",
				success : function(data) {
					if (data == null || data == '') {
					} else {
						var str = "";
						for (var i = 0; i < data.length; i++) {
							var time = 2;
							$.ajax({
								async : false,
								url : "/laboratoryweb/getLabTime",
								data:{"id":data[i].laboratoryId},
								method : "GET",
								success : function(data) {
									time = data;
						
									return time;
								}
							});
							str += "<tr><td>" + (i + 1) + "</td><td>"
									+ data[i].laboratoryName + "</td><td>"
									+ Math.round(time/24) +"天"+ "</td></tr>";
						}
						$("#labRankListTable").html(str);
					}
				}
			});
		}
		function getExperPjtList() {
			$.ajax({
				async : false,
				url : "/laboratoryweb/getExperPjtList",
				cache : false,
				method : "GET",
				success : function(data) {
					if (data == null || data == '') {
					} else {
						var str = "";
						for (var i = 0; i < (data.length>5?5: data.length); i++) {
							str += "<tr><td>" + (i + 1) + "</td><td>"
									+ data[i].experimentalProjectName + "</td></tr>";
						}
						$("#experProjectListTable").html(str);
					}
				}
			});
		}
		function getLabList() {
			$.ajax({
				async : false,
				url : "/laboratoryweb/getLabList",
				cache : false,
				method : "GET",
				success : function(data) {
					if (data == null || data == '') {
					} else {
						var str = "";
						for (var i = 0; i < (data.length>5?5: data.length); i++) {
							str += "<tr><td>" + (i + 1) + "</td><td>"
									+ data[i].laboratoryName + "</td></tr>";
						}
						$("#labList").html(str);
					}
				}
			});
		}
		//显示学生请求
		function changeNoticePage() {
			$("#ntc-table").datagrid({
				title : "&nbsp;&nbsp;&nbsp;&nbsp;全部公告",
				url : "/laboratoryweb/getPagerNotice",
				pagination : true,
				pageSize : 13,
				singleSelect:true,
				pageList : [ 13, 50, 100 ],
				columns : [ [ { 
					field : "headline",
					title : "公告标题",
					width : 532
				}, {
					field : "upDateTime",
					title : "发布时间",
					width : 150,
					formatter:function(value, row, index) {
			
						return value.split(" ")[0];
					}
				}, {
					field : " ",
					title : "公告内容",
					width : 100,
					formatter:function(value, row, index) {
						return "<a href='#' onclick='showNoticeContent("+ row.noticePKID
						+ ")'>"+"查看详细</a>";
					}
				} ] ],
				striped : true
			});
		}
		function changeRulePage() {
			$("#rules-table").datagrid({
				title : "&nbsp;&nbsp;&nbsp;&nbsp;全部规章制度",
				url : "/laboratoryweb/getPagerRule",
				pagination : true,
				pageSize : 13,
				singleSelect:true,
				pageList : [ 13, 50, 100 ],
				columns : [ [ { 
					field : "headline",
					title : "标题",
					width : 532
				}, {
					field : "uploadDate",
					title : "发布时间",
					width : 150,
					formatter:function(value, row, index) {
			
						return value.split(" ")[0];
					}
				}, {
					field : " ",
					title : "详细内容",
					width : 100,
					formatter:function(value, row, index) {
						return "<a href='#' onclick='showRuleContent("+ row.labRulePKID
						+ ")'>"+"查看详细</a>";
					}
				} ] ],
				striped : true
			});
		}
		function changeExpPage() {
			$("#exp-table").datagrid({
				title : "&nbsp;&nbsp;&nbsp;&nbsp;项目列表",
				url : "/laboratoryweb/getPagerExperProjects",
				pagination : true,
				pageSize : 13,
				singleSelect:true,
				pageList : [ 13, 50, 100 ],
				columns : [ [
					{
						field : "experProjectPKID",
						title : "序号",
						width : 132
					},{ 
					field : "experimentalProjectName",
					title : "项目名字",
					width : 532
				} ] ],
				striped : true
			});
		}
		function changeLabPage() {
			$("#lab-table").datagrid({
				title : "&nbsp;&nbsp;&nbsp;&nbsp;项目列表",
				url : "/laboratoryweb/getPagerLaboratorys",
				pagination : true,
				pageSize : 13,
				singleSelect:true,
				pageList : [ 13, 50, 100 ],
				columns : [ [
					{
						field : "laboratoryPKID",
						title : "序号",
						width : 132
					},{ 
					field : "laboratoryName",
					title : "实验室",
					width : 532
				} ] ],
				striped : true
			});
		}
	</script>
</body>
</html>