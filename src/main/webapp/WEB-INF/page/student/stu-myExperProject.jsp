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
	<table id="stu-exper-table" style="width: 100%; height: 100%;" />
	<div id="stu-exper-tb"></div>
	<script type="text/javascript">
		$(function() {
			$("#stu-exper-table")
					.datagrid(
							{
								title : "项目信息表",
								url : "/laboratoryweb/getPagerStuExperProjects",
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
											formatter : function(value, row,
													index) {
												return value.laboratoryName;
											}
										},
										{
											field : "experimentalProjectName",
											title : "项目名字",
											width : 100
										},
										{
											field : "hasVideo",
											title : "资料情况",
											width : 150,
											formatter : function(value, row,
													index) {
												if(value == 1){ 
													return "有视频";
												}else{
													return "没视频";
												}
												return btn;
											}
										},
										{
											field : " ",
											title : "视频观看",
											width : 200,
											formatter : function(value, row,
													index) {
												var btn = '<a class="watchVideo"   onclick="watchVideo('
														+ index
														+ ')"  href="javascript:void(0);"></a>';
												return btn;
											}
										},
										{
											field : "  ",
											title : "资料下载",
											width : 200,
											formatter : function(value, row,
													index) {
												var btn = '<a class="download"'
														+ ' href="/laboratoryweb/downloadFile?experProjectPKID='
														+ row.experProjectPKID
														+ '">资料下载</a>';
												return btn;
											}
										},
										{
											field : "isStudy",
											title : "是否预习",
											width : 100,
											formatter : function(value, row,
													index) {
												$.ajax({   
													        async : false,
															url : "/laboratoryweb/getStuStudyInfo",
															data : {
																"experId" : row.experimentalProjectId
															},
															success : function(data) {
																value = data;
															}
														})
												return value;
											},
											styler : function(value, row, index) {
												$.ajax({   
											        async : false,
													url : "/laboratoryweb/getStuStudyInfo",
													data : {
														"experId" : row.experimentalProjectId
													},
													success : function(data) {
														value = data;
													}
												})
												if (value == "完成") {
													return 'tetx-align:center;background-color:#60D41F;color:white;';
												} else if (value == "未完成") {
													return 'background-color:#E22018;color:white;';
												} else if (value == "待完成") {
													return 'background-color:#D9D9D9;color:white;';
												}
											}
										} ] ],
								onLoadSuccess : function(data) {
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
								toolbar : "#stu-exper-tb",
							});
		});
		function watchVideo(id) {
			var rows = $("#stu-exper-table").datagrid("getRows");
			var oneRow = rows[id];
			var experProjectPKID = oneRow["experProjectPKID"];

			var experimentalProjectId = oneRow["experimentalProjectId"];

			$.ajax({
				async : false,
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
						window.location.href="/laboratoryweb/watchVideo";
					}
				}
			});
		}
	</script>

</body>
</html>