/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-04-17 12:10:28 UTC
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

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(".row：after, .row::before {\r\n");
      out.write("\tclear: both;\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".sbox {\r\n");
      out.write("\tpadding-left: 15px;\r\n");
      out.write("\twidth: 570px;\r\n");
      out.write("\theight: 70%;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".index-table {\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\twidth: 960px;\r\n");
      out.write("\tborder: 1px solid #CCC;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\ttext-align: center;\r\n");
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
      out.write("\t\t\t\t\tstyle=\"background-color: white; font-size: 17px; width: 300px;\">\r\n");
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
      out.write("\r\n");
      out.write("\t\t\t<div class=\"sbox\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<h2 class=\"stuindextable\" style=\"width: 500px; height: 35px;\">近&nbsp;期&nbsp;预&nbsp;约</h2>\r\n");
      out.write("\t\t\t\t<table class=\"index-table\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: white; width: 500px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>序号</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验室</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验项目</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验开始时间</td>\r\n");
      out.write("\t\t\t\t\t\t<td>实验教师</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						for (int i = 0; i < lists.size(); i++) {
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
      out.write("\t\t\t\t<h2 class=\"stuindextable\" style=\"width: 300px; height: 35px;\">公&nbsp;告&nbsp;信&nbsp;息</h2>\r\n");
      out.write("\t\t\t\t<table class=\"index-table\"\r\n");
      out.write("\t\t\t\t\tstyle=\"padding-left: 0px; background-color: white; width: 300px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>标题</td>\r\n");
      out.write("\t\t\t\t\t\t<td>发布日期</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tbody id=\"noticeListTable\"></tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<!-- 显示公告消息的提示框 -->\r\n");
      out.write("\t<div id=\"noticeContent-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 400px; height: 360px; padding: 10px;\">\r\n");
      out.write("\t\t<div id=\"notice-content\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction showNoticeContent(noticeId) {\r\n");
      out.write("\t\t\tvar content;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getNoticeContent\",\r\n");
      out.write("\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\"id\" : noticeId\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tcontent = data;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#notice-content\").text(content);\r\n");
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
      out.write("\t\t\tgetNoticeList();\r\n");
      out.write("\t\t})\r\n");
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
      out.write("\t\t\t\t\t\t\t\tfor (var i = 0; i < data.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstr += \"<tr><td><a href='#' style='text-decoration:none; color:blue;' onclick='showNoticeContent(\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ data[i].noticePKID\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \")'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ data[i].headline\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</a></td><td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ data[i].upDateTime + \"</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#noticeListTable\").html(str);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
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
