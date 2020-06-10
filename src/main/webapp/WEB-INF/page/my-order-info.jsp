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
	<table id="myordr-table" style="width: 100%; height: 100%;"  />
	<div id="myordr-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			class="easyui-linkbutton" onclick="deleteOrder()">选中撤销</a> &nbsp;
		<div id="myordr-dim-search" class="easyui-textbox"></div>
		&nbsp; <a href="javascript:void(0);" data-options="iconCls:'icon-search'"
			id="myordr-search-btn" class="easyui-linkbutton">搜索</a>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#myordr-table").datagrid({
				title : "我的预约信息表",
				url : "/laboratoryweb/getPagerOrderByUser",
				pagination : true,
				striped : true,
				pageSize : 15,
				pageList : [ 15, 50, 100 ],
				columns : [ [ {
					field : "orderPKID",
					hidden : true,
					title : "orderPKID",
					width : 100,
					formatter : function(value, row, index) {
						var role = $("#userRole").val();
						if(role == "学生"){
						$('#myordr-table').datagrid('hideColumn', "stuClass");
						}
					}
				}, {
					field : "roomId",
					title : "实验室",
					width : 100
				}, {
					field : "roomName",
					title : "实验室",
					width : 100
				},{
					field : "roomSitId",
					title : "座位号",
					width : 100
				},{
					field : "orderTime",
					title : "预约时间",
					width : 150
				}, {
					field : "startTime",
					title : "开始时间",
					width : 150
				}, {
					field : "endTime",
					title : "结束时间",
					width : 150
				}, {
					field : "stuClass",
					title : "预约班级",
					width : 150,

				}, {
					field : "experProjectAccount",
					title : "实验项目",
					width : 150,
					formatter:function(value,row,index){
						if(value == null){							
						return "个人预约";
						}else{
							return value;
						}
						
					}
				}, {
					field : "status",
					title : "当前状态",
					width : 100,
					formatter : function(value, row, index) {
						if (value == 1) {
							return "已通过";
						} else if (value == 0) {
							return "未审核";
						} else if (value == 3) {
							return "已撤销";
						} else {
							return "未通过";
						}
					},
					styler : function(value, row, index) {
						if (value == 1) {
							return 'background-color:#70D41F;color:white;';
						} else if (value == 0) {
							return 'background-color:#FECB41;color:white;';
						} else if (value == 3) {
							return 'background-color:#D9D9D9;color:white;';
						} else {
							return 'background-color:#E22018;color:white;';

						}
					}
				} ] ],
				singleSelect : true,
				striped : true,
				toolbar : "#myordr-tb",
			});
			var editIndex;
			$("#myordr-search-btn")
					.click(
							function() {
								var dimWord = $("#myordr-dim-search").textbox(
										"getValue");
								var queryParam = $("#myordr-table").datagrid(
										"options").queryParams;
								queryParam.dimWord = dimWord;
								$("#myordr-table").datagrid("load");
							});
		});

		function deleteOrder() {
			var rows = $("#myordr-table").datagrid("getSelections");
			if (rows.length < 1) {
				$.messager.alert("提示", "请至少选择一条信息", "info");
			} else {
				var laboratory = rows[0];
				if (laboratory.status == 0) {
					$.messager.confirm("提示", "确定撤销选中预约申请?", function(result) {
						if (result) {
							var ids = [];
							$(rows).each(function() {
								ids.push(this.orderPKID);
							});
							//传递ids
							$.ajax({
								url : "/laboratoryweb/cancelOrder",
								data : {
									ids : ids
								},
								success : function(data) {
									if (data == "success") {
										$("#myordr-table").datagrid("reload");
										Alert("撤销申请成功!");
									} else {
										Alert("撤销申请失败！");
									}
								}

							});

						}
					})
				} else {
					Alert("仅未通过的预约可撤销!");
				}
			}

		}
	</script>

</body>
</html>