/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-04-17 13:50:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class class_002dinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table id=\"class-table\" style=\"width: 100%; height: 100%;\" />\r\n");
      out.write("\t<div id=\"class-tb\">\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-add'\"\r\n");
      out.write("\t\t\tid=\"add-to-manager\" class=\"easyui-linkbutton\" onclick=\"addManager()\">管理该班级</a>\r\n");
      out.write("\t\t&nbsp;班级名:\r\n");
      out.write("\t\t<div id=\"search-class-name\" class=\"easyui-textbox\"></div>\r\n");
      out.write("\t\t&nbsp;班级编号:\r\n");
      out.write("\t\t<div id=\"search-class-id\" class=\"easyui-numberbox\"></div>\r\n");
      out.write("\t\t&nbsp;学院: <input type=\"text\" id=\"search-department\"\r\n");
      out.write("\t\t\tname=\"search-department\" class=\"easyui-combotree\"\r\n");
      out.write("\t\t\tdata-options=\"url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203\" />&nbsp;\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-search'\"\r\n");
      out.write("\t\t\tid=\"stuClass-seacher-btn\" class=\"easyui-linkbutton\">查询</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\"#class-table\").datagrid({\r\n");
      out.write("\t\t\t\ttitle : \"&nbsp;&nbsp;&nbsp;&nbsp;教师信息表\",\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getPageClasses\",\r\n");
      out.write("\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\tpageList : [ 10, 20 ],\r\n");
      out.write("\t\t\t\tcolumns : [ [ {\r\n");
      out.write("\t\t\t\t\tfield : \"ck\",\r\n");
      out.write("\t\t\t\t\tcheckbox : \"true\"\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"stuClassPKID\",\r\n");
      out.write("\t\t\t\t\thidden : true,\r\n");
      out.write("\t\t\t\t\ttitle : \"stuClassPKID\",\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"stuClassName\",\r\n");
      out.write("\t\t\t\t\ttitle : \"班级名字\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"stuNum\",\r\n");
      out.write("\t\t\t\t\ttitle : \"班级人数\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"stuClassId\",\r\n");
      out.write("\t\t\t\t\ttitle : \"班级编号\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"department\",\r\n");
      out.write("\t\t\t\t\ttitle : \"学院\",\r\n");
      out.write("\t\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\t\tformatter : function(value, row, index) {\r\n");
      out.write("\t\t\t\t\t\tvar departmentName;\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\t\t\t\turl : \"/laboratoryweb/getClassDepartName\",\r\n");
      out.write("\t\t\t\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\"departmentId\" : value\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\tdepartmentName = data;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\treturn departmentName;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} ] ],\r\n");
      out.write("\t\t\t\tstriped : true,\r\n");
      out.write("\t\t\t\ttoolbar : \"#class-tb\",\r\n");
      out.write("\t\t\t\tsingleSelect : true\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//保存修改id\r\n");
      out.write("\t\t\tvar editIndex;\r\n");
      out.write("\t\t\t$(\"#stuClass-seacher-btn\")\r\n");
      out.write("\t\t\t\t\t.click(\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar stuClassId = $(\"#search-class-id\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.numberbox(\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar stuClassName = $(\"#search-class-name\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.textbox(\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar searchDepartment = $(\"#search-department\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.textbox(\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar queryParam = $(\"#class-table\").datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"options\").queryParams;\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParam.stuClassId = stuClassId;\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParam.stuClassName = stuClassName;\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParam.searchDepartment = searchDepartment;\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#class-table\").datagrid(\"load\");\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction addManager() {\r\n");
      out.write("\t\t\tvar rows = $(\"#class-table\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\tif (rows.length >= 1) {\r\n");
      out.write("\t\t\t\tvar stuClass = rows[0];\r\n");
      out.write("\t\t\t\t$.messager.confirm(\"提示\", \"确定将\" + stuClass.stuClassName\r\n");
      out.write("\t\t\t\t\t\t+ \"添加至我的管理班级?\", function(result) {\r\n");
      out.write("\t\t\t\t\tif (result) {\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\t\t\t\tmethod : \"GET\",\r\n");
      out.write("\t\t\t\t\t\t\turl : \"/laboratoryweb/addManagerClass\",\r\n");
      out.write("\t\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\"stuClassPKID\" : stuClass.stuClassPKID\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tAlert(\"添加管理成功\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#class-table\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tAlert(\"删除失败！\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$.messager.Alert(\"提示\", \"请选择一个班级！\", \"info\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction classCancel() {\r\n");
      out.write("\t\t\t$(\"#class-table\").datagrid(\"rejectChanges\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
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