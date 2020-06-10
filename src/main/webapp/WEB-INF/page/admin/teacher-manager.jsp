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
	<table id="teacher-table" style="width: 100%; height: 100%;" />
	<div id="teacher-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			id="addbutton" class="easyui-linkbutton" onclick="addTeacher()">添加</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-save'" id="updatebutton"
			class="easyui-linkbutton" onclick="updateTeacher()">修改</a>&nbsp; <a
			href="javascript:void(0);" data-options="iconCls:'icon-remove'"
			id="removebutton" class="easyui-linkbutton" onclick="deleteTeacher()">删除</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-cancel'" id="cancelbutton"
			class="easyui-linkbutton" onclick="cancelT()">取消选择</a> &nbsp; 账号:
		<div id="searchTeacherAccount" class="easyui-numberbox"></div>
		&nbsp;用户名:
		<div id="searchTeacherName" class="easyui-textbox"></div>

		&nbsp;学院: <input type="text" id="searchDepartment"
			name="searchDepartment" class="easyui-combotree"
			data-options="url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203" />&nbsp;
		<a href="javascript:void(0);" data-options="iconCls:'icon-search'"
			id="teacher-search-btn" class="easyui-linkbutton">查询</a>
	</div>

	<!-- 增加的提示框 -->
	<div id="teacher-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 320px; height: 360px; padding: 10px;">
		<form id="teacher-dialog-form" method="post">
			<table>
				<tr>
					<td width="60px" align="right">教师名 <input id="teacherPKID"
						name="teacherPKID" type="hidden" /></td>
					<td><input type="text" id="t-teacherName" name="teacherName"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">工号</td>
					<td><input type="text" id="t-teacherAccount"
						name="teacherAccount" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">密码</td>
					<td><input type="text" id="t-teacherPassword"
						name="teacherPassword" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">状&nbsp;态:&nbsp;</td>
					<td><input type="text" id="teacher-status" name="status"
						class="easyui-combotree" data-options="panelHeight:99" /></td>
				</tr>
				<tr>
					<td width="80px" align="right">所属学院</td>
					<td><input type="text" id="t-department" name="department"
						class="easyui-combotree"
						data-options="url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203" /></td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">

		$(function() {
			$('#teacher-status').combotree('loadData', [ {
				id : 1,
				text : '正常',
			}, {
				id : 2,
				text : '禁用',
			} ]);
			$("#teacher-table").datagrid({
				title : "&nbsp;&nbsp;&nbsp;&nbsp;教师信息表",
				url : "/laboratoryweb/getPagerTeachers",
				pagination : true,
				pageSize : 15,
				pageList : [ 15, 50, 100 ],
				columns : [ [ {
					field : "ck",
					checkbox : "true"
				}, {
					field : "teacherPKID",
					hidden : true,
					title : "teacherPKID"
				}, {
					field : "teacherAccount",
					title : "工号",
					width : 100
				}, {
					field : "teacherName",
					title : "名字",
					width : 100
				}, {
					field : "department",
					title : "学院",
					width : 150,
					formatter : function(value, row, index) {
						var departmentName;
						$.ajax({
							async : false,
							url : "/laboratoryweb/getTeacherDepart",
							method : "get",
							datatype : "json",
							data : {
								"teacherId" : row.teacherPKID
							},
							success : function(data) {
								departmentName = data.text;
							}
						});
						return departmentName;
					}
				},{
					field : "status",
					title : "状态",
					width : 100,
					formatter : function(value, row,
							index) {
						if (value == "2") {
							return "禁用";
						} else if (value == "1") {
							return "正常";
						}
					},
					styler : function(value, row, index) {
						if (value == 1) {
							return 'tetx-align:center;background-color:#60D41F;color:white;';
						} else {
							return 'background-color:#E22018;color:white;';
						}
					}
				}  ] ],
				striped : true,
				toolbar : "#teacher-tb",
				singleSelect : true
			});
			//保存修改id
			var editIndex;
			$("#teacher-search-btn").click(
					function() {
						var teacherAccount = $("#searchTeacherAccount")
								.numberbox("getValue");
						var teacherName = $("#searchTeacherName").textbox(
								"getValue");
						var searchDepartment = $("#searchDepartment").textbox(
								"getValue");
						var queryParam = $("#teacher-table")
								.datagrid("options").queryParams;
						queryParam.teacherAccount = teacherAccount;
						queryParam.teacherName = teacherName;
						queryParam.searchDepartment = searchDepartment;
						$("#teacher-table").datagrid("load");
					});
		});
		function addTeacher() {
			$("#teacher-dialog-form").form("clear");
			$("#teacher-dialog").dialog({
				title : "增加教师用户",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : "确定",
					iconCls : "icon-ok",
					handler : teacher_add
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#teacher-dialog").dialog("close");
					}
				}

				]
			});
		}
		function updateTeacher() {
			$("#teacher-dialog-form").form("clear");
			var rows = $("#teacher-table").datagrid("getSelections");
			if (rows.length != 1) {
				$.messager.alert("提示", "请选择一条数据", "info");
			} else {
				var teacher = rows[0];
				teacher.teacherPassword = "";
				$.ajax({
					async : false,
					url : "/laboratoryweb/getTeacherDepart",
					method : "get",
					data : {
						"teacherId" : teacher.teacherPKID
					},
					success : function(data) {
						teacher.department = data;
					}
				});
				//表单绑定数据
				$("#teacher-dialog-form").form("load", teacher);
				$("#teacher-dialog").dialog({
					title : "修改教师信息",
					closed : false,
					modal : true,
					buttons : [ //按钮
					{
						text : "确定",
						iconCls : "icon-ok",
						handler : teacher_update
					}, {
						text : '取消',
						iconCls : "icon-cancel",
						handler : function() {
							$("#teacher-dialog").dialog("close");
						}
					}

					]
				});
			}
		}
		function teacher_add() {
			doAjaxT("/laboratoryweb/addTeacher");
		}
		function teacher_update() {
			doAjaxT("/laboratoryweb/updateTeacher");
		}
		function doAjaxT(param) {
			var departmentId = $("#t-department").val();
			var teacherName = $("#t-teacherName").val();
			var teacherAccount = $("#t-teacherAccount").val();
			var status = $("#teacher-status").val();
			var id = $("#teacherPKID").val();
			var teacherPassword = $("#t-teacherPassword").val();
			if (teacherName == "") {
				Alert("请输入姓名");
				return;
			}
			if (teacherAccount == "") {
				Alert("请输入工号");
				return;
			}
			if (departmentId == "") {
				Alert("请选择学院");
				return;
			}
			if (status == "") {
				status = 1;
			}
			$.ajax({
				url : param,
				method : "post",
				data : {
					id : id,
					teacherName : teacherName,
					teacherAccount : teacherAccount,
					teacherPassword : teacherPassword,
					departmentId : departmentId,
					status : status
				},
				success : function(data) {
					if (data == "ok") {
						$("#teacher-dialog").dialog("close");
						$("#teacher-table").datagrid("reload");
						Alert("操作成功");
					} else if (data == "wrongPassword") {
						Alert("密码应为字母加数字6-12位");
					} else {
						Alert("系统异常,请重试");
					}
				}
			})
		}

		function deleteTeacher() {
			var rows = $("#teacher-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确定删除?", function(result) {
					if (result) {
						var ids = [];
						$(rows).each(function() {
							ids.push(this.teacherPKID);
						});
						$.ajax({
							url : "/laboratoryweb/deleteTeacher",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "ok") {
									$("#teacher-dialog").dialog("close");
									$("#teacher-table").datagrid("reload");
									Alert("删除成功!");
								} else {
									Alert("删除失败！");
								}
							}

						});

					}
				})
			} else {
				$.messager.alert("提示", "请至少选择一个用户！", "info");
			}
		}
		function cancelT() {
			$("#teacher-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>