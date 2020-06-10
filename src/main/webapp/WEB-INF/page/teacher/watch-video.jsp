<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>视频观看</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/video-js.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/video.min.js"></script>
<style>
body {
	background-color: #191919;
}

.m {
	width: 100%;
	height: 100%;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	   
	<input id="stuId" type="hidden"
		value="<%=session.getAttribute("userAccount")%>" />
	<div class="m">


		<video id="expervideo"
			class="video-js vjs-default-skin  vjs-big-play-centered"
			controls="controls" preload="auto" width="1500" height="680"
			webkit-playsinline="true" onended="over()" playsinline=""
			x5-playsinline="" data-setup='{"example_option":true}'>      
		<source
			src="/laboratoryweb/resources/videos/<%=session.getAttribute("videoPath")%>"
			type='video/mp4' />              </video>
	</div>

</body>

<script type="text/javascript">
	var that = this;
	var vd = document.getElementById("expervideo"); //获取video对象
    vd.play();
 
</script>
</html>
