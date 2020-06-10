$(function() {
	// 登录验证
	// 验证码模块
	$("#checkimg").click(function() {
		this.src = "/laboratoryweb/kaptcha.jpg?d=" + new Date();
	});
	$(".submit-btn")
			.click(
					function() {
						var checkword = $("#checkword").val();

						var realCheckword;
						$.ajax({
							async : false,
							url : "/laboratoryweb/getCheckWord",
							type : "get",
							success : function(data) {
								realCheckword = data;
							}
						});
						if (checkword != realCheckword) {
							$("#checkimg").attr(
									"src",
									"/laboratoryweb/kaptcha.jpg?d="
											+ new Date());
							$(".errorMessage").text("验证码错误!");
							return false;
						}

						// 输入有效性验证
						var userAccount = $("#userAccount").val();
						var password = $("#password").val();
						var namepatt = /^\w{5,12}$/;
						var passwordpatt = /^\w{5,12}$/;
						if (!namepatt.test(userAccount)) {
							$(".errorMessage").text("用户名不合法!");
							$("#checkimg").attr(
									"src",
									"/laboratoryweb/kaptcha.jpg?d="
											+ new Date());
							return false;
						}
						if (!passwordpatt.test(password)) {
							$(".errorMessage").text("密码不合法!");
							$("#checkimg").attr(
									"src",
									"/laboratoryweb/kaptcha.jpg?d="
											+ new Date());
							return false;
						}
						$(".errorMessage").text("");
						var status = $(':radio[name="t1"]:checked').val();
						// 登录信息
						var data = {
							"status" : status,
							"userAccount" : userAccount,
							"password" : password
						};
						$.ajax({
									async : false,
									url : "/laboratoryweb/login",// 登录方法
									type : "POST",//POST方式请求
									data : data,
									dataType : "json",
									success : function(data) {
										// 根据角色进入界面
										if (data == 0) {
											$(".errorMessage").text("账户或密码错误");
											$("#checkimg").attr("src","/laboratoryweb/kaptcha.jpg?d="+ new Date());
										} else if (data == 1) {
											window.location.href = "/laboratoryweb/studentPage";
										} else if (data == 2) {
											window.location.href = "/laboratoryweb/teacherPage";
										} else if (data == 3) {
											window.location.href = "/laboratoryweb/adminPage";
										} else if (data == 4) {
											$(".errorMessage").text("账户已被锁定");
											$("#checkimg").attr("src","/laboratoryweb/kaptcha.jpg?d="+ new Date());
										}
									}
								});
					});
})
