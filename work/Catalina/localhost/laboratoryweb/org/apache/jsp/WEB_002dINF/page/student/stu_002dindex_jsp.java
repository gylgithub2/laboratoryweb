/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-05-14 07:06:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import cn.gyl.laboratoryweb.model.Order;

public final class stu_002dindex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("cn.gyl.laboratoryweb.model.Order");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");

		List<Order> lists = (List<Order>) session.getAttribute("stuNowOrder");
	
      out.write("\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write(".box {\r\n");
      out.write("\tmargin: 0px 50px;\r\n");
      out.write("\twidth: 1200px;\r\n");
      out.write("\theight: 70%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".row：after, .row::before {\r\n");
      out.write("\tclear: both;\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".sbox {\r\n");
      out.write("\tpadding-left: 15px;\r\n");
      out.write("\twidth: 570px;\r\n");
      out.write("\theight: 300px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".index-table td {\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t<div class=\"stuindex\">\r\n");
      out.write("\t\t<div style=\"margin-left: 20%; margin-top: 10px;\">\r\n");
      out.write("\t\t\t<h1 class=\"stuHeadLine\">欢迎登陆实验室预约管理系统</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br /> <br />\r\n");
      out.write("\t\t<div class=\"box row\">\r\n");
      out.write("\t\t\t<div class=\"sbox\" style=\"width: 300px; height: 320px;\">\r\n");
      out.write("\t\t\t\t<h2 class=\"stuindextable\">个&nbsp;人&nbsp;信&nbsp;息</h2>\r\n");
      out.write("\t\t\t\t<table class=\"index-table\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: white; font-size: 13px; width: 300px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>当前预约数:</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"80px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.stuInfoMap.orderNumber }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>历史预约数:</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.stuInfoMap.allOrderNumber }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>累计缺席次数:</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.stuInfoMap.absenceNumber }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>累计迟到次数:</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.stuInfoMap.lateNumber }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>当前违纪积分:</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.stuInfoMap.violateScore }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<p style=\"font-size: 12px; color: red;\">*注:违纪积分达到6分(迟到+1,未预习+1,缺席+2),账号将被限制预约</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"color: red; width: 150px; text-align: center; background-color: white; height: 30px; border-radius: 4px; position: fixed; top: 120px; left: 200px;\">\r\n");
      out.write("\t\t\t\t<a id=\"msgFlag\" href=\"javascript:void(0);\" onclick=\"showMSGView()\"\r\n");
      out.write("\t\t\t\t\tstyle=\"font-size: 20px; color: gray;\">暂无新消息</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"color: red; width: 150px; text-align: center; background-color: green; height: 30px; border-radius: 4px; position: fixed; top: 120px; right: 100px;\">\r\n");
      out.write("\t\t\t\t<a id=\"\" href=\"javascript:void(0);\" onclick=\"showRuleView()\"\r\n");
      out.write("\t\t\t\t\tstyle=\"font-size: 20px; color: yellow;\">实验室规章制度</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"sbox\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<h2 class=\"stuindextable\" style=\"width: 500px; height: 35px;\">近&nbsp;期&nbsp;预&nbsp;约</h2>\r\n");
      out.write("\t\t\t\t<table class=\"index-table\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: white; font-size: 13px; width: 500px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>序号</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验室</td>\r\n");
      out.write("\t\t\t\t\t\t<td>工位</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验项目</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验开始时间</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验教师</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						for (int i = 0; i < (lists.size() > 5 ? 5 : lists.size()); i++) {
							Order order = lists.get(i);
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(i + 1);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(order.getRoomName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(order.getRoomSitId() == null ? "0" : order.getRoomSitId());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(order.getExperProjectAccount() == null ? "无" : order.getExperProjectAccount());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(order.getStartTime());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(order.getStuClass() != null ? order.getUserName() : "无");
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"sbox\" style=\"width: 300px; height: 200px;\">\r\n");
      out.write("\t\t\t\t<h2 class=\"stuindextable\" style=\"width: 300px; height: 35px;\">\r\n");
      out.write("\t\t\t\t\t公&nbsp;告&nbsp;信&nbsp;息<a id=\"blink\" href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"noticePage()\" style=\"float: right\">More&nbsp;</a>\r\n");
      out.write("\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t<table class=\"index-table\"\r\n");
      out.write("\t\t\t\t\tstyle=\"padding-left: 0px; font-size: 13px; background-color: white; width: 300px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>标题</td>\r\n");
      out.write("\t\t\t\t\t\t<td>发布日期</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tbody id=\"noticeListTable\"></tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"sbox\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 200px; height: 0px; margin: 100px 50px;\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0);\" onclick=\"sendMSG()\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/img/msg.jpg\"\r\n");
      out.write("\t\t\t\t\talt=\"\" />\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 消息发送 -->\r\n");
      out.write("\t<div id=\"sendmsg-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 350px; height: 420px; padding: 10px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<form id=\"sendmsg-dialog-form\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"60px\">*请填写您信息:</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><textarea id=\"msgContent\" name=\"msgContent\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 300px; height: 200px;\"\r\n");
      out.write("\t\t\t\t\t\t\tοnblur=\"this.value=this.value.trim()\"></textarea></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\t<!-- 显示实验室规章制度的提示框 -->\r\n");
      out.write("\t\t<div id=\"ruleContent-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\t\tstyle=\"width: 800px; height: 600px; padding: 10px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"rule-head\"\r\n");
      out.write("\t\t\t\tstyle=\"font-weight: bold; font-size: 20px; text-align: center;\"></div>\r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<div id=\"rule-date\" style=\"text-align: center;\"></div>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<div id=\"showrule-content\" style=\"text-indent: 2em; line-height: 30px;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<!-- 显示公告消息的提示框 -->\r\n");
      out.write("\t<div id=\"noticeContent-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 800px; height: 600px; padding: 10px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"notice-head\"\r\n");
      out.write("\t\t\tstyle=\"font-weight: bold; font-size: 20px; text-align: center;\"></div>\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t\t<div id=\"notice-date\" style=\"text-align: center;\"></div>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<div id=\"notice-content\" style=\"text-indent: 2em; line-height: 30px;\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<!-- 显示全部消息的提示框 -->\r\n");
      out.write("\t<div id=\"allMSG-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 800px; height: 600px;\">\r\n");
      out.write("\t\t<div id=\"msg-table\"\r\n");
      out.write("\t\t\tstyle=\"margin: 0px 0px; padding: 0px; width: 784px; height: 100%;\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<!-- 显示全部规章制度告的提示框 -->\r\n");
      out.write("\t<div id=\"allRule-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 800px; height: 600px;\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t<div id=\"rule-table\"\r\n");
      out.write("\t\t\tstyle=\"margin: 0px 0px; padding: 0px; width: 784px; height: 100%;\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 显示全部通知公告的提示框 -->\r\n");
      out.write("\t<div id=\"allNotice-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 800px; height: 600px;\">\r\n");
      out.write("\t\t<div id=\"ntc-table\"\r\n");
      out.write("\t\t\tstyle=\"margin: 0px 0px; padding: 0px; width: 784px; height: 100%;\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 显示回复消息 -->\r\n");
      out.write("\t<div id=\"appealContent-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 400px; height: 360px; padding: 10px;\">\r\n");
      out.write("\t\t<div id=\"appeal-content\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tfunction sendMSG() {\r\n");
      out.write("\t\t$(\"#sendmsg-dialog-form\").form(\"clear\");\r\n");
      out.write("\t\t$(\"#sendmsg-dialog\").dialog({\r\n");
      out.write("\t\t\ttitle : \"消息留言\",\r\n");
      out.write("\t\t\tclosed : false,\r\n");
      out.write("\t\t\tmodal : true,\r\n");
      out.write("\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\ttext : \"确定\",\r\n");
      out.write("\t\t\t\ticonCls : \"icon-ok\",\r\n");
      out.write("\t\t\t\thandler : doSendMSG\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\ttext : '取消',\r\n");
      out.write("\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t$(\"#sendmsg-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction doSendMSG() {\r\n");
      out.write("\t\tvar msgContent = $(\"#msgContent\").val();\r\n");
      out.write("\t\tvar data = {\r\n");
      out.write("\t\t\t\"content\" : msgContent\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"/laboratoryweb/msgStore\",\r\n");
      out.write("\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\tdata : data,\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t$(\"#sendmsg-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\tAlert(\"留言成功！\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tAlert(\"系统异常,请重试..\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\tfunction showNoticeContent(noticeId) {\r\n");
      out.write("\t\t\tvar headline;\r\n");
      out.write("\t\t\tvar content;\r\n");
      out.write("\t\t\tvar date;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getNoticeContent\",\r\n");
      out.write("\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\"id\" : noticeId\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\theadline = data.headline;\r\n");
      out.write("\t\t\t\t\tcontent = data.content;\r\n");
      out.write("\t\t\t\t\tdate = data.date;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#notice-content\").text(content);\r\n");
      out.write("\t\t\t$(\"#notice-head\").text(headline);\r\n");
      out.write("\t\t\t$(\"#notice-date\").text(date.split(' ')[0]);\r\n");
      out.write("\t\t\t$(\"#noticeContent-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"公告内容\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : '关闭',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#noticeContent-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\tfindMsg();\r\n");
      out.write("\t\t\tgetNoticeList();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\tfunction showMSGView() {\r\n");
      out.write("\t\t\tchangeNMSGPage();\r\n");
      out.write("\t\t\t$(\"#allMSG-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : '关闭',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#allMSG-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction findMsg() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/findUserMsg\",\r\n");
      out.write("\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#msgFlag\").css(\"display\", \"block\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#msgFlag\").css(\"color\", \"red\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#msgFlag\").html(\"您有新的消息！\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction getNoticeList() {\r\n");
      out.write("\t\t\t$\r\n");
      out.write("\t\t\t\t\t.ajax({\r\n");
      out.write("\t\t\t\t\t\taysnc : false,\r\n");
      out.write("\t\t\t\t\t\turl : \"/laboratoryweb/getNoticeList\",\r\n");
      out.write("\t\t\t\t\t\tcache : false,\r\n");
      out.write("\t\t\t\t\t\tmethod : \"GET\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tif (data == null || data == '') {\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar str = \"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tfor (var i = 0; i < (data.length>4?4:data.length); i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstr += \"<tr><td><a href='#' style='text-decoration:none; color:black;' onclick='showNoticeContent(\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ data[i].noticePKID\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \")'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ data[i].headline.substring(0, 12)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"..\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</a></td><td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"[\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ data[i].upDateTime.split(' ')[0]\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"]\" + \"</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#noticeListTable\").html(str);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction noticePage() {\r\n");
      out.write("\t\t\tchangeNoticePage();\r\n");
      out.write("\t\t\t$(\"#allNotice-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : '关闭',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#allNotice-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction changeNoticePage() {\r\n");
      out.write("\t\t\t$(\"#ntc-table\")\r\n");
      out.write("\t\t\t\t\t.datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\ttitle : \"&nbsp;&nbsp;&nbsp;&nbsp;全部公告\",\r\n");
      out.write("\t\t\t\t\t\t\t\turl : \"/laboratoryweb/getPagerNotice\",\r\n");
      out.write("\t\t\t\t\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\t\t\t\t\tpageSize : 13,\r\n");
      out.write("\t\t\t\t\t\t\t\tsingleSelect : true,\r\n");
      out.write("\t\t\t\t\t\t\t\tpageList : [ 13, 50, 100 ],\r\n");
      out.write("\t\t\t\t\t\t\t\tcolumns : [ [\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"headline\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"公告标题\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 532\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"upDateTime\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"发布时间\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tformatter : function(value, row,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tindex) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn value.split(\" \")[0];\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \" \",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"公告内容\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 100,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tformatter : function(value, row,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tindex) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn \"<a href='#' onclick='showNoticeContent(\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ row.noticePKID\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \")'>\" + \"查看详细</a>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t} ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\tstriped : true\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction changeNMSGPage() {\r\n");
      out.write("\t\t\t$(\"#msg-table\")\r\n");
      out.write("\t\t\t\t\t.datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\ttitle : \"&nbsp;&nbsp;&nbsp;&nbsp;全部消息\",\r\n");
      out.write("\t\t\t\t\t\t\t\turl : \"/laboratoryweb/getPagerUserNMSG\",\r\n");
      out.write("\t\t\t\t\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\t\t\t\t\tpageSize : 13,\r\n");
      out.write("\t\t\t\t\t\t\t\tsingleSelect : true,\r\n");
      out.write("\t\t\t\t\t\t\t\tpageList : [ 13, 50, 100 ],\r\n");
      out.write("\t\t\t\t\t\t\t\tcolumns : [ [\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"userName\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"用户姓名\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 80\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"userRole\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"用户角色\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 90,\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"msgDate\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"发送时间\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 200\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"status\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"状态\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 80,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tformatter : function(value, row,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tindex) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tif (value == 1) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\treturn \"未读\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t} else if (value == 2) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\treturn \"已读\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t} else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\treturn \"已回复\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyler : function(value, row, index) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tif (value == 1) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn 'background-color:#E22018;color:white;';\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn 'tetx-align:center;background-color:#60D41F;color:white;';\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t} ,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \" \",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"消息内容\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 80,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tformatter : function(value, row,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tindex) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn \"<a href='javascript:void(0);' onclick='scanMSGContent(\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ row.messagePKID\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \")'>\" + \"查看详细</a>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}] ],\r\n");
      out.write("\t\t\t\t\t\t\t\tstriped : true\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction scanMSGContent(msgId) {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tasync:false,\r\n");
      out.write("\t\t\t\turl:\"/laboratoryweb/readMsg\",\r\n");
      out.write("\t\t\t\tdata:{\"id\": msgId},\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#msg-table\").datagrid(\"reload\");\r\n");
      out.write("\t\t\tvar content;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getMsgContent\",\r\n");
      out.write("\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\"id\" : msgId\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tcontent = data;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#appeal-content\").text(content);\r\n");
      out.write("\t\t\t$(\"#appealContent-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"申请消息\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : '关闭',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#appealContent-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction showRuleView() {\r\n");
      out.write("\t\t\tchangeRulePage();\r\n");
      out.write("\t\t\t$(\"#allRule-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : '关闭',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#allRule-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction changeRulePage() {\r\n");
      out.write("\t\t\t$(\"#rule-table\")\r\n");
      out.write("\t\t\t\t\t.datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\ttitle : \"&nbsp;&nbsp;&nbsp;&nbsp;规章制度\",\r\n");
      out.write("\t\t\t\t\t\t\t\turl : \"/laboratoryweb/getPagerRule\",\r\n");
      out.write("\t\t\t\t\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\t\t\t\t\tpageSize : 13,\r\n");
      out.write("\t\t\t\t\t\t\t\tsingleSelect : true,\r\n");
      out.write("\t\t\t\t\t\t\t\tpageList : [ 13, 50, 100 ],\r\n");
      out.write("\t\t\t\t\t\t\t\tcolumns : [ [\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"headline\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"标题\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 400\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \"uploadDate\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"发布时间\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 190,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tformatter : function(value, row,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tindex) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn value.split(\" \")[0];\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfield : \" \",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : \"详细内容\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\twidth : 190,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tformatter : function(value, row,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tindex) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\treturn \"<a href='javascript:void(0);' onclick='showRuleContent(\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ row.labRulePKID\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \")'>\" + \"查看详细</a>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\tstriped : true\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction showRuleContent(ruleId) {\r\n");
      out.write("\t\t\tvar headline;\r\n");
      out.write("\t\t\tvar content;\r\n");
      out.write("\t\t\tvar date;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getRuleContent\",\r\n");
      out.write("\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\"id\" : ruleId\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\theadline = data.headline;\r\n");
      out.write("\t\t\t\t\tcontent = data.content;\r\n");
      out.write("\t\t\t\t\tdate = data.date;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#showrule-content\").text(content);\r\n");
      out.write("\t\t\t$(\"#rule-head\").text(headline);\r\n");
      out.write("\t\t\t$(\"#rule-date\").text(date.split(' ')[0]);\r\n");
      out.write("\t\t\t$(\"#ruleContent-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"内容\t\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : '关闭',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#ruleContent-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
