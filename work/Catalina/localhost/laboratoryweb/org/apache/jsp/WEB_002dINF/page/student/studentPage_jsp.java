/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-05-05 07:08:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>学生系统</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/easyui/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/page.css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/easyui/local/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/studentPage.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".ec_tip {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\twidth: 140px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbackground: #777;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tborder: 3px solid #777;\r\n");
      out.write("\tz-index: 9999;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"labweb_head\"\r\n");
      out.write("\t\tdata-options=\"region:'north',border:false,split:false\">\r\n");
      out.write("\t\t<div class=\"labweb_head_left\">\r\n");
      out.write("\t\t\t<span id=\"userName\" class=\"headInfo\">你好:\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;角色:&nbsp;&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.role}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t状态:&nbsp;&nbsp;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.status eq 1?\"正常\":\"禁用\"}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" </span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<input id=\"userRole\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.role}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t<div class=\"labweb_head_right\">\r\n");
      out.write("\t\t\t<span><a href=\"javascript:void(0);\" onclick=\"cgpassword()\">修改密码</a><a\r\n");
      out.write("\t\t\t\thref=\"javascript:void(0);\">|</a><a\r\n");
      out.write("\t\t\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/exit\" target=\"_top\">安全退出</a><a\r\n");
      out.write("\t\t\t\thref=\"javascript:void(0);\">|</a><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\tonclick=\"stuAppeal()\">账号申诉</a></span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<p id=\"userAccount\" style=\"display: none;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userAccount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"labweb_left\"\r\n");
      out.write("\t\tdata-options=\"region:'west',border:true,split:false,title:'' ,\r\n");
      out.write("\t\tcollapsible:false\">\r\n");
      out.write("\t\t<!-- 折叠面板 -->\r\n");
      out.write("\r\n");
      out.write("\t\t<div title=\"功能分类\t\" data-options=\"iconCls:'icon.wrench'\">\r\n");
      out.write("\t\t\t<ul class=\"easyui-tree labweb_tree ulform\" style=\"height: 290px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: #a62d2d; color: #fff;\"\r\n");
      out.write("\t\t\t\t\tdata-link=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/student/index\"\r\n");
      out.write("\t\t\t\t\tiframe=\"0\"><p>首页</p></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\tdata-link=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/laboratoryInfo\"\r\n");
      out.write("\t\t\t\t\tiframe=\"0\"><p>实验室信息</p></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\tdata-link=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/myOrderInfo\"\r\n");
      out.write("\t\t\t\t\tiframe=\"0\"><p>我的预约</p></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\tdata-link=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/myExperProject\"\r\n");
      out.write("\t\t\t\t\tiframe=\"0\"><p>我的实验预习</p></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\tdata-link=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/experProjectInfo\"\r\n");
      out.write("\t\t\t\t\tiframe=\"0\"><p>项目信息查看</p></a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 中心 -->\r\n");
      out.write("\t<div class=\"labweb_center\"\r\n");
      out.write("\t\tdata-options=\"region:'center',collapsible:false,split:false\">\r\n");
      out.write("\t\t<div id=\"labweb_tabs\" class=\"easyui-tabs\"\r\n");
      out.write("\t\t\tdata-options=\"border:false,fit:true\">\r\n");
      out.write("\t\t\t<div title=\"首页\"\r\n");
      out.write("\t\t\t\tdata-options=\"href:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/student/index',closable:false,iconCls:'icon-tip',cls:'pd3'\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"labweb_bottom\"\r\n");
      out.write("\t\tdata-options=\"region:'south',border:false,split:false,collapsible:false\">\r\n");
      out.write("\t\t<p\r\n");
      out.write("\t\t\tstyle=\"height: 20px; font-size: 13px; margin: 0px; line-height: 25px;\">版权所有\r\n");
      out.write("\t\t\t盗版必究</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 增加的密码修改框 -->\r\n");
      out.write("\t<div id=\"password_dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-key'\"\r\n");
      out.write("\t\tstyle=\"width: 320px; height: 270px; padding: 10px;\">\r\n");
      out.write("\t\t<form id=\"password_dialog_form\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"60px\" align=\"right\">旧密码:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"adminPassword\" name=\"adminPassword\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-textbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"60px\" align=\"right\">新密码:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"newPassword\" class=\"easyui-textbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"80px\" align=\"right\">确认密码:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"rpNewPassword\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-textbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 增加的账号申诉 -->\r\n");
      out.write("\t<div id=\"stuAppeal-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 350px; height: 420px; padding: 10px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<form id=\"stuAppeal-dialog-form\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"60px\">*请填写您的申请理由:</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><textarea id=\"content\" name=\"content\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 300px; height: 200px;\"\r\n");
      out.write("\t\t\t\t\t\t\tοnblur=\"this.value=this.value.trim()\"></textarea></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<p style=\"text-align: center; font-size: 12px; color: red;\">*账号被封禁时使用</p>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/page.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction stuAppeal() {\r\n");
      out.write("\t\t\t$(\"#stuAppeal-dialog-form\").form(\"clear\");\r\n");
      out.write("\t\t\t$(\"#stuAppeal-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"账号申诉\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : \"确定\",\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-ok\",\r\n");
      out.write("\t\t\t\t\thandler : doStuAppeal\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ttext : '取消',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#stuAppeal-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} ]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction doStuAppeal() {\r\n");
      out.write("\t\t\tvar appealText = $(\"#content\").val();\r\n");
      out.write("\t\t\tvar len = appealText.length;\r\n");
      out.write("\t\t\tif (len<20||len>1000) {\r\n");
      out.write("\t\t\t\tAlert(\"请输入20-1000字\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar data = {\r\n");
      out.write("\t\t\t\t\"appealText\" : appealText\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/stuAppeal\",\r\n");
      out.write("\t\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\t\tdata : data,\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#stuAppeal-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\tAlert(\"申诉成功,请等待管理员处理..\");\r\n");
      out.write("\t\t\t\t\t} else if (data == \"useless\") {\r\n");
      out.write("\t\t\t\t\t\tAlert(\"账号正常,无需申诉\");\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tAlert(\"系统异常,请重试！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
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
