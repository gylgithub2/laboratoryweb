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
	<table id="lab-table" style="width: 100%;height:100%;" />
	<div id="lab-tb">
		<div class="lab-Toolbar_button"></div>
		<a href="javascript:void(0);" data-options="iconCls:'icon-add'" id="addbutton"
			class="easyui-linkbutton" onclick="addLaboratory()">添加</a> &nbsp; <a
			href="javascript:void(0);" data-options="iconCls:'icon-save'" id="updatebutton"
			class="easyui-linkbutton" onclick="updateLaboratory()">修改</a>&nbsp;
		<a href="javascript:void(0);" data-options="iconCls:'icon-remove'" id="removebutton"
			class="easyui-linkbutton" onclick="deleteLaboratory()">删除</a> &nbsp;
		<a href="javascript:void(0);" data-options="iconCls:'icon-cancel'" id="cancelbutton"
			class="easyui-linkbutton" onclick="cancelL()">取消选择</a>
		&nbsp;实验室名:
		<div id="searcher_laboratoryName" prompt="实验室名字..." class="easyui-textbox"></div>
		&nbsp; <a href="javascript:void(0);" data-options="iconCls:'icon-search'" id="lab-searcherbutton" class="easyui-linkbutton">搜索</a>
	</div>

	<!-- 增加的提示框 -->
	<div id="lab-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 350px; height: 330px; padding: 10px;">
		<form id="lab-dialog-form" method="post">
			<table>
				<tr>
					<td width="90px" align="right">实验室名:&nbsp;
					<input type="hidden" id="laboratoryPKID" name="laboratoryPKID" /> </td>
					<td><input type="text" id="laboratoryName"
						name="laboratoryName" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="90px" align="right">实验室编号:&nbsp;</td>
					<td><input type="text" id="laboratoryId"
						name="laboratoryId" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<td width="90px" align="right">座位数:&nbsp;</td>
					<td><input type="text" id="laboratorySitNum"
						name="laboratorySitNum" class="easyui-numberbox" /></td>
				</tr>

				<tr>
					<td width="90px" align="right">实验室状态:&nbsp;</td>
					<td><input type="text" id="laboratoryStatus"
						name="laboratoryStatus" 	class="easyui-combotree" data-options="panelHeight:99"  /></td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">
		$(function() {
			$('#laboratoryStatus').combotree('loadData', [{
				id : 2,
				text : '禁用',
			}, {
				id : 1,
				text : '正常',
			} ]);
			$("#lab-table").datagrid({
				title : "实验室信息表",
				url : "/laboratoryweb/getPagerLaboratorys",
				pagination : true,
				pageSize : 15,
				pageList : [ 15, 50, 100 ],
				columns : [ [ {
					field : "ck",
					checkbox : "true"
				}, {
					field : "laboratoryPKID",
					hidden: true,
					title : "laboratoryPKID"
					
				},{
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
				},  {
					field : "laboratoryStatus",
					title : "实验室状态",
					width : 100,
					formatter:function(value,row,index){
						if(value==1){
							return "正常";
						}else if(value==2){
							return "禁用";
						}
					}
				},]],
				striped : true,
				toolbar : "#lab-tb",
			});
			$("#lab-searcherbutton")
					.click(
							function() {
								var laboratoryName = $("#searcher_laboratoryName")
										.textbox("getValue");
								var queryParam = $("#lab-table").datagrid(
										"options").queryParams;
								queryParam.laboratoryName = laboratoryName;
								$("#lab-table").datagrid("load");
							});
		});
function addLaboratory() {
			$("#lab-dialog-form").form("clear");
			$("#lab-dialog").dialog({
				title:"增加用户",
				closed:false,
				modal:true,
				onOpen:function(){
					$("#laboratoryName").textbox({disabled:false});
				},
				buttons:[ //按钮
					{
					text:"确定",
					iconCls:"icon-ok",
					handler: laboratory_add
				    },
				    {     text:'取消',iconCls:"icon-cancel",
					    handler:function(){
						$("#lab-dialog").dialog("close");
					}
			       	}
				    
				       ]
			});
		} 
		function updateLaboratory(){
			$("#lab-dialog-form").form("clear");
			var rows = $("#lab-table").datagrid("getSelections");
			if(rows.length!=1){		
				$.messager.alert("提示","请选择一条信息","info");
			}else{
				var laboratory = rows[0];
				//表单绑定数据
				$("#lab-dialog-form").form("load",laboratory);
				$("#lab-dialog").dialog({
					title:"修改实验室信息",
					closed:false,
					modal:true,
					//不可修改
/* 					onOpen:function(){
						$("#laboratoryName").textbox({disabled:true});
					}, */
					buttons:[ //按钮
						{
						text:"确定",
						iconCls:"icon-ok",
						handler:laboratory_update
					    },
					    {     text:'取消',iconCls:"icon-cancel",
						    handler:function(){
							$("#lab-dialog").dialog("close");
						}
				       	}
					    
					       ]
				});
			}
		}
		function laboratory_add(){
			doAjaxL("/laboratoryweb/addLaboratory");
		}
		function laboratory_update(){
			doAjaxL("/laboratoryweb/updateLaboratory");
		}
		function doAjaxL(param){
			$.ajax({
				url:param,
				method:"post",
				contentType : "application/json;charset=utf-8",
				data:JSON.stringify({
					laboratoryPKID:$("#laboratoryPKID").val(),
					laboratoryName:$("#laboratoryName").val(),
					laboratoryId:$("#laboratoryId").val(),
					laboratorySitNum:$("#laboratorySitNum").val(),
					laboratoryStatus:$("#laboratoryStatus").val(),
				}),
				success : function(data) {
					if (data == "ok") {
						$("#lab-dialog").dialog("close");
						$("#lab-table").datagrid("reload");
						Alert("操作成功!");
					} else {
						Alert("请重试！");
					}
				}
			})
		}
		
		function deleteLaboratory(){
					var rows = $("#lab-table").datagrid("getSelections");
					if(rows.length>=1){	
			$.messager.confirm("提示","确定删除?",function(result){
				if(result){
					var ids=[];
					$(rows).each(function(){
						ids.push(this.laboratoryPKID);
					});
					$.ajax({
						url:"/laboratoryweb/deleteLaboratory",
						data:{ids:ids},
						success : function(data) {
							if (data == "ok") {
								$("#lab-dialog").dialog("close");
								$("#lab-table").datagrid("reload");
								Alert("删除成功!");
							} else {
								Alert("删除失败！");
							}
						}
						
					});
				
					}
			})
					}else{
						$.messager.alert("提示","请至少选择一条记录！","info");
					}
		}
		
		function cancelL(){
			$("#lab-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>