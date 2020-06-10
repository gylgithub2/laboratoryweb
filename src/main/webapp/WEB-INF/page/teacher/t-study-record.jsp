<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<table id="studyRecordTable" style="width: 100%; height: 100%;" />
	<div id="studyRecordtb"></div>
	<!-- 增加的提示框 -->
	<div id="unPreStudyStu_dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 410px; padding: 10px;"></div>
	<script type="text/javascript">
		$(function() {
			$("#studyRecordTable")
					.datagrid(
							{
								title : "学生实验预习情况",
								url : "/laboratoryweb/getPassOrderByAccount",
								pagination : true,
								striped : true,
								pageSize : 15,
								pageList : [ 15, 20 ],
								columns : [ [
										{
											field : "orderPKID",
											hidden : true,
											title : "orderPKID",
										},
										{
											field : "roomId",
											title : "实验室",
											width : 100
										},
										{
											field : "orderTime",
											title : "预约时间",
											width : 150
										},
										{
											field : "startTime",
											title : "开始时间",
											width : 150
										},
										{
											field : "endTime",
											title : "结束时间",
											width : 150
										},
										{
											field : "stuClass",
											title : "班级",
											width : 100
										},

										{
											field : "experProjectAccount",
											title : "实验项目",
											width : 100
										},

										{

											field : "preStudy",
											title : "已完成预习人数/总人数",
											width : 170,
											formatter : function(value, row,
													index) {
												var num;
												var data = {
													"orderPKID" : row.orderPKID,
													"stuClassId" : row.stuClass
												};
												$
														.ajax({
															async : false,
															data : data,
															url : "/laboratoryweb/getPreStudyNum",
															type : "post",
															success : function(
																	data) {
																num = data.preStudyStuNum
																		+ "/"
																		+ data.studentNum;
															}
														})
												return num;
											}

										},
										{
											field : "  ",
											title : "未预习学生",
											width : 100,
											formatter : function(value, row,
													index) {

												var btn = '<a class="unPreStudy" onclick="unPreStudy('
														+ row.orderPKID
														+ ')"  href="javascript:void(0)"></a>';
												return btn;

											},
											styler : function(value, row, index) {

											}

										} ] ],
								onLoadSuccess : function(data) {
									$('.unPreStudy').linkbutton({
										text : '学生信息',
										plain : true,
										iconCls : 'icon-serchar'
									});
								},
								singleSelect : true,
								striped : true,
								toolbar : "#studyRecordtb",
							});
			$("#seacherbutton").click(
					function() {
						var dimWord = $("#dimSeacher").textbox("getValue");
						var queryParam = $("#studyRecordTable").datagrid(
								"options").queryParams;
						queryParam.dimWord = dimWord;
						$("#studyRecordTable").datagrid("load");
					});
		});

		function unPreStudy(orderPKID) {
			var data = {
				"orderPKID" : orderPKID,
			};
			$.ajax({
				async : false,
				url : "/laboratoryweb/setWatches",
				type : "POST",
				data : data,
				success : function(data) {
				}
			});
			$('#unPreStudyStu_dialog').dialog('refresh',
					'/laboratoryweb/unPreStudyStu');
			$("#unPreStudyStu_dialog").dialog({
				onOpen : function() {
				},
				title : "未预习学生列表",
				closed : false,
				modal : true,
				buttons : [ {
					text : '关闭',
					iconCls : "icon-cancel",
					handler : function() {
						$("#unPreStudyStu_dialog").dialog("close");
					}
				} ]
			});
		}
	</script>

</body>
</html>