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
	<table id="old-order-table" style="width: 100%;height:100%;" />
	<div id="old-order-tb">
		&nbsp;<a href="javascript:void(0);"
			data-options="iconCls:'icon-cancel'" id="oldor-deletebutton"
			class="easyui-linkbutton" onclick="deleteOrder()">删除</a> <a
			href="javascript:void(0);" data-options="iconCls:'icon-reload'"
			id="oldor-cancel-btn" class="easyui-linkbutton" onclick="cancel()">刷新</a>
		&nbsp;
		<div id="oldor-searcherId" class="easyui-numberbox"
			data-options="prompt:'输入用户id或者实验室id'" style="width: 150px;"></div>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-search'" id="oldor-seacher-btn"
			class="easyui-linkbutton">查询</a>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#old-order-table").datagrid({
				title : "预约信息表",
				url : "/laboratoryweb/getPagerOldOrders",
				pagination : true,
				pageSize : 13,
				pageList : [ 13, 50, 100 ],
				columns : [ [ {
					field : "ck",
					checkbox : "true"
				}, {
					field : "orderPKID",
					hidden : true,
					title : "orderPKID"
				}, {
					field : "userId",
					title : "预约人",
					width : 100
				}, {
					field : "roomId",
					title : "实验室编号",
					width : 80
				},  {
					field : " ",
					title : "实验室名称",
					width : 150,
					formatter:function(value, row, index){
						var var1;
						$.ajax({
							async : false,
							url : "/laboratoryweb/getLabName",
							method : "get",
							data : {
								"labId" : row.roomId
							},
							success : function(data) {
								var1 = data;
							}
						});
						return var1;
					}
				}, {
					field : "orderTime",
					title : "预约申请时间",
					width : 150
				}, {
					field : "  ",
					title : "预约时间",
					width : 350,
					formatter : function(value, row, index) {
						return row.startTime + "~" + row.endTime;
					}
				} ] ],
				striped : true,
				toolbar : "#old-order-tb",
			});
			$("#oldor-seacher-btn").click(
					function() {
						var orderId = $("#oldor-searcherId").numberbox(
								"getValue");
						var queryParam = $("#old-order-table").datagrid(
								"options").queryParams;
						queryParam.id = orderId;
						$("#old-order-table").datagrid("load");
					});
		});
		function deleteOrder() {
			var rows = $("#old-order-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确认该条记录?", function(result) {
					if (result) {
						var ids = [];
						$(rows).each(function() {
							ids.push(this.orderPKID);
						});
						$.ajax({
							url : "/laboratoryweb/deleteOrder",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "success") {
									$("#old-order-table").datagrid("reload");
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

		function cancel() {
			$("#old-order-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>