/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-05-08 12:07:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.web.context.annotation.SessionScope;

public final class laboratory_002dinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("org.springframework.web.context.annotation.SessionScope");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table id=\"lab-table\" style=\"width: 100%; height: 100%;\" />\r\n");
      out.write("\t<div id=\"lab_tb\">\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-add'\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"order()\">预约</a>&nbsp; <a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-undo'\" id=\"stu-refreshbutton\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\" onclick=\"refreshTable()\">刷新</a> &nbsp;实验室名:\r\n");
      out.write("\t\t<div id=\"stu-search-labName\" prompt=\"实验室名字...\"\r\n");
      out.write("\t\t\tclass=\"easyui-textbox\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t&nbsp; <a href=\"javascript:void(0);\" data-options=\"iconCls:'icon-search'\"\r\n");
      out.write("\t\t\tid=\"stu-search-btn\" class=\"easyui-linkbutton\">搜索</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 增加的提示框 -->\r\n");
      out.write("\t<div id=\"stu-lab-dialog\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tdata-options=\"closed:true,iconCls:'icon-save'\"\r\n");
      out.write("\t\tstyle=\"width: 380px; height: 320px; padding: 10px;\">\r\n");
      out.write("\t\t<form id=\"stu-lab-dialog-form\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td style=\"padding: 10px;\" width=\"100px\" align=\"right\">实验室名:\r\n");
      out.write("\t\t\t\t\t<input id=\"stu-laboratoryPKID\" name=\"laboratoryPKID\" type=\"hidden\" /></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" disabled=\"disabled\" id=\"stu-laboratoryName\"\r\n");
      out.write("\t\t\t\t\t\tname=\"laboratoryName\" class=\"easyui-textbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding: 10px;\"  align=\"right\">实验室编号:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" disabled=\"disabled\" id=\"stu-laboratoryId\"\r\n");
      out.write("\t\t\t\t\t\tname=\"laboratoryId\" class=\"easyui-textbox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding: 10px;\"  align=\"right\">预约时间:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"stu-orderDay\" name=\"orderDay\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-datebox\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"padding: 10px;\" align=\"right\">预约时间段:</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" id=\"stu-orderTimeSectionId\"\r\n");
      out.write("\t\t\t\t\t\tname=orderTimeSection class=\"easyui-combotree\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"url:'/laboratoryweb/getAllTimeSection',multiple:false,panelHeight:200\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\"#lab-table\").datagrid({\r\n");
      out.write("\t\t\t\ttitle : \"实验室信息\",\r\n");
      out.write("\t\t\t\turl : \"/laboratoryweb/getPagerLaboratorys\",\r\n");
      out.write("\t\t\t\tpagination : true,\r\n");
      out.write("\t\t\t\tsingleSelect:true,\r\n");
      out.write("\t\t\t\tpageSize : 14,\r\n");
      out.write("\t\t\t\tpageList : [ 14, 50, 100 ],\r\n");
      out.write("\t\t\t\tcolumns : [ [ {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryPKID\",\r\n");
      out.write("\t\t\t\t\thidden:true,\r\n");
      out.write("\t\t\t\t\ttitle : \"laboratoryPKID\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryId\",\r\n");
      out.write("\t\t\t\t\tsortable : true,\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室编号\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryName\",\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室名字\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratorySitNum\",\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室座位数量\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : \"laboratoryStatus\",\r\n");
      out.write("\t\t\t\t\ttitle : \"实验室状态\",\r\n");
      out.write("\t\t\t\t\twidth : 100\r\n");
      out.write("\t\t\t\t}, ] ],\r\n");
      out.write("\t\t\t\tstriped : true,\r\n");
      out.write("\t\t\t\ttoolbar : \"#lab_tb\",\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//保存修改id\r\n");
      out.write("\t\t\t$(\"#stu-search-btn\").click(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\tvar laboratoryName = $(\"#stu-search-labName\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.textbox(\"getValue\");\r\n");
      out.write("\t\t\t\t\t\t//绑定到lab-table上\r\n");
      out.write("\t\t\t\t\t\tvar queryParam = $(\"#lab-table\").datagrid(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"options\").queryParams;\r\n");
      out.write("\t\t\t\t\t\tqueryParam.laboratoryName = laboratoryName;\r\n");
      out.write("\t\t\t\t\t\t$(\"#lab-table\").datagrid(\"load\");\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t//保存修改\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction order() {\r\n");
      out.write("\t\t\t$(\"#stu-lab-dialog-form\").form(\"clear\");\r\n");
      out.write("\t\t\tvar rows = $(\"#lab-table\").datagrid(\"getSelections\");\r\n");
      out.write("\t\t\tif (rows.length != 1) {\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示\", \"请选择一条信息\", \"info\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tvar laboratory = rows[0];\r\n");
      out.write("\t\t\t\t//表单绑定数据\r\n");
      out.write("\t\t\t\t$(\"#stu-lab-dialog-form\").form(\"load\", laboratory);\r\n");
      out.write("\t\t\t\t$(\"#stu-lab-dialog\").dialog({\r\n");
      out.write("\t\t\t\t\ttitle : \"预约实验室\",\r\n");
      out.write("\t\t\t\t\tclosed : false,\r\n");
      out.write("\t\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\t\t//不可修改\r\n");
      out.write("\t\t\t\t\t/* \t\t\t\t\tonOpen:function(){\r\n");
      out.write("\t\t\t\t\t $(\"#laboratoryName\").textbox({disabled:true});\r\n");
      out.write("\t\t\t\t\t }, */\r\n");
      out.write("\t\t\t\t\tbuttons : [ //按钮\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\ttext : \"确定\",\r\n");
      out.write("\t\t\t\t\t\ticonCls : \"icon-ok\",\r\n");
      out.write("\t\t\t\t\t\thandler : laboratory_order\r\n");
      out.write("\t\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\ttext : '取消',\r\n");
      out.write("\t\t\t\t\t\ticonCls : \"icon-cancel\",\r\n");
      out.write("\t\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#stu-lab-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t]\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction laboratory_order() {\r\n");
      out.write("\t\t\tdoAjax(\"/laboratoryweb/orderLaboratory\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction doAjax(param) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar laboratoryId = $(\"#stu-laboratoryId\").val();\r\n");
      out.write("\t\t\tvar orderTimeSectionId = $(\"#stu-orderTimeSectionId\").val();\r\n");
      out.write("\t\t\tvar orderDay = $(\"#stu-orderDay\").val();\r\n");
      out.write("\t\t\tif(orderDay==\"\"||orderTimeSectionId==\"\"){\r\n");
      out.write("\t\t\t\tAlert(\"请填写完整信息\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar loadData = {\r\n");
      out.write("\t\t\t\t\"laboratoryId\" : laboratoryId,\r\n");
      out.write("\t\t\t\t\"orderTimeSectionId\" : orderTimeSectionId,\r\n");
      out.write("\t\t\t\t\"orderDay\" : orderDay\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : param,\r\n");
      out.write("\t\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\t\tdata : loadData,\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tif (data == \"ok\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#stu-lab-dialog\").dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\tAlert(\"预约成功,请留意批准信息.....\");\r\n");
      out.write("\t\t\t\t\t}else if(data == \"swrongday\"){\r\n");
      out.write("\t\t\t\t        var myDate = new Date;\r\n");
      out.write("\t\t\t\t        var year = myDate.getFullYear(); //获取当前年\r\n");
      out.write("\t\t\t\t        var mon = myDate.getMonth() + 1; //获取当前月\r\n");
      out.write("\t\t\t\t        var date = myDate.getDate();\r\n");
      out.write("\t\t\t\t\t\tAlert(\"日期应为:\"+year+\"-\"+mon+\"-\"+date+\"后五天内\");\r\n");
      out.write("\t\t\t\t\t} else if(data == \"labForbidden\"){\r\n");
      out.write("\t\t\t\t\t\tAlert(\"实验室不可用\");\r\n");
      out.write("\t\t\t\t\t} else if(data == \"classordered\"){\r\n");
      out.write("\t\t\t\t\t\tAlert(\"实验室已被占用\");\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t} else if(data == \"forbidden\"){\r\n");
      out.write("\t\t\t\t\t\tAlert(\"账号被禁用,请联系管理员..\");\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\telse if(data == \"ordered\"){\r\n");
      out.write("\t\t\t\t\t\tAlert(\"同时间段预约冲突\");\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\telse if(data == \"outofnum\"){\r\n");
      out.write("\t\t\t\t\t\tAlert(\"实验室已满\");\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\telse if(data == \"outMaxOrder\"){\r\n");
      out.write("\t\t\t\t\t\tAlert(\"预约请求已满\");\r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\tAlert(\"系统异常,请重试..\");\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction refreshTable(){\r\n");
      out.write("\t\t\t$(\"#lab-table\").datagrid(\"load\");\r\n");
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
