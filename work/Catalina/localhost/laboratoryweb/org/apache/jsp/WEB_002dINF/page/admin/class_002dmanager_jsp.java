/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-04-25 12:21:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class class_002dmanager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\tid=\"addbutton\" class=\"easyui-linkbutton\" onclick=\"addClass()\">添加</a>\r\n");
      out.write("\t\t&nbsp; <a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-save'\" id=\"updatebutton\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"updateClass()\">修改</a>&nbsp; <a\r\n");
      out.write("\t\t\thref=\"javascript:void(0);\" data-options=\"iconCls:'icon-remove'\"\r\n");
      out.write("\t\t\tid=\"removebutton\" class=\"easyui-linkbutton\" onclick=\"deleteClass()\">删除</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t&nbsp; <a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-cancel'\" id=\"classCancelbutton\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"classCancel()\">取消选择</a> &nbsp;班级名:\r\n");
      out.write("\t\t<div id=\"searchClassName\" class=\"easyui-textbox\"></div>\r\n");
      out.write("\t\t&nbsp;班级编号:\r\n");
      out.write("\t\t<div id=\"searchClassId\" class=\"easyui-numberbox\"></div>\r\n");
      out.write("\t\t&nbsp;学院: <input type=\"text\" id=\"searchClassDepartment\"\r\n");
      out.write("\t\t\tname=\"searchClassDepartment\" class=\"easyui-combotree\"\r\n");
      out.write("\t\t\tdata-options=\"url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203\" />&nbsp;\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-search'\"\r\n");
      out.write("\t\t\tid=\"stuClass-seacher-btn\" class=\"easyui-linkbutton\">查询</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 增加的提示框 -->\r\n");
      out.write("\t<div id=\"class-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 300px; height: 330px; padding: 10px;\">\r\n");
      out.write("\t\t<form id=\"class-dialog-form\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"60px\" align=\"right\">班级名 <input id=\"stuClassPKID\"\r\n");
      out.write("\t\t\t\t\t\tname=\"stuClassPKID\" type=\"hidden\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\tid=\"class-stuNum\" name=\"stuNum\" class=\"easyui-numberbox\" /></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"class-stuClassName\"\r\n");
      out.write("\t\t\t\t\t\tname=\"stuClassName\" class=\"easyui-textbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"60px\" align=\"right\">班级编号</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"class-stuClassId\" name=\"stuClassId\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-numberbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"60px\" align=\"right\">所属学院</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"class-department\" name=\"department\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-combotree\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"url:'/laboratoryweb/getAllDepartments',multiple:false,panelHeight:203\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\"#class-table\").datagrid({\r\n");
      out.write("\t\t\t\ttitle : \"&nbsp;&nbsp;&nbsp;&nbsp;教师信息表\",\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getPageClasses\",\r\n");
      out.write("\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\tpageSize : 15,\r\n");
      out.write("\t\t\t\tpageList : [ 15, 50, 100 ],\r\n");
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
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//保存修改id\r\n");
      out.write("\t\t\tvar editIndex;\r\n");
      out.write("\t\t\t$(\"#stuClass-seacher-btn\")\r\n");
      out.write("\t\t\t\t\t.click(\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar stuClassId = $(\"#searchClassId\").numberbox(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar stuClassName = $(\"#searchClassName\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.textbox(\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar searchDepartment = $(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"#searchClassDepartment\").textbox(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar queryParam = $(\"#class-table\").datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"options\").queryParams;\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParam.stuClassId = stuClassId;\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParam.stuClassName = stuClassName;\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParam.searchDepartment = searchDepartment;\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#class-table\").datagrid(\"load\");\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction addClass() {\r\n");
      out.write("\t\t\t$(\"#class-dialog-form\").form(\"clear\");\r\n");
      out.write("\t\t\t$(\"#class-dialog\").dialog({\r\n");
      out.write("\t\t\t\ttitle : \"增加班级\",\r\n");
      out.write("\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ttext : \"确定\",\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-ok\",\r\n");
      out.write("\t\t\t\t\thandler : class_add\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\ttext : '取消',\r\n");
      out.write("\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t$(\"#class-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction updateClass() {\r\n");
      out.write("\t\t\t$(\"#class-dialog-form\").form(\"clear\");\r\n");
      out.write("\t\t\tvar rows = $(\"#class-table\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\tif (rows.length != 1) {\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示\", \"请选择一条数据\", \"info\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tvar stuClass = rows[0];\r\n");
      out.write("\t\t\t\t//表单绑定数据\r\n");
      out.write("\t\t\t\t$(\"#class-dialog-form\").form(\"load\", stuClass);\r\n");
      out.write("\t\t\t\t$(\"#class-dialog\").dialog({\r\n");
      out.write("\t\t\t\t\ttitle : \"修改班级信息\",\r\n");
      out.write("\t\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\ttext : \"确定\",\r\n");
      out.write("\t\t\t\t\t\ticonCls : \"icon-ok\",\r\n");
      out.write("\t\t\t\t\t\thandler : class_update\r\n");
      out.write("\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\ttext : '取消',\r\n");
      out.write("\t\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#class-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t]\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction class_add() {\r\n");
      out.write("\t\t\tdoAjaxC(\"/laboratoryweb/addClass\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction class_update() {\r\n");
      out.write("\t\t\tdoAjaxC(\"/laboratoryweb/updateClass\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction doAjaxC(param) {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : param,\r\n");
      out.write("\t\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\t\tcontentType : \"application/json;charset=utf-8\",\r\n");
      out.write("\t\t\t\tdata : JSON.stringify({\r\n");
      out.write("\t\t\t\t\tstuClassPKID : $(\"#stuClassPKID\").val(),\r\n");
      out.write("\t\t\t\t\tstuClassName : $(\"#class-stuClassName\").val(),\r\n");
      out.write("\t\t\t\t\tstuClassId : $(\"#class-stuClassId\").val(),\r\n");
      out.write("\t\t\t\t\tstuNum : $(\"#class-stuNum\").val(),\r\n");
      out.write("\t\t\t\t\tdepartment : $(\"#class-department\").val()\r\n");
      out.write("\t\t\t\t}),\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#class-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#class-table\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\tAlert(\"操作成功\");\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tAlert(\"操作失败！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction deleteClass() {\r\n");
      out.write("\t\t\tvar rows = $(\"#class-table\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\tif (rows.length >= 1) {\r\n");
      out.write("\t\t\t\t$.messager.confirm(\"提示\", \"确定删除?\", function(result) {\r\n");
      out.write("\t\t\t\t\tif (result) {\r\n");
      out.write("\t\t\t\t\t\tvar ids = [];\r\n");
      out.write("\t\t\t\t\t\t$(rows).each(function() {\r\n");
      out.write("\t\t\t\t\t\t\tids.push(this.stuClassPKID);\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl : \"/laboratoryweb/deleteClass\",\r\n");
      out.write("\t\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\tids : ids\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#class-table\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\tAlert(\"删除成功!\");\r\n");
      out.write("\t\t\t\t\t\t\t\t} else if (data == \"hasStudent\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tAlert(\"该班级尚有学生信息,无法删除\");\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tAlert(\"该班级无法删除,请断开与教师的关联！\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示\", \"请至少选择一个用户！\", \"info\");\r\n");
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
