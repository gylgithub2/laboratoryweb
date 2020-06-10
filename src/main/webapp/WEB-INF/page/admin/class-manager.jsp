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
			id="addbutton" class="easyui-linkbutton" onclick="addClass()">添加</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-save'" id="updatebutton"
			class="easyui-linkbutton" onclick="updateClass()">修改</a>&nbsp; <a
			href="javascript:void(0);" data-options="iconCls:'icon-remove'"
			id="removebutton" class="easyui-linkbutton" onclick="deleteClass()">删除</a>
		
			
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-cancel'" id="classCancelbutton"
			class="easyui-linkbutton" onclick="classCancel()">取消选择</a> &nbsp;班级名:
		<div id="searchClassName" class="easyui-textbox"></div>
		&nbsp;班级编号:
		<div id="searchClassId" class="easyui-numberbox"></div>
		&nbsp;学院: <input type="text" id="searchClassDepartment"
			name="searchClassDepartment" class="easyui-combotree"
			data-options="url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203" />&nbsp;
		<a href="javascript:void(0);" data-options="iconCls:'icon-search'"
			id="stuClass-seacher-btn" class="easyui-linkbutton">查询</a>
	</div>

	<!-- 增加的提示框 -->
	<div id="class-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 300px; height: 330px; padding: 10px;">
		<form id="class-dialog-form" method="post">
			<table>
				<tr>
					<td width="60px" align="right">班级名 <input id="stuClassPKID"
						name="stuClassPKID" type="hidden" /> <input type="hidden"
						id="class-stuNum" name="stuNum" class="easyui-numberbox" /></td>
					<td><input type="text" id="class-stuClassName"
						name="stuClassName" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">班级编号</td>
					<td><input type="text" id="class-stuClassId" name="stuClassId"
						class="easyui-numberbox" /></td>
				</tr>


				<tr>
					<td width="60px" align="right">所属学院</td>
					<td><input type="text" id="class-department" name="department"
						class="easyui-combotree"
						data-options="url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203" /></td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			$("#class-table").datagrid({
				title : "&nbsp;&nbsp;&nbsp;&nbsp;教师信息表",
				url : "/laboratoryweb/getPageClasses",
				pagination : true,
				pageSize : 15,
				pageList : [ 15, 50, 100 ],
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

			});
			//保存修改id
			var editIndex;
			$("#stuClass-seacher-btn")
					.click(
							function() {
								var stuClassId = $("#searchClassId").numberbox(
										"getValue");
								var stuClassName = $("#searchClassName")
										.textbox("getValue");
								var searchDepartment = $(
										"#searchClassDepartment").textbox(
										"getValue");
								var queryParam = $("#class-table").datagrid(
										"options").queryParams;
								queryParam.stuClassId = stuClassId;
								queryParam.stuClassName = stuClassName;
								queryParam.searchDepartment = searchDepartment;
								$("#class-table").datagrid("load");
							});
		});
		function addClass() {
			$("#class-dialog-form").form("clear");
			$("#class-dialog").dialog({
				title : "增加班级",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : "确定",
					iconCls : "icon-ok",
					handler : class_add
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#class-dialog").dialog("close");
					}
				}

				]
			});
		}
		function updateClass() {
			$("#class-dialog-form").form("clear");
			var rows = $("#class-table").datagrid("getSelections");
			if (rows.length != 1) {
				$.messager.alert("提示", "请选择一条数据", "info");
			} else {
				var stuClass = rows[0];
				//表单绑定数据
				$("#class-dialog-form").form("load", stuClass);
				$("#class-dialog").dialog({
					title : "修改班级信息",
					closed : false,
					modal : true,
					buttons : [ //按钮
					{
						text : "确定",
						iconCls : "icon-ok",
						handler : class_update
					}, {
						text : '取消',
						iconCls : "icon-cancel",
						handler : function() {
							$("#class-dialog").dialog("close");
						}
					}

					]
				});
			}
		}
		function class_add() {
			doAjaxC("/laboratoryweb/addClass");
		}
		function class_update() {
			doAjaxC("/laboratoryweb/updateClass");
		}
		function doAjaxC(param) {
			$.ajax({
				url : param,
				method : "post",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify({
					stuClassPKID : $("#stuClassPKID").val(),
					stuClassName : $("#class-stuClassName").val(),
					stuClassId : $("#class-stuClassId").val(),
					stuNum : $("#class-stuNum").val(),
					department : $("#class-department").val()
				}),
				success : function(data) {
					if (data == "ok") {
						$("#class-dialog").dialog("close");
						$("#class-table").datagrid("reload");
						Alert("操作成功");
					} else {
						Alert("操作失败！");
					}
				}
			})
		}

		function deleteClass() {
			var rows = $("#class-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确定删除?", function(result) {
					if (result) {
						var ids = [];
						$(rows).each(function() {
							ids.push(this.stuClassPKID);
						});
						$.ajax({
							url : "/laboratoryweb/deleteClass",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "ok") {
									$("#class-table").datagrid("reload");
									Alert("删除成功!");
								} else if (data == "hasStudent") {
									Alert("该班级尚有学生信息,无法删除");
								} else {
									Alert("该班级无法删除,请断开与教师的关联！");
								}
							}

						});

					}
				})
			} else {
				$.messager.alert("提示", "请至少选择一个用户！", "info");
			}
		}
		function classCancel() {
			$("#class-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>