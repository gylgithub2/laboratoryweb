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
	<table id="class-table" style="width: 100%; height: 100%;" />
	<div id="class-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			id="add-to-manager" class="easyui-linkbutton" onclick="addManager()">管理该班级</a>
		&nbsp;班级名:
		<div id="search-class-name" class="easyui-textbox"></div>
		&nbsp;班级编号:
		<div id="search-class-id" class="easyui-numberbox"></div>
		&nbsp;学院: <input type="text" id="search-department"
			name="search-department" class="easyui-combotree"
			data-options="url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203" />&nbsp;
		<a href="javascript:void(0);" data-options="iconCls:'icon-search'"
			id="stuClass-seacher-btn" class="easyui-linkbutton">查询</a>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#class-table").datagrid({
				title : "&nbsp;&nbsp;&nbsp;&nbsp;教师信息表",
				url : "/laboratoryweb/getPageClasses",
				pagination : true,
				pageList : [ 10, 20 ],
				columns : [ [ {
					field : "ck",
					checkbox : "true"
				}, {
					field : "stuClassPKID",
					hidden : true,
					title : "stuClassPKID",
				}, {
					field : "stuClassName",
					title : "班级名字",
					width : 100
				}, {
					field : "stuNum",
					title : "班级人数",
					width : 100
				}, {
					field : "stuClassId",
					title : "班级编号",
					width : 100
				}, {
					field : "department",
					title : "学院",
					width : 150,
					formatter : function(value, row, index) {
						var departmentName;
						$.ajax({
							async : false,
							url : "/laboratoryweb/getClassDepartName",
							method : "get",
							data : {
								"departmentId" : value
							},
							success : function(data) {
								departmentName = data;
							}
						});
						return departmentName;
					}
				} ] ],
				striped : true,
				toolbar : "#class-tb",
				singleSelect : true
			});
			//保存修改id
			var editIndex;
			$("#stuClass-seacher-btn")
					.click(
							function() {
								var stuClassId = $("#search-class-id")
										.numberbox("getValue");
								var stuClassName = $("#search-class-name")
										.textbox("getValue");
								var searchDepartment = $("#search-department")
										.textbox("getValue");
								var queryParam = $("#class-table").datagrid(
										"options").queryParams;
								queryParam.stuClassId = stuClassId;
								queryParam.stuClassName = stuClassName;
								queryParam.searchDepartment = searchDepartment;
								$("#class-table").datagrid("load");
							});
		});
		function addManager() {
			var rows = $("#class-table").datagrid("getSelections");
			if (rows.length >= 1) {
				var stuClass = rows[0];
				$.messager.confirm("提示", "确定将" + stuClass.stuClassName
						+ "添加至我的管理班级?", function(result) {
					if (result) {
						$.ajax({
							async : false,
							method : "GET",
							url : "/laboratoryweb/addManagerClass",
							data : {
								"stuClassPKID" : stuClass.stuClassPKID
							},
							success : function(data) {
								if (data == "ok") {
									Alert("添加管理成功");
									$("#class-table").datagrid("reload");
								} else {
									Alert("删除失败！");
								}
							}

						});

					}
				})
			} else {
				$.messager.Alert("提示", "请选择一个班级！", "info");
			}
		}
		function classCancel() {
			$("#class-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>