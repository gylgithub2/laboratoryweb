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
	<table id="experProjectTable" style="width: 100%; height: 100%;" />
	<div id="experProject_tb">
		&nbsp;实验室名:
		<div id="seacher_experProjectName" class="easyui-textbox"></div>
		&nbsp; <a href="#" data-options="iconCls:'icon-search'"
			id="exper-search-btn" class="easyui-linkbutton">搜索</a>
	</div>
	<!-- 增加的提示框 -->
	<div id="video_dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 410px; height: 270px; padding: 10px;">
		<form class="video_dialog_form" id="video_dialog_form"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td width="80px" align="right">项目编号:&nbsp;&nbsp;&nbsp;</td>
					<td><input type="text" class="file-btn"
						id="experimentalProjectId" disabled="disabled"
						name="experimentalProjectId" /><input type="hidden" id="hasVideo"
						name="hasVideo" /></td>
				</tr>

				<tr>
					<td width="80px" align="right">实验视频:&nbsp;&nbsp;&nbsp;</td>
					<td><input class="file-btn" type="file" id="video" /></td>
				</tr>

				<tr>
					<td width="80px" align="right">学习资料:&nbsp;&nbsp;&nbsp;</td>
					<td><input class="file-btn" type="file" id="learnfile" /></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#experProjectTable")
					.datagrid(
							{
								title : "项目信息表",
								url : "/laboratoryweb/getPagerExperProjects",
								pagination : true,
								singleSelect : true,
								pageSize : 15,
								pageList : [ 15, 50, 100 ],
								columns : [ [
										{
											field : "experProjectPKID",
											hidden : true,
											title : "experProjectPKID",
											width : 100
										},
										{
											field : "experimentalProjectId",
											sortable : true,
											title : "编号",
											width : 100
										},
										{
											field : "laboratory",
											title : "实验室",
											width : 180,
											formatter : function(value, row,
													index) {
												return value.laboratoryName;
											}
										},
										{
											field : "experimentalProjectName",
											title : "项目名字",
											width : 200
										},
										{
											field : "hasVideo",
											title : "学习资料",
											width : 100,
											formatter : function(value, row,
													index) {
												if (value == true) {
													return "有";

												} else {
													return "无";
												}
											}
										},
										{
											field : " ",
											title : "上传视频",
											width : 150,
											formatter : function(value, row,
													index) {
												var btn = '<a class="uploadvf" onclick="uploadbtn('
														+ index
														+ ')"  href="javascript:void(0);"></a>';
												return btn;
											}
										},
										{
											field : "  ",
											title : "视频观看",
											width : 200,
											formatter : function(value, row,
													index) {
												var btn = '<a id="watchVideoid'+index+'" class="watchVideo"   onclick="tWatchVideo('
														+ index
														+ ')"  href="javascript:void(0);"></a>';
												return btn;
											}
										},
										{
											field : "   ",
											title : "资料下载",
											width : 200,
											formatter : function(value, row,
													index) {
												var btn = '<a class="download"'
														+ ' href="/laboratoryweb/downloadFile?experProjectPKID='
														+ row.experProjectPKID
														+ '"></a>';
												return btn;
											}
										} ] ],
								onLoadSuccess : function(data) {
									$('.uploadvf').linkbutton({
										text : '上传视频及资料',
										plain : true,
										iconCls : 'icon-add'
									});
									$('.watchVideo').linkbutton({
										text : '观看视频',
										plain : true,
										iconCls : 'icon-add'
									});
									$('.download').linkbutton({
										text : '资料下载',
										plain : true,
										iconCls : 'icon-add'
									});
								},
								striped : true,
								toolbar : "#experProject_tb",
							});
			$("#exper-search-btn").click(
					function() {
						var experProjectName = $("#seacher_experProjectName")
								.textbox("getValue");
						var queryParam = $("#experProjectTable").datagrid(
								"options").queryParams;
						queryParam.experProjectName = experProjectName;
						$("#experProjectTable").datagrid("load");
					});

		});
		function uploadbtn(id) {
			var rows = $("#experProjectTable").datagrid("getRows");
			var oneRow = rows[id];
			var experimentalProjectId = oneRow["experimentalProjectId"];
			var hasVideo = oneRow["hasVideo"];
			if (hasVideo) {
				$.messager.confirm("提示", "该项目已有视频,是否进行覆盖?", function(result) {
					if (result) {
						$("#video_dialog_form").form("clear");
						$("#video_dialog").dialog(
								{
									onOpen : function() {
										$('#experimentalProjectId').val(
												experimentalProjectId);
										$('#hasVideo').val(hasVideo);
									},
									title : "资料上传",
									closed : false,
									modal : true,
									buttons : [ //按钮
									{
										text : "上传",
										iconCls : "icon-ok",
										handler : upload
									}, {
										text : '取消',
										iconCls : "icon-cancel",
										handler : function() {
											$("#video_dialog").dialog("close");
										}
									} ]
								});
					}
				})
			} else {
				$("#video_dialog_form").form("clear");
				$("#video_dialog").dialog({
					onOpen : function() {
						$('#hasVideo').val(hasVideo);
						$('#experimentalProjectId').val(experimentalProjectId);
					},
					title : "资料上传",
					closed : false,
					modal : true,
					buttons : [ //按钮
					{
						text : "上传",
						iconCls : "icon-ok",
						handler : upload
					}, {
						text : '取消',
						iconCls : "icon-cancel",
						handler : function() {
							$("#video_dialog").dialog("close");
						}
					} ]
				});
			}

		}
		function upload() {
			doAjaxc("/laboratoryweb/uploadVideo");
		}
		function doAjaxc(param) { //使用ajax方式
			var experProjectId = $("#experimentalProjectId").val();
			var hasVideo = $("#hasVideo").val();
			var video = $("#video")[0].files[0];
			var learnfile = $("#learnfile")[0].files[0];
			var formData = new FormData();
			formData.append("experimentalProjectId", experProjectId);
			formData.append("hasVideo", hasVideo);
			formData.append("video", video);
			formData.append("learnfile", learnfile);
			$.ajax({
				url : param,
				method : "post",
				data : formData,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(data) {
					if (data == "ok") {
						$("#video_dialog").dialog("close");
						$("#experProjectTable").datagrid("reload");
						Alert("上传成功!");
					} else if (data == "falseVideo") {
						Alert("实验视频非视频格式！");
					} else {
						Alert("请重试!");
					}
				}
			})
		}
		function tWatchVideo(id) {
			var rows = $("#experProjectTable").datagrid("getRows");
			var oneRow = rows[id];
			var experProjectPKID = oneRow["experProjectPKID"];
			var experimentalProjectId = oneRow["experimentalProjectId"];
			$.ajax({
				async : false,
				cache:false,
				url : "/laboratoryweb/getVideoAddress",
				type : "get",
				data : {
					"experProjectPKID" : experProjectPKID,
					"experimentalProjectId" : experimentalProjectId
				},
				success : function(data) {
					if(data == "fail"){
						Alert("视频不存在,请及时联系管理员");
					}else{
						$("#watchVideoid"+id).css("target","_blank");
						window.location.href="/laboratoryweb/watchVideo";
					}
				}
			});
		}
	</script>

</body>
</html>