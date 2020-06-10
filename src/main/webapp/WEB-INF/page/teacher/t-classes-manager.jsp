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
	<table id="my-class-table" style="width: 100%; height: 100%;" />
	<div id="my-class-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-remove'"
			id="removebutton" class="easyui-linkbutton" onclick="deleteClass()">删除</a>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#my-class-table").datagrid({
				title : "班级信息表",
				url : "/laboratoryweb/getAllPageTeacherClasses",
				pagination : true,
				striped : true,
				pageSize : 13,
				pageList : [ 13, 50, 100 ],
				toolbar : "#my-class-tb",
				columns : [ [ {
					field : "stuClassPKID",
					title : "stuClassPKID",
					hidden : true
				}, {
					field : "stuClassName",
					title : "班级名字",
					width : 150
				}, {
					field : "stuClassId",
					title : "班级编号",
					width : 100
				}, {
					field : "stuNum",
					title : "学生数量",
					width : 100
				}, {
					field : "department",
					title : "所属院系",
					width : 150
				} ] ]
			});
		});
		function deleteClass() {
			var rows = $("#my-class-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确定删除?", function(result) {
					if (result) {
						var ids = [];
						$(rows).each(function() {
							ids.push(this.stuClassPKID);
						});
						$.ajax({
							url : "/laboratoryweb/deleteMyClass",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "ok") {
									$("#my-class-table").datagrid("reload");
									Alert("ok!");
								} else {
									Alert("删除失败！");
								}
							}
						});
					}
				})
			} else {
				$.messager.Alert("提示", "请至少选择一个用户！", "info");
			}
		}
	</script>
</body>
</html>