<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login.css"></link>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/login.js"></script>
</head>
<body>

	<div id="header">
		<div class="header_title">
			<span class="title_con">实验室预约管理系统</span>
		</div>
	</div>
	<div id="content">
		<center>
			<div class="con">
				<div class="con_title">
					<span class="con_title_sp" >实验室预约管理系统</span>
				</div>
				<div class="con_panel">
					<div class="con_input">
						<span class="errorMessage" style="color:red;"></span> <br> 
						
						<img width="22px" height="22px" class="icon" alt="" src="${pageContext.request.contextPath }/resources/css/icons/user.png" />
						<input id="userAccount"  class="user" type="text" autofocus placeholder="请输入账号"" />
		

					</div>
					<div class="con_input">
					<img width="22px" height="22px" class="icon" alt="" src="${pageContext.request.contextPath }/resources/css/icons/lock.png" />
						<input id="password" class="password" type="password" placeholder="请输入密码" />
					</div>
					<div class="con_input">
					<img width="22px" height="22px" class="icon" alt="" src="${pageContext.request.contextPath }/resources/css/icons/key.png" />
					<input  id="checkword" class="checkword" type="text" placeholder="请输入验证码"  >
					<img id="checkimg" style="width:120px;height:30px;position:relative;top:22px;" alt="" src="${pageContext.request.contextPath}/kaptcha.jpg">					
					</div>
					<div class="con_select">
						账号类型:&nbsp;&nbsp;&nbsp;<input type="radio" name="t1" checked="checked" value="1" />学生 <input
							type="radio" name="t1" value="2" />教师 <input type="radio"
							name="t1" value="3" />管理员
					</div>
					<input type="submit" value="登    录" class="submit-btn" />
				</div>
			</div>
		</center>
	</div>

	<div id="footer"> Copyright©2020</div>

</body>
</html>


