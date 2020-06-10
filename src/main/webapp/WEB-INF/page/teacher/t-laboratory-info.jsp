<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<table id="lab-table" style="width: 100%;height:100%;" />
	<div id="lab-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			class="easyui-linkbutton" onclick="orderLab()">预约</a> &nbsp;实验室名:
		<div id="search-lab-name" prompt="实验室名字..."
			class="easyui-textbox"></div>

		&nbsp; <a href="javascript:void(0);" data-options="iconCls:'icon-search'"
			id="lab-search-btn" class="easyui-linkbutton">搜索</a>
	</div>

	<!-- 增加的提示框 -->
	<div id="lab-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 350px; height: 420px; padding: 10px;">
		</div>
	<script type="text/javascript">
		$(function() {
			$("#lab-table").datagrid({
				title : "实验室信息表",
				url : "/laboratoryweb/getPagerLaboratorys",
				pagination : true,
				pageSize : 14,
				pageList : [ 14, 50, 100 ],
				columns : [ [ {
					field : "laboratoryPKID",
					hidden : true,
					title : "laboratoryPKID",
				}, {
					field : "laboratoryId",
					title : "实验室编号",
					width : 100
				}, {
					field : "laboratoryName",
					title : "实验室名字",
					width : 100
				}, {
					field : "laboratorySitNum",
					title : "实验室座位数量",
					width : 100
				}, {
					field : "laboratoryStatus",
					title : "实验室状态",
					width : 100
				}, ] ],
				striped : true,
				toolbar : "#lab-tb",
				singleSelect:true
			});
			$("#lab-search-btn").click(
					function() {
						var laboratoryName = $("#search-lab-name")
								.textbox("getValue");
						var queryParam = $("#lab-table").datagrid(
								"options").queryParams;
						queryParam.laboratoryName = laboratoryName;
						$("#lab-table").datagrid("load");
					});
		});
		function orderLab() {
			var rows = $("#lab-table").datagrid("getSelections");
			if (rows.length != 1) {
				$.messager.Alert("提示", "请选择一条信息", "info");
			} else {
				var laboratory = rows[0];
				var data = {
					"labId" : laboratory["laboratoryPKID"],
					"laboratoryName" : laboratory["laboratoryName"],
					"laboratoryId" : laboratory["laboratoryId"],
					
				};
				$.ajax({
					async : true,
					data : data,
					url : "/laboratoryweb/saveOrderData",
					type : "get",
					success : function(data) {
						if (data != "ok") {
							Alert("系统异常,请重试");
							return false;
						}else{
							$('#lab-dialog').dialog('refresh',
							'/laboratoryweb/teacherOrder');
							$("#lab-dialog").dialog({
								title : "预约实验室",
								closed : false,
								cache : false,
								modal : true,
								buttons : [ //按钮
								{
									text : "确定",
									iconCls : "icon-ok",
									handler : laboratory_order
								}, {
									text : '取消',
									iconCls : "icon-cancel",
									handler : function() {
										$("#lab-dialog").dialog("close");
									}
								} ],
							});
						}
					}

				});
	
			}
		}
		function laboratory_order() {
			doAjaxOrder("/laboratoryweb/orderLaboratory");
		}
		function doAjaxOrder(param) {
			var experProject = $("#experProject").val();
			var laboratoryId = $("#laboratoryId").val();
			var stuClass = $("#stuClass").val();
			var orderTimeSectionId = $("#orderTimeSectionId").val();
			var orderDay = $("#orderDay").val();
			if (orderDay == "" || orderTimeSectionId == "") {
				Alert("请填写完整信息");
				return false;
			}
			var loadData = {
				"experProjectId" : experProject,
				"laboratoryId" : laboratoryId,
				"stuClass" : stuClass,
				"orderTimeSectionId" : orderTimeSectionId,
				"orderDay" : orderDay
			};
			$.ajax({
				url : param,
				method : "post",
				data : loadData,
				success : function(data) {
					if (data == "ok") {
						$("#lab-dialog").dialog("close");
						Alert("预约成功,请留意批准信息.....");
					} else if (data == "twrongday") {
						var myDate = new Date;
						var year = myDate.getFullYear(); //获取当前年
						var mon = myDate.getMonth() + 1; //获取当前月
						var date = myDate.getDate();
						Alert("日期应为:" + year + "-" + mon + "-" + date + "后的30天内");
					} else if(data == "labForbidden"){
						Alert("实验室不可用");
					} else if(data == "classordered"||data == "ordered"){
						Alert("实验室已被占用");						
					} else if(data == "forbidden"){
						Alert("账号被禁用,请联系管理员..");
					} else if(data == "overStuNum"){
						Alert("班级人数超出!");
					} else{
						Alert("系统异常,请重试..");						
					}
				}
			});
		}
	</script>

</body>
</html>