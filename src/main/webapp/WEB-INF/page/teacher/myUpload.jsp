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
	<table id="my-upload-table" style="width: 100%; height: 100%;"/>
	<div id="my-upload-tb">
		<a href="javascript:void(0);" data-options="iconCls:'icon-remove'"
			id="upload-remove-btn" class="easyui-linkbutton" onclick="deleteUpload()">删除</a>
		&nbsp; <a href="javascript:void(0);"
			data-options="iconCls:'icon-cancel'" id="upload-cancel-btn"
			class="easyui-linkbutton" onclick="cancel()">取消选择</a>
		</div>
	<script type="text/javascript">
		$(function() {
			$("#my-upload-table").datagrid(
					{
						title : "我的上传",
						url : "/laboratoryweb/getMyUpload",
						pagination : true,
						pageSize : 13,
						pageList : [ 13, 50, 100 ],
						columns : [ [
								{
									field : "ck",
									checkbox : "true"
								},
								{
									field : "videoPKID",
									hidden : true,
									title : "videoPKID"
								},
								{
									field : "uploadDate",
									title : "上传日期",
									width : 150
								},
								{
									field : "videoName",
									title : "视频名字",
									width : 120
								},
								{
									field : "fileName",
									title : "配套资料名",
									width : 140
								},
								{
									field : "experimentalProject",
									title : "关联项目",
									formatter : function(value, row, index) {
										var experName = "【"
												+ value.experimentalProjectName
												+ "】";
										return experName;
									}
								} ] ],
						striped : true,
						toolbar : "#my-upload-tb",
					});
		});
		function deleteUpload() {
			var rows = $("#my-upload-table").datagrid("getSelections");
			if (rows.length >= 1) {
				$.messager.confirm("提示", "确定删除?", function(result) {
					if (result) {
						var ids = [];
						$(rows).each(function() {
							ids.push(this.videoPKID);
						});
						$.ajax({
							url : "/laboratoryweb/deleteMyUpload",
							data : {
								ids : ids
							},
							success : function(data) {
								if (data == "ok") {
									$("#my-upload-table").datagrid("reload");
									Alert("ok!");
								} else {
									Alert("删除失败！");
								}
							}

						});

					}
				})
			} else {
				$.messager.Alert("提示", "请至少选择一条数据！", "info");
			}
		}

		function cancel() {
			$("#my-upload-table").datagrid("rejectChanges");
		}
	</script>

</body>
</html>