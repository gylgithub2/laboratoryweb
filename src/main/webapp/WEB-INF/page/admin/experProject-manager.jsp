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
	<table id="exper-table" style="width: 100%; height: 100%;" />
	<div id="exper-tb">
		<div class="experProjectsToolbar_button"></div>
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			id="addbutton" class="easyui-linkbutton" onclick="addExperProject()">添加</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-save'" id="updatebutton"
			class="easyui-linkbutton" onclick="updateExperProject()">修改</a>&nbsp;
		<a href="javascript:void(0);" data-options="iconCls:'icon-remove'"
			id="removebutton" class="easyui-linkbutton"
			onclick="deleteExperProject()">删除</a> &nbsp; <a
			href="javascript:void(0);" data-options="iconCls:'icon-cancel'"
			id="cancelbutton" class="easyui-linkbutton" onclick="cancelE()">取消选择</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-undo'" id="refreshbutton"
			class="easyui-linkbutton" onclick="refreshTable()">刷新</a> &nbsp;实验室名:
		<div id="seacher_experProjectName" class="easyui-textbox"></div>
		&nbsp; <a href="#" data-options="iconCls:'icon-search'"
			placeholder="密码" id="exper-search-btn" class="easyui-linkbutton">搜索</a>
	</div>

	<!-- 增加的提示框 -->
	<div id="exper-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 400px; height: 300px; padding: 10px;">
		<form id="exper-dialog-form" method="post">
			<table>
				<tr>
					<td width="100px" align="right">实验项目名:<input
						id="experProjectPKID" name="experProjectPKID" type="hidden" /></td>
					<td><input type="text" id="experimentalProjectName"
						name="experimentalProjectName" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60px" align="right">实验项目编号:</td>
					<td><input type="text" id="experimentalProjectId"
						name="experimentalProjectId" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<!-- 关联其他类型修改时设置为树 -->
					<td width="60px" align="right">项目实验室:</td>
					<td><input type="text" id="exper-laboratoryId"
						name="laboratory" class="easyui-combotree"
						data-options="url:'/laboratoryweb/getAllLaboratory',multiple:false,panelHeight:233" /></td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			$("#exper-table").datagrid({
				title : "项目信息表",
				url : "/laboratoryweb/getPagerExperProjects",
				pagination : true,
				pageSize : 15,
				pageList : [ 15, 50, 100 ],
				columns : [ [ {
					field : "ck",
					checkbox : "true"
				}, {
					field : "experProjectPKID",
					hidden : true,
					title : "experProjectPKID"
				}, {
					field : "laboratory",
					title : "实验室",
					width : 150,
					formatter : function(value, row, index) {
						return value.laboratoryName;
					}
				}, {
					field : "experimentalProjectId",
					title : "实验室编号",
					width : 150,
				}, {
					field : "hasVideo",
					title : "是否有材料",
					width : 150,
					formatter : function(value, row, index) {
					   if(value==true){
						   return "有";
					   }else{
						   return "无";
					   }
					}
				}, {
					field : "experimentalProjectName",
					title : "项目名字",
					width : 180
				}, ] ],
				// 背景色交替
				striped : true,
				// 增加工具栏
				toolbar : "#exper-tb",
			//行索引传入   使用自带的编辑器
			});
			//保存修改id
			var editIndex;
			$("#exper-search-btn")
					.click(
							function() {
								var experProjectName = $(
										"#seacher_experProjectName").textbox(
										"getValue");
								//绑定到exper-table上
								var queryParam = $("#exper-table").datagrid(
										"options").queryParams;
								queryParam.experProjectName = experProjectName;
								$("#exper-table").datagrid("load");
							});
			//保存修改
		});
		//新增一条数据
		function addExperProject() {

			$("#exper-dialog-form").form("clear");
			$("#exper-dialog").dialog({
				title : "新增项目",
				closed : false,
				modal : true,
				buttons : [ //按钮
				{
					text : "确定",
					iconCls : "icon-ok",
					handler : experProject_add
				}, {
					text : '取消',
					iconCls : "icon-cancel",
					handler : function() {
						$("#exper-dialog").dialog("close");
					}
				}

				]
			});
		}
		function updateExperProject() {
			$("#exper-dialog-form").form("clear");
			var rows = $("#exper-table").datagrid("getSelections");
			if (rows.length != 1) {
				$.messager.alert("提示", "请选择一条信息", "info");
			} else {
				var experProject = rows[0];
				experProject.laboratory = {
					"id" : experProject.laboratory.laboratoryPKID,
					"text" : experProject.laboratory.laboratoryName
				}
				//表单绑定数据
				$("#exper-dialog-form").form("load", experProject);
				$("#exper-dialog").dialog({
					title : "修改项目信息",
					closed : false,
					modal : true,
					//不可修改
					/* 					onOpen:function(){
					 $("#experProjectName").textbox({disabled:true});
					 }, */
					buttons : [ //按钮
					{
						text : "确定",
						iconCls : "icon-ok",
						handler : experProject_update
					}, {
						text : '取消',
						iconCls : "icon-cancel",
						handler : function() {
							$("#exper-dialog").dialog("close");
						}
					}

					]
				});
			}
		}
		function experProject_add() {

			doAjaxE("/laboratoryweb/addExperProject");
		}
		function experProject_update() {
			doAjaxE("/laboratoryweb/updateExperProject");
		}
		function doAjaxE(param) {
			var data = {
				"id" : $("#experProjectPKID").val(),
				"experId" : $("#experimentalProjectId").val(),
				"experProjectName" : $("#experimentalProjectName").val(),
				"laboratoryId" : $("#exper-laboratoryId").val()
			};
			$.ajax({
				async : false,
				url : param,
				type : "post",
				data : data,
				success : function(mesa) {
					if (mesa == "ok") {
						$("#exper-dialog").dialog("close");
						$("#exper-table").datagrid("reload");
						Alert("操作成功!");
					} else {
						Alert("请重试！");
					}
				}
			})
		}

		function deleteExperProject() {
			var rows = $("#exper-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确定删除?", function(result) {
					if (result) {
						var ids = [];
						//遍历rows
						$(rows).each(function() {
							ids.push(this.experProjectPKID);
						});
						//传递ids
						$.ajax({
							url : "/laboratoryweb/deleteExperProject",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "ok") {
									$("#exper-dialog").dialog("close");
									$("#exper-table").datagrid("reload");
									Alert("删除成功");
								} else {
									Alert("删除失败！");
								}
							}

						});

					}
				})
			} else {
				$.messager.alert("提示", "请至少选择一条记录！", "info");
			}
		}

		function cancelE() {
			$("#exper-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>