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
	var resetTime = 0; // 拖动后重置播放时间
	var curTime = 0; // 当前播放时间
	var vd = document.getElementById("expervideo"); //获取video对象
	var getCurTime = localStorage.getItem('remTime'); //获取本地存储
	if (getCurTime > 0.1) {
		curTime = getCurTime;
		resetTime = getCurTime;
		vd.addEventListener('play', function() {
			setTimeout(function() {
				vd.currentTime = getCurTime;
				setInterval(timer, 100)
			}, 2000)
		})
	} else {
		vd.play();
		setInterval(timer, 100)
	}

	// 定时器
	function timer() {
		curTime = vd.currentTime;
		var apartTime = curTime - resetTime;
		if (apartTime > 2) {
			vd.currentTime = resetTime;
		} else {
			resetTime = curTime;
		}
		that.curTime = curTime;
	}

	vd.addEventListener('pause', function() {
		localStorage.setItem('remTime', that.curTime);
	})
	$(function() {
		var myPlayer = videojs('expervideo');
		var myInterval = setInterval(storeDuration, 5000);
		function storeDuration() {
			var myPlayer = videojs('expervideo');
			var videoTime = myPlayer.duration();
			var watchTime = myPlayer.currentTime();
			var stuId = $("#stuId").val();
			var data = {
				"stuId" : stuId,
				"videoTime" : videoTime,
				"watchTime" : watchTime
			}
			$.ajax({
				async : true,
				url : "/laboratoryweb/stuWatchLog",
				type : "POST",
				data : data,
				success : function(msg) {
					if (msg == "watched") {
						alert("学习完毕");
						clearInterval(myInterval);
					} else if (msg == "overDate") {
						alert("已过学习日期");
						clearInterval(myInterval);
					}
				}
			});
			if (videoTime == watchTime) {
				clearInterval(myInterval);
			}
		}
	})
</script>
</html>
