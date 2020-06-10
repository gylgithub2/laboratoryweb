$(function() {
	$(".labweb_tree li a").bind("click", function() {
		// 拿到点击的a的值
		var iconname = $(this).attr("data-icon");
		var url = $(this).attr("data-link");
		var iframe = $(this).attr("iframe") == 1;
		var text = $(this).text();
		addTab(text, url, iconname, iframe);
	})
});
function addTab(text, url, iconname, iframe) {
	var tabPanel = $("#labweb_tabs");
	if (!tabPanel.tabs("exists", text)) {
		// 构建content
		var content = "<iframe scrolling='auto' frameborder='0' src='" + url
				+ "'style='width:100%;height:100%;'></iframe>";
		// 是否用iframe打开？
		if (iframe) {
			tabPanel.tabs("add", {
				title : text,
				content : content,
				iconCls : iconname,
				fit : true,
				cls : "pd3",
				closable : true
			})
		} else {
			tabPanel.tabs("add", {
				title : text,
				href : url,
				iconCls : iconname,
				fit : true,
				cls : "pd3",
				closable : true
			})
		}
	} else {
		tabPanel.tabs("select", text);
	}
}
function cgpassword() {

	$("#password_dialog_form").form("clear");
	$("#password_dialog").dialog({
		title : "修改密码",
		closed : false,
		modal : true,
		buttons : [ // 按钮
		{
			text : "确定",
			iconCls : "icon-ok",
			handler : docgpassword
		}, {
			text : '取消',
			iconCls : "icon-cancel",
			handler : function() {
				$("#password_dialog").dialog("close");
			}
		}

		]
	});
}
function docgpassword() {
	// 当前session域内的用户
	var userAccount = $("#userAccount").text();
	var passwordpatt = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
	var rppassword = $("#rpNewPassword").val();
	var newPassword = $("#newPassword").val();
	var oldPassword = $("#studentPassword").val();
	if (rppassword != newPassword) {
		Alert("旧密码和新密码不同!");
		return false;
	}
	if (!passwordpatt.test(newPassword)) {
		Alert("新密码不合规范:\n字母数字组成且长度在5-12!");
		return false;
	}
	var flag = true;
	var data = {
		"userAccount" : userAccount,
		"password" : oldPassword,
		"newPassword" : newPassword
	};
	$.ajax({
		async : false,
		url : "/laboratoryweb/checkStudentPsword",
		type : "POST",
		data : data,
		dataType : "json",
		success : function(data) {
				flag = data;
		}
	});
	if (!flag) {
		Alert("旧密码错误,请重试");
		return false;
	} else {
		$.messager.show({
			title : '提示',
			msg : "请记住你的密码:"+newPassword,
			timeout : 800,
			showType : 'slide',
			style : {
				right : '',
				bottom : '',
				top : document.body.scrollTop + document.documentElement.scrollTop
						+ window.innerheight
			}
		});
		$("#password_dialog").dialog("close");
	}
	
}
