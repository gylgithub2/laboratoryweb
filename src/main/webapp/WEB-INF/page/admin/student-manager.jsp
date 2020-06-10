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
	<table id="student-table" style="width: 100%; height: 100%;" />
	<div id="student-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			id="addbutton" class="easyui-linkbutton" onclick="addStudent()">添加</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-save'" id="updatebutton"
			class="easyui-linkbutton" onclick="updateStudent()">修改</a>&nbsp; <a
			href="javascript:void(0);" data-options="iconCls:'icon-remove'"
			id="removebutton" class="easyui-linkbutton" onclick="deleteStudent()">删除</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-cancel'" id="cancelbutton"
			class="easyui-linkbutton" onclick="cancelS()">取消选择</a> &nbsp; 学号:
		<div id="stu-searchStuAccount" class="easyui-numberbox"></div>
		&nbsp;学生名:
		<div id="stu-searchStuName" class="easyui-textbox"></div>
		&nbsp;班级：
		<div id="stu-classn" class="easyui-textbox"></div>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-search'" id="stu-seacher-btn"
			class="easyui-linkbutton">查询</a>
	</div>

	<!-- 增加的提示框 -->
	<div id="update-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 300px; height: 540px; padding: 10px;">
		<form id="update-form" method="post">
			<table>
				<tr>
					<td width="60px" align="right">学生名:&nbsp;<input
						id="studentPKID" name="studentPKID" type="hidden" /></td>
					<td><input type="text" id="stu-studentName" name="studentName"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">学&nbsp;号:&nbsp;</td>
					<td><input type="text" id="stu-studentAccount"
						name="studentAccount" class="easyui-numberbox" /></td>
				</tr>

				<tr>
					<td width="60px" align="right">密&nbsp;码:&nbsp;</td>
					<td><input type="text" id="stu-studentPassword"
						name="studentPassword" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">状&nbsp;态:&nbsp;</td>
					<td><input type="text" id="stu-status" name="status"
						class="easyui-combotree" data-options="panelHeight:99" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">迟到次数:</td>
					<td><input type="text" id="stu-lateTime" name="lateTime"
						class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">缺席次数:</td>
					<td><input type="text" id="stu-absenceTime" name="absenceTime"
						class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<td width="90px" align="right">当前违纪分数:</td>
					<td><input type="text" id="stu-violateScore"
						name="violateScore" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">班级编号:</td>
					<td><input type="text" id="stu-stuClass" name="stuClass"
						class="easyui-numberbox" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 增加的提示框 -->
	<div id="add-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 300px; height: 320px; padding: 10px;">
		<form id="add-form" method="post">
			<table>
				<tr>
					<td width="60px" align="right">学生名:&nbsp;</td>
					<td><input type="text" id="add-stu-studentName"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">学&nbsp;号:&nbsp;</td>
					<td><input type="text" id="add-stu-studentAccount"
						class="easyui-numberbox" /></td>
				</tr>

				<tr>
					<td width="60px" align="right">密&nbsp;码:&nbsp;</td>
					<td><input type="text" id="add-stu-studentPassword"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">班级编号:</td>
					<td><input type="text" id="add-stu-stuClass" name="stuClass"
						class="easyui-numberbox" /></td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			$('#stu-status').combotree('loadData', [ {
				id : 1,
				text : '正常',
			}, {
				id : 2,
				text : '禁用',
			} ,{
				id : 3,
				text : '失效',
			} ]);
			$("#student-table").datagrid({
								title : "&nbsp;&nbsp;&nbsp;学生信息表",//名字
								url : "/laboratoryweb/getPagerStudents",//JSON数据源
								pagination : true,//分页
								pageSize : 15,//分页大小
								pageList : [ 15, 50, 100 ],//可选择的分页大小
								striped : true,//显示优化
								toolbar : "#student-tb",//绑定工具栏
								//循环数据源展示
								columns : [ [{field : "ck",checkbox : "true"},
										{field : "studentPKID",hidden : true,title : "studentPKID",},
										{field : "studentAccount",title : "学号",width : 100},
										{field : "studentName",title : "名字",width : 100},
										{field : "stuClassName",title : "班级",width : 200,
											formatter : function(value, row,index) {
												var var1;
												$.ajax({
													    async : false,
														url : "/laboratoryweb/getStuClassName",
														method : "get",
														data : {"stuClassId" : row.stuClass},
														success : function(data) {
																var1 = data;
														}});
												return var1;
											}
										},{field : "stuClass",title : "班级编号",width : 100},
										{field : "violateScore",title : "当前违纪分数",width : 120},
										{field : "lateTime",title : "历史迟到次数",width : 100,
											formatter : function(value, row,index) {
												if (value == "0") {
													return "无";
												} else {
													return value + "次";
												}},},
										{field : "absenceTime",title : "历史缺席次数",width : 100,
											formatter : function(value, row,index) {
												if (value == "0") {
													return "无";
												} else {
													return value + "次";
												}},},
										{field : "status",title : "状态",width : 100,
											formatter : function(value, row,index) {
												if (value == "2") {
													return "禁用";
												} else if (value == "1") {
													return "正常";
												}else{
													return "失效";
												}},
											styler : function(value, row, index) {
												if (value == 1) {
													return 'tetx-align:center;background-color:#60D41F;color:white;';
												} else {
													return 'background-color:#E22018;color:white;';
												}}} ] ],});

			$("#stu-seacher-btn").click(
					function() {
						var studentAccount = $("#stu-searchStuAccount")
								.numberbox("getValue");
						var studentName = $("#stu-searchStuName").textbox(
								"getValue");
						var classn = $("#stu-classn").textbox("getValue");
						var queryParam = $("#student-table")
								.datagrid("options").queryParams;
						queryParam.studentAccount = studentAccount;
						queryParam.studentName = studentName;
						queryParam.classn = classn;
						$("#student-table").datagrid("load");
					});
		});
		function addStudent() {
			$("#add-form").form("clear");
			$("#add-dialog").dialog({
				title : "增加学生",
				closed : false,
				modal : true,
				buttons : [ {
					text : "确定",
					iconCls : "icon-ok",
					handler : student_add
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#add-dialog").dialog("close");
					}
				}

				]
			});
		}
		function student_add() {
			$.ajax({
				async : false,
				url : "/laboratoryweb/addStudent",
				method : "post",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify({
					studentName : $("#add-stu-studentName").val(),
					studentAccount : $("#add-stu-studentAccount").val(),
					studentPassword : $("#add-stu-studentPassword").val(),
					stuClass : $("#add-stu-stuClass").val(),
				}),
				success : function(data) {
					if (data == "ok") {
						$("#add-dialog").dialog("close");
						$("#student-table").datagrid("reload");
						Alert("添加成功");
					} else if(data == "wrongPassword"){
						Alert("密码应为字母加数字6-12位");
					} else if(data == "wrongClass"){
						Alert("找不到该编号的班级");
					} else if(data == "wrongAccount"){
						Alert("学号重复");
					} else{
						Alert("系统异常,请重试");
					}
				}
			})
		}
		function updateStudent() {
			$("#update-form").form("clear");
			var rows = $("#student-table").datagrid("getSelections");
			if (rows.length != 1) {
				$.messager.alert("提示", "请选择一条数据", "info");
			} else {
				var student = rows[0];
				student.studentPassword = "";
				$("#update-form").form("load", student);
				$("#update-dialog").dialog({
					title : "修改用户",
					closed : false,
					modal : true,
					buttons : [ {
						text : "确定",
						iconCls : "icon-ok",
						handler : student_update
					}, {
						text : '取消',
						iconCls : "icon-cancel",
						handler : function() {
							$("#update-dialog").dialog("close");
						}
					}

					]
				});
			}
		}

		function student_update() {
			$.ajax({
				async : false,
				url : "/laboratoryweb/updateStudent",
				method : "post",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify({
					studentPKID : $("#studentPKID").val(),
					studentName : $("#stu-studentName").val(),
					studentAccount : $("#stu-studentAccount").val(),
					lateTime : $("#stu-lateTime").val(),
					absenceTime : $("#stu-absenceTime").val(),
					violateScore : $("#stu-violateScore").val(),
					studentPassword : $("#stu-studentPassword").val(),
					stuClass : $("#stu-stuClass").val(),
					status : $("#stu-status").val(),
				}),
				success : function(data) {
					if (data == "ok") {
						$("#update-dialog").dialog("close");
						$("#student-table").datagrid("reload");
						Alert(" 修改成功 ");
					} else if(data == "wrongPassword"){
						Alert("密码应为字母加数字6-12位");
					} else if(data == "wrongClass"){
						Alert("找不到该编号的班级");
					} else if(data == "nameFalse"){
						Alert("修改名字请输入密码");
					}  else{
						Alert("系统异常,请重试");
					}
				}
			})
		}
		function deleteStudent() {
			var rows = $("#student-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确定删除?", function(result) {
					if (result) {
						var ids = [];
						$(rows).each(function() {
							ids.push(this.studentPKID);
						});
						$.ajax({
							url : "/laboratoryweb/deleteStudent",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "ok") {
									$("#student-table").datagrid("reload");
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
		function cancelS() {
			$("#student-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>