<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<table id="lab-table" style="width: 100%; height: 100%;" />
	<div id="lab_tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'"
			class="easyui-linkbutton" onclick="order()">预约</a>&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-undo'" id="stu-refreshbutton"
			class="easyui-linkbutton" onclick="refreshTable()">刷新</a> &nbsp;实验室名:
		<div id="stu-search-labName" prompt="实验室名字..."
			class="easyui-textbox"></div>

		&nbsp; <a href="javascript:void(0);" data-options="iconCls:'icon-search'"
			id="stu-search-btn" class="easyui-linkbutton">搜索</a>
	</div>

	<!-- 增加的提示框 -->
	<div id="stu-lab-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 380px; height: 320px; padding: 10px;">
		<form id="stu-lab-dialog-form" method="post">
			<table>
				<tr>

					<td style="padding: 10px;" width="100px" align="right">实验室名:
					<input id="stu-laboratoryPKID" name="laboratoryPKID" type="hidden" /></td>
					<td><input type="text" disabled="disabled" id="stu-laboratoryName"
						name="laboratoryName" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;"  align="right">实验室编号:</td>
					<td><input type="text" disabled="disabled" id="stu-laboratoryId"
						name="laboratoryId" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;"  align="right">预约时间:</td>
					<td><input type="text" id="stu-orderDay" name="orderDay"
						class="easyui-datebox" /></td>
				</tr>
				<tr>
					<td style="padding: 10px;" align="right">预约时间段:</td>

					<td><input type="text" id="stu-orderTimeSectionId"
						name=orderTimeSection class="easyui-combotree"
						data-options="url:'/laboratoryweb/getAllTimeSection',multiple:false,panelHeight:200" /></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#lab-table").datagrid({
				title : "实验室信息",
				url : "/laboratoryweb/getPagerLaboratorys",
				pagination : true,
				singleSelect:true,
				pageSize : 14,
				pageList : [ 14, 50, 100 ],
				columns : [ [ {
					field : "laboratoryPKID",
					hidden:true,
					title : "laboratoryPKID",
					width : 100

				}, {
					field : "laboratoryId",
					sortable : true,
					title : "实验室编号",
					width : 100
				}, {
					field : "laboratoryName",
					title : "实验室名字",
					width : 100
				}, {
					field : "laboratorySitNum",
					title : "实验室座位数量",
					width : 100
				}, {
					field : "laboratoryStatus",
					title : "实验室状态",
					width : 100
				}, ] ],
				striped : true,
				toolbar : "#lab_tb",
			});
			//保存修改id
			$("#stu-search-btn").click(
					function() {
						var laboratoryName = $("#stu-search-labName")
								.textbox("getValue");
						//绑定到lab-table上
						var queryParam = $("#lab-table").datagrid(
								"options").queryParams;
						queryParam.laboratoryName = laboratoryName;
						$("#lab-table").datagrid("load");
					});
			//保存修改
		});
		function order() {
			$("#stu-lab-dialog-form").form("clear");
			var rows = $("#lab-table").datagrid("getSelections");
			if (rows.length != 1) {
				$.messager.alert("提示", "请选择一条信息", "info");
			} else {
				var laboratory = rows[0];
				//表单绑定数据
				$("#stu-lab-dialog-form").form("load", laboratory);
				$("#stu-lab-dialog").dialog({
					title : "预约实验室",
					closed : false,
					modal : true,
					//不可修改
					/* 					onOpen:function(){
					 $("#laboratoryName").textbox({disabled:true});
					 }, */
					buttons : [ //按钮
					{
						text : "确定",
						iconCls : "icon-ok",
						handler : laboratory_order
					}, {
						text : '取消',
						iconCls : "icon-cancel",
						handler : function() {
							$("#stu-lab-dialog").dialog("close");
						}
					}
					]
				});
			}
		}
		function laboratory_order() {
			doAjax("/laboratoryweb/orderLaboratory");
		}
		function doAjax(param) {
			
			var laboratoryId = $("#stu-laboratoryId").val();
			var orderTimeSectionId = $("#stu-orderTimeSectionId").val();
			var orderDay = $("#stu-orderDay").val();
			if(orderDay==""||orderTimeSectionId==""){
				Alert("请填写完整信息");
				return false;
			}
			var loadData = {
				"laboratoryId" : laboratoryId,
				"orderTimeSectionId" : orderTimeSectionId,
				"orderDay" : orderDay
			};
			$.ajax({
				url : param,
				method : "post",
				data : loadData,
				success : function(data) {
					if (data == "ok") {
						$("#stu-lab-dialog").dialog("close");
						Alert("预约成功,请留意批准信息.....");
					}else if(data == "swrongday"){
				        var myDate = new Date;
				        var year = myDate.getFullYear(); //获取当前年
				        var mon = myDate.getMonth() + 1; //获取当前月
				        var date = myDate.getDate();
						Alert("日期应为:"+year+"-"+mon+"-"+date+"后五天内");
					} else if(data == "labForbidden"){
						Alert("实验室不可用");
					} else if(data == "classordered"){
						Alert("实验室已被占用");						
					} else if(data == "forbidden"){
						Alert("账号被禁用,请联系管理员..");
					} 
					else if(data == "ordered"){
						Alert("同时间段预约冲突");
					} 
					else if(data == "outofnum"){
						Alert("实验室已满");
					} 
					else if(data == "outMaxOrder"){
						Alert("预约请求已满");
					} 
					else{
						Alert("系统异常,请重试..");						
					}
				}
			});

		}
		function refreshTable(){
			$("#lab-table").datagrid("load");
		}
	</script>

</body>
</html>