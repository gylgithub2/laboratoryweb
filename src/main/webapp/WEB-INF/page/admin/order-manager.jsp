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
	<table id="order-table" style="width: 100%; height: 100%;" />
	<div id="order-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-ok'"
			id="or-confirmbutton" class="easyui-linkbutton" onclick="confirm()">确认</a>
		&nbsp;<a href="javascript:void(0);"
			data-options="iconCls:'icon-cancel'" id="or-deletebutton"
			class="easyui-linkbutton" onclick="deleteOrder()">删除</a> &nbsp;<a
			href="javascript:void(0);" data-options="iconCls:'icon-undo'"
			id="or-cancel-btn" class="easyui-linkbutton" onclick="cancelO()">刷新</a>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#order-table").datagrid({
				title : "预约信息表",
				url : "/laboratoryweb/getPagerOrders",
				pagination : true,
				pageSize : 15,
				pageList : [ 15, 50, 100 ],
				columns : [ [ {
					field : "ck",
					checkbox : "true"
				}, {
					field : "orderPKID",
					hidden : true,
					title : "orderPKID"

				}, {
					field : "userId",
					title : "学号/工号",
					width : 100
				}, {
					field : "userName",
					title : "姓名 ",
					width : 100
				}, {
					field : "userRole",
					title : "角色",
					width : 100,
					formatter : function(value, row, index) {
						if (value == "1") {
							return "教师";
						} else {
							return "学生";
						}
					},
				}, {
					field : "roomId",
					title : "实验室编号",
					width : 100
				}, {
					field : "roomName",
					title : "实验室名称",
					width : 150
				}, {
					field : "roomSitId",
					title : "座位号",
					width : 50
				}, {
					field : "orderTime",
					title : "预约时间",
					width : 150
				}, {
					field : "startTime",
					title : "预约开始时间",
					width : 150
				}, {
					field : "endTime",
					title : "预约结束时间",
					width : 150
				}, {
					field : "stuClass",
					title : "预约班级",
					width : 150
				}, {
					field : "stuClassName",
					title : "预约班级名称",
					width : 150
				} ] ],
				// 背景色交替
				striped : true,
				// 增加工具栏
				toolbar : "#order-tb",
			//行索引传入   使用自带的编辑器
			});
		});
		function confirm() {
			var rows = $("#order-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.defaults = {
					ok : "1   ",
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					cancel : "2    ",
					width : '300px',
					height : '200px'
				};
				$.messager.confirm("提示", "请选择下列选项并通过预约：" + "<br/>" + " 1.管理员开门"
						+ "<br/>" + " 2.学生开门" + "<br/>", function(result) {
					if (result) {
						var ids = [];
						$(rows).each(function() {
							ids.push(this.orderPKID);
						});
						$.ajax({
							url : "/laboratoryweb/confirmOrder",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "success") {
									$("#order-table").datagrid("reload");
								} else {
									Alert("同意预约失败！");
								}
							}
						});
					} else {
						var ids = [];
						var flag = 1;
						$(rows).each(function() {
							ids.push(this.orderPKID);
						});
						$.ajax({
							url : "/laboratoryweb/confirmOrder",
							data : {
								ids : ids,
								flag : flag
							},
							success : function(data) {
								if (data == "success") {
									$("#order-table").datagrid("reload");
								} else {
									Alert("同意预约失败！");
								}
							}
						});
					}
				})
			} else {
				$.messager.alert("提示", "请至少选择一条信息！", "info");
			}
		}

		function deleteOrder() {
			var rows = $("#order-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确认不同意预约请求?", function(result) {
					if (result) {

						//定义数组
						var ids = [];
						//遍历rows
						$(rows).each(function() {
							ids.push(this.orderPKID);
						});
						//传递ids
						$.ajax({
							url : "/laboratoryweb/deleteOrder",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "success") {
									$("#order-table").datagrid("reload");
								} else {
									alert("请重试！");
								}
							}

						});

					}
				})
			} else {
				$.messager.alert("提示", "请至少选择一条信息！", "info");
			}
		}

		function cancelO() {
			$("#order-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>