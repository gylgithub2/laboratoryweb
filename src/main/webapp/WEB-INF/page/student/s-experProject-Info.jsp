<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>

<body>
	<table id="experProjectTable" style="width: 100%; height: 100%;" />
	<div id="experProject_tb">
		&nbsp;实验室名:
		<div id="seacher_experProjectName" class="easyui-textbox"></div>
		&nbsp; <a href="#" data-options="iconCls:'icon-search'"
			id="seacherbutton" class="easyui-linkbutton">搜索</a>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#experProjectTable")
					.datagrid(
							{
								title : "项目信息表",
								url : "/laboratoryweb/getPagerExperProjects",
								pagination : true,
								singleSelect : true,
								pageSize : 14,
								pageList : [ 14, 20 ],
								columns : [ [
										{
											field : "experimentalProjectId",
											sortable : true,
											title : "编号",
											width : 100
										},
										{
											field : "laboratory",
											title : "实验室",
											formatter : function(value, row,
													index) {
												return value.laboratoryName;
											}
										},
										{
											field : "experimentalProjectName",
											title : "项目名字",
											width : 100
										}] ],
								striped : true,
								toolbar : "#experProject_tb"
							});
			$("#seacherbutton").click(
					function() {
						var experProjectName = $("#seacher_experProjectName")
								.textbox("getValue");
						var queryParam = $("#experProjectTable").datagrid(
								"options").queryParams;
						queryParam.experProjectName = experProjectName;
						$("#experProjectTable").datagrid("load");
					});

		});
	</script>

</body>
</html>