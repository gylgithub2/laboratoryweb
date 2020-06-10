<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<table id="stat-table" style="width: 100%;height:100%;" />
	<div id="stat-tb">
		&nbsp;&nbsp;&nbsp; <select onchange="statSelectTable()"
			style="height: 25px;" id="statSelectTable">
			<option value="1">实验室人时数</option>
			<option value="2">教师人时数</option>
			<option value="3">学生人时数</option>
		</select> &nbsp;&nbsp;&nbsp; 查询日期:
		<div id="statSearcherdate" class="easyui-datebox"></div>

		&nbsp; 查询时间段: <input type="text" id="statSearcherTimesection"
			name="orderTimeSection" class="easyui-combotree"
			data-options="url:'/laboratoryweb/getAllTimeSection',multiple:false,panelHeight:233" />&nbsp;

		<span style="display: none;" id="statStudentIdbox"> 学生学号:
			<div id="statStudentId" class="easyui-numberbox"></div>&nbsp;
		</span> <span style="display: none;" id="statTeacherIdbox"> 教师工号:
			<div id="statTeacherId" class="easyui-numberbox"
				style="display: none;"></div>&nbsp;
		</span>  <a href="javascript:void(0);" data-options="iconCls:'icon-search'"
			onclick="statSearcher()" id="stat-search-btn" class="easyui-linkbutton">搜索</a>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#statSearcherdate').datebox('setValue', '-');
			$("#stat-table").datagrid({
				title : "实验室统计信息查看",
				pagination : true,
				pageSize : 13,
				pageList : [ 13, 50, 100 ],
				columns : [ [ {
					field : "date",
					title : "日期",
					width : 100
				}, {
					field : "timesection",
					title : "时间段",
					width : 100
				}, {
					field : "laboratoryName",
					title : "实验室名字",
					width : 150,
				}, {
					field : "laboratoryId",
					title : "实验室编号",
					width : 150,
				}, {
					field : "teacherName",
					title : "教师姓名",
					width : 100
				}, {
					field : "teacherAccount",
					title : "教师工号",
					width : 100
				}, {
					field : "studentName",
					title : "学生姓名",
					width : 100
				}, {
					field : "studentAccount",
					title : "学号",
					width : 100
				}, {
					field : "statisticnum",
					title : "人时数",
					width : 100
				} ] ],
				striped : true,
				toolbar : "#stat-tb",
			});
			$('#stat-table').datagrid({

				onDblClickCell : function(index, field, value) {
					$(this).datagrid('beginEdit', index);
					var ed = $(this).datagrid('getEditor', {
						index : index,
						field : field
					});
					$(ed.target).focus();
				}

			});

		});
		function statSearcher() {
			var id = $("#statSelectTable").val();
			var date = $("#statSearcherdate").val();
			var timesectionId = $("#statSearcherTimesection").val();
			if (date == "") {
				Alert("请选择日期!");
				return false;
			}
			if (timesectionId == "") {
				Alert("请选择时间段!");
				return false;
			}
			//动态的添加查询所需的账号(学生、老师、实验室)，以及数据地址
			var account;
			var url = "/laboratoryweb/searchStatistic";
			if (id == 1) {
				$('#stat-table').datagrid('showColumn', "laboratoryName");
				$('#stat-table').datagrid('showColumn', "laboratoryId");
				$('#stat-table').datagrid('hideColumn', "teacherName");
				$('#stat-table').datagrid('hideColumn', "teacherAccount");
				$('#stat-table').datagrid('hideColumn', "studentName");
				$('#stat-table').datagrid('hideColumn', "studentAccount");
				account = $("#statLaboratoryId").val();
			} else if (id == 2) {
				$('#stat-table').datagrid('showColumn', "teacherName");
				$('#stat-table').datagrid('showColumn', "teacherAccount");
				$('#stat-table').datagrid('hideColumn', "laboratoryName");
				$('#stat-table').datagrid('hideColumn', "laboratoryId");
				$('#stat-table').datagrid('hideColumn', "studentName");
				$('#stat-table').datagrid('hideColumn', "studentAccount");
				account = $("#statTeacherId").val();
			} else if (id == 3) {
				$('#stat-table').datagrid('showColumn', "studentName");
				$('#stat-table').datagrid('showColumn', "studentAccount");
				$('#stat-table').datagrid('hideColumn', "laboratoryName");
				$('#stat-table').datagrid('hideColumn', "laboratoryId");
				$('#stat-table').datagrid('hideColumn', "teacherName");
				$('#stat-table').datagrid('hideColumn', "teacherAccount");
				account = $("#statStudentId").val();
			}

			$("#stat-table").datagrid('options').url = url + "?id=" + id
					+ "&&date=" + date + "&&timesectionId=" + timesectionId
					+ "&&Account=" + account;
			$('#stat-table').datagrid('load');

		}
		function statSelectTable(data) {
			var id = $("#statSelectTable").val();
			if (id == 1) {
				$("#statLaboratoryIdbox").css("display", "");
				$("#statTeacherIdbox").css("display", "none");
				$("#statStudentIdbox").css("display", "none");
			} else if (id == 2) {
				$("#statLaboratoryIdbox").css("display", "none");
				$("#statTeacherIdbox").css("display", "");
				$("#statStudentIdbox").css("display", "none");
			} else if (id == 3) {
				$("#statLaboratoryIdbox").css("display", "none");
				$("#statTeacherIdbox").css("display", "none");
				$("#statStudentIdbox").css("display", "");
			}
		}
	</script>
</body>
</html>